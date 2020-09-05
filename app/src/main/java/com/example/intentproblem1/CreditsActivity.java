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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        gi=getIntent();
        x=gi.getDoubleExtra("answer",0);
        answer=(TextView)findViewById(R.id.answer);
        answer.setText("Your last answer was: "+x);
    }

    public void back(View view)
    {
        finish();
    }
}