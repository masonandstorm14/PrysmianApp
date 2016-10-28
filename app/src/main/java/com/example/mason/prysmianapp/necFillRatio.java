package com.example.mason.prysmianapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class necFillRatio extends AppCompatActivity {

    private String[] arraySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nec_fill_ratio);

        //sets view items
        final Spinner nominalDiameter = (Spinner) findViewById(R.id.spin_insideDiameter);
        final Spinner conduit = (Spinner) findViewById(R.id.spin_conduit);
        Button calculate = (Button) findViewById(R.id.btn_Calculate);
        final EditText B3 = (EditText) findViewById(R.id.editText_insideDiamter);
        final EditText B4 = (EditText) findViewById(R.id.editText_phaseCables);
        final EditText B5 = (EditText) findViewById(R.id.editText_phaseCableDiameter);
        final EditText B6 = (EditText) findViewById(R.id.editText_groundWire);
        final EditText B7 = (EditText) findViewById(R.id.editText_groundWireDiameter);
        final EditText B8 = (EditText) findViewById(R.id.editText_neutralWire);
        final EditText B9 = (EditText) findViewById(R.id.editText_neutralWireDiameter);


        //changes the conduit Diameter options based on the Conduit Type
        final nominalDiameterAdapterSetter diameterSetter = new nominalDiameterAdapterSetter();
        final conduitInsideDiameterCalc diameterCalc = new conduitInsideDiameterCalc();
        conduit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                arraySpinner = diameterSetter.nominalDiameterAdapterSetter(id);
                ArrayAdapter<String>  adapter = new ArrayAdapter<String>(necFillRatio.this, android.R.layout.simple_list_item_1, arraySpinner);
                nominalDiameter.setAdapter(adapter);

                B3.setText(Double.toString(diameterCalc.conduitInsideDiameterCalc(id, nominalDiameter.getSelectedItemId())));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        nominalDiameter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                B3.setText(Double.toString(diameterCalc.conduitInsideDiameterCalc(conduit.getSelectedItemId(), id)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //when calculate button is pressed
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( !B3.getText().toString().equals("") && !B4.getText().toString().equals("") && !B5.getText().toString().equals("") && !B6.getText().toString().equals("") && !B7.getText().toString().equals("") && !B8.getText().toString().equals("") && !B9.getText().toString().equals("")){
                    FillRatioCalc calc = new FillRatioCalc();
                    /// TODO: 10/27/2016 fix this not kow why 
                    double calculatedFillRatio = calc.CalcFillRatio(Double.parseDouble(B4.getText().toString()),Double.parseDouble(B5.getText().toString()),Double.parseDouble(B6.getText().toString()),Double.parseDouble(B7.getText().toString()),Double.parseDouble(B8.getText().toString()),Double.parseDouble(B9.getText().toString()),Double.parseDouble(B3.getText().toString()));
                    mover(FillRatioResult.class, calculatedFillRatio);
                }
            }
        });


    }

    private void mover(Class moveTo, double calculatedFillRatio){
        Intent i = new Intent(this,moveTo);
        Bundle b = new Bundle();
        b.putDouble("calculatedFillRatio", calculatedFillRatio);
        i.putExtras(b);
        startActivity(i);
    }
}
