package ru.example;

public class Starter {
    public static void main(String[] args) {
        Fraction fr= new Fraction(5,2);
        Fractionable num =Utils.cache(fr);
        System.out.println(num.doubleValue());// sout сработал
        System.out.println(num.doubleValue());// sout молчит
        System.out.println(num.doubleValue());// sout молчит
        num.setNum(8);
        System.out.println(num.doubleValue());// sout сработал
        System.out.println(num.doubleValue());// sout молчит
        System.out.println(num.doubleMult());
        System.out.println(num.doubleMult());
        num.setNum(10);
        System.out.println(num.doubleValue());// sout сработал
        System.out.println(num.doubleMult());
        System.out.println(num.doubleValue());// sout молчит
        System.out.println(num.doubleMult());

    }
}