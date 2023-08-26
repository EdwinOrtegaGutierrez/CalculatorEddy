package com.example.calculatoreddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainActivity extends AppCompatActivity {

    TextView workingsTV;
    TextView resultsTV;
    String workings = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }

    private void initTextViews(){
        workingsTV = (TextView)findViewById(R.id.workingsTextView);
        resultsTV = (TextView)findViewById(R.id.resultTextView);
    }

    private void setWorkings(String givenValue){
        workings = workings + givenValue;
        workingsTV.setText(workings);
    }

    public void equalsOnClick(View view) {
        double result;

        try {
            Expression expression = new ExpressionBuilder(workings).build();
            result = expression.evaluate();
        } catch (Exception e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
            return;
        }

        resultsTV.setText(String.valueOf(result));
    }

    public void clearOnClick(View view) {
        workingsTV.setText("");
        workings = "";
        resultsTV.setText("");
    }

    boolean leftBracket = true;
    public void parenthesisOnClick(View view) {
        setWorkings(leftBracket ? " (" : ")");
        leftBracket = !leftBracket;
    }

    public void exponentiationOnClick(View view) {
        setWorkings(" ^ ");
    }

    public void divisionOnClick(View view) {
        setWorkings(" / ");
    }

    public void sevenOnClick(View view) {
        setWorkings("7");
    }

    public void eightOnClick(View view) {
        setWorkings("8");
    }

    public void nine(View view) {
        setWorkings("9");
    }

    public void multiplicationOnClick(View view) {
        setWorkings(" * ");
    }

    public void fourOnClick(View view) {
        setWorkings("4");
    }

    public void fiveOnClick(View view) {
        setWorkings("5");
    }

    public void sixOnClick(View view) {
        setWorkings("6");
    }

    public void subtractionOnClick(View view) {
        setWorkings(" - ");
    }

    public void oneOnClick(View view) {
        setWorkings("1");
    }

    public void twoOnClick(View view) {
        setWorkings("2");
    }

    public void threeOnClick(View view) {
        setWorkings("3");
    }

    public void additionOnClick(View view) {
        setWorkings(" + ");
    }

    public void dotOnClick(View view) {
        setWorkings(".");
    }

    public void zeroOnClick(View view) {
        setWorkings("0");
    }
}