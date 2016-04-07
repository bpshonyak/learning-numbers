package net.greenrivertech.bdizzle.learningnumbers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button leftBtn;
    Button rightBtn;

    NumbersModel game = new NumbersModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftBtn = (Button) findViewById(R.id.firstNumber);
        rightBtn = (Button) findViewById(R.id.secondNumber);

        updateButtons();
    }

    public void leftBtnClicked(View view) {
        boolean didWin = game.play("left");
        showToast(didWin);
        updateGame();
    }

    public void rightBtnClicked(View view) {
        boolean didWin = game.play("right");
        showToast(didWin);
        updateGame();
    }

    public void showToast(Boolean didWin) {
        String toast;
        if (didWin){
            toast = "Correct!";
        } else {
            toast = "Try again!";
        }
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }

    public void updateButtons(){
        leftBtn.setText(String.valueOf(game.getLeftNumber()));
        rightBtn.setText(String.valueOf(game.getRightNumber()));
    }

    public void updateGame(){
        TextView scoreText = (TextView) findViewById(R.id.score);
        String tStr = String.valueOf(game.getTotalGames());
        String wStr = String.valueOf(game.getWins());
        scoreText.setText("Score: " + wStr + "/" + tStr);
        game.generateNumbers();
        updateButtons();
    }
}
