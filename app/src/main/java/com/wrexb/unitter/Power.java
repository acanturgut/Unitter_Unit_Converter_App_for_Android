package com.wrexb.unitter;

/**
 * Created by Can on 26/06/15.
 */
public class Power {

    public enum PowerRatio{

        Attowatt(Math.pow(10,-18)),
        CalorieHour(0.00116299999710413),
        Centiwatt (0.01),
        ErgHour(2.7777777777777777*Math.pow(10,-11)),
        Gigawatt (1000000000),
        Hectowatt(100),
        HorsepowerMetric(735.4987999866727),
        Kilowatt(1000),
        Megawatt (1000000),
        Watt (1);



        private final double ratio;
        PowerRatio(double ratio){
            this.ratio = ratio;
        }
        private double getRatio(){
            return ratio;
        }
    }

    public double calculate(double value, String from, String to){

        double kat = getRatio(from, to);
        return value * kat;
    }

    public double getRatio(String from, String to){
        return  PowerRatio.valueOf(from).getRatio() /  PowerRatio.valueOf(to).getRatio();
    }
}
