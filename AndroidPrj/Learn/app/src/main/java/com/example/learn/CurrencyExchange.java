package com.example.learn;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CurrencyExchange extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    TextView input;
    TextView output;
    TextView symbolIn;
    TextView symbolOut;
    TextView curRateText;

    Spinner spinnerIn;
    Spinner spinnerOut;

    boolean isFirst = true;
    boolean isDot = false;

    double curRate;

    //Currency rate (base on USD)    |   position
    double[] rates = {23340.69,   1,   0.9191,107.56,1216.26};
    //                 vnd    usd  eur    jpy    krw
    String[] namesCur = {"VNĐ", "USD", "EUR", "JPY", "KWR"};
    String[] symCurs  = { "₫",   "$",   "€",   "¥",   "₩"};

    String[] items = {"Vietnam - Dong",
            "United State - Dollar",
            "Europe - Euro",
            "Japan - Yen",
            "Korean - Won"};

    DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
    DecimalFormat decimalFormatIn = new DecimalFormat("#,##0");
    DecimalFormat decimalFormatCur = new DecimalFormat("#,##0.0000000");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_exchange);

        symbolIn = findViewById(R.id.symCur1);
        symbolOut = findViewById(R.id.symCur2);

        input = findViewById(R.id.cur1);
        output = findViewById(R.id.cur2);
/*        Typeface tf = Typeface.createFromAsset(getAssets(), "digital.ttf");
        input.setTypeface(tf);
        output.setTypeface(tf);*/

        curRateText = findViewById(R.id.curRate);

        spinnerIn = (Spinner) findViewById(R.id.pickCur1);
        spinnerOut = (Spinner) findViewById(R.id.pickCur2);
        spinnerIn.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_items, items));
        spinnerOut.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_items, items));

        spinnerIn.setOnItemSelectedListener(this);
        spinnerOut.setOnItemSelectedListener(this);
        spinnerIn.setSelection(1);

        findViewById(R.id.reverseCur).setOnClickListener(this);

        findViewById(R.id.bs).setOnClickListener(this);
        findViewById(R.id.ce).setOnClickListener(this);

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

    //Chỉnh lại size khi độ dài view lớn
    void justifyViewSize(TextView view) {
        String content = view.getText().toString();
        if (content.length() < 12) view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 50);
        else {
            for (int i = 14; i < 30; i++)
                if (content.length() == i) {
                    view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 50 - (i - 13) * 2);
                    break;
                }
        }
    }

    //Thêm dấu phẩy ngăn cách các hàng
    void addComma(TextView view){
        double content = Double.parseDouble(view.getText().toString().replaceAll(",", ""));
        view.setText(decimalFormatIn.format(content));
    }

    //Chỉnh tỉ giá
    void setExRate() {
        int in = spinnerIn.getSelectedItemPosition();
        int out = spinnerOut.getSelectedItemPosition();

        //Thay đổi biểu tượng
        symbolIn.setText(symCurs[in]);
        symbolOut.setText(symCurs[out]);

        //Tính tỉ giá
        curRate = rates[out] / rates[in];
        curRateText.setText("1 " + namesCur[in] + " = " + decimalFormatCur.format((double) Math.round(curRate * 100000000) / 100000000) + " " + namesCur[out]);
    }

    //Chuyển đổi tiền
    void exChange() {
        if ("0".equals(input.getText().toString())) {
            output.setText("0");
        } else {
            //Chuyển tiền và thêm dấu phẩy
            double rs = Double.parseDouble(input.getText().toString().replaceAll(",", "")) * curRate;
            String display = decimalFormat.format(rs);
            output.setText(display);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.n0: {
                if (input.getText().length() == 50 || isFirst) break;
                input.setText(input.getText() + "0");
                break;
            }
            case R.id.n1: {
                if (isFirst) {
                    input.setText("1");
                    isFirst = false;
                    break;
                }
                if (input.getText().length() == 50) break;
                input.setText(input.getText() + "1");
                break;
            }
            case R.id.n2: {
                if (isFirst) {
                    input.setText("2");
                    isFirst = false;
                    break;
                }
                if (input.getText().length() == 50) break;
                input.setText(input.getText() + "2");
                break;
            }
            case R.id.n3: {
                if (isFirst) {
                    input.setText("3");
                    isFirst = false;
                    break;
                }
                if (input.getText().length() == 50) break;
                input.setText(input.getText() + "3");
                break;
            }
            case R.id.n4: {
                if (isFirst) {
                    input.setText("4");
                    isFirst = false;
                    break;
                }
                if (input.getText().length() == 50) break;
                input.setText(input.getText() + "4");
                break;
            }
            case R.id.n5: {
                if (isFirst) {
                    input.setText("5");
                    isFirst = false;
                    break;
                }
                if (input.getText().length() == 50) break;
                input.setText(input.getText() + "5");
                break;
            }
            case R.id.n6: {
                if (isFirst) {
                    input.setText("6");
                    isFirst = false;
                    break;
                }
                if (input.getText().length() == 50) break;
                input.setText(input.getText() + "6");
                break;
            }
            case R.id.n7: {
                if (isFirst) {
                    input.setText("7");
                    isFirst = false;
                    break;
                }
                if (input.getText().length() == 50) break;
                input.setText(input.getText() + "7");
                break;
            }
            case R.id.n8: {
                if (isFirst) {
                    input.setText("8");
                    isFirst = false;
                    break;
                }
                if (input.getText().length() == 50) break;
                input.setText(input.getText() + "8");
                break;
            }
            case R.id.n9: {
                if (isFirst) {
                    input.setText("9");
                    isFirst = false;
                    break;
                }
                if (input.getText().length() == 50) break;
                input.setText(input.getText() + "9");
                break;
            }
            case R.id.point: {
                if(isFirst) break;
                String tmp = input.getText().toString();
                if (!tmp.contains(".")) {
                    if (input.getText().length() == 50) break;
                    input.setText(input.getText() + ".");
                    isDot = true;
                }
                break;
            }
            case R.id.ce: {
                input.setText("0");
                isFirst = true;
                isDot = false;
                break;
            }
            case R.id.bs: {
                String content = input.getText().toString();
                int length = content.length();
                if(content.charAt(length - 1) == '.'){
                    input.setText(content.subSequence(0, length - 1));
                    isDot = false;
                }
                else if (length == 1) {
                    input.setText("0");
                    isFirst = true;
                } else input.setText(content.subSequence(0, length - 1));
                break;
            }
            case R.id.reverseCur:{
                int in = spinnerIn.getSelectedItemPosition();
                int out = spinnerOut.getSelectedItemPosition();
                spinnerIn.setSelection(out);
                spinnerOut.setSelection(in);
                setExRate();
                break;
            }
        }
        if(!isDot){
            addComma(input);
        }
        exChange();
        justifyViewSize(input);
        justifyViewSize(output);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        setExRate();
        exChange();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Nothing here ᓚᘏᗢ
    }
}
