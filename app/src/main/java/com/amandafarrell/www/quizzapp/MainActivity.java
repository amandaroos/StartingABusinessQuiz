package com.amandafarrell.www.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int mScore = 0;

    String q1;
    String q4;
    RadioGroup q1RadioGroup;
    RadioGroup q4RadioGroup;

    CheckBox q2c1;
    CheckBox q2c2;
    CheckBox q2c3;
    CheckBox q2c4;

    EditText q3EditText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Question 1
        q1RadioGroup = findViewById(R.id.q1_radio_group);

        q1RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.q1_false:
                        q1 = getString(R.string.answer_false);
                        break;
                    case R.id.q1_true:
                        q1 = getString(R.string.answer_true);
                        break;
                }

            }
        });

        //Question 2
        q2c1 = findViewById(R.id.q2_check1);
        q2c2 = findViewById(R.id.q2_check2);
        q2c3 = findViewById(R.id.q2_check3);
        q2c4 = findViewById(R.id.q2_check4);

        //Question 3
        q3EditText = findViewById(R.id.q3_edit_text);

        //Question 4
        q4RadioGroup = findViewById(R.id.q4_radio_group);

        q4RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.q4_false:
                        q4 = getString(R.string.answer_false);
                        break;
                    case R.id.q4_true:
                        q4 = getString(R.string.answer_true);
                        break;
                }

            }
        });
    }

    //Called when user hits submit button
    public void submitAnswers(View view) {
        //The score starts at zero
        mScore = 0;

        //Check answers
        if (q1.equals(getString(R.string.answer_true))) {
            mScore += 1;
        }

        if (q2c1.isChecked() && q2c2.isChecked() && q2c3.isChecked() && !q2c4.isChecked()) {
            mScore += 1;
        }

        String q3Answer = q3EditText.getText().toString();
        if (q3Answer.equals(getString(R.string.employer_identification_number)) || q3Answer.equals(getString(R.string.taxpayer_identification_number))) {
            mScore += 1;
        }

        if (q4.equals(getString(R.string.answer_true))) {
            mScore += 1;
        }

        //Display score
        if (mScore == 4) {
            Toast.makeText(this, getString(R.string.congratulations) +
                    Integer.toString(mScore) + " " + getString(R.string.score_message), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, Integer.toString(mScore) + " " + getString(R.string.score_message), Toast.LENGTH_SHORT).show();
        }
    }

    //Called when user hits reset button
    public void reset(View view) {

        //Reset the score
        mScore = 0;

        //Q1
        q1RadioGroup.clearCheck();
        q1 = "";

        //Q2
        q2c1.setChecked(false);
        q2c2.setChecked(false);
        q2c3.setChecked(false);
        q2c4.setChecked(false);

        //Q3
        q3EditText.setText("");

        //Q4
        q4RadioGroup.clearCheck();
        q4 = "";
    }
}
