package com.example.ajay.quizz_app;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static com.example.ajay.quizz_app.R.id.*;

public class QuizActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        this.setTitle("Hello " +getIntent().getExtras().getString("username"));

    }

    public boolean[] submitAnswers(View view) {
        RadioGroup answer_set_1;
        RadioGroup answer_set_2;
        CheckBox[] answer_set_3 = new CheckBox[3];
        RadioGroup answer_set_4;
        EditText answer5Text;
        RadioButton answer1;
        RadioButton answer2;
        RadioButton answer4;

        CheckBox checkbox3_btn_1;
        CheckBox checkbox3_btn_2;
        CheckBox checkbox3_btn_3;
        int answer_id_1;
        int answer_id_2;
        int answer_id_4;
        String answer_5;

        checkbox3_btn_1 = findViewById(R.id.checkbox3_btn_1);
        checkbox3_btn_2 = findViewById(R.id.checkbox3_btn_2);
        checkbox3_btn_3 = findViewById(R.id.checkbox3_btn_3);

        boolean[] results = {false, false, false, false, false};

        answer_set_1 = findViewById(answer_1);
        answer_set_2 = findViewById(answer_2);

        answer_set_3[0] = findViewById(R.id.checkbox3_btn_1);
        answer_set_3[1] = findViewById(R.id.checkbox3_btn_2);
        answer_set_3[2] = findViewById(R.id.checkbox3_btn_3);

        answer_set_4 = findViewById(answer_4);
        answer5Text = findViewById(question5_answer);
        answer_id_1 = answer_set_1.getCheckedRadioButtonId();
        answer_id_2 = answer_set_2.getCheckedRadioButtonId();
        answer_id_4 = answer_set_4.getCheckedRadioButtonId();

        answer_5 = answer5Text.getText().toString().toLowerCase();

        results[4] = answer_5.compareTo("cpu") == 0 || answer_5.compareTo(getString(R.string.question5_option_2_back)) == 0;
        if (answer_id_1 > 0) {
            answer1 = findViewById(answer_id_1);
            if (answer1.getText().toString().compareTo(getString(R.string.question1_option_3)) == 0)
                results[0] = true;
        }
        if (answer_id_2 > 0) {
            answer2 = findViewById(answer_id_2);
            if (answer2.getText().toString().compareTo(getString(R.string.question2_option_3)) == 0)
                results[1] = true;
        }
        if (answer_id_4 > 0) {
            answer4 = findViewById(answer_id_4);
            if (answer4.getText().toString().compareTo(getString(R.string.question4_option_3)) == 0)
                results[3] = true;
        }

      /*  if(answer_set_3[2].isSelected()|| answer_set_3[2].isSelected() || (answer_set_3[3].isSelected() && answer_set_3[2].isSelected()))
        {
            results[2] = true;
        }*/





        Intent i = new Intent(QuizActivity.this, ResultActivity.class);
        i.putExtra("result", results);
        startActivity(i);
        return results;
    }


}

