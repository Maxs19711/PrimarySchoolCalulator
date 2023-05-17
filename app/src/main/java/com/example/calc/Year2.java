package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Year2 extends AppCompatActivity {

    private String oldNum = "";
    private String newNum = "";
    private String op = "+";
    private boolean isNewOp = true;
    private EditText display;
    private int max = 1000;
    private int min = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        display = findViewById(R.id.textView4);
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
        int mod = 0;
        int result = 0;
        int firstNum = Integer.parseInt(oldNum);
        int secondNum = Integer.parseInt(newNum);
        switch (op){
            case "+":
                result = firstNum + secondNum;
                if(firstNum>=min && firstNum<=max && secondNum>min && secondNum<=max && result<=max){
                    display.setText(result + "");
                    isNewOp = true;
                }
                else if(firstNum>max-1 || secondNum>max-1){
                    Toast.makeText(getApplicationContext(), "Cannot calculate more than 3 digit number! Insert another expression", Toast.LENGTH_LONG).show();
                    isNewOp = true;
                }
                else if(result>max){
                    Toast.makeText(getApplicationContext(), "Result cannot be greater than 1000! Insert another expression", Toast.LENGTH_LONG).show();
                    isNewOp = true;
                }
                break;
            case "-":
                result = firstNum - secondNum;
                if(firstNum>=min && firstNum<=max && secondNum>=min && secondNum<=max && result<=max && result>=min){
                    display.setText(result + "");
                    isNewOp = true;
                }
                else if(firstNum>=max || secondNum>=max){
                    Toast.makeText(getApplicationContext(), "Only 3 digit number allowed to calculate! Insert another expression", Toast.LENGTH_LONG).show();
                    isNewOp = true;
                }
                else if(firstNum>=min && secondNum<=max && secondNum>firstNum){
                    Toast.makeText(getApplicationContext(), "Second number cannot be greater than the first number! Insert another expression", Toast.LENGTH_LONG).show();
                    isNewOp = true;
                }
                break;
            case "×":
                result = firstNum * secondNum;
                if(firstNum>=min && firstNum<=10 && secondNum>min && secondNum<=10){
                    display.setText(result + "");
                    isNewOp = true;
                }
                else if(firstNum==10 && secondNum>min && secondNum<=10){
                    display.setText(result + "");
                    isNewOp = true;
                }
                else if(firstNum>=min && firstNum<10 && secondNum>10){
                    Toast.makeText(getApplicationContext(), "Multiply operator only allow to calculate 1 digit with 1 digit or 1 digit with 10! Insert another expression", Toast.LENGTH_LONG).show();
                    isNewOp = true;
                }
                else if(firstNum>10 && secondNum>=min && secondNum<10){
                    Toast.makeText(getApplicationContext(), "Multiply operator only allow to calculate 1 digit with 1 digit or 1 digit with 10! Insert another expression", Toast.LENGTH_LONG).show();
                    isNewOp = true;
                }
                else if(firstNum>10 && secondNum>10){
                    Toast.makeText(getApplicationContext(), "Multiply operator only allow to calculate 1 digit with 1 digit or 1 digit with 10! Insert another expression", Toast.LENGTH_LONG).show();
                    isNewOp = true;
                }
                break;
            case "÷":
                result = firstNum / secondNum;
                mod = firstNum % secondNum;
                if(firstNum>=min && secondNum<=10 && mod==min){
                    display.setText(result + "");
                    isNewOp = true;
                }
                else if(firstNum>=min && secondNum<=10 && mod>min && result>=min){
                    display.setText(result + " " + "remainder" + " " + mod);
                    isNewOp = true;
                }else if(secondNum>10){
                    Toast.makeText(Year2.this, "Dividend must be between 0 to 10 only", Toast.LENGTH_LONG).show();
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