package com.prasunpersonal.snakeandladder;

import static com.prasunpersonal.snakeandladder.App.POSITIONS;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.prasunpersonal.snakeandladder.databinding.ActivityGameBinding;
import com.prasunpersonal.snakeandladder.databinding.WinDialogBinding;

import java.util.Random;

public class PlayerVSComputer extends AppCompatActivity {
    ActivityGameBinding binding;
    private ImageView[] gamePosition;
    private final int[] diceState = {R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5, R.drawable.d6};
    String[] Final_Names;
    private int player1, player2, p1pts = 0, p2pts = 0;
    private boolean player1Start = false, player2Start = false;
    private Random random;
    private Handler handler;
    private boolean handlerActive;

    public void newGame() {
        player1 = -1;
        player2 = -1;
        player1Start = false;
        player2Start = false;
        handlerActive = false;
        binding.player1Dice.setImageResource(R.drawable.d1);
        binding.player2Dice.setImageResource(R.drawable.d1);
        for (ImageView imageView : gamePosition) imageView.setImageResource(0);
        binding.player1Dice.setEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.pvcToolbar);
        binding.pvcToolbar.setNavigationOnClickListener(v -> finish());

        random = new Random();
        handler = new Handler();
        gamePosition = new ImageView[]{
                binding.imageView1, binding.imageView2, binding.imageView3, binding.imageView4, binding.imageView5, binding.imageView6, binding.imageView7, binding.imageView8, binding.imageView9, binding.imageView10,
                binding.imageView11, binding.imageView12, binding.imageView13, binding.imageView14, binding.imageView15, binding.imageView16, binding.imageView17, binding.imageView18, binding.imageView19, binding.imageView20,
                binding.imageView21, binding.imageView22, binding.imageView23, binding.imageView24, binding.imageView25, binding.imageView26, binding.imageView27, binding.imageView28, binding.imageView29, binding.imageView30,
                binding.imageView31, binding.imageView32, binding.imageView33, binding.imageView34, binding.imageView35, binding.imageView36, binding.imageView37, binding.imageView38, binding.imageView39, binding.imageView40,
                binding.imageView41, binding.imageView42, binding.imageView43, binding.imageView44, binding.imageView45, binding.imageView46, binding.imageView47, binding.imageView48, binding.imageView49, binding.imageView50,
                binding.imageView51, binding.imageView52, binding.imageView53, binding.imageView54, binding.imageView55, binding.imageView56, binding.imageView57, binding.imageView58, binding.imageView59, binding.imageView60,
                binding.imageView61, binding.imageView62, binding.imageView63, binding.imageView64, binding.imageView65, binding.imageView66, binding.imageView67, binding.imageView68, binding.imageView69, binding.imageView70,
                binding.imageView71, binding.imageView72, binding.imageView73, binding.imageView74, binding.imageView75, binding.imageView76, binding.imageView77, binding.imageView78, binding.imageView79, binding.imageView80,
                binding.imageView81, binding.imageView82, binding.imageView83, binding.imageView84, binding.imageView85, binding.imageView86, binding.imageView87, binding.imageView88, binding.imageView89, binding.imageView90,
                binding.imageView91, binding.imageView92, binding.imageView93, binding.imageView94, binding.imageView95, binding.imageView96, binding.imageView97, binding.imageView98, binding.imageView99, binding.imageView100
        };

        String Player_Name = getIntent().getStringExtra("Player_Name");
        binding.p1name.setText((Player_Name.length() == 0) ? getString(R.string.player) : Player_Name);
        binding.p2name.setText(Build.MANUFACTURER);
        Final_Names = new String[]{binding.p1name.getText().toString(), binding.p2name.getText().toString()};

        newGame();

