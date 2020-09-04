package com.example.intentproblem1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    double a, b, answer;
    char sign;
    EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display=(EditText)findViewById(R.id.display);
    }

    public void plus(View view)
    {
        a=Double.parseDouble(String.valueOf(display.getText()));
        sign='+';
    }

    public void minus(View view)
    {
        a=Double.parseDouble(String.valueOf(display.getText()));
        sign='-';
    }

    public void multiply(View view)
    {
        a=Double.parseDouble(String.valueOf(display.getText()));
        sign='*';
    }

    public void divide(View view)
    {
        a=Double.parseDouble(String.valueOf(display.getText()));
        sign='/';
    }

    public void answer(View view)
    {
        b=Double.parseDouble(String.valueOf(display.getText()));

        if (sign=='+') answer=a+b;
        else if (sign=='-') answer=a-b;
        else if (sign=='*') answer=a*b;
        else if (sign=='/') answer=a/b;

        display.setText(""+answer);
    }
}