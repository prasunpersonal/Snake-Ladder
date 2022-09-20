package com.prasunpersonal.snakeandladder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.prasunpersonal.snakeandladder.databinding.ActivityNamepagePvcBinding;

public class NamePagePVC extends AppCompatActivity {
    ActivityNamepagePvcBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNamepagePvcBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.pvcNameToolbar);
        binding.pvcNameToolbar.setNavigationOnClickListener(v -> finish());

        binding.StartButton.setOnClickListener(v -> {
            String FirstPlayerName = binding.FirstNameInput.getText().toString();
            Intent PlayerVSComputer = new Intent(this, PlayerVSComputer.class);
            PlayerVSComputer.putExtra("Player_Name", FirstPlayerName);
            startActivity(PlayerVSComputer);
            finish();
        });
    }
}