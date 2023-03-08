package com.example.seeproject;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainAcitivity extends AppCompatActivity {
    private EditText mEditText1;
    private EditText mEditText2;
    private EditText mEditText3;
    private EditText mEditText4;
    private EditText mEditText5;
    private EditText mEditText6;
    private EditText mEditText7;

    private TextView mTextViewResult;
    private Button button_add;
    //private Button sumOfTheYears;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText1 = findViewById(R.id.edittext_number_1);
        mEditText2 = findViewById(R.id.edittext_number_2);
        mEditText3=findViewById(R.id.edittext_number_3);
        mEditText4=findViewById(R.id.edittext_number_4);
        mEditText5=findViewById(R.id.edittext_number_5);
        mEditText6=findViewById(R.id.edittext_number_6);
        mEditText7=findViewById(R.id.edittext_number_7);
        mTextViewResult = findViewById(R.id.textView);
        button_add = findViewById(R.id.button_add);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double CapitalA = Integer.parseInt(mEditText1.getText().toString());
                double emcA=  Integer.parseInt(mEditText2.getText().toString());
                double lifeA=  Integer.parseInt(mEditText3.getText().toString());
                double capitalB=  Integer.parseInt(mEditText4.getText().toString());
                double emcB=  Integer.parseInt(mEditText5.getText().toString());
                double lifeB=  Integer.parseInt(mEditText6.getText().toString());
                double costOfCapital=  Integer.parseInt(mEditText7.getText().toString());
                costOfCapital = costOfCapital/100;
                double factorA = Math.pow((1+costOfCapital),lifeA);
                double afA = ((1-(1/factorA))/costOfCapital);
                double costA = (CapitalA/afA)+emcA;
                costA=Math.round(costA);
                double factorB = Math.pow((1+costOfCapital),lifeB);
                double afB = ((1-(1/factorB))/costOfCapital);
                double costB = (capitalB/afB)+emcB;
                costB=Math.round(costB);
                double result=0;
                String str="";
                if(costA>costB){
                    result=costA-costB;
                    str="Result: Machine B is selected as it's EAC is"+" "+result+" less than machine A";
                    mTextViewResult.setText(str);

                }
                else{
                    result=costB-costA;
                    str="Result: Machine A is selected as it's EAC is"+" "+result+" less than machine B";
                    mTextViewResult.setText(str);

                }

            }
        });

    }
}
