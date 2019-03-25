package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnClickListener {



    TextView result;
    EditText number;
    TextView operation;
    Double operand = null;
    String lastOperation = "=";
    Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result =(TextView) findViewById(R.id.result);
        number = (EditText) findViewById(R.id.number);
        operation = (TextView) findViewById(R.id.operation);
        clear = (Button) findViewById(R.id.buttonClear);


    }

    @Override   //Стереть все
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonClear:
                result.setText("");
                number.setText("");
                break;}

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {// сохранение состояния
        outState.putString("OPERATION", lastOperation);
        if(operand!=null)
            outState.putDouble("OPERAND", operand);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {// получение ранее сохраненного состояния
        super.onRestoreInstanceState(savedInstanceState);
        lastOperation = savedInstanceState.getString("OPERATION");
        operand= savedInstanceState.getDouble("OPERAND");
        result.setText(operand.toString());
        operation.setText(lastOperation);
    }

    public void onNumberClick(View view){// обработка нажатия на числовую кнопку

        Button button = (Button)view;
        number.append(button.getText());

        if(lastOperation.equals("=") && operand!=null){
            operand = null;
        }
    }

    public void onOperationClick(View view){//обработка нажатия на кнопку операции

        Button button = (Button)view;
        String op = button.getText().toString();
        String num = number.getText().toString();
        if(num.length()>0){
            num = num;
            try{
                performOperation(Double.valueOf(num), op);
            }catch (NumberFormatException ex){
                number.setText("");
            }
        }
        lastOperation = op;
        operation.setText(lastOperation);
    }

    private void performOperation(Double num, String operation){
        if(operand ==null){ //если до этого не был задан операнд
            operand = num;
        }
        else{
            if(lastOperation.equals("=")){
                lastOperation = operation;
            }
            switch(lastOperation){
                case "=":
                    operand =num;
                    break;
                case "+":
                    operand +=num;
                    break;
                case "-":
                    operand -=num;
                    break;
                case "*":
                    operand *=num;
                    break;
                case "÷":
                    if(num==0){
                        Toast.makeText(this, "Нельзя делить на ноль!", Toast.LENGTH_LONG).show();
                        operand =operand;
                    }
                    else{
                        operand /=num;
                    }
                    break;

            }
        }
        result.setText(operand.toString());
        number.setText("");
    }


}