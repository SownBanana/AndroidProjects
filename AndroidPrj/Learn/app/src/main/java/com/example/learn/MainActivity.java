package com.example.learn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tmpView;           //view phụ
    TextView view;
    String tempOperand = "0";
    String tempOperater = "";
    boolean isOperaterBefore = false;
    boolean isFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*Typeface tf = Typeface.createFromAsset(getAssets(), "digital.ttf");
        view.setTypeface(tf);*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.view);
        tmpView = findViewById(R.id.tmpView);
        findViewById(R.id.bs).setOnClickListener(this);
        findViewById(R.id.c).setOnClickListener(this);
        findViewById(R.id.ce).setOnClickListener(this);
        findViewById(R.id.div).setOnClickListener(this);
        findViewById(R.id.mul).setOnClickListener(this);
        findViewById(R.id.plus).setOnClickListener(this);
        findViewById(R.id.minus).setOnClickListener(this);
        findViewById(R.id.equal).setOnClickListener(this);
        findViewById(R.id.reverse).setOnClickListener(this);
        findViewById(R.id.point).setOnClickListener(this);
        findViewById(R.id.n1).setOnClickListener(this);
        findViewById(R.id.n2).setOnClickListener(this);
        findViewById(R.id.n3).setOnClickListener(this);
        findViewById(R.id.n4).setOnClickListener(this);
        findViewById(R.id.n5).setOnClickListener(this);
        findViewById(R.id.n6).setOnClickListener(this);
        findViewById(R.id.n7).setOnClickListener(this);
        findViewById(R.id.n8).setOnClickListener(this);
        findViewById(R.id.n9).setOnClickListener(this);
        findViewById(R.id.n0).setOnClickListener(this);
    }

    void justifyViewSize() {
        String content = view.getText().toString();
        String tmpContent = tmpView.getText().toString();
        if (content.length() < 29) view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        else view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        if (content.length() < 12) view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 60);
        else {
            for (int i = 12; i < 19; i++)
                if (content.length() == i) {
                    view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 56 - (i - 12) * 4);
                    break;
                }
        }
    }

    void isSecondOperand() {
        if (isOperaterBefore) {
            view.setText("");
            isOperaterBefore = false;
        }
    }

    void calculate() {
        String currentOperand = view.getText().toString();
        try {
            if (currentOperand.contains(".") || tempOperand.contains(".") || tempOperater.equals("/")) {
                Double first = Double.parseDouble(tempOperand);
                Double second = Double.parseDouble(currentOperand);
                Double result;
                switch (tempOperater) {
                    case "+": {
                        result = first + second;
                        break;
                    }
                    case "-": {
                        result = first - second;
                        break;
                    }
                    case "*": {
                        result = first * second;
                        break;
                    }
                    case "/": {
                        result = first / second;
                        break;
                    }
                    default:
                        throw new IllegalStateException("Unexpected value: " + tempOperater);
                }
                double checkInt = result % 1;
                if (checkInt == 0.0) {
                    Integer r = (int) Math.round(result);
                    tempOperand = Integer.toString(r);
                } else
                    tempOperand = Double.toString((double) Math.round(result * 1000000000) / 1000000000);
            } else {
                Integer first = Integer.parseInt(tempOperand);
                Integer second = Integer.parseInt(currentOperand);
                Integer result;
                switch (tempOperater) {
                    case "+": {
                        result = first + second;
                        break;
                    }
                    case "-": {
                        result = first - second;
                        break;
                    }
                    case "*": {
                        result = first * second;
                        break;
                    }
                    default:
                        throw new IllegalStateException("Unexpected value: " + tempOperater);
                }
                tempOperand = Integer.toString(result);
            }
            view.setText(tempOperand);
        } catch (Exception e) {
            e.printStackTrace();
            if(tempOperater.equals("")) return;
            view.setText("Too Large Number");
            tmpView.setText("");
            tempOperand = "0";
            tempOperater = "";
            isFirst = true;
            isOperaterBefore = false;
        }

        tempOperater = "";
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.n0: {
                if (view.getText().length() == 16 || isFirst || isOperaterBefore) break;
                isSecondOperand();
                view.setText(view.getText() + "0");
                break;
            }
            case R.id.n1: {
                isSecondOperand();
                if (isFirst) {
                    view.setText("1");
                    isFirst = false;
                    break;
                }
                if (view.getText().length() == 16) break;
                view.setText(view.getText() + "1");
                break;
            }
            case R.id.n2: {
                isSecondOperand();
                if (isFirst) {
                    view.setText("2");
                    isFirst = false;
                    break;
                }
                if (view.getText().length() == 16) break;
                view.setText(view.getText() + "2");
                break;
            }
            case R.id.n3: {

                isSecondOperand();
                if (isFirst) {
                    view.setText("3");
                    isFirst = false;
                    break;
                }
                if (view.getText().length() == 16) break;
                view.setText(view.getText() + "3");
                break;
            }
            case R.id.n4: {

                isSecondOperand();
                if (isFirst) {
                    view.setText("4");
                    isFirst = false;
                    break;
                }
                if (view.getText().length() == 16) break;
                view.setText(view.getText() + "4");
                break;
            }
            case R.id.n5: {

                isSecondOperand();
                if (isFirst) {
                    view.setText("5");
                    isFirst = false;
                    break;
                }
                if (view.getText().length() == 16) break;
                view.setText(view.getText() + "5");
                break;
            }
            case R.id.n6: {

                isSecondOperand();
                if (isFirst) {
                    view.setText("6");
                    isFirst = false;
                    break;
                }
                if (view.getText().length() == 16) break;
                view.setText(view.getText() + "6");
                break;
            }
            case R.id.n7: {

                isSecondOperand();
                if (isFirst) {
                    view.setText("7");
                    isFirst = false;
                    break;
                }
                if (view.getText().length() == 16) break;
                view.setText(view.getText() + "7");
                break;
            }
            case R.id.n8: {

                isSecondOperand();
                if (isFirst) {
                    view.setText("8");
                    isFirst = false;
                    break;
                }
                if (view.getText().length() == 16) break;
                view.setText(view.getText() + "8");
                break;
            }
            case R.id.n9: {

                isSecondOperand();
                if (isFirst) {
                    view.setText("9");
                    isFirst = false;
                    break;
                }
                if (view.getText().length() == 16) break;
                view.setText(view.getText() + "9");
                break;
            }
            case R.id.plus: {
                if (!tempOperater.equals("")) {
                    calculate();
                    tempOperater = "+";
                    isOperaterBefore = true;
                } else {
                    if (view.getText().equals("0")) break;
                    if(view.getText().equals("Too Large Number")){
                        view.setText("0");
                        break;
                    }
                    isFirst = false;
                    tempOperand = view.getText().toString();
                    tempOperater = "+";
                    isOperaterBefore = true;
                }
                tmpView.setText(tempOperand + " " + "+ ");
                break;
            }
            case R.id.minus: {
                if (!tempOperater.equals("")) {
                    calculate();
                    tempOperater = "-";
                    isOperaterBefore = true;
                } else {
                    if (view.getText().equals("0")) break;
                    if(view.getText().equals("Too Large Number")){
                        view.setText("0");
                        break;
                    }
                    isFirst = false;
                    tempOperand = view.getText().toString();
                    tempOperater = "-";
                    isOperaterBefore = true;
                }
                tmpView.setText(tempOperand + " " + "- ");
                break;
            }
            case R.id.mul: {
                if (!tempOperater.equals("")) {
                    calculate();
                    tempOperater = "*";
                    isOperaterBefore = true;
                } else {
                    if (view.getText().equals("0")) break;
                    if(view.getText().equals("Too Large Number")){
                        view.setText("0");
                        break;
                    }
                    isFirst = false;
                    tempOperand = view.getText().toString();
                    tempOperater = "*";
                    isOperaterBefore = true;
                }
                tmpView.setText(tempOperand + " " + "* ");
                break;
            }
            case R.id.div: {
                if (!tempOperater.equals("")) {
                    calculate();
                    tempOperater = "/";
                    isOperaterBefore = true;
                } else {
                    if (view.getText().equals("0")) break;
                    if(view.getText().equals("Too Large Number")){
                        view.setText("0");
                        break;
                    }
                    isFirst = false;
                    tempOperand = view.getText().toString();
                    tempOperater = "/";
                    isOperaterBefore = true;
                }
                tmpView.setText(tempOperand + " " + "/ ");
                break;
            }
            case R.id.equal: {
                if (!tempOperater.equals(""))
                    tmpView.setText(tmpView.getText() + "" + view.getText());
                calculate();
                isFirst = true;
                isOperaterBefore = false;
                break;
            }
            case R.id.ce: {
                view.setText("0");
                isFirst = true;
                break;
            }
            case R.id.c: {
                tmpView.setText("");
                view.setText("0");
                tempOperand = "0";
                tempOperater = "";
                isFirst = true;
                isOperaterBefore = false;
                break;
            }
            case R.id.bs: {
                if (view.getText().equals("Too Large Number")) {
                    tmpView.setText("");
                    view.setText("0");
                    tempOperand = "0";
                    tempOperater = "";
                    isFirst = true;
                    isOperaterBefore = false;
                }
                if (view.getText().length() == 1) {
                    view.setText("0");
                    isFirst = true;
                } else view.setText(view.getText().subSequence(0, view.getText().length() - 1));
                break;
            }
            case R.id.reverse: {
                if(view.getText().equals("Too Large Number")){
                    view.setText("0");
                    break;
                }
                if (view.getText().toString().contains("-"))
                    view.setText(view.getText().subSequence(1, view.getText().length()));
                else view.setText("-" + view.getText());
                break;
            }
            case R.id.point: {
/*                if(view.getText().equals("Too Large Number")){
                    view.setText("0");
                    break;
                }
                if (view.getText().length() == 16) break;
                view.setText(view.getText() + ".");
                break;*/

                Intent intent = new Intent(this, CurrencyExchange.class);
                startActivity(intent);

            }
        }
        justifyViewSize();
    }
}
