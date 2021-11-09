package com.example.quze;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {
    private boolean isAnswerTrue;
    private TextView answerTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        // Получаем дополнение
        isAnswerTrue = getIntent().getBooleanExtra("answer", true);
        answerTextView = findViewById(R.id.answerTextView);
        answerTextView.setText(isAnswerTrue?R.string.yes:R.string.no);
       /* if(isAnswerTrue)
            answerTextView.setText(R.string.yes);
        else
            answerTextView.setText(R.string.no);*/
    }
}