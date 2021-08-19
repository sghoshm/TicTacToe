  package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

  public class MainActivity extends AppCompatActivity {
      boolean gameActive=true;
      //State Meanings
      //0-X
      //1-O
      //2-Null
      int activePlayer=0;
      int[] gameState={2,2,2,2,2,2,2,2,2};
      int[][] winPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedImage=Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            gameReset(view);
        }
        if (gameState[tappedImage]==2&& gameActive) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.l);
                activePlayer = 1;
                TextView status =findViewById(R.id.status);
                status.setText("O's Turn Tap to Play");
            } else {
                img.setImageResource(R.drawable.p);
                activePlayer = 0;
                TextView status =findViewById(R.id.status);
                status.setText("X's Turn Tap to Play");
            }
            img.animate().translationYBy(1000f).setDuration(100);
        }
        //Check if Won
        for(int[] winPositions:winPositions){
          if  (gameState[winPositions[0]]==gameState[winPositions[1]]&& gameState[winPositions[1]]==gameState[winPositions[2]]&&
                  gameState[winPositions[0]]!=2){
              //Someone has won Find out who??
              String winnerStr;
              gameActive=false;
              if(gameState[winPositions[0]]==0){
                  winnerStr= "X has Won";
              }
              else {
                  winnerStr="O has Won";
              }
              //Incase win Status = Won
              TextView status =findViewById(R.id.status);
              status.setText(winnerStr);
          }
          boolean emptySquare=false;
          for (int squareState:gameState){
              if(squareState==2){
                  emptySquare=true;
                  break;
              }
          }
          if(!emptySquare&&gameActive){
              //Game is draw
              gameActive=false;
              String winnerStr="No One Wins!";
              TextView status=findViewById(R.id.status);
              status.setText(winnerStr);
          }

        }
    }
      public void gameReset(View view){
        gameActive=true;
        activePlayer=0;
        for(int i=0; i<gameState.length;i++){
            gameState[i]=2;
        }
          ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

          TextView status =findViewById(R.id.status);
          status.setText("X's Turn Tap to Play");

      }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}