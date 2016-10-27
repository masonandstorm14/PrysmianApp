package com.example.mason.prysmianapp;

/**
 * Created by mason on 10/8/2016.
 */
public class FillRatioCalc {
    public void FillRatioCalc(){

    }

    public double CalcFillRatio(double B4, double B5, double B6, double B7, double B8, double B9, double B3){
      return Math.pow(Math.pow(Math.pow(B4*(B5/2),2*Math.PI+B6*(B7/2)), 2*Math.PI+B8*(B9/2)),2*Math.PI )/ Math.pow((B3/2), 2*Math.PI);
    }
}
