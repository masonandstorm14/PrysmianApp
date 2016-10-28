package com.example.mason.prysmianapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

/**
 * Created by mason on 10/27/2016.
 */
public class nominalDiameterAdapterSetter {

    private String[] arraySpinner;

    public void nominalDiameterAdapterSetter() {
    }

    public String[] nominalDiameterAdapterSetter(long id) {
        if (id == 0) {

            arraySpinner = new String[]{
                    "1/2\"", "3/4\"", "1\"", "1-1/4\"", "1-1/2\"", "2\"", "2-1/2\"", "3\"", "3-1/2\"", "4\"", "5\"", "6\""
            };
            return arraySpinner;
        } else if (id == 1) {

            arraySpinner = new String[]{
                    "1/2\"", "3/4\"", "1\"", "1-1/4\"", "1-1/2\"", "2\"", "2-1/2\"", "3\"", "3-1/2\"", "4\"", "5\"", "6\""
            };

            return arraySpinner;
        } else if (id == 2) {

            arraySpinner = new String[]{
                    "1/2\"", "3/4\"", "1\"", "1-1/4\"", "1-1/2\"", "2\"", "2-1/2\"", "3\"", "3-1/2\"", "4\"", "5\"", "6\""
            };

            return arraySpinner;
        } else if (id == 3) {

            arraySpinner = new String[]{
                    "1/2\"", "3/4\"", "1\"", "1-1/4\"", "1-1/2\"", "2\"", "2-1/2\"", "3\"", "3-1/2\"", "4\""
            };

            return arraySpinner;
        } else if (id == 4) {

            arraySpinner = new String[]{
                    "2\"", "3\"", "3-1/2\"", "4\"", "5\"", "6\""
            };

            return arraySpinner;
        } else if (id == 5) {

            arraySpinner = new String[]{
                    "1/2\"", "3/4\"", "1\"", "1-1/4\"", "1-1/2\"", "2\"", "2-1/2\"", "3\"", "3-1/2\"", "4\""
            };

            return arraySpinner;
        } else if (id == 6) {

            arraySpinner = new String[]{
                    "1/2\"", "3/4\"", "1\"", "1-1/4\"", "1-1/2\"", "2\""
            };

            return arraySpinner;
        } else if (id == 7) {

            arraySpinner = new String[]{
                    "1/2\"", "3/4\"", "1\"", "1-1/4\"", "1-1/2\"", "2\"", "2-1/2\"", "3\"", "3-1/2\"", "4\""
            };

            return arraySpinner;
        } else if (id == 8) {

            arraySpinner = new String[]{
                    "1\"", "1/2\"", "3/4\"", "1\"", "1-1/4\"", "1-1/2\"", "2\"", "2-1/2\"", "3\"", "3-1/2\"", "4\""
            };

            return arraySpinner;
        } else if (id == 9) {


            arraySpinner = new String[]{
                    "1\"", "1/2\"", "3/4\"", "1\"", "1-1/4\"", "1-1/2\"", "2\""
            };

            return arraySpinner;
        } else if (id == 10) {

            arraySpinner = new String[]{
                    "1\"", "1/2\"", "3/4\"", "1\"", "1-1/4\"", "1-1/2\"", "2\""
            };

            return arraySpinner;
        } else if (id == 11) {

            arraySpinner = new String[]{
                    "1\"", "1/2\"", "3/4\"", "1\"", "1-1/4\"", "1-1/2\"", "2\"", "2-1/2\"", "3\"", "3-1/2\"", "4\""
            };

            return arraySpinner;
        } else {
            return null;
        }
    }
}
