package com.wrexb.unitter;

/**
 * Created by Can on 26/06/15.
 */
public class Pressure {

    public enum PressureRatio{

        Pascal(1),
        Hectopascal (100),
        Kilopascal(1000),
        Megapascal (1000000),
        Atmosphere (101325),
        Torr(133.322),
        Millimetersofmercury (133.322),
        Psi (9894.76),
        Newtonpersquaremillimeter(1000000),
        Kilogrampersquaremeter (9.8067),
        Bar(100000) ;



        private final double ratio;
        PressureRatio(double ratio){
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
        return  PressureRatio.valueOf(from).getRatio() /  PressureRatio.valueOf(to).getRatio();
    }
}
