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
    boolean error=false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display=(EditText)findViewById(R.id.display);
        a=0;
        b=0;
        answer=0;
        sign='0';//sign='0' means no operation is done. 9=9
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
        error=false;
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
        error=false;
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
        error=false;
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
        error=false;
    }

    public void answer(View view)
    {
        bString=String.valueOf(display.getText());
        if (!check(bString)) return;
        b=Double.parseDouble(bString);

        if (sign=='+') answer=a+b;
        else if (sign=='-') answer=a-b;
        else if (sign=='*') answer=a*b;
        else if (sign=='/') divide(a,b);
        else if (sign=='0') answer=b;

        if (!error && answer%1==0) display.setText(""+(int)answer);
        else if (!error) display.setText(""+answer);
        else display.setText("Error");

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
        si.putExtra("error",error);
        startActivity(si);
    }

    public void divide(double x, double y)
    {
        if (y==0)
        {
            Toast.makeText(getApplicationContext(), "You can't divide by 0!!!!!!!!!!", Toast.LENGTH_LONG).show();
            error=true;
        }
        else
        {
            answer=x/y;
        }
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