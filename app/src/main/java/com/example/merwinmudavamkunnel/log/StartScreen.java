package com.example.merwinmudavamkunnel.log;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
    }

    public void startGame(View view){
        Intent intentgamestart = new Intent(this,MainActivity.class);
        startActivity(intentgamestart);
    }

    public void startNetwork(View view){
        Intent intentnetworkstart = new Intent(this,network_activity.class);
        startActivity(intentnetworkstart);
    }

    public void startTerminal(View view){
        Intent intentterminalstart = new Intent(this,terminal.class);
        startActivity(intentterminalstart);
    }
}
