package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.guessinggame.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private Button checkButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextId);
        checkButton = findViewById(R.id.checkButtonId);
        resultTextView = findViewById(R.id.resultTextViewId);

        checkButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        String guessString = editText.getText().toString();

        if (guessString.isEmpty())
        {
            errorMessage();
        }

        else {
            int guess = Integer.parseInt(guessString);

            if (guess>5)
            {
                errorMessage();
            }

            else {
                Random random = new Random();
                int randomNumber = random.nextInt(5)+1;

                if (randomNumber == guess)
                {
                    resultTextView.setText(R.string.won_text);
                }

                else {
                    resultTextView.setText("Sorry ! You have lost. Random number was " + randomNumber);
                }
            }

            //Generating random number


        }


    }

    void errorMessage(){

        editText.setError("Please enter an valid input");
        editText.requestFocus();
        return;
    }
}