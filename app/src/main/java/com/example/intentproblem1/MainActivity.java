package com.example.intentproblem1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    double a, b, answer;
    String aString,bString;
    char sign;
    EditText display;
    Intent si;
    Button plusButton,minusButton, multiplyButton, divideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display=(EditText)findViewById(R.id.display);
        a=0;
        b=0;
        answer=0;
        sign='0';
        si=new Intent(this, CreditsActivity.class);

        plusButton=(Button)findViewById(R.id.plusButton);
        minusButton=(Button)findViewById(R.id.minusButton);
        multiplyButton=(Button)findViewById(R.id.multiplyButton);
        divideButton=(Button)findViewById(R.id.divideButton);
    }

    public void plus(View view)
    {
        aString=String.valueOf(display.getText());
        if (!check(aString)) return;
        a=Double.parseDouble(aString);
        sign='+';
        display.setText("");
        plusButton.setEnabled(false);
        minusButton.setEnabled(false);
        multiplyButton.setEnabled(false);
        divideButton.setEnabled(false);
    }

    public void minus(View view)
    {
        aString=String.valueOf(display.getText());
        if (!check(aString)) return;
        a=Double.parseDouble(aString);
        sign='-';
        display.setText("");
        plusButton.setEnabled(false);
        minusButton.setEnabled(false);
        multiplyButton.setEnabled(false);
        divideButton.setEnabled(false);
    }

    public void multiply(View view)
    {
        aString=String.valueOf(display.getText());
        if (!check(aString)) return;
        a=Double.parseDouble(aString);
        sign='*';
        display.setText("");
        plusButton.setEnabled(false);
        minusButton.setEnabled(false);
        multiplyButton.setEnabled(false);
        divideButton.setEnabled(false);
    }

    public void divide(View view)
    {
        aString=String.valueOf(display.getText());
        if (!check(aString)) return;
        a=Double.parseDouble(aString);
        sign='/';
        display.setText("");
        plusButton.setEnabled(false);
        minusButton.setEnabled(false);
        multiplyButton.setEnabled(false);
        divideButton.setEnabled(false);
    }

    public void answer(View view)
    {
        bString=String.valueOf(display.getText());
        if (!check(bString)) return;
        b=Double.parseDouble(bString);

        if (sign=='+') answer=a+b;
        else if (sign=='-') answer=a-b;
        else if (sign=='*') answer=a*b;
        else if (sign=='/') answer=a/b;
        else if (sign=='0') answer=b;

        display.setText(""+answer);

        plusButton.setEnabled(true);
        minusButton.setEnabled(true);
        multiplyButton.setEnabled(true);
        divideButton.setEnabled(true);
        sign='0';
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

    public boolean check(String x)
    {
        try
        {
            double d = Double.parseDouble(x);
        }
        catch (NumberFormatException nfe)
        {
            Toast.makeText(getApplicationContext(), "Type a number!!!!!!!!!!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}