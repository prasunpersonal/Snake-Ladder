package com.SoftSkill.snake_and_ladder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NamePagePVC extends AppCompatActivity {

    private EditText FirstNameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namepage_pvc);
        FirstNameInput = findViewById(R.id.FirstNameInput);
    }

    public void StartButton(View view){
        String FirstPlayerName = FirstNameInput.getText().toString();
        Intent PlayerVSComputer = new Intent(this, PlayerVSComputer.class);
        PlayerVSComputer.putExtra("Player_Name", FirstPlayerName);
        startActivity(PlayerVSComputer);
    }
}