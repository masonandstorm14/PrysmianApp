package com.example.mason.prysmianapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class homeActivity extends AppCompatActivity {

    private String[] arraySpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button necAmpacityTables = (Button) findViewById(R.id.btn_NecTable);
        necAmpacityTables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mover(tables.class);
            }
        });

        Button necFillRatio = (Button) findViewById(R.id.btn_necFillRatio);
        necFillRatio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mover(necFillRatio.class);
            }
        });


    }

    private void mover(Class moveTo){
        Intent i = new Intent(this,moveTo);
        startActivity(i);
    }
}
