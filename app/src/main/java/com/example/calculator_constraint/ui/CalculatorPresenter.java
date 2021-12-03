package com.example.calculator_constraint.ui;

import com.example.calculator_constraint.domain.Calculator;
import com.example.calculator_constraint.domain.Operation;

public class CalculatorPresenter {

    private CalculatorVeiw veiw;
    private Calculator calculator;

    private Double argOne = 0.0;
    private Double argTwo = null;
    private Operation previousOperation = null;

    public CalculatorPresenter(CalculatorVeiw veiw, Calculator calculator) {
        this.veiw = veiw;
        this.calculator = calculator;
    }

    public void onDotPresset() {
    }

    public void onDigitPresset(int digit) {

        if(previousOperation != null){

            argTwo = argTwo * 10 + digit;
            veiw.shouResult(String.valueOf(argTwo));

        } else {
            argOne = argOne * 10 + digit;
            veiw.shouResult(String.valueOf(argOne));
        }



    }

    public void onOperandPresset(Operation operation) {

        if(argTwo != null){
            double result = calculator.performOperation(argOne, argTwo, previousOperation);

            veiw.shouResult(String.valueOf(result));
            argOne = result;
            argTwo = 0.0;

        } else {
            argTwo = 0.0;
            previousOperation = operation;
        }
    }
}
