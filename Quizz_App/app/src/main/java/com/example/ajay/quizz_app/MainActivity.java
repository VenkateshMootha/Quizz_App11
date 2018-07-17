package com.example.ajay.quizz_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startQuiz(View view)
    {
        Intent i = new Intent(MainActivity.this, QuizActivity.class);
        EditText ed = (EditText) findViewById(R.id.name_editText);
        i.putExtra("username", ed.getText().toString());
        startActivity(i);
    }
}