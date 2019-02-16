package com.example.homework4_1firstapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnIntent;
    Button btnHideIntent;
    EditText editText;
    String textFromEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIntent=findViewById(R.id.intent_btn);
        btnHideIntent=findViewById(R.id.hide_intent_btn);
        editText=findViewById(R.id.textEdit);


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                textFromEdit=editText.getText().toString();
            }
        });

        btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("click1","clicked on Intent");
                Intent intent=new Intent(MainActivity.this,Activity2.class);
                intent.putExtra("SOME_TEXT","Text from main activity");
                startActivityForResult(intent,1);
            }
        });

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
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
