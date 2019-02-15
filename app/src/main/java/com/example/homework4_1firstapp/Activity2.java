package com.example.homework4_1firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        textView=findViewById(R.id.textView2);
        Intent intent=getIntent();
        String text=intent.getStringExtra("SOME_TEXT");
        textView.setText(text);
    }

    public void textClick(View v){
        Intent intent=new Intent();
        intent.putExtra("RETURN_TEXT","Clicked");
        setResult(RESULT_OK,intent);
        finish();
    }

}
