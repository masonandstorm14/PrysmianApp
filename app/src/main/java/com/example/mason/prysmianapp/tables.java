package com.example.mason.prysmianapp;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class tables extends AppCompatActivity {

    private String metalType = "C";
    private String chartType = "T";
    private int changeChecker = 20;
    private String[] arraySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);

        final Button C = (Button) findViewById(R.id.btn_C);
        final Button A = (Button) findViewById(R.id.btn_A);
        final Button T = (Button) findViewById(R.id.btn_T);
        final Button I = (Button) findViewById(R.id.btn_I);
        final Button CF = (Button) findViewById(R.id.btn_cf);

        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                C.setTextColor(getResources().getColor(R.color.red));
                A.setTextColor(getResources().getColor(R.color.black));
                metalType = "C";
                whereGo();
            }
        });

        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A.setTextColor(getResources().getColor(R.color.red));
                C.setTextColor(getResources().getColor(R.color.black));
                metalType = "A";
                whereGo();
            }
        });

        T.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T.setTextColor(getResources().getColor(R.color.red));
                I.setTextColor(getResources().getColor(R.color.black));
                CF.setTextColor(getResources().getColor(R.color.black));
                chartType = "T";
                whereGo();
            }
        });

        I.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I.setTextColor(getResources().getColor(R.color.red));
                T.setTextColor(getResources().getColor(R.color.black));
                CF.setTextColor(getResources().getColor(R.color.black));
                chartType = "I";
                whereGo();
            }
        });

        CF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CF.setTextColor(getResources().getColor(R.color.red));
                T.setTextColor(getResources().getColor(R.color.black));
                I.setTextColor(getResources().getColor(R.color.black));
                chartType = "CF";
                whereGo();
            }
        });

        final Spinner conductorType = (Spinner) findViewById(R.id.spin_ConductorType);
        final Spinner circuit = (Spinner) findViewById(R.id.spin_Circuit);

        conductorType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(changeChecker != position) {
                    if(id <= 4){
                        circuit.setAdapter(adapterMaker1("One"));
                    } else if(id == 5){
                        circuit.setAdapter(adapterMaker3("One", "Three", "Six"));
                    }else if(id == 6){
                        circuit.setAdapter(adapterMaker3("One", "Three", "Six"));
                    }else if(id == 7){
                        circuit.setAdapter(adapterMaker2("One", "Two"));
                    }else if(id == 8){
                        circuit.setAdapter(adapterMaker2("One", "Two"));
                    }else if(id == 9){
                        circuit.setAdapter(adapterMaker2("One", "Two"));
                    }
                    if (position <= 4 && chartType.equals("I")) {
                        I.setTextColor(getResources().getColor(R.color.black));
                        I.setEnabled(false);
                        I.setAlpha(.05f);
                        T.setTextColor(getResources().getColor(R.color.red));
                        chartType = "T";
                        changeChecker = position;
                    } else if (position < 4) {
                        I.setEnabled(false);
                        I.setAlpha(.05f);
                        changeChecker = position;
                    } else {
                        I.setEnabled(true);
                        I.setAlpha(1f);
                        changeChecker = position;
                    }
                    whereGo();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        circuit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                whereGo();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    protected ArrayAdapter<String> adapterMaker1(String one){
        arraySpinner = new String[]{
                one
        };
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraySpinner);
        return adapter;
    }

    protected ArrayAdapter<String> adapterMaker2(String one, String two){
        arraySpinner = new String[]{
                one, two
        };
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraySpinner);
        return adapter;
    }

    protected ArrayAdapter<String> adapterMaker3(String one, String two, String three){
        arraySpinner = new String[]{
                one, two, three
        };
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraySpinner);
        return adapter;
    }

    protected void whereGo(){
        Spinner conductorType = (Spinner) findViewById(R.id.spin_ConductorType);
        Spinner circuit = (Spinner) findViewById(R.id.spin_Circuit);
        final SubsamplingScaleImageView chart = (SubsamplingScaleImageView) findViewById(R.id.image_chart);

        if(chartType.equals("CF")){
            chart.setImage(ImageSource.resource(R.drawable.tempcorrection));
        }
        if(metalType.equals("C") && chartType.equals("T") ){
            metalCChart(chart, conductorType, circuit);
        } else if(metalType.equals("C") && chartType.equals("I")){
            metalCInstall(chart, conductorType, circuit);
        }else if(metalType.equals("A") && chartType.equals("T")){
            metalAChart(chart, conductorType, circuit);
        }else if(metalType.equals("A") && chartType.equals("I")){
            metalAInstall(chart, conductorType, circuit);
        }

    }

    protected void metalCChart(SubsamplingScaleImageView  chart, Spinner conductorType, Spinner circuit){
        if(conductorType.getSelectedItemPosition() == 0){
            chart.setImage(ImageSource.resource(R.drawable.table67));
        }else if(conductorType.getSelectedItemPosition() == 1){
            chart.setImage(ImageSource.resource(R.drawable.table69));
        }else if(conductorType.getSelectedItemPosition() == 2){
            chart.setImage(ImageSource.resource(R.drawable.table71));
        }else if(conductorType.getSelectedItemPosition() == 3){
            chart.setImage(ImageSource.resource(R.drawable.table73));
        }else if(conductorType.getSelectedItemPosition() == 4){
            chart.setImage(ImageSource.resource(R.drawable.table75));
        }else if(conductorType.getSelectedItemPosition() == 5 && circuit.getSelectedItemPosition() == 0){
            chart.setImage(ImageSource.resource(R.drawable.table77));
        }else if(conductorType.getSelectedItemPosition() == 5 && circuit.getSelectedItemPosition() == 1){
            chart.setImage(ImageSource.resource(R.drawable.table77_2));
        }else if(conductorType.getSelectedItemPosition() == 5 && circuit.getSelectedItemPosition() == 2){
            chart.setImage(ImageSource.resource(R.drawable.table77_3));
        }else if(conductorType.getSelectedItemPosition() == 6 && circuit.getSelectedItemPosition() == 0){
            chart.setImage(ImageSource.resource(R.drawable.table79));
        }else if(conductorType.getSelectedItemPosition() == 6 && circuit.getSelectedItemPosition() == 1){
            chart.setImage(ImageSource.resource(R.drawable.table79_2));
        }else if(conductorType.getSelectedItemPosition() == 6 && circuit.getSelectedItemPosition() == 2){
            chart.setImage(ImageSource.resource(R.drawable.table79_3));
        }else if(conductorType.getSelectedItemPosition() == 7 && circuit.getSelectedItemPosition() == 0){
            chart.setImage(ImageSource.resource(R.drawable.table81));
        }else if(conductorType.getSelectedItemPosition() == 7 && circuit.getSelectedItemPosition() == 1){
            chart.setImage(ImageSource.resource(R.drawable.table81_2));
        }else if(conductorType.getSelectedItemPosition() == 8 && circuit.getSelectedItemPosition() == 0){
            chart.setImage(ImageSource.resource(R.drawable.table83));
        }else if(conductorType.getSelectedItemPosition() == 8 && circuit.getSelectedItemPosition() == 1){
            chart.setImage(ImageSource.resource(R.drawable.table83_2));
        }else if(conductorType.getSelectedItemPosition() == 9 && circuit.getSelectedItemPosition() == 0){
            chart.setImage(ImageSource.resource(R.drawable.table85));
        }else if(conductorType.getSelectedItemPosition() == 9 && circuit.getSelectedItemPosition() == 1){
            chart.setImage(ImageSource.resource(R.drawable.table85_2));
        }
    }

    protected void metalCInstall(SubsamplingScaleImageView chart, Spinner conductorType, Spinner circuit){
        if(conductorType.getSelectedItemPosition() == 5 && circuit.getSelectedItemPosition() == 0){
            chart.setImage(ImageSource.resource(R.drawable.detail1));
        }else if(conductorType.getSelectedItemPosition() == 5 && circuit.getSelectedItemPosition() == 1){
            chart.setImage(ImageSource.resource(R.drawable.detail2));
        }else if(conductorType.getSelectedItemPosition() == 5 && circuit.getSelectedItemPosition() == 2){
            chart.setImage(ImageSource.resource(R.drawable.detail3));
        }else if(conductorType.getSelectedItemPosition() == 6 && circuit.getSelectedItemPosition() == 0){
            chart.setImage(ImageSource.resource(R.drawable.detail1));
        }else if(conductorType.getSelectedItemPosition() == 6 && circuit.getSelectedItemPosition() == 1){
            chart.setImage(ImageSource.resource(R.drawable.detail2));
        }else if(conductorType.getSelectedItemPosition() == 6 && circuit.getSelectedItemPosition() == 2){
            chart.setImage(ImageSource.resource(R.drawable.detail3));
        }else if(conductorType.getSelectedItemPosition() == 7 && circuit.getSelectedItemPosition() == 0){
            chart.setImage(ImageSource.resource(R.drawable.detail9));
        }else if(conductorType.getSelectedItemPosition() == 7 && circuit.getSelectedItemPosition() == 1){
            chart.setImage(ImageSource.resource(R.drawable.detail10));
        }else if(conductorType.getSelectedItemPosition() == 8 && circuit.getSelectedItemPosition() == 0){
            chart.setImage(ImageSource.resource(R.drawable.detail5));
        }else if(conductorType.getSelectedItemPosition() == 8 && circuit.getSelectedItemPosition() == 1){
            chart.setImage(ImageSource.resource(R.drawable.detail6));
        }else if(conductorType.getSelectedItemPosition() == 9 && circuit.getSelectedItemPosition() == 0){
            chart.setImage(ImageSource.resource(R.drawable.detail7));
        }else if(conductorType.getSelectedItemPosition() == 9 && circuit.getSelectedItemPosition() == 1){
            chart.setImage(ImageSource.resource(R.drawable.detail8));
        }
    }

    protected void metalAChart(SubsamplingScaleImageView chart, Spinner conductorType, Spinner circuit){
        if(conductorType.getSelectedItemPosition() == 0){
            chart.setImage(ImageSource.resource(R.drawable.table68));
        }else if(conductorType.getSelectedItemPosition() == 1){
            chart.setImage(ImageSource.resource(R.drawable.table70));
        }else if(conductorType.getSelectedItemPosition() == 2){
            chart.setImage(ImageSource.resource(R.drawable.table72));
        }else if(conductorType.getSelectedItemPosition() == 3){
            chart.setImage(ImageSource.resource(R.drawable.table74));
        }else if(conductorType.getSelectedItemPosition() == 4){
            chart.setImage(ImageSource.resource(R.drawable.table76));
        }else if(conductorType.getSelectedItemPosition() == 5 && circuit.getSelectedItemPosition() == 0){
            chart.setImage(ImageSource.resource(R.drawable.table78));
        }else if(conductorType.getSelectedItemPosition() == 5 && circuit.getSelectedItemPosition() == 1){
            chart.setImage(ImageSource.resource(R.drawable.table78_2));
        }else if(conductorType.getSelectedItemPosition() == 5 && circuit.getSelectedItemPosition() == 2){
            chart.setImage(ImageSource.resource(R.drawable.table78_3));
        }else if(conductorType.getSelectedItemPosition() == 6 && circuit.getSelectedItemPosition() == 0){
            chart.setImage(ImageSource.resource(R.drawable.table80));
        }else if(conductorType.getSelectedItemPosition() == 6 && circuit.getSelectedItemPosition() == 1){
            chart.setImage(ImageSource.resource(R.drawable.table80_2));
        }else if(conductorType.getSelectedItemPosition() == 6 && circuit.getSelectedItemPosition() == 2){
            chart.setImage(ImageSource.resource(R.drawable.table80_3));
        }else if(conductorType.getSelectedItemPosition() == 7 && circuit.getSelectedItemPosition() == 0){
            chart.setImage(ImageSource.resource(R.drawable.table82));
        }else if(conductorType.getSelectedItemPosition() == 7 && circuit.getSelectedItemPosition() == 1){
            chart.setImage(ImageSource.resource(R.drawable.table82_2));
        }else if(conductorType.getSelectedItemPosition() == 8 && circuit.getSelectedItemPosition() == 0){
            chart.setImage(ImageSource.resource(R.drawable.table84));
        }else if(conductorType.getSelectedItemPosition() == 8 && circuit.getSelectedItemPosition() == 1){
            chart.setImage(ImageSource.resource(R.drawable.table84_2));
        }else if(conductorType.getSelectedItemPosition() == 9 && circuit.getSelectedItemPosition() == 0){
            chart.setImage(ImageSource.resource(R.drawable.table86));
        }else if(conductorType.getSelectedItemPosition() == 9 && circuit.getSelectedItemPosition() == 1){
            chart.setImage(ImageSource.resource(R.drawable.table86_2));
        }
    }

    protected void metalAInstall(SubsamplingScaleImageView chart, Spinner conductorType, Spinner circuit){
        if(conductorType.getSelectedItemPosition() == 5 && circuit.getSelectedItemPosition() == 0){
            chart.setImage(ImageSource.resource(R.drawable.detail1));
        }else if(conductorType.getSelectedItemPosition() == 5 && circuit.getSelectedItemPosition() == 1){
            chart.setImage(ImageSource.resource(R.drawable.detail2));
        }else if(conductorType.getSelectedItemPosition() == 5 && circuit.getSelectedItemPosition() == 2){
            chart.setImage(ImageSource.resource(R.drawable.detail3));
        }else if(conductorType.getSelectedItemPosition() == 6 && circuit.getSelectedItemPosition() == 0){
            chart.setImage(ImageSource.resource(R.drawable.detail1));
        }else if(conductorType.getSelectedItemPosition() == 6 && circuit.getSelectedItemPosition() == 1){
            chart.setImage(ImageSource.resource(R.drawable.detail2));
        }else if(conductorType.getSelectedItemPosition() == 6 && circuit.getSelectedItemPosition() == 2){
            chart.setImage(ImageSource.resource(R.drawable.detail3));
        }else if(conductorType.getSelectedItemPosition() == 7 && circuit.getSelectedItemPosition() == 0){
            chart.setImage(ImageSource.resource(R.drawable.detail9));
        }else if(conductorType.getSelectedItemPosition() == 7 && circuit.getSelectedItemPosition() == 1){
            chart.setImage(ImageSource.resource(R.drawable.detail10));
        }else if(conductorType.getSelectedItemPosition() == 8 && circuit.getSelectedItemPosition() == 0){
            chart.setImage(ImageSource.resource(R.drawable.detail5));
        }else if(conductorType.getSelectedItemPosition() == 8 && circuit.getSelectedItemPosition() == 1){
            chart.setImage(ImageSource.resource(R.drawable.detail6));
        }else if(conductorType.getSelectedItemPosition() == 9 && circuit.getSelectedItemPosition() == 0){
            chart.setImage(ImageSource.resource(R.drawable.detail7));
        }else if(conductorType.getSelectedItemPosition() == 9 && circuit.getSelectedItemPosition() == 1){
            chart.setImage(ImageSource.resource(R.drawable.detail8));
        }
    }
}
