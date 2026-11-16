package com.example.bmicalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

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
    private TextView wynikText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        wynikText = findViewById(R.id.wynik);


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
       }else if(wzrostInput.getText().toString().trim().isEmpty()){
           return 3;
       }else if(Integer.parseInt(String.valueOf(wzrostInput.getText()))>300){
           return 4;
       }else if(!plecRadioK.isChecked() && !plecRadioM.isChecked()){
           return 5;
       }else{
           return 1;
       }
    }
    private void wyswietl(){
        double waga = Double.parseDouble(String.valueOf(wagaInput.getText()));
        double wzrost = Double.parseDouble(String.valueOf(wzrostInput.getText()));
        double BMI=waga/((wzrost/100)*(wzrost/100));
        BMI = Math.round(BMI);
        wynikText.setText("Twoje BMI to: "+ BMI);
    }
    private void blad(int err){
        if(err == 2){
            wynikText.setText("waga nie może być pusta");
        }else if(err == 3){
            wynikText.setText("wzrost nie może być pusty");
        }else if(err == 4){
            wynikText.setText("wzrost nie może być powyżej 300");
        }else if(err == 5){
            wynikText.setText("plec nie moze być pusta");
        }
    }


}