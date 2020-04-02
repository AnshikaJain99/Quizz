package com.example.quizz;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

     private Button b1,b2,b3,b4;
     private ImageButton b5,b6;
     private TextView tv;
     private int curr=0;
     private  ImageView iv1;
     private final int REQUEST_CODE = 2;

    private question[] questions=new question[]{
            new question(R.string.q1,147,"147","58","198","208",R.drawable.img1),
            new question(R.string.q2,72,"72","58","48","50",R.drawable.img2),
            new question(R.string.q3,21,"98","34","21","46",R.drawable.img3),
            new question(R.string.q4,12,"19","16","12","14",R.drawable.img4),
            new question(R.string.q5,52,"59","52","48","64",R.drawable.img5)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        tv=findViewById(R.id.ques);
        iv1=findViewById(R.id.iv);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        Intent intent=new Intent(MainActivity.this,result.class);
        if(v.getId()==R.id.b5)
        {
            if(curr==0)
                curr=1;
            curr=(curr-1) % (questions.length);
            tv.setText(questions[curr].getQid());
            b1.setText(questions[curr].getC1());
            b2.setText(questions[curr].getC2());
            b3.setText(questions[curr].getC3());
            b4.setText(questions[curr].getC4());
            iv1.setImageResource(questions[curr].getImage());
            return;
        }
        if(v.getId()==R.id.b6)
        {
            curr=(curr+1) % (questions.length);
            tv.setText(questions[curr].getQid());
            b1.setText(questions[curr].getC1());
            b2.setText(questions[curr].getC2());
            b3.setText(questions[curr].getC3());
            b4.setText(questions[curr].getC4());
            iv1.setImageResource(questions[curr].getImage());
            return;
        }
        Button b=(Button)v;
        int n=Integer.valueOf(b.getText().toString());

        if(n==(questions[curr].getAns()))
        {
//            Toast.makeText(getApplicationContext(),"Right Answer",Toast.LENGTH_SHORT).show();
            intent.putExtra("Hey","Your answer is correct!");
            intent.putExtra("Corr","abc");


        }
        else
        {
//            Toast.makeText(getApplicationContext(),"Oops,Wrong Answer!",Toast.LENGTH_SHORT).show();
            intent.putExtra("Hey","Well tried! :)");
            String a="Correct answer is "+ String.valueOf(questions[curr].getAns());
            intent.putExtra("Corr",a);
        }

        startActivityForResult(intent,REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*String a=getIntent().getStringExtra("value");
        if(a.compareTo("0")==0)
            curr=curr-1;*/
       if(requestCode==REQUEST_CODE)
       {

           curr=(curr+1) % (questions.length);
           tv.setText(questions[curr].getQid());
           b1.setText(questions[curr].getC1());
           b2.setText(questions[curr].getC2());
           b3.setText(questions[curr].getC3());
           b4.setText(questions[curr].getC4());
           iv1.setImageResource(questions[curr].getImage());
       }
    }
}
