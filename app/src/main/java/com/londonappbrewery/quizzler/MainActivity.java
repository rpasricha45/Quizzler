package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.londonappbrewery.TrueFalse;

public class MainActivity extends Activity {

    // TODO: Declare constants here


    // TODO: Declare member variables here:

int mIndex = 0;
int mQuestion;
TextView mScoreTextView;
ProgressBar mProgressBar ;
int mScore;




    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };
    final int PROGRESS_BARINCREMENT = (int)(Math.ceil(100.0/mQuestionBank.length));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mTrueButton = findViewById(R.id.true_button);// link the button
        Button mFalseButton = findViewById(R.id.false_button);

       mScoreTextView= findViewById(R.id.score);
       mProgressBar = findViewById(R.id.progress_bar);


        //  TextView ***********************************
        TextView text = findViewById(R.id.question_text_view);

    final int mQuestion = mQuestionBank[mIndex].getnQuestion();

    text.setText(mQuestion);
    //**********************************************************

    // Butonns ***************************************************************
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Selected True", Toast.LENGTH_SHORT).show();
                TextView   question = findViewById(R.id.question_text_view);
                checkAnwer(true);
                upDateQuestion();
                question.setText(mQuestionBank[mIndex].getnQuestion());

            }
        });

      mFalseButton.setOnClickListener(new View.OnClickListener(){
          public void onClick(View view) {
              Toast.makeText(getApplicationContext(),"Selected False", Toast.LENGTH_SHORT).show();// toast
              upDateQuestion();// icrementign the quesitons
              //* putting new image to the secrren
              TextView   question = findViewById(R.id.question_text_view);
              checkAnwer(false);
              upDateQuestion();
              question.setText(mQuestionBank[mIndex].getnQuestion());

          }
      });

    }
    public void upDateQuestion (){
       mIndex = (mIndex+1)%mQuestionBank.length;
       mProgressBar.incrementProgressBy(PROGRESS_BARINCREMENT);
       mScoreTextView.setText("Score"+mScore + "/"+ mQuestionBank.length);
       if ( mIndex==0){// end of the game create alert dialog
      AlertDialog.Builder endMessage = new AlertDialog.Builder(this);
      endMessage.setTitle("Game Over");
      endMessage.setCancelable(false);
      endMessage.setMessage("You Scored " + mScore);
      endMessage.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
              finish();
          }
      });
      endMessage.show();
       }

    }
    public void checkAnwer ( boolean userSelection){
        boolean correctAnswer = mQuestionBank[mIndex].isAnswer();
        if ( correctAnswer == userSelection){
            Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
            mScore +=1;

        }
        else{
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();

        }
    }
}
