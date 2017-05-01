package com.wrexb.unitter;

public class Force {

    public enum ForceRatio{
        Dyne(0.0001),
        Poundal(1.3825495),
        Newton(10),
        PoundForce(44.482216),
        KilogramForce(98.0665),
        Sthene(10000),
        Kip(44482.216),
        TonForceMetric(98066.5),
        Meganewton(10000000);

        private final double ratio;
        ForceRatio(double ratio){
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
        return  ForceRatio.valueOf(from).getRatio() /  ForceRatio.valueOf(to).getRatio();
    }
}
