package com.SoftSkill.snake_and_ladder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class PlayerVSPlayer extends AppCompatActivity {

    private final ImageView[] gamePosition = new ImageView[100];
    private final int[] diceState = new int[6];
    private String[] Player_Names = new String[2];
    private String[] Final_Names = new String[2];
    ImageView diceImg1, diceImg2;
    TextView p1pt, p2pt, FirstPlayerName, SecondPlayerName, status;
    private int player1 = 0, player2 = 0, p1pts = 0, p2pts = 0;
    private boolean player1Start = false, player2Start = false;

    public void goHome(View view){
        Intent homePage = new Intent(this, SelectionPage.class);
        startActivity(homePage);
    }
    public void NewGame(View view){
        player1=0;
        player2=0;
        player1Start = false;
        player2Start = false;
        diceImg1.setImageResource(R.drawable.d1);
        diceImg2.setImageResource(R.drawable.d1);
        for (int i = player1; i < gamePosition.length; i++){
            gamePosition[i].setImageResource(0);
        }
        diceImg2.setEnabled(false);
        diceImg1.setEnabled(true);
        status.setVisibility(View.INVISIBLE);
    }
    private int getRandom(){
        Random rand = new Random();
        return (rand.nextInt(6)+1);
    }
    private void ChangeDiceImage(int num, ImageView diceImg) {
        Thread thread = new Thread(){
            @Override
            public void run(){
                for (int i=0; i<num; i++){
                    try {
                        Thread.sleep(100);
                        int j = i;
                        runOnUiThread(() -> diceImg.setImageResource(diceState[j]));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }
    private void startPlayer1(int num) {
        if (num==1) {
            player1Start = true;
            player1 += 1;
            if (player1 == player2) {
                gamePosition[0].setImageResource(R.drawable.bothpawn);
            } else {
                gamePosition[0].setImageResource(R.drawable.redpawn);
            }
        }
    }
    private void startPlayer2(int num) {
        if (num==1) {
            player2Start = true;
            player2 += 1;
            if (player2 == player1) {
                gamePosition[0].setImageResource(R.drawable.bothpawn);
            } else {
                gamePosition[0].setImageResource(R.drawable.bluepawn);
            }
        }
    }
    private void updateBoardPlayer1(int num) {
        for (int i = player1; i < player1+num; i++){
            if (player1+num <= 100) {
                if (i==player1+num-1){
                    gamePosition[i].setImageResource(R.drawable.redpawn);
                    gamePosition[player1-1].setImageResource(0);
                }
            }
        }
        if (player1+num <= 100) {
            player1 += num;
        }
    }
    private void updateBoardPlayer2(int num) {
        for (int i = player2; i < player2+num; i++){
            if (player2+num <= 100) {
                if (i==player2+num-1){
                    gamePosition[i].setImageResource(R.drawable.bluepawn);
                    gamePosition[player2-1].setImageResource(0);
                }
            }
        }
        if (player2+num <= 100) {
            player2 += num;
        }
    }
    private void SnakeLadderPlayer1() {
        //===============For Ladder===============
        if (player1==3){
            gamePosition[player1-1].setImageResource(0);
            player1=60;
            gamePosition[player1-1].setImageResource(R.drawable.redpawn);
        }else if (player1==6){
            gamePosition[player1-1].setImageResource(0);
            player1=27;
            gamePosition[player1-1].setImageResource(R.drawable.redpawn);
        }else if (player1==11){
            gamePosition[player1-1].setImageResource(0);
            player1=70;
            gamePosition[player1-1].setImageResource(R.drawable.redpawn);
        }else if (player1==35){
            gamePosition[player1-1].setImageResource(0);
            player1=56;
            gamePosition[player1-1].setImageResource(R.drawable.redpawn);
        }else if (player1==63){
            gamePosition[player1-1].setImageResource(0);
            player1=96;
            gamePosition[player1-1].setImageResource(R.drawable.redpawn);
        }else if (player1==68){
            gamePosition[player1-1].setImageResource(0);
            player1=93;
            gamePosition[player1-1].setImageResource(R.drawable.redpawn);
        }
        //=============== For Snake ===============
        else if (player1==25){
            gamePosition[player1-1].setImageResource(0);
            player1=5;
            gamePosition[player1-1].setImageResource(R.drawable.redpawn);
        }else if (player1==37){
            gamePosition[player1-1].setImageResource(0);
            player1=1;
            gamePosition[player1-1].setImageResource(R.drawable.redpawn);
        }else if (player1==47){
            gamePosition[player1-1].setImageResource(0);
            player1=9;
            gamePosition[player1-1].setImageResource(R.drawable.redpawn);
        }else if (player1==65){
            gamePosition[player1-1].setImageResource(0);
            player1=59;
            gamePosition[player1-1].setImageResource(R.drawable.redpawn);
        }else if (player1==87){
            gamePosition[player1-1].setImageResource(0);
            player1=54;
            gamePosition[player1-1].setImageResource(R.drawable.redpawn);
        }else if (player1==92){
            gamePosition[player1-1].setImageResource(0);
            player1=69;
            gamePosition[player1-1].setImageResource(R.drawable.redpawn);
        }else if (player1==99){
            gamePosition[player1-1].setImageResource(0);
            player1=62;
            gamePosition[player1-1].setImageResource(R.drawable.redpawn);
        }
    }
    private void SnakeLadderPlayer2() {
        //===============For Ladder===============
        if (player2==3){
            gamePosition[player2-1].setImageResource(0);
            player2=60;
            gamePosition[player2-1].setImageResource(R.drawable.bluepawn);
        }else if (player2==6){
            gamePosition[player2-1].setImageResource(0);
            player2=27;
            gamePosition[player2-1].setImageResource(R.drawable.bluepawn);
        }else if (player2==11){
            gamePosition[player2-1].setImageResource(0);
            player2=70;
            gamePosition[player2-1].setImageResource(R.drawable.bluepawn);
        }else if (player2==35){
            gamePosition[player2-1].setImageResource(0);
            player2=56;
            gamePosition[player2-1].setImageResource(R.drawable.bluepawn);
        }else if (player2==63){
            gamePosition[player2-1].setImageResource(0);
            player2=96;
            gamePosition[player2-1].setImageResource(R.drawable.bluepawn);
        }else if (player2==68){
            gamePosition[player2-1].setImageResource(0);
            player2=93;
            gamePosition[player2-1].setImageResource(R.drawable.bluepawn);
        }
        //=============== For Snake ===============
        else if (player2==25){
            gamePosition[player2-1].setImageResource(0);
            player2=5;
            gamePosition[player2-1].setImageResource(R.drawable.bluepawn);
        }else if (player2==37){
            gamePosition[player2-1].setImageResource(0);
            player2=1;
            gamePosition[player2-1].setImageResource(R.drawable.bluepawn);
        }else if (player2==47){
            gamePosition[player2-1].setImageResource(0);
            player2=9;
            gamePosition[player2-1].setImageResource(R.drawable.bluepawn);
        }else if (player2==65){
            gamePosition[player2-1].setImageResource(0);
            player2=59;
            gamePosition[player2-1].setImageResource(R.drawable.bluepawn);
        }else if (player2==87){
            gamePosition[player2-1].setImageResource(0);
            player2=54;
            gamePosition[player2-1].setImageResource(R.drawable.bluepawn);
        }else if (player2==92){
            gamePosition[player2-1].setImageResource(0);
            player2=69;
            gamePosition[player2-1].setImageResource(R.drawable.bluepawn);
        }else if (player2==99){
            gamePosition[player2-1].setImageResource(0);
            player2=62;
            gamePosition[player2-1].setImageResource(R.drawable.bluepawn);
        }
    }
    private void firstPlayer(){
        int num = getRandom();
        ChangeDiceImage(num, diceImg1);
        if (!player1Start){
            diceImg1.setEnabled(false);
            diceImg2.setEnabled(true);
            startPlayer1(num);
        }else {
            if (num != 6) {
                diceImg1.setEnabled(false);
                diceImg2.setEnabled(true);
            }
            Handler handler = new Handler();
            handler.postDelayed(() -> {
                updateBoardPlayer1(num);
                SnakeLadderPlayer1();
                if (player1==player2){
                    gamePosition[player1-1].setImageResource(R.drawable.bothpawn);
                }
                if (player2Start){
                    if (player1-num==player2){
                        gamePosition[player1-1-num].setImageResource(R.drawable.bluepawn);
                    }
                }
                if (player1==100){
                    p1pts+=1;
                    diceImg1.setEnabled(false);
                    diceImg2.setEnabled(false);
                    scoreUpdate();
                }
            }, 100*(num+1));
        }
    }
    private void secondPlayer(){
        int num = getRandom();
        ChangeDiceImage(num, diceImg2);
        if (!player2Start){
            diceImg1.setEnabled(true);
            diceImg2.setEnabled(false);
            startPlayer2(num);
        }else {
            if (num != 6) {
                diceImg1.setEnabled(true);
                diceImg2.setEnabled(false);
            }
            Handler handler = new Handler();
            handler.postDelayed(() -> {
                updateBoardPlayer2(num);
                SnakeLadderPlayer2();
                if (player2==player1){
                    gamePosition[player2-1].setImageResource(R.drawable.bothpawn);
                }
                if (player1Start) {
                    if (player2 - num == player1) {
                        gamePosition[player2 - 1 - num].setImageResource(R.drawable.redpawn);
                    }
                }
                if (player2==100){
                    p2pts+=1;
                    diceImg1.setEnabled(false);
                    diceImg2.setEnabled(false);
                    scoreUpdate();
                }
            }, 100*(num+1));
        }
    }
    @SuppressLint("DefaultLocale")
    private void scoreUpdate() {
        if (player1==100){
            p1pt.setText(String.format("%02d",p1pts));
            status.setText(Final_Names[0] + " has won !!!");
            status.setVisibility(View.VISIBLE);
        }else if (player2==100){
            p2pt.setText(String.format("%02d",p2pts));
            status.setText(Final_Names[1] + " has won !!!");
            status.setVisibility(View.VISIBLE);
        }
    }
    public void dice1Tap(View view){
        firstPlayer();
    }
    public void dice2Tap(View view){
        secondPlayer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_player);

        diceImg1=findViewById(R.id.player1Dice);
        diceImg2=findViewById(R.id.player2Dice);
        p1pt=findViewById(R.id.p1pt);
        p2pt=findViewById(R.id.p2pt);
        FirstPlayerName=findViewById(R.id.p1name);
        SecondPlayerName=findViewById(R.id.p2name);
        status=findViewById(R.id.status);
        Player_Names = getIntent().getStringArrayExtra("Player_Names");
        if (Player_Names[0].length()==0){
            FirstPlayerName.setText(R.string.player_1);
        }else {
            FirstPlayerName.setText(Player_Names[0]);
        }
        if (Player_Names[1].length()==0){
            SecondPlayerName.setText(R.string.player_2);
        }else {
            SecondPlayerName.setText(Player_Names[1]);
        }
        Final_Names = new String[] {FirstPlayerName.getText().toString(), SecondPlayerName.getText().toString()};
        diceImg2.setEnabled(false);

        diceState[0] = R.drawable.d1;
        diceState[1] = R.drawable.d2;
        diceState[2] = R.drawable.d3;
        diceState[3] = R.drawable.d4;
        diceState[4] = R.drawable.d5;
        diceState[5] = R.drawable.d6;

        gamePosition[0] = findViewById(R.id.imageView1);
        gamePosition[1] = findViewById(R.id.imageView2);
        gamePosition[2] = findViewById(R.id.imageView3);
        gamePosition[3] = findViewById(R.id.imageView4);
        gamePosition[4] = findViewById(R.id.imageView5);
        gamePosition[5] = findViewById(R.id.imageView6);
        gamePosition[6] = findViewById(R.id.imageView7);
        gamePosition[7] = findViewById(R.id.imageView8);
        gamePosition[8] = findViewById(R.id.imageView9);
        gamePosition[9] = findViewById(R.id.imageView10);
        gamePosition[10] = findViewById(R.id.imageView11);
        gamePosition[11] = findViewById(R.id.imageView12);
        gamePosition[12] = findViewById(R.id.imageView13);
        gamePosition[13] = findViewById(R.id.imageView14);
        gamePosition[14] = findViewById(R.id.imageView15);
        gamePosition[15] = findViewById(R.id.imageView16);
        gamePosition[16] = findViewById(R.id.imageView17);
        gamePosition[17] = findViewById(R.id.imageView18);
        gamePosition[18] = findViewById(R.id.imageView19);
        gamePosition[19] = findViewById(R.id.imageView20);
        gamePosition[20] = findViewById(R.id.imageView21);
        gamePosition[21] = findViewById(R.id.imageView22);
        gamePosition[22] = findViewById(R.id.imageView23);
        gamePosition[23] = findViewById(R.id.imageView24);
        gamePosition[24] = findViewById(R.id.imageView25);
        gamePosition[25] = findViewById(R.id.imageView26);
        gamePosition[26] = findViewById(R.id.imageView27);
        gamePosition[27] = findViewById(R.id.imageView28);
        gamePosition[28] = findViewById(R.id.imageView29);
        gamePosition[29] = findViewById(R.id.imageView30);
        gamePosition[30] = findViewById(R.id.imageView31);
        gamePosition[31] = findViewById(R.id.imageView32);
        gamePosition[32] = findViewById(R.id.imageView33);
        gamePosition[33] = findViewById(R.id.imageView34);
        gamePosition[34] = findViewById(R.id.imageView35);
        gamePosition[35] = findViewById(R.id.imageView36);
        gamePosition[36] = findViewById(R.id.imageView37);
        gamePosition[37] = findViewById(R.id.imageView38);
        gamePosition[38] = findViewById(R.id.imageView39);
        gamePosition[39] = findViewById(R.id.imageView40);
        gamePosition[40] = findViewById(R.id.imageView41);
        gamePosition[41] = findViewById(R.id.imageView42);
        gamePosition[42] = findViewById(R.id.imageView43);
        gamePosition[43] = findViewById(R.id.imageView44);
        gamePosition[44] = findViewById(R.id.imageView45);
        gamePosition[45] = findViewById(R.id.imageView46);
        gamePosition[46] = findViewById(R.id.imageView47);
        gamePosition[47] = findViewById(R.id.imageView48);
        gamePosition[48] = findViewById(R.id.imageView49);
        gamePosition[49] = findViewById(R.id.imageView50);
        gamePosition[50] = findViewById(R.id.imageView51);
        gamePosition[51] = findViewById(R.id.imageView52);
        gamePosition[52] = findViewById(R.id.imageView53);
        gamePosition[53] = findViewById(R.id.imageView54);
        gamePosition[54] = findViewById(R.id.imageView55);
        gamePosition[55] = findViewById(R.id.imageView56);
        gamePosition[56] = findViewById(R.id.imageView57);
        gamePosition[57] = findViewById(R.id.imageView58);
        gamePosition[58] = findViewById(R.id.imageView59);
        gamePosition[59] = findViewById(R.id.imageView60);
        gamePosition[60] = findViewById(R.id.imageView61);
        gamePosition[61] = findViewById(R.id.imageView62);
        gamePosition[62] = findViewById(R.id.imageView63);
        gamePosition[63] = findViewById(R.id.imageView64);
        gamePosition[64] = findViewById(R.id.imageView65);
        gamePosition[65] = findViewById(R.id.imageView66);
        gamePosition[66] = findViewById(R.id.imageView67);
        gamePosition[67] = findViewById(R.id.imageView68);
        gamePosition[68] = findViewById(R.id.imageView69);
        gamePosition[69] = findViewById(R.id.imageView70);
        gamePosition[70] = findViewById(R.id.imageView71);
        gamePosition[71] = findViewById(R.id.imageView72);
        gamePosition[72] = findViewById(R.id.imageView73);
        gamePosition[73] = findViewById(R.id.imageView74);
        gamePosition[74] = findViewById(R.id.imageView75);
        gamePosition[75] = findViewById(R.id.imageView76);
        gamePosition[76] = findViewById(R.id.imageView77);
        gamePosition[77] = findViewById(R.id.imageView78);
        gamePosition[78] = findViewById(R.id.imageView79);
        gamePosition[79] = findViewById(R.id.imageView80);
        gamePosition[80] = findViewById(R.id.imageView81);
        gamePosition[81] = findViewById(R.id.imageView82);
        gamePosition[82] = findViewById(R.id.imageView83);
        gamePosition[83] = findViewById(R.id.imageView84);
        gamePosition[84] = findViewById(R.id.imageView85);
        gamePosition[85] = findViewById(R.id.imageView86);
        gamePosition[86] = findViewById(R.id.imageView87);
        gamePosition[87] = findViewById(R.id.imageView88);
        gamePosition[88] = findViewById(R.id.imageView89);
        gamePosition[89] = findViewById(R.id.imageView90);
        gamePosition[90] = findViewById(R.id.imageView91);
        gamePosition[91] = findViewById(R.id.imageView92);
        gamePosition[92] = findViewById(R.id.imageView93);
        gamePosition[93] = findViewById(R.id.imageView94);
        gamePosition[94] = findViewById(R.id.imageView95);
        gamePosition[95] = findViewById(R.id.imageView96);
        gamePosition[96] = findViewById(R.id.imageView97);
        gamePosition[97] = findViewById(R.id.imageView98);
        gamePosition[98] = findViewById(R.id.imageView99);
        gamePosition[99] = findViewById(R.id.imageView100);
    }
}