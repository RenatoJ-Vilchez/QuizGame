package com.example.quizgame;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuizStartScreen extends AppCompatActivity {

    Button quizBtnStart;
// Button Declaration//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_start_screen);
        //Information to correspond with Start Screen XML file//

        quizBtnStart = findViewById(R.id.quizBtnStart);
//FindViewByID declared to find button//
        quizBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity (new Intent(QuizStartScreen.this, TakeTheQuiz.class));
                finish(); //Activity Start declared from current activity of Quiz Start Screen to the targeted
                //activity of TakeTheQuiz after the user selected the button//
            }
        });
    }
}


