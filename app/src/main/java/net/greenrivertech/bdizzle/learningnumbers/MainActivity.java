package net.greenrivertech.bdizzle.learningnumbers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int totalGames = 0;
    int wins = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandomNumbers();
    }

    public void firstNumberClicked(View view) {
        Button numBtn = (Button) findViewById(R.id.firstNumber);
        int num =  Integer.parseInt((String) numBtn.getText());
        checkAnswer(1, num);
    }

    public void secondNumberClicked(View view) {
        Button numBtn = (Button) findViewById(R.id.secondNumber);
        int num =  Integer.parseInt((String) numBtn.getText());
        checkAnswer(2, num);
    }

    public void checkAnswer(int choice, int answer) {
        Button compareBtn;

        if(choice == 1){
            compareBtn = (Button) findViewById(R.id.secondNumber);
        } else {
            compareBtn = (Button) findViewById(R.id.firstNumber);
        }

        int compareInt =  Integer.parseInt((String) compareBtn.getText());

        String toast;

        if(answer < compareInt){
            toast = "Try Again!";
        } else {
            toast = "Correct!";
            wins++;
        }

        totalGames++;

        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
        generateRandomNumbers();
        updateScore();
    }

    public void generateRandomNumbers(){

        Button num1 = (Button) findViewById(R.id.firstNumber);
        Button num2 = (Button) findViewById(R.id.secondNumber);

        Random rand = new Random();
        String n1 = String.valueOf(rand.nextInt(10));
        String n2 = String.valueOf(rand.nextInt(10));

        num1.setText(n1);
        num2.setText(n2);

    }

    public void updateScore(){
        TextView scoreText = (TextView) findViewById(R.id.score);
        String tStr = String.valueOf(totalGames);
        String wStr = String.valueOf(wins);
        scoreText.setText("Score: " + wStr + "/" + tStr);
    }
}
