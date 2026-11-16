package com.example.bmicalc;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity<view> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        listeners();
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });

    }
    View wagaInput = findViewById(R.id.editTextNumberDecimal);
    View wzrostInput = findViewById(R.id.editTextNumberDecimal2);
    View plecRadioK = findViewById(R.id.radioButton);
    View plecRadioM = findViewById(R.id.radioButton2);
    View submitButton = findViewById(R.id.button);

   private void listeners(){
       submitButton.setOnClickListener(v -> {
           int wynik = validateForm();
           if(wynik == 1){
               wyswietl();
           }else{
               blad(wynik);
           }
       });

   }


}