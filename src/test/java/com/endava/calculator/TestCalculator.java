package com.endava.calculator;

import com.endava.calculator.Basic.Basic;
import com.endava.calculator.Basic.BasicOperations;
import com.endava.calculator.Expert.Expert;
import com.endava.calculator.Expert.ExpertOperations;


public class TestCalculator {
    public static void main(String[] args) {
        BasicOperations b = new Basic(3);
        ExpertOperations e = new Expert(3);
        System.out.println(b.add(2,3,4,5));
        System.out.println(b.substract(2));
        System.out.println(b.multiply(2,6));
        System.out.println(b.divide(10,3));
        System.out.println(b.divide(5,0));
        System.out.println(b.multiply(3.5,2.3, 1.2));
        System.out.println(e.pow(2,-5));
        System.out.println(e.root(4));
        System.out.println(e.root(7));
        System.out.println(e.fact(3)); //1 * 2 * 3 = 6
        System.out.println(e.root2(8000, 3));

        System.out.println(e.calculate("22.6+33.4 +3+11.5"));
        System.out.println(e.calculate("2*(-2+3)/5"));
        System.out.println(e.calculate("(3+2)/5*5-(8-2)"));
        System.out.println(e.calculate("3*3+2^4"));  //ridicarea la putere
    }
}
