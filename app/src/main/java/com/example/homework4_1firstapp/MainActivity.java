package com.example.homework4_1firstapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnIntent;
    Button btnHideIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIntent=findViewById(R.id.intent_btn);
        btnHideIntent=findViewById(R.id.hide_intent_btn);

        btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("click1","clicked on Intent");
                Intent intent=new Intent(MainActivity.this,Activity2.class);
                intent.putExtra("SOME_TEXT","Text from main activity");
                startActivity(intent);
                startActivityForResult(intent,1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            String text=data.getStringExtra("RETURN_TEXT");
            btnIntent.setText(text);
        }
    }

    public void onHideClick(View v){
        Log.d("click2","clicked on Hide Intent");
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,"Hide Intent text");
        intent.setType("text/plain");

        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }


}