        binding.player1Dice.setOnClickListener(v -> {
            if (!handlerActive) dice1Roll(0);
        });
        binding.player2Dice.setEnabled(false);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.game_menu, menu);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.restart) newGame();
        return super.onOptionsItemSelected(item);
    }

    private void dice1Roll(int i) {
        handlerActive = true;
        int r = random.nextInt(6);
        binding.player1Dice.setImageResource(diceState[r]);
        if (i == 6) {
            if ((player1Start || r == 0) && player1+r < 99) {
                player1Start = true;
                player1Turn(0, r);
            } else {
                binding.player1Dice.setEnabled(false);
                binding.player2Dice.setEnabled(true);
                handlerActive = false;
                dice2Roll(0);
            }
        } else {
            handler.postDelayed(()-> {
                dice1Roll(i+1);
            }, 200);
        }
    }
    
    private void player1Turn(int i, int n) {
        if (player1 >= 0) gamePosition[player1].setImageResource((player1 == player2) ? R.drawable.bluepawn : 0);
        gamePosition[++player1].setImageResource((player1 == player2) ? R.drawable.bothpawn : R.drawable.redpawn);
        if (i < n) {
            handler.postDelayed(()-> player1Turn(i+1, n), 250);
        } else if (i == n){
            handler.postDelayed(()-> {
                if (POSITIONS.containsKey(player1)) {
                    gamePosition[player1].setImageResource(0);
                    player1 = POSITIONS.get(player1);
                    gamePosition[player1].setImageResource((player1 == player2) ? R.drawable.bothpawn : R.drawable.redpawn);
                }
                handlerActive = false;
                if (player1 != 99 && player2 != 99) {
                    if (n != 5) {
                        binding.player1Dice.setEnabled(false);
                        binding.player2Dice.setEnabled(true);
                        dice2Roll(0);
                    }
                } else {
                    winDialog();
                }
            }, 250);
        }
    }

    private void dice2Roll(int i) {
        handlerActive = true;
        int r = random.nextInt(6);
        binding.player2Dice.setImageResource(diceState[r]);
        if (i == 6) {
            if ((player2Start || r == 0) && player2+r < 99) {
                player2Start = true;
                player2Turn(0, r);
            } else {
                binding.player1Dice.setEnabled(true);
                binding.player2Dice.setEnabled(false);
                handlerActive = false;
            }
        } else {
            handler.postDelayed(()-> {
                dice2Roll(i+1);
            }, 200);
        }
    }

    private void player2Turn(int i, int n) {
        if (player2 >= 0) gamePosition[player2].setImageResource((player1 == player2) ? R.drawable.redpawn : 0);
        gamePosition[++player2].setImageResource((player1 == player2) ? R.drawable.bothpawn : R.drawable.bluepawn);
        if (i < n) {
            handler.postDelayed(()-> player2Turn(i+1, n), 250);
        } else if (i == n){
            handler.postDelayed(()-> {
                if (POSITIONS.containsKey(player2)) {
                    gamePosition[player2].setImageResource(0);
                    player2 = POSITIONS.get(player2);
                    gamePosition[player2].setImageResource((player1 == player2) ? R.drawable.bothpawn : R.drawable.bluepawn);
                }
                handlerActive = false;
                if (player1 != 99 && player2 != 99) {
                    if (n != 5) {
                        binding.player1Dice.setEnabled(true);
                        binding.player2Dice.setEnabled(false);
                    } else {
                        dice2Roll(0);
                    }
                } else {
                    winDialog();
                }
            }, 250);
        }
    }

    private void winDialog() {
        WinDialogBinding dialogBinding = WinDialogBinding.inflate(getLayoutInflater());
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(dialogBinding.getRoot())
                .setCancelable(false)
                .create();
        dialog.show();
        if (player1 == 99) {
            dialogBinding.winnerPawn.setImageResource(R.drawable.redpawn);
            dialogBinding.winnerName.setText(binding.p1name.getText());
            p1pts++;
        } else if (player2 == 99) {
            dialogBinding.winnerPawn.setImageResource(R.drawable.bluepawn);
            dialogBinding.winnerName.setText(binding.p2name.getText());
            p2pts++;
        }
        binding.p1pt.setText(String.valueOf(p1pts));
        binding.p2pt.setText(String.valueOf(p2pts));
        dialogBinding.homeBtn.setOnClickListener(v -> {
            dialog.dismiss();
            finish();
        });
        dialogBinding.rematchBtn.setOnClickListener(v -> {
            dialog.dismiss();
            newGame();
        });
    }
}