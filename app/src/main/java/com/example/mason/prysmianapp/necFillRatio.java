package com.example.mason.prysmianapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class necFillRatio extends AppCompatActivity {

    private String[] arraySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nec_fill_ratio);

        final Spinner nominalDiameter = (Spinner) findViewById(R.id.spin_insideDiameter);
        final Spinner conduit = (Spinner) findViewById(R.id.spin_conduit);
        conduit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (id == 0) {
                    nominalDiameter.setAdapter(adapterSCH40PVC("1/2\"", "3/4\"", "1\"", "1-1/4\"", "1-1/2\"", "2\"", "2-1/2\"", "3\"", "3-1/2\"", "4\"", "5\"", "6\""));
                } else if (id == 1) {
                    nominalDiameter.setAdapter(adapterRMC("1/2\"", "3/4\"", "1\"", "1-1/4\"", "1-1/2\"", "2\"", "2-1/2\"", "3\"", "3-1/2\"", "4\"", "5\"", "6\""));
                } else if (id == 2) {
                    nominalDiameter.setAdapter(adapterSCH80PVC("1/2\"", "3/4\"", "1\"", "1-1/4\"", "1-1/2\"", "2\"", "2-1/2\"", "3\"", "3-1/2\"", "4\"", "5\"", "6\""));
                } else if (id == 3) {
                    nominalDiameter.setAdapter(adapterPVC_TYPE_A("1/2\"", "3/4\"", "1\"", "1-1/4\"", "1-1/2\"", "2\"", "2-1/2\"", "3\"", "3-1/2\"", "4\""));
                } else if (id == 4) {
                    nominalDiameter.setAdapter(adapterPVC_TYPE_EB("2\"", "3\"", "3-1/2\"", "4\"", "5\"", "6\""));
                } else if (id == 5) {
                    nominalDiameter.setAdapter(adapterEMT("1/2\"", "3/4\"", "1\"", "1-1/4\"", "1-1/2\"", "2\"", "2-1/2\"", "3\"", "3-1/2\"", "4\""));
                } else if (id == 6) {
                    nominalDiameter.setAdapter(adapterENT("1/2\"", "3/4\"", "1\"", "1-1/4\"", "1-1/2\"", "2\""));
                } else if (id == 7) {
                    nominalDiameter.setAdapter(adapterIMC("1/2\"", "3/4\"", "1\"", "1-1/4\"", "1-1/2\"", "2\"", "2-1/2\"", "3\"", "3-1/2\"", "4\""));
                } else if (id == 8) {
                    nominalDiameter.setAdapter(adapterFMC("1\"", "1/2\"", "3/4\"", "1\"", "1-1/4\"", "1-1/2\"", "2\"", "2-1/2\"", "3\"", "3-1/2\"", "4\""));
                } else if (id == 9) {
                    nominalDiameter.setAdapter(adapterLFNC_A("1\"", "1/2\"", "3/4\"", "1\"", "1-1/4\"", "1-1/2\"", "2\""));
                } else if (id == 10) {
                    nominalDiameter.setAdapter(adapterLFNC_B("1\"", "1/2\"", "3/4\"", "1\"", "1-1/4\"", "1-1/2\"", "2\""));
                } else if (id == 11) {
                    nominalDiameter.setAdapter(adapterLFMC("1\"", "1/2\"", "3/4\"", "1\"", "1-1/4\"", "1-1/2\"", "2\"", "2-1/2\"", "3\"", "3-1/2\"", "4\""));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    protected ArrayAdapter<String> adapterSCH40PVC(String two, String three, String four, String five, String six, String seven, String eight, String nine, String ten, String eleven, String twelve, String therteen){
        arraySpinner = new String[]{
                two, three, four, five, six, seven,nine, eight, ten ,eleven, twelve, therteen
        };
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraySpinner);
        return adapter;
    }
    protected ArrayAdapter<String> adapterRMC(String two, String three, String four, String five, String six, String seven, String eight,String nine, String ten, String eleven, String twelve, String therteen){
        arraySpinner = new String[]{
                two, three, four, five, six, seven, eight,nine, ten ,eleven, twelve, therteen
        };
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraySpinner);
        return adapter;
    }
    protected ArrayAdapter<String> adapterSCH80PVC(String two, String three, String four, String five, String six, String seven, String eight,String nine, String ten, String eleven, String twelve, String therteen){
        arraySpinner = new String[]{
                two, three, four, five, six, seven, eight,nine, ten ,eleven, twelve, therteen
        };
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraySpinner);
        return adapter;
    }
    protected ArrayAdapter<String> adapterPVC_TYPE_A(String two, String three, String four, String five, String six, String seven, String eight,String nine, String ten, String eleven){
        arraySpinner = new String[]{
                two, three, four, five, six, seven, eight,nine, ten ,eleven
        };
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraySpinner);
        return adapter;
    }
    protected ArrayAdapter<String> adapterPVC_TYPE_EB(String seven,String nine, String ten, String eleven, String twelve, String therteen){
        arraySpinner = new String[]{
                seven,nine,ten ,eleven, twelve, therteen
        };
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraySpinner);
        return adapter;
    }
    protected ArrayAdapter<String> adapterEMT(String two, String three, String four, String five, String six, String seven, String eight,String nine, String ten, String eleven){
        arraySpinner = new String[]{
                two, three, four, five, six, seven, eight,nine, ten ,eleven
        };
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraySpinner);
        return adapter;
    }
    protected ArrayAdapter<String> adapterENT(String two, String three, String four, String five, String six, String seven){
        arraySpinner = new String[]{
                two, three, four, five, six, seven
        };
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraySpinner);
        return adapter;
    }
    protected ArrayAdapter<String> adapterIMC(String two, String three, String four, String five, String six, String seven, String eight,String nine, String ten, String eleven){
        arraySpinner = new String[]{
                two, three, four, five, six, seven, eight,nine, ten ,eleven
        };
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraySpinner);
        return adapter;
    }
    protected ArrayAdapter<String> adapterFMC(String one, String two, String three, String four, String five, String six, String seven, String eight,String nine, String ten, String eleven){
        arraySpinner = new String[]{
                one, two, three, four, five, six, seven, eight,nine, ten ,eleven
        };
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraySpinner);
        return adapter;
    }
    protected ArrayAdapter<String> adapterLFNC_A(String one, String two, String three, String four, String five, String six, String seven){
        arraySpinner = new String[]{
                one, two, three, four, five, six, seven
        };
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraySpinner);
        return adapter;
    }
    protected ArrayAdapter<String> adapterLFNC_B(String one, String two, String three, String four, String five, String six, String seven){
        arraySpinner = new String[]{
                one, two, three, four, five, six, seven
        };
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraySpinner);
        return adapter;
    }
    protected ArrayAdapter<String> adapterLFMC(String one, String two, String three, String four, String five, String six, String seven, String eight,String nine, String ten, String eleven){
        arraySpinner = new String[]{
                one, two, three, four, five, six, seven, eight,nine, ten ,eleven
        };
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraySpinner);
        return adapter;
    }
}
