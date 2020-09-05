package com.example.intentproblem1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    double a, b, answer;
    char sign;
    EditText display;
    Intent si;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display=(EditText)findViewById(R.id.display);
        a=0;
        b=0;
        answer=0;
        si=new Intent(this, CreditsActivity.class);
    }

    public void plus(View view)
    {
        a=Double.parseDouble(String.valueOf(display.getText()));
        sign='+';
        display.setText("");
    }

    public void minus(View view)
    {
        a=Double.parseDouble(String.valueOf(display.getText()));
        sign='-';
        display.setText("");
    }

    public void multiply(View view)
    {
        a=Double.parseDouble(String.valueOf(display.getText()));
        sign='*';
        display.setText("");
    }

    public void divide(View view)
    {
        a=Double.parseDouble(String.valueOf(display.getText()));
        sign='/';
        display.setText("");
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

    public void clear(View view)
    {
        display.setText("");
    }

    public void goToCredits(View view)
    {
        si.putExtra("answer",answer);
        startActivity(si);
    }
}