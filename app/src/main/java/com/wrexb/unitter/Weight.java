package com.wrexb.unitter;

/**
 * Created by Can on 26/06/15.
 */
public class Weight {

    public enum WeightRatio{

        Milligram(0.001),
        Gram(1),
        Kilogram (1000),
        Metrictonne(1000000),
        Carat (0.2),
        Quintal(100000),
        AtomicMassUnit(1.6605*Math.pow(10,-24)),
        PlanckMass(2.1765*Math.pow(10,-5)),
        Ounce (28.3495),
        Pound (453.5924),
        Stone(6350.2932),
        USHundredweight(45359.237),
        ImpHundredweight(50802.3554),
        ShortTon(9.0718474*Math.pow(10,5)),
        LongTon(1.0160*Math.pow(10,6)),
        Grain(0.0648);


        private final double ratio;
        WeightRatio(double ratio){
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
        return  WeightRatio.valueOf(from).getRatio() /  WeightRatio.valueOf(to).getRatio();
    }
}
