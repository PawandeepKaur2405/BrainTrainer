package com.example.braintrainer;

import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    ConstraintLayout gamelayout;
    int x;
    int y;
    int ansplace;
    int right;

    ArrayList<Integer> answers = new ArrayList<>();

    public void ans(View view){
        Button button10 = (Button)view;
        if (button10.getText().equals(Integer.toString(right))){

            textView4.setText("correct!!");
            y++;
        }else{
            textView4.setText("wrong!!");
        }
        textView4.setVisibility(View.VISIBLE);
        generater();

        textView2.setText(Integer.toString(y)+"/"+Integer.toString(x));

    }

    public void start() {
        textView.setText("30s");
        textView2.setText("0/0");
        new CountDownTimer(30100, 1000) {

            @Override
            public void onTick(long l) {
                textView.setText(String.valueOf(l / 1000) + "s");
            }

            @Override
            public void onFinish() {
                reset();


            }
        }.start();
        generater();
    }
    public void reset(){

        textView3.setText("question ready");
        button6.setVisibility(View.VISIBLE);
        textView4.setVisibility(View.INVISIBLE);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);

    }
    public void playagain(View view){
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        x=0;
        y=0;
        button6.setVisibility(View.INVISIBLE);

        start();

    }
    public void generater(){
        Random random = new Random();
        int first = random.nextInt(20)+1;
        int second = random.nextInt(20)+1;

        textView3.setText(Integer.toString(first)+"+"+Integer.toString(second));

        int wrong = random.nextInt(40)+1;

        right = first+second;
        x++;
        int answerhere = 0;

        ansplace = random.nextInt(4)+1;
        answers.clear();

        for (int i =1;i<=4;i++){
            if (ansplace == i){
                answers.add(right);
            }else{
                while (wrong==right){
                    wrong = random.nextInt(40)+1;

                }
                wrong = random.nextInt(40)+1;
                answers.add(wrong);
            }
        }
        button2.setText(Integer.toString(answers.get(0)));
        button3.setText(Integer.toString(answers.get(1)));
        button4.setText(Integer.toString(answers.get(2)));
        button5.setText(Integer.toString(answers.get(3)));
    }

    public void go(View view){
        button.setVisibility(View.INVISIBLE);
        gamelayout.setVisibility(View.VISIBLE);
        start();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);
        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        gamelayout = (ConstraintLayout)findViewById(R.id.gamelayout);



    }
}