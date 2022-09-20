package com.prasunpersonal.snakeandladder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.prasunpersonal.snakeandladder.databinding.ActivityNamepagePvpBinding;

public class NamePagePVP extends AppCompatActivity {
    ActivityNamepagePvpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNamepagePvpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.pvpNameToolbar);
        binding.pvpNameToolbar.setNavigationOnClickListener(v -> finish());

        binding.StartButton.setOnClickListener(v -> {
            String FirstPlayerName = binding.FirstNameInput.getText().toString();
            String SecondPlayerName = binding.SecondNameInput.getText().toString();
            Intent PlayerVSPlayer = new Intent(this, PlayerVSPlayer.class);
            PlayerVSPlayer.putExtra("Player_Names", new String[] {FirstPlayerName, SecondPlayerName});
            startActivity(PlayerVSPlayer);
            finish();
        });
    }
}