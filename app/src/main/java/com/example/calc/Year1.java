 package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Year1 extends AppCompatActivity {

     private String oldNum = "";
     private String op = "+";
     private boolean isNewOp = true;
     private int min = 0;
     private int max = 100;
     private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        display = findViewById(R.id.textView2);
    }

    public void numberEvent(View view) {
        if(isNewOp)
            display.setText("");
        isNewOp = false;
        String number = display.getText().toString();
        switch (view.getId()){
            case R.id.one:
                number += "1";
                break;
            case R.id.two:
                number +="2";
                break;
            case R.id.three:
                number += "3";
                break;
            case R.id.four:
                number +="4";
                break;
            case R.id.five:
                number += "5";
                break;
            case R.id.six:
                number +="6";
                break;
            case R.id.seven:
                number += "7";
                break;
            case R.id.eight:
                number +="8";
                break;
            case R.id.nine:
                number += "9";
                break;
            case R.id.zero:
                number +="0";
                break;
        }
        display.setText(number);
    }

    public void operatorEvent(View view) {
        isNewOp = true;

        oldNum = display.getText().toString();
        switch (view.getId()){
            case R.id.addb:
                display.setText(oldNum+"+");
                op="+";
                break;
            case R.id.minusb:
                display.setText(oldNum+"-");
                op="-";
                break;
        }
    }

    public void equalbtn(View view) {
        String newNum = display.getText().toString();
        int result = 0;
        int firstNum = Integer.parseInt(oldNum);
        int secondNum = Integer.parseInt(newNum);
        switch (op){
            case "+":
                result = firstNum + secondNum;
                if(firstNum>=min && secondNum<=max && secondNum>=min && secondNum<=max && result<=max){
                    display.setText(result + "");
                    isNewOp = true;
                }
                else if(firstNum>=max || secondNum>=max){
                    Toast.makeText(getApplicationContext(), "Only 2 digit number allowed to calculate! Insert another expression", Toast.LENGTH_SHORT).show();
                    isNewOp = true;
                }
                else if(result>max){
                    Toast.makeText(getApplicationContext(), "Maximum result number is 100! Insert another expression", Toast.LENGTH_SHORT).show();
                    isNewOp = true;
                }
                break;
            case "-":
                result = firstNum - secondNum;
                if(firstNum>=min && firstNum<=max && secondNum>=min && secondNum<=max && result<=max){
                    display.setText(result + "");
                    isNewOp = true;
                }
                else if(firstNum>=min && firstNum<=max && secondNum>firstNum){
                    Toast.makeText(getApplicationContext(), "Second number cannot be greater than the first number! Insert another expression", Toast.LENGTH_SHORT).show();
                    isNewOp = true;
                }
                else if(result>max){
                    Toast.makeText(getApplicationContext(), "Maximum result number is 100! Insert another expression", Toast.LENGTH_SHORT).show();
                    isNewOp = true;
                }
                else if(result<min){
                    Toast.makeText(getApplicationContext(), "Second number cannot be greater than the first number! Insert another expression", Toast.LENGTH_SHORT).show();
                    isNewOp = true;
                }
                break;
            }
    }

    public void Cbtn(View view) {
        display.setText("");
        isNewOp = true;
    }
}