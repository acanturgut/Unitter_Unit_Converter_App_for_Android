package com.wrexb.unitter;

public class Length {

    public enum LengthRatio{
        Millimeter(5),
        Centimeter(50),
        Inch(127),
        Feet(1524),
        Yard(4572),
        Meter(5000),
        Kilometer(500000),
        Mile(804672);

        private final int ratio;
        LengthRatio(int ratio){
            this.ratio = ratio;
        }
        private int getRatio(){
            return ratio;
        }
    }

    public Length(){

    }

    public double calculate(double value, String from, String to){

        double kat = getRatio(from, to);
        return value * kat;
    }

    public double getRatio(String from, String to){
        return (double) LengthRatio.valueOf(from).getRatio() / (double) LengthRatio.valueOf(to).getRatio();
    }


}
