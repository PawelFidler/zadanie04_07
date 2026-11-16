package com.example.bmicalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity<view> extends AppCompatActivity {

    private EditText wagaInput;
    private EditText wzrostInput;
    private RadioButton plecRadioK;
    private RadioButton plecRadioM;
    private Button submitButton;

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
        wagaInput = findViewById(R.id.editTextNumberDecimal);
        wzrostInput = findViewById(R.id.editTextNumberDecimal2);
        plecRadioK = findViewById(R.id.radioButton);
        plecRadioM = findViewById(R.id.radioButton2);
        submitButton = findViewById(R.id.button);
    }


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
    private int validateForm(){
       if(wagaInput.getText().toString().trim().isEmpty()){
           return 2;
       }else if(wagaInput.getText().toString().trim().isEmpty()){
           return 3;
       }else if(wzrostInput.getText().toString().trim().isEmpty()){
           return 4;
       }else if(Integer.parseInt(String.valueOf(wagaInput.getText()))>300){
           return 5;
       }else if(!plecRadioK.isChecked() && !plecRadioM.isChecked()){
           return 6;
       }else{
           return 1;
       }
    }

}