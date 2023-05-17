package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.content.ContentValues.TAG;

public class Year3 extends AppCompatActivity {

    private String oldNum = "";
    private String newNum = "";
    private String op = "+";
    private boolean isNewOp = true;
    private int min = 0;
    private int max = 10000;
    private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        display = findViewById(R.id.textView5);
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
            case R.id.dot:
                number += ".";
                break;
            //case R.id.button44:
            //    number +="˼";
        }
        display.setText(number);
    }

    public void operatorEvent(View view) {
        isNewOp = true;
        oldNum = display.getText().toString();
        switch (view.getId()){
            case R.id.divide:
                display.setText(oldNum+"÷");
                op="÷";
                break;
            case R.id.multiply:
                display.setText(oldNum+"×");
                op="×";
                break;
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
        newNum = display.getText().toString();
        double result = 0;
        double firstNum = Double.parseDouble(oldNum);
        double secondNum = Double.parseDouble(newNum);
        DecimalFormat df = new DecimalFormat("####0.00");
                switch (op){
                    case "+":
                        result = firstNum + secondNum;
                        if(firstNum>=min && firstNum<1000 && secondNum>=min && secondNum<=1000 && result<=max){
                            display.setText(df.format(result) + "");
                            isNewOp = true;
                        }
                        else if(firstNum>=1000 || secondNum>=1000){
                            Toast.makeText(getApplicationContext(), "Only 3 digit number allowed to calculate! Insert another expression", Toast.LENGTH_LONG).show();
                            isNewOp = true;
                        }
                        else if (result>max){
                            Toast.makeText(getApplicationContext(), "Maximum result number is 10000! Insert another expression", Toast.LENGTH_LONG).show();
                            isNewOp = true;
                        }
                        break;
                    case "-":
                        result = firstNum - secondNum;
                        if(firstNum>=min && firstNum<1000 && secondNum>=min && secondNum<1000 && secondNum<=firstNum && result<=max){
                            display.setText(df.format(result) + "");
                            isNewOp = true;
                        }
                        else if(firstNum>=1000 || secondNum>=1000){
                            Toast.makeText(getApplicationContext(), "Only 3 digit number allowed to calculate! Insert another expression", Toast.LENGTH_LONG).show();
                            isNewOp = true;
                        }
                        else if(firstNum>=min && firstNum<=1000 && secondNum>firstNum){
                            Toast.makeText(getApplicationContext(), "Second number cannot be greater than the first number! Insert another expression", Toast.LENGTH_LONG).show();
                            isNewOp = true;
                        }
                        else if (result>max){
                            Toast.makeText(getApplicationContext(), "Maximum result number is 10000! Insert another expression", Toast.LENGTH_LONG).show();
                            isNewOp = true;
                        }
                        break;
                    case "×":
                        result = firstNum * secondNum;
                        if(firstNum>=min && firstNum<=max && secondNum>min && secondNum<11 && result<=max){
                            display.setText(df.format(result) + "");
                            isNewOp = true;
                        }
                        else if(firstNum>=min && firstNum<=max && secondNum==100 && result<=max){
                            display.setText(df.format(result) + "");
                            isNewOp = true;
                        }
                        else if(firstNum>=min && firstNum<=max && secondNum==1000 && result<=max){
                            display.setText(df.format(result) + "");
                            isNewOp = true;
                        }
                        else if(firstNum>=min && firstNum<=max && secondNum>10 && secondNum<100){
                            Toast.makeText(getApplicationContext(), "Cannot multiply number other than 1-10, 100 and 1000! Insert another expression", Toast.LENGTH_LONG).show();
                            isNewOp = true;
                        }
                        else if(firstNum>=min && firstNum<max && secondNum>100 && secondNum<1000){
                            Toast.makeText(getApplicationContext(), "Cannot multiply number other than 1-10, 100 and 1000! Insert another expression", Toast.LENGTH_LONG).show();
                            isNewOp = true;
                        }
                        else if(firstNum>=min && firstNum<max && secondNum>1000){
                            Toast.makeText(getApplicationContext(), "Cannot multiply number other than 1-10, 100 and 1000! Insert another expression", Toast.LENGTH_LONG).show();
                            isNewOp = true;
                        }
                        else if (result>max){
                            Toast.makeText(getApplicationContext(), "Exceeded maximum number 10000! Insert another expression", Toast.LENGTH_LONG).show();
                            isNewOp = true;
                        }
                        break;
                    case "÷":
                        result = Double.parseDouble(oldNum) / Double.parseDouble(newNum);
                        if(firstNum>=min && firstNum<max && secondNum>min && secondNum<11 && result<=max){
                            display.setText(df.format(result) + "");
                            isNewOp = true;
                        }
                        else if(firstNum>=min && firstNum<max && secondNum==100 && result<=max){
                            display.setText(df.format(result) + "");
                            isNewOp = true;
                        }
                        else if(firstNum>=min && firstNum<max && secondNum==1000 && result<=max){
                            display.setText(df.format(result) + "");
                            isNewOp = true;
                        }
                        else if(firstNum>=min && firstNum<max && secondNum>10 && secondNum<100){
                            Toast.makeText(getApplicationContext(), "Only 4 digit with 1-10 or 100 or 1000 allowed to divide! Insert another expression", Toast.LENGTH_LONG).show();
                            isNewOp = true;
                        }
                        else if(firstNum>=min && firstNum<max && secondNum>100 && secondNum<1000){
                            Toast.makeText(getApplicationContext(), "Only 4 digit with 1-10 or 100 or 1000 allowed to divide! Insert another expression", Toast.LENGTH_LONG).show();
                            isNewOp = true;
                        }
                        else if(firstNum>=min && firstNum<max && secondNum>1000){
                            Toast.makeText(getApplicationContext(), "Only 4 digit with 1-10 or 100 or 1000 allowed to divide! Insert another expression", Toast.LENGTH_LONG).show();
                            isNewOp = true;
                        }
                        else if (result>max){
                            Toast.makeText(getApplicationContext(), "Exceeded maximum number 10000! Insert another expression", Toast.LENGTH_LONG).show();
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