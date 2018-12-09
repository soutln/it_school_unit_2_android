package com.example.egor.it_school_unit_2;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class IT_SCHOOL_UNIT_2 extends AppCompatActivity {

    private TextView text;
    private EditText ed1;
    private EditText ed2;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private double first;
    private double second;
    private static final String RES_KEY = "d1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            setContentView(R.layout.activity_portait);

        else
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            setContentView(R.layout.activite_landspace);

        text = findViewById(R.id.tv);

        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);

        button1 = findViewById(R.id.b1);
        button2 = findViewById(R.id.b2);
        button3 = findViewById(R.id.b3);
        button4 = findViewById(R.id.b4);
        button5 = findViewById(R.id.b5);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (voidCheck() == false) {
                    first = scanFirst();
                    second = scanSecond();
                    inputResult(1);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (voidCheck() == false) {
                    first = scanFirst();
                    second = scanSecond();
                    inputResult(2);
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (voidCheck() == false) {
                    first = scanFirst();
                    second = scanSecond();
                    inputResult(3);
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (voidCheck() == false) {
                    first = scanFirst();
                    second = scanSecond();
                    inputResult(4);
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("Результат");
                ed1.setText("");
                ed2.setText("");
            }
        });
    }

    private boolean voidCheck() {
        if (ed1.getText().toString().isEmpty() | ed2.getText().toString().isEmpty()) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Заполните поля ввода", Toast.LENGTH_SHORT);
            toast.show();
            return true;
        } else
            return false;
    }

    private double scanFirst() {
        double a = Double.valueOf(String.valueOf(ed1.getText()));
        return a;
    }

    private double scanSecond() {
        double a = Double.valueOf(String.valueOf(ed2.getText()));
        return a;
    }

    private void inputResult(int a) {
        ed1.setText(String.valueOf(""));
        ed2.setText(String.valueOf(""));
        switch (a) {
            case 1:
                if (((first + second) * 10) % 10 == 0)
                    text.setText(String.valueOf((long) (first + second)));
                else
                    text.setText(String.valueOf(first + second));
                break;
            case 2:
                if (((first - second) * 10) % 10 == 0)
                    text.setText(String.valueOf((long) (first - second)));
                else
                    text.setText(String.valueOf(first - second));
                break;
            case 3:
                if (((first * second) * 10) % 10 == 0)
                    text.setText(String.valueOf((long) (first * second)));
                else
                    text.setText(String.valueOf(first * second));
                break;
            case 4:
                if(second == 0)
                    text.setText("На ноль делить нельзя");
                else {
                    if (((first / second) * 10) % 10 == 0)
                        text.setText(String.valueOf((long) (first / second)));
                    else
                        text.setText(String.valueOf(first / second));
                    break;
                }
                default: text.setText("Ошибка");
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(RES_KEY, String.valueOf(text.getText()));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        text.setText(savedInstanceState.getString(RES_KEY));

    }
}