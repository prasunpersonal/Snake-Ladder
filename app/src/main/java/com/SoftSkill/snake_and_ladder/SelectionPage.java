package com.SoftSkill.snake_and_ladder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectionPage extends AppCompatActivity {


    public void playesVSplayer(View view){
        Intent NamePagePVP = new Intent(this, NamePagePVP.class);
        startActivity(NamePagePVP);
    }
    public void playesVScomputer(View view){
        Intent NamePagePVC = new Intent(this, NamePagePVC.class);
        startActivity(NamePagePVC);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_page);

    }
}