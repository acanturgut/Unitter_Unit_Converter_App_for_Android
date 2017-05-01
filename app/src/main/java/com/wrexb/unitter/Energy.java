package com.wrexb.unitter;

/**
 * Created by Can on 26/06/15.
 */
public class Energy {

    public enum EnergyRatio{

        Joule(1),
        Kilojoule(1000),
        Kilogrammeter(9.80665),
        Watthour(3600),
        Kilowatthour(3600000),
        Erg(Math.pow(10,-7)),
        Calorie(4.1868),
        Kilocalorie(4186.8),
        FootPoundal(0.0421401100938),
        InchPoundForce(0.1129848290276167),
        FootPoundForce (1.3558179483314004),
        HorsepowerHour (2.6845*Math.pow(10,6)),
        BTU(1055.05585262),
        Electronvolt(1.6021765314*Math.pow(10,-19)),
        Hartree(4.3597441775*Math.pow(10,-18)),
        Rydberg(2.179872*Math.pow(10,-18));



        private final double ratio;
        EnergyRatio(double ratio){
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
        return  EnergyRatio.valueOf(from).getRatio() /  EnergyRatio.valueOf(to).getRatio();
    }
}
