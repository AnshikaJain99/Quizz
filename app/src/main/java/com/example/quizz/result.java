package com.example.quizz;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class result extends AppCompatActivity {

    private TextView tv,tv1;
    private ImageView iv1;
    //ImageButton b5,b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String ans=getIntent().getStringExtra("Hey");
        String v =getIntent().getStringExtra("Corr");
        tv=findViewById(R.id.tv);
        tv1=findViewById(R.id.tv1);
        iv1=findViewById(R.id.iv1);
        tv.setText(ans);
        if(v.compareTo("abc")!=0)
        {
            iv1.setImageResource(R.drawable.img7);
            tv1.setText(v);
        }
        else
            iv1.setImageResource(R.drawable.img6);
//        Toast.makeText(getApplicationContext(),ans,Toast.LENGTH_SHORT).show();

    }

    public void onClick(View view) {
        Intent intent=new Intent(result.this,MainActivity.class);
        intent.putExtra("value","kjjkj");
        setResult(RESULT_OK,intent);
        finish();
    }
}
