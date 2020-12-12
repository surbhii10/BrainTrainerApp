package com.surbhi100.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumtextview;
    TextView Timer;
    TextView correct;
    Button play;
    TextView scoreset;
    RelativeLayout relative;
    int score = 0;
    int noofquestions = 0;
    ArrayList<Integer> answer = new ArrayList<>();
    int locationofcorrectanswer;
    public  void Playagain(View view)
    {
        score= 0;
        noofquestions = 0;
        Timer.setText("20s");
        scoreset.setText("0/0");
        correct.setText("");
        play.setVisibility(View.INVISIBLE);
        generate();
        new CountDownTimer(20100,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Timer.setText(String.valueOf(millisUntilFinished / 1000)+"s");
            }

            @Override
            public void onFinish() {
                play.setVisibility(View.VISIBLE);
                Timer.setText("0s");
                correct.setText("Your score: " +Integer.toString(score) + "/" + Integer.toString(noofquestions));
            }
        }.start();
    }
    public void generate()

    {
        Random rand = new Random();
//      /for(int j= 1; j<=5; j++) {
        int  a = rand.nextInt(21);     //0-21
        int  b = rand.nextInt(21);
        sumtextview.setText(" "+Integer.toString(a)+" + "+ Integer.toString(b));
        locationofcorrectanswer = rand.nextInt(4);
        answer.clear();
        int incorrectanswer;
        for (int i = 0; i < 4; i++) {
            if (i == locationofcorrectanswer) {
                answer.add(a+b);
            } else
                {
                incorrectanswer = rand.nextInt(41);
                while (incorrectanswer == a + b) {
                    incorrectanswer = rand.nextInt(41);
                }
                answer.add(incorrectanswer);

            }

        }
        button0.setText(Integer.toString(answer.get(0)));
        button1.setText(Integer.toString(answer.get(1)));
        button2.setText(Integer.toString(answer.get(2)));
        button3.setText(Integer.toString(answer.get(3)));

    }
    public void chooseAnswer(View view)
    {


            if (view.getTag().toString().equals(Integer.toString(locationofcorrectanswer))) {
                 score++;

                //scoreset.setText(Integer.toString(score) + "/" + "5");
                correct.setText("        Correct!");
                correct.setVisibility(View.VISIBLE);

            }
            else
                {

                correct.setVisibility(View.VISIBLE);
                correct.setText("        Wrong!");


            }
       noofquestions++;
        scoreset.setText(Integer.toString(score) + "/" + Integer.toString(noofquestions));
        generate();

    }

    public void start(View view)
    {
        button.setVisibility(View.INVISIBLE);
        relative.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
      scoreset = (TextView)findViewById(R.id.score);
        sumtextview = (TextView)findViewById(R.id.sum);
        correct = (TextView)findViewById(R.id.correct);
        button0= (Button)findViewById(R.id.button_0);
         button1= (Button)findViewById(R.id.button_1);
         button2= (Button)findViewById(R.id.button_2);
        button3= (Button)findViewById(R.id.button_3);
        Timer = (TextView)findViewById(R.id.timer);
        play= (Button) findViewById(R.id.Play);
        relative= (RelativeLayout)findViewById(R.id.relative);

         Playagain(findViewById(R.id.Play));
  }
    }

