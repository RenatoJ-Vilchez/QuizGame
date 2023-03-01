package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TakeTheQuiz extends AppCompatActivity implements View.OnClickListener{
//TextView amd Button IDs declared//
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB,  ansC, ansD;
    Button SubmitBtn;

    int score=0;
    int totalQuestion = QuestionsAndAnswers.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_the_quiz);
//XML information to be corresponded in this current java file//
        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.FollowingQuestions);
        ansA = findViewById(R.id.AnswerA);
        ansB = findViewById(R.id.AnswerB);
        ansC = findViewById(R.id.AnswerC);
        ansD = findViewById(R.id.AnswerD);
        SubmitBtn = findViewById(R.id.SubmitBtn);
//FindViewByID to match the declared IDs in the XML file of this java file//
        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        SubmitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total questions : "+totalQuestion);
//Amount of questions to be displayed on the screen with how many quesitons that are being asked to the user
       //in this case it is 5 questions //
        loadNewQuestion();


    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);
//The background color of the answers bars are set to the color white, in matching with the XML file//
        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.SubmitBtn){
            if(selectedAnswer.equals(QuestionsAndAnswers.correctAnswers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();
//To match with the questions that are set to be asked to the user, information from the QuestionsAndAnswers
           //java file will be stored and shown from the layout design, including the strings of the
            //answer choices and correct answers that will later be stored and results shown//

        }else{
            //choices button clicked
            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
//Background color to be display when an answer is clicked by the user//
        }

    }

    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion ){
            finishQuiz();
            return;
        }

        questionTextView.setText(QuestionsAndAnswers.question[currentQuestionIndex]);
        ansA.setText(QuestionsAndAnswers.answerChoices[currentQuestionIndex][0]);
        ansB.setText(QuestionsAndAnswers.answerChoices[currentQuestionIndex][1]);
        ansC.setText(QuestionsAndAnswers.answerChoices[currentQuestionIndex][2]);
        ansD.setText(QuestionsAndAnswers.answerChoices[currentQuestionIndex][3]);
//The correct answer for each declared questions stored in accordance with the QuestionsAndAnswers java file//
    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus = "Congrats. You have passed the quiz. Good job. Thank you for taking it";
        }else{
            passStatus = "You have failed the quiz. Don't worry, you can try again!!";
        }
//After the user finishes the quiz, they will receive a message that tells their results//
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Your quiz score is "+ score+" out of "+ totalQuestion)
                .setPositiveButton("Want another chance? Click here!!",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();

//If the user wants to try again, they are given the option to retake the quiz//
    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }

}


