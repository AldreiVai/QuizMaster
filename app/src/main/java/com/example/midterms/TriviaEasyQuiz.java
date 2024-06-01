package com.example.midterms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import android.os.CountDownTimer;

public class TriviaEasyQuiz extends AppCompatActivity {
    private TextView textViewTimer;
    private TextView textViewQuizCounter;
    private TextView textViewScore;
    private TextView textViewQuestion;
    private RadioGroup radioGroupAnswers;
    private Button buttonConfirm;

    private DatabaseHelper databaseHelper;
    private Button buttonSkip;
    private Button button30sec;
    private List<Question> questionList;
    private int currentQuestionIndex;
    private int score;


    private int questionCounter;


    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;
    private Button buttonVoiceInput;

    private boolean isVoiceRecognitionActive = false;
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    private boolean permissionToRecordAccepted = false;
    private String username;

    private TextView tvScorex2Counter;
    private TextView tvSkipCounter;
    private TextView tv30SecCounter;
    private MediaPlayer mediaPlayerCorrect;
    private MediaPlayer mediaPlayerWrong;
    private MediaPlayer mediaPlayerGameMusic;
    private MediaPlayer mediaPlayerPowerUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia_easy_quiz);

        textViewTimer = findViewById(R.id.textViewTimer);
        textViewQuizCounter = findViewById(R.id.textViewQuizCounter);
        textViewScore = findViewById(R.id.textViewScore);
        textViewQuestion = findViewById(R.id.textViewQuestion);
        radioGroupAnswers = findViewById(R.id.radioGroupAnswers);
        buttonConfirm = findViewById(R.id.buttonConfirm);
        buttonVoiceInput = findViewById(R.id.buttonVoiceInput);
        buttonSkip = findViewById(R.id.buttonSkip);
        button30sec = findViewById(R.id.button30sec);

        tvScorex2Counter = findViewById(R.id.tvScorex2Counter);
        tvSkipCounter = findViewById(R.id.tvSkipCounter);
        tv30SecCounter = findViewById(R.id.tv30SecCounter);

        databaseHelper = new DatabaseHelper(this);
        mediaPlayerCorrect = MediaPlayer.create(this, R.raw.correct);
        mediaPlayerGameMusic = MediaPlayer.create(this, R.raw.gamemusic);
        mediaPlayerWrong = MediaPlayer.create(this, R.raw.wrong);
        mediaPlayerPowerUp = MediaPlayer.create(this, R.raw.powerup);

        buttonSkip.setEnabled(true);
        button30sec.setEnabled(true);
        // Retrieve the username from shared preferences
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        username = preferences.getString("username", "");

        updateCounters();
        // Set up the question list (replace with your own questions)
        questionList = getQuestions();

        // Initialize variables
        currentQuestionIndex = 0;
        score = 0;

        questionCounter = 1;

        checkSkip();
        checkThirtySec();
        // Start the quiz
        startQuiz();

        // Set up confirm button click listener
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });

        buttonSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                useSkip();
            }
        });

        button30sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                useThirtySec();
            }
        });

        buttonVoiceInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startVoiceRecognition();
            }
        });


    }
    private void useSkip() {
        mediaPlayerPowerUp.start();
        score++;
        int getSkip = databaseHelper.getSkip(username);
        getSkip--;
        databaseHelper.updateSkip(username, getSkip);
        updateCounters();
        checkSkip();
        if (currentQuestionIndex < questionList.size()) {
            // Move to the next question
            currentQuestionIndex++;

            // Check if there are more questions
            if (currentQuestionIndex < questionList.size()) {
                questionCounter++;
                showQuestion();
            } else {
                endQuiz();
            }

        }
    }

    private void useThirtySec() {
        mediaPlayerPowerUp.start();
        long additionalTimeInMillis = 30000; // 30 seconds

        // Increase the time by 30 seconds if the timer is still running
        if (countDownTimer != null) {
            countDownTimer.cancel(); // Cancel the current timer

            // Calculate the new time left, adding 30 seconds
            long newTimeLeftInMillis = timeLeftInMillis + additionalTimeInMillis;

            // Start a new timer with the updated time left
            startTimer(newTimeLeftInMillis);
        }

        int getThirtysec= databaseHelper.getThirtySeconds(username);
        getThirtysec--;
        databaseHelper.updateThirtySeconds(username, getThirtysec);
        updateCounters();
        checkThirtySec();
        button30sec.setEnabled(false);

        updateTimer();
        }


    private void checkSkip() {
        int skip = databaseHelper.getSkip(username);
        if (skip == 0){
            buttonSkip.setEnabled(false);
        }
    }

    private void checkThirtySec() {
        int thirtysec = databaseHelper.getThirtySeconds(username);
        if (thirtysec == 0){
            button30sec.setEnabled(false);
        }
    }


    private void updateCounters() {

        int scorex2 = databaseHelper.getX2Score(username);
        int skip = databaseHelper.getSkip(username);
        int thirtySec = databaseHelper.getThirtySeconds(username);

        // Update the TextViews with the new counter values

        tvScorex2Counter.setText(" : " + scorex2);
        tvSkipCounter.setText(" : " + skip);
        tv30SecCounter.setText(" : " + thirtySec);
    }
    private void startQuiz() {
        mediaPlayerGameMusic.start();
        // Set the current question
        showQuestion();

        // Start the timer (replace with your own timer implementation)
        startTimer(60000);
    }
    private List<Question> getQuestions() {
        // Replace with your own implementation to retrieve questions from the database or any other source
        QuizDBHelper dbHelper = new QuizDBHelper(this);  // Use the appropriate context
        List<Question> questions = dbHelper.getAllTriviaEasyQuestions();

        // Shuffle the question list
        Collections.shuffle(questions);


        return questions;
    }

    private void endQuiz() {
        // Stop the timer (replace with your own timer implementation)
        stopTimer();

        mediaPlayerGameMusic.stop();
        // Show the final score
        textViewScore.setText("Score: " + score);

        // Disable the confirm button
        buttonConfirm.setEnabled(false);
        int accuracy = (score * 100) / 10; // Calculate accuracy percentage
        int timeTakenInSeconds = (int) ((timeLeftInMillis) / 1000); // Calculate time taken in seconds

        // User-defined multipliers for accuracy and time
        int accuracyMultiplier = 5; // Adjust this value according to your preference
        int timeMultiplier = 5; // Adjust this value according to your preference

        int score = (accuracy * accuracyMultiplier) + (timeTakenInSeconds * timeMultiplier);

        Intent intent = new Intent(TriviaEasyQuiz.this, TriviaScore.class);
        String quiz = "trivia_easy";
        intent.putExtra("quiz", quiz);

        intent.putExtra("score", score);
        startActivity(intent);
        finish();
    }


    private void showQuestion() {
        if (questionCounter > 10) {
            endQuiz();
            return;
        }

        // Get the current question
        Question currentQuestion = questionList.get(currentQuestionIndex);

        // Update UI elements
        textViewQuizCounter.setText("Question " + questionCounter + " of " + 10);
        textViewScore.setText("Score: " + score);
        textViewQuestion.setText(currentQuestion.getQuestion());

        // Create a list with the radio group answer indices
        List<Integer> answerIndices = new ArrayList<>();
        answerIndices.add(0);
        answerIndices.add(1);
        answerIndices.add(2);
        answerIndices.add(3);

        // Shuffle the answer indices
        Collections.shuffle(answerIndices);

        // Set the randomized answer texts to the radio buttons
        ((RadioButton) radioGroupAnswers.getChildAt(answerIndices.get(0))).setText(currentQuestion.getOption1());
        ((RadioButton) radioGroupAnswers.getChildAt(answerIndices.get(1))).setText(currentQuestion.getOption2());
        ((RadioButton) radioGroupAnswers.getChildAt(answerIndices.get(2))).setText(currentQuestion.getOption3());
        ((RadioButton) radioGroupAnswers.getChildAt(answerIndices.get(3))).setText(currentQuestion.getOption4());


        // Clear radio button selection
        radioGroupAnswers.clearCheck();
    }

    private void checkAnswer() {
        // Get the selected answer
        int selectedRadioButtonId = radioGroupAnswers.getCheckedRadioButtonId();

        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            String selectedAnswer = selectedRadioButton.getText().toString();

            // Get the current question
            Question currentQuestion = questionList.get(currentQuestionIndex);

            // Check if the answer is correct
            if (selectedAnswer.equals(currentQuestion.getCorrectAnswer())) {
                score++;
                mediaPlayerCorrect.start();
            }else{
                mediaPlayerWrong.start();
            }

            // Move to the next question
            currentQuestionIndex++;

            // Check if there are more questions
            if (currentQuestionIndex < questionList.size()) {
                questionCounter++;
                showQuestion();
            }
            else {
                endQuiz();

            }
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Exit?");
        builder.setMessage("Are you sure you want to go back? You will lose all your progress.");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Stop the timer (replace with your own timer implementation)
                stopTimer();
                mediaPlayerGameMusic.stop();
                // Close the activity
                finish();
            }
        });


        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Handle Cancel button click
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }




    private void startTimer(long timeInMillis) {
        timeLeftInMillis = timeInMillis;

        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                endQuiz();
            }
        };

        countDownTimer.start();
    }

    private void stopTimer() {
        // Replace with your own timer implementation
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private void updateTimer() {
        // Replace with your own timer implementation
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;
        String timeFormatted = String.format("%02d:%02d", minutes, seconds);
        textViewTimer.setText(timeFormatted);
    }


    private void startVoiceRecognition() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak your choice");

        try {
            startActivityForResult(intent, 100);
        } catch (Exception e) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String voiceInput = result.get(0).toLowerCase();

            switch (voiceInput) {
                case "one":
                    ((RadioButton) radioGroupAnswers.getChildAt(0)).setChecked(true);
                    checkAnswer();
                    break;
                case "two":
                    ((RadioButton) radioGroupAnswers.getChildAt(1)).setChecked(true);
                    checkAnswer();
                    break;
                case "three":
                    ((RadioButton) radioGroupAnswers.getChildAt(2)).setChecked(true);
                    checkAnswer();
                    break;
                case "four":
                    ((RadioButton) radioGroupAnswers.getChildAt(3)).setChecked(true);
                    checkAnswer();
                    break;
                case "submit":
                    checkAnswer();
                    break;

                default:
                    Toast.makeText(this, "Invalid voice input", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_RECORD_AUDIO_PERMISSION) {
            permissionToRecordAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
        }

        if (!permissionToRecordAccepted) {
            Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

}
