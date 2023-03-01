package com.example.quizgame;

public class QuestionsAndAnswers {
    public static String question[] ={
            "In what town is Montclair State University located at?",
            "In what year was the United States founded?",
            "Which company has created the Playstation",
            "Which company is the owner of YouTube?",
            "How many days are in a year?",

    };
//Here are the questions that will be asked to the user for the quiz. In this java file,
   // the questions are all connected with TakeTheQuiz java file to connect with the XML TakeTheQuiz file
//As a result, there is only need of just one XML file for the quiz layout//
    public static String answerChoices[][] = {
            {"Montclair", "Trenton", "Newark", "Wayne"},
            {"1776","1801","1754","1765"},
            {"Facebook","Nintendo","Sony","Toshiba"},
            {"MicroSoft","Apple","Google","Twitter"},
            {"265 days","365 days","302 days","291 days"},
    };
// For each line, there is the answer choices for each of the questions. For example that first line that starts
   // with Montclair and ends to Wayne is for question 1. And so on for the rest. Hence the choices string//
    public static String correctAnswers[] = {
            "Montclair",
            "1776",
            "Sony",
            "Google",
            "365 days",
//Likewise, the CorrectAnswers string goes for each line of the correct answers, so the quiz will keep
       //track of what is the right answer for each question to record and show the score at the end //
    };

}
