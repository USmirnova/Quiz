package com.example.quze;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button yesBtn;
    private Button noBtn;
    private TextView textView;
    private Button answerBtn;

    Question[] questions = {
            new Question(R.string.question1, true),
            new Question(R.string.question2, true),
            new Question(R.string.question3, false),
            new Question(R.string.question4, false),
            new Question(R.string.question5, false)
    };
    int questionIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("SYSTEM INFO: ", "вызван метод onCreate()");
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null) { // при первичном запуске == null
            questionIndex = savedInstanceState.getInt("CurrentIndex", 0); // получаем // для int  кастовать ничего не надо
        }

        yesBtn = findViewById(R.id.yesBtn);
        noBtn = findViewById(R.id.noBtn);
        textView = findViewById(R.id.textView);
        answerBtn = findViewById(R.id.answerBtn);
        textView.setText(questions[questionIndex].getQuestionText());

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
                /*if (questions[questionIndex].isAnswerTrue()){
                    Toast.makeText(MainActivity.this, "Правильно!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Неправильно!", Toast.LENGTH_SHORT).show();
                }
                questionIndex++;
                if(questionIndex == questions.length) questionIndex = 0;
                textView.setText(questions[questionIndex].getQuestionText());*/
            }
        });

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
                /*if (!questions[questionIndex].isAnswerTrue()){
                    Toast.makeText(MainActivity.this, "Правильно!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Неправильно!", Toast.LENGTH_SHORT).show();
                }
                questionIndex = (questionIndex+1)%questions.length;
                textView.setText(questions[questionIndex].getQuestionText());*/
            }
        });

        answerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                intent.putExtra("answer", questions[questionIndex].isAnswerTrue());
                startActivity(intent);
            }
        });
    }
    public void checkAnswer(boolean btn){
        if ((questions[questionIndex].isAnswerTrue() && btn) || (!questions[questionIndex].isAnswerTrue() && !btn))
            Toast.makeText(MainActivity.this, "Правильно!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Неправильно!", Toast.LENGTH_SHORT).show();

        questionIndex = (questionIndex+1)%questions.length;
        textView.setText(questions[questionIndex].getQuestionText());
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) { // вызывается всегда перед уничтожением активности
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("CurrentIndex", questionIndex); // ключ, значение
        //savedInstanceState.putByte("CurrentIndex", CurrentIndex); //  у нас же байтовое число
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.i("SYSTEM INFO: ", "вызван метод onStart()");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.i("SYSTEM INFO: ", "вызван метод onResume()");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.i("SYSTEM INFO: ", "вызван метод onPause()");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.i("SYSTEM INFO: ", "вызван метод onStop()");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i("SYSTEM INFO: ", "вызван метод onDestroy()");
    }
}