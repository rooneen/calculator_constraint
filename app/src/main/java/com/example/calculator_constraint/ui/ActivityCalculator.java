package com.example.calculator_constraint.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator_constraint.R;
import com.example.calculator_constraint.domain.CalculatorImpl;
import com.example.calculator_constraint.domain.Operation;

import java.util.HashMap;

public class ActivityCalculator extends AppCompatActivity implements CalculatorVeiw {

    private TextView txtResult;
    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_constraint);

        txtResult = findViewById(R.id.result);

        presenter = new CalculatorPresenter(this, new CalculatorImpl());

        findViewById(R.id.key_point).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDotPresset();
            }
        });

        HashMap<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.key_0,0);
        digits.put(R.id.key_1,1);
        digits.put(R.id.key_2,2);
        digits.put(R.id.key_3,3);
        digits.put(R.id.key_4,4);
        digits.put(R.id.key_5,5);
        digits.put(R.id.key_6,6);
        digits.put(R.id.key_7,7);
        digits.put(R.id.key_8,8);
        digits.put(R.id.key_9,9);

        View.OnClickListener digitClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onDigitPresset(digits.get(v.getId()));

            }
        };

        findViewById(R.id.key_0).setOnClickListener(digitClickListener);
        findViewById(R.id.key_1).setOnClickListener(digitClickListener);
        findViewById(R.id.key_2).setOnClickListener(digitClickListener);
        findViewById(R.id.key_3).setOnClickListener(digitClickListener);
        findViewById(R.id.key_4).setOnClickListener(digitClickListener);
        findViewById(R.id.key_5).setOnClickListener(digitClickListener);
        findViewById(R.id.key_6).setOnClickListener(digitClickListener);
        findViewById(R.id.key_7).setOnClickListener(digitClickListener);
        findViewById(R.id.key_8).setOnClickListener(digitClickListener);
        findViewById(R.id.key_9).setOnClickListener(digitClickListener);

        HashMap<Integer, Operation> operands = new HashMap<>();
        operands.put(R.id.key_minus,Operation.SUB);
        operands.put(R.id.key_multiply,Operation.MULT);
        operands.put(R.id.key_divide,Operation.DIV);
        operands.put(R.id.key_plus,Operation.SUM);

        View.OnClickListener operandsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onOperandPresset(operands.get(v.getId()));

            }
        };



        findViewById(R.id.key_minus).setOnClickListener(operandsClickListener);
        findViewById(R.id.key_multiply).setOnClickListener(operandsClickListener);
        findViewById(R.id.key_divide).setOnClickListener(operandsClickListener);
        findViewById(R.id.key_plus).setOnClickListener(operandsClickListener);


    }

    @Override
    public void shouResult(String value) {
        txtResult.setText(value);

    }
}