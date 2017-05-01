package com.wrexb.unitter;

/**
 * Created by Can on 26/06/15.
 */
public class Time {

    public enum TimeRatio{

        Nanosecond (Math.pow(10,-9)),
        Microsecond(Math.pow(10,-6)),
        Millisecond(0.001),
        Second (1),
        Minute (60),
        Quadrans (900),
        Hour(3600),
        Day(86400),
        Week(6.048*Math.pow(10,5)),
        Month30Days(2.5920*Math.pow(10,+6)),
        Year(3.1536*Math.pow(10,7)),
        Century(3.1558*Math.pow(10,9)),
        Millennium(3.1558*Math.pow(10,10));


        private final double ratio;
        TimeRatio(double ratio){
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
        return  TimeRatio.valueOf(from).getRatio() /  TimeRatio.valueOf(to).getRatio();
    }
}
