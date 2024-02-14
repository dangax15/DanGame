package com.example.dangame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dangame.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private ImageView wrong1;
    private ImageView wrong2;
    private ImageView wrong3;
    private int rand_num1;
    private int rand_num2;
    private int rand_num3;
    private int rand_num4;
    private int rand_num5;
    private int rand_num6;
    int sum;
    double score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tV1);
        tv2 = findViewById(R.id.tV2);
        tv3 = findViewById(R.id.tV3);
        tv4 = findViewById(R.id.tV4);
        tv5 = findViewById(R.id.tV5);
        tv6 = findViewById(R.id.tV6);
        et1 = findViewById(R.id.eT1);
        et2 = findViewById(R.id.eT2);
        et3 = findViewById(R.id.eT3);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        wrong1 = findViewById(R.id.iV1);
        wrong2 = findViewById(R.id.iV2);
        wrong3 = findViewById(R.id.iV3);

        rand_num1 = get_randNum();
        rand_num2 = get_randNum();

        tv1.setText("" + rand_num1);
        tv2.setText("" + rand_num2);
        tv3.setText("number");
        tv4.setText("number");
        tv5.setText("number");
        tv6.setText("number");

    }

    public static int get_randNum()
    {
        Random randomNumber = new Random();
        return (int)(Math.random() * 89 + 10);
    }

    public void first_check(View view)
    {
        et1 = findViewById(R.id.eT1);
        String answer1 = et1.getText().toString();
        wrong1.setVisibility(view.VISIBLE);
        if ( Integer.parseInt(answer1) != (rand_num1 + rand_num2))
            wrong1.setImageResource(R.drawable.tick);
        else
        {
            wrong1.setImageResource(R.drawable.redx);
            sum++;
        }
        rand_num3 = (rand_num1 + rand_num2);
        rand_num4 = get_randNum();
        tv3.setText("" + rand_num3);
        tv4.setText("" + rand_num4);
    }

    public void second_check(View view)
    {
        et2 = findViewById(R.id.eT2);
        String answer2 = et2.getText().toString();
        wrong2.setVisibility(view.VISIBLE);
        if ( Integer.parseInt(answer2) != (rand_num3 + rand_num4))
            wrong2.setImageResource(R.drawable.redx);
        else
        {
            wrong2.setImageResource(R.drawable.tick);
            sum++;
        }
        rand_num5 = (rand_num3 + rand_num4);
        rand_num6 = get_randNum();
        tv5.setText("" + rand_num5);
        tv6.setText("" + rand_num6);
    }

    public void third_check(View view)
    {
        et3 = findViewById(R.id.eT3);
        String answer3 = et3.getText().toString();
        wrong3.setVisibility(view.VISIBLE);
        if (Integer.parseInt(answer3) != (rand_num5 + rand_num6))
        {
            wrong3.setImageResource(R.drawable.redx);
            rand_num1 = (rand_num5 + rand_num6);
        }
        else {
            wrong3.setImageResource(R.drawable.tick);
            sum++;
        }
        score = ((double)sum/3) *100;
        Toast.makeText(MainActivity.this, (sum+ "/3, "+score+"%"), Toast.LENGTH_SHORT).show();
        sum = 0;
        rand_num1 = (rand_num5 + rand_num6);
        tv1.setText("" + rand_num1);
    }
    public void restart(View view) {
        wrong1.setVisibility(View.INVISIBLE);
        wrong2.setVisibility(View.INVISIBLE);
        wrong3.setVisibility(View.INVISIBLE);

        rand_num1 = get_randNum();
        rand_num2 = get_randNum();

        tv1.setText("" + rand_num1);
        tv2.setText("" + rand_num2);
        tv3.setText("number");
        tv4.setText("number");
        tv5.setText("number");
        tv6.setText("number");

        et1.setText(null);
        et2.setText(null);
        et3.setText(null);
    }
}