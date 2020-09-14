package com.example.intentproblem1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CreditsActivity extends AppCompatActivity
{
    TextView answer;
    Intent gi;
    double x;
    boolean error;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        answer = (TextView) findViewById(R.id.answer);
        gi=getIntent();
        error=gi.getBooleanExtra("error",false);
        if(error)
        {
            answer.setText("Your last answer was: Error");
        }
        else
        {
            x = gi.getDoubleExtra("answer", 0);

            if (x%1==0) answer.setText("Your last answer was: " + (int)x);
            else answer.setText("Your last answer was: " + x);
        }
    }

    public void back(View view)
    {
        finish();
    }
}