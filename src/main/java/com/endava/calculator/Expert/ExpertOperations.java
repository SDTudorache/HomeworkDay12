package com.endava.calculator.Expert;

import com.endava.calculator.Basic.BasicOperations;

public interface ExpertOperations extends BasicOperations {

    abstract double pow(int base, int exponent);
    abstract double root(int a);
    abstract long fact(int n);
    abstract long factRec(int n);
    abstract long root2(int a, double e); // radical de n
    abstract double calculate (String s);

}
