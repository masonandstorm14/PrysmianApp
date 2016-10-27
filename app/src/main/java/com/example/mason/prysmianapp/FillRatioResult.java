package com.example.mason.prysmianapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FillRatioResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_ratio_result);

        Bundle b = getIntent().getExtras();
        double calculatedFillRatio = b.getDouble("calculatedFillRatio");
        TextView FillRatio = (TextView) findViewById(R.id.text_fillRatioResult);
        FillRatio.setText(String.valueOf(calculatedFillRatio));
    }
}
