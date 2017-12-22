package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the result button is clicked.
     */
    public void getResults(View view) {
        RadioButton rightAnswerQuestionOne = findViewById(R.id.button1a);
// Is the button now checked?
        boolean checkedAnswerOne = rightAnswerQuestionOne.isChecked();

        RadioButton rightAnswerQuestionTwo = findViewById(R.id.button1x);
        boolean checkedAnswerTwo = rightAnswerQuestionTwo.isChecked();

        RadioButton rightAnswerQuestionThree = findViewById(R.id.button2b);
        boolean checkedAnswerThree = rightAnswerQuestionThree.isChecked();

        CheckBox rightAnswerOne = findViewById(R.id.box1_quest4);
        boolean checkedRightAnswerOne = rightAnswerOne.isChecked();

        CheckBox rightAnswerTwo = findViewById(R.id.box2_quest4);
        boolean checkedRightAnswerTwo = rightAnswerTwo.isChecked();

        CheckBox wrongAnswerThree = findViewById(R.id.box3_quest4);
        boolean checkedWrongAnswerThree = wrongAnswerThree.isChecked();

        RadioButton rightAnswerQuestionFive = findViewById(R.id.button3c);
        boolean checkedAnswerFive = rightAnswerQuestionFive.isChecked();

        EditText enterYourName = findViewById(R.id.your_name);
        String enteredName = enterYourName.getText().toString();

        int result = calculateResult(checkedAnswerOne, checkedAnswerThree, checkedAnswerTwo, checkedAnswerFive, checkedRightAnswerOne, checkedRightAnswerTwo, checkedWrongAnswerThree);
        String resultMessage = createResults(result, enteredName);
        displayMessage(resultMessage);

    }

    /**
     * calculates the total result
     *
     * @param checkedAnswerOne      check if the right answer in question one is clicked
     * @param checkedRightAnswerTwo check if the right answer in question two is clicked
     * @param
     * @return total score
     */

    private int calculateResult(boolean checkedAnswerOne, boolean checkedAnswerThree, boolean checkedAnswerTwo, boolean checkedAnswerFive, boolean checkedRightAnswerOne, boolean checkedRightAnswerTwo, boolean checkedWrongAnswerThree) {

        if (checkedAnswerOne) {
            score = score + 1;
        } else {
            score = score;
        }
        if (checkedAnswerTwo) {
            score = score + 1;
        }
        if (checkedAnswerThree) {
            score = score + 1;
        }
        if (checkedAnswerFive) {
            score = score + 1;
        }

        if (!checkedWrongAnswerThree) {
            if (checkedRightAnswerOne && checkedRightAnswerTwo) {
                score = score + 1;
            }
        }
        if (checkedWrongAnswerThree) {
            score = score;
        }
        return score;
    }


    /**
     * should reset the score to 0
     */
    public void makeReset(View view) {
        getResults(view);
        setResult(score);
        score = 0;
    }

    /**
     * create summary of the order
     *
     * @param score     shows score of the Quiz
     * @param typedName shows the typed name of the text field
     * @return text summary
     */

    private String createResults(int score, String typedName) {
        String resultMessage = typedName + ", your score is" + score + "/5";

        return resultMessage;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView TextViewResults = findViewById(R.id.textView_results);
        TextViewResults.setText(message);

    }

}
