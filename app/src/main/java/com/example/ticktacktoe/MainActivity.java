package com.example.ticktacktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    //Player Representation
    //0 - X
    //1 - 0
    int activePlayer=0;
    int[] gameState={2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
    //State Meaning
    //0 - X
    //1 - 0
    //2- NULL
    int[][] winPosition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    private int[][] winPositions;

    public void playerTap(View view){
        ImageView img=(ImageView) view;
        int tappedImage=Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            gameReset(view);
        }
        if(gameState[tappedImage]==2 && gameActive){
            gameState[tappedImage]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0){
                img.setImageResource(R.drawable.cross);
                activePlayer= 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn - Tap to Play");
            }
            else{
                img.setImageResource(R.drawable.zero);
                activePlayer =0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn - Tap to Play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for(int[] winPosition: winPositions){
            if(gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]]!=2){
                    //SomeBody has won the Game - Find out who???
                String winnerStr;
                gameActive=false;
                if(gameState[winPosition[0]] == 0){
                    winnerStr = "X has won";
                }
                else{
                    winnerStr = "0 has won";
                }
                //Update the status Bar for Winner Announcement
            }
        }

    }
    public  void  gameReset(View view){
        gameActive = true;
        activePlayer = 0;
        for(int i=0; i<gameState.length; i++){
            gameState[i]=2;
        }
//        ((ImageView)findViewById(R.id.innerView0)).setImageResource(0);
//        ((ImageView)findViewById(R.id.innerView1)).setImageResource(0);
//        ((ImageView)findViewById(R.id.innerView2)).setImageResource(0);
//        ((ImageView)findViewById(R.id.innerView3)).setImageResource(0);
//        ((ImageView)findViewById(R.id.innerView4)).setImageResource(0);
//        ((ImageView)findViewById(R.id.innerView5)).setImageResource(0);
//        ((ImageView)findViewById(R.id.innerView6)).setImageResource(0);
//        ((ImageView)findViewById(R.id.innerView7)).setImageResource(0);
//        ((ImageView)findViewById(R.id.innerView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to Play");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}