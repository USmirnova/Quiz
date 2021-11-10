package com.example.quze;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    private TextView resultTextView; // объявляем переменную поля под результат
    private ArrayList<String> resultHere = new ArrayList<String>();// коллекция в которую получим переданный через интент компонет
    private int rightAnswerCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultHere = getIntent().getStringArrayListExtra("result");
        rightAnswerCount = getIntent().getIntExtra("rightAnswerCount", 0);
        System.out.println("=========================="+resultHere+"==========================================");
        resultTextView = findViewById(R.id.resultTextView); // находим view где хотим поменять текст
        for (int i = 0; i < resultHere.size(); i++) {
            resultTextView.append(resultHere.get(i)+"\n");
        }

        resultTextView.append("\n\n Количество правильных ответов: "+rightAnswerCount);
    }
}