package com.endava.calculator.Basic;

public interface BasicOperations {
    public abstract int add(int... no);
    public abstract long add(long... no);
    public abstract double add(double... no);

    public int substract(int...no);
    public long substract(long...no);
    public double substract(double...no);

    public abstract long multiply(int... no);
    public abstract long multiply(long... no);
    public abstract double multiply(double... no);

    public abstract double divide (int... no);
    public abstract long divide (long...no);
    public abstract double divide (double...no);

}
