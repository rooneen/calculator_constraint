package com.example.calculator_constraint.domain;

public class CalculatorImpl implements Calculator {
    @Override
    public double performOperation(double argOne, double argTwo, Operation operation) {


        switch (operation) {
            case SUB:
                return argOne - argTwo;
        }

       switch (operation) {
           case MULT:
               return argOne * argTwo;
       }

       switch (operation) {
           case DIV:
               return argOne / argTwo;
       }

       switch (operation) {
           case SUM:
               return argOne + argTwo;
       }

       return 0;
    }
}
