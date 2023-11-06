package com.example.a3labdarbas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button MC, MR, MS, mPlus, mMinus, back, clearEverything, del, plusMinus, squareRoot, n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, division, procent, multiplication, oneDevidedByX, plus, minus, BtnDot, result;
    TextView calculatorScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorScreen = findViewById(R.id.calculatorScreen);

        assignId(n1,R.id.n1);
        assignId(n2,R.id.n2);
        assignId(n3,R.id.n3);
        assignId(n4,R.id.n4);
        assignId(n5,R.id.n5);
        assignId(n6,R.id.n6);
        assignId(n7,R.id.n7);
        assignId(n8,R.id.n8);
        assignId(n9,R.id.n9);
        assignId(n10,R.id.n10);

        assignId(plus,R.id.plus);
        assignId(minus,R.id.minus);

        assignId(multiplication,R.id.multiplication);
        assignId(division,R.id.division);

        assignId(oneDevidedByX,R.id.oneDevidedByX);
        assignId(BtnDot,R.id.BtnDot);
        assignId(procent,R.id.procent);
        assignId(squareRoot,R.id.squareRoot);
        assignId(plusMinus,R.id.plusMinus);

        assignId(del,R.id.del);
        assignId(clearEverything,R.id.clearEverything);
        assignId(back,R.id.back);

        assignId(mMinus,R.id.mMinus);
        assignId(mPlus,R.id.mPlus);
        assignId(MC,R.id.MC);
        assignId(MR,R.id.MR);
        assignId(MS,R.id.MS);

        assignId(result,R.id.result);




    }

    void assignId (Button btn, int id){
        btn=findViewById(id);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Button button=(Button) view;
        String buttonText=button.getText().toString();
        String dataToCalculate=calculatorScreen.getText().toString();

        if(buttonText.equals("CE")) {
            calculatorScreen.setText("");
            return;
        }
        if(buttonText.equals("=")) {
            calculatorScreen.setText(calculatorScreen.getText());
            return;
        }
        if(buttonText.equals("DEL")) {
            dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length()-1);
        }else{
            dataToCalculate=dataToCalculate+buttonText;
        }
        calculatorScreen.setText(dataToCalculate);

        String finalResult = getResult(dataToCalculate);

        if(!finalResult.equals("ERROR")){
            calculatorScreen.setText(finalResult);
        }

    }

    String getResult(String data) {
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            if(finalResult.endsWith(".0")){
                finalResult = finalResult.replace(".0", "");
            }
            return finalResult;
        }catch (Exception e){
            return "EROR";
        }
    }

}