package com.SoftSkill.snake_and_ladder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NamePagePVP extends AppCompatActivity {

    private EditText FirstNameInput;
    private EditText SecondNameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namepage_pvp);

        FirstNameInput = findViewById(R.id.FirstNameInput);
        SecondNameInput = findViewById(R.id.SecondNameInput);
    }

    public void StartButton(View view){
        String FirstPlayerName = FirstNameInput.getText().toString();
        String SecondPlayerName = SecondNameInput.getText().toString();
        Intent PlayerVSPlayer = new Intent(this, PlayerVSPlayer.class);
        PlayerVSPlayer.putExtra("Player_Names", new String[] {FirstPlayerName, SecondPlayerName});
        startActivity(PlayerVSPlayer);
    }
}