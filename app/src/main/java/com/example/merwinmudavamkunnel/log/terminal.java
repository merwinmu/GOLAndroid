package com.example.merwinmudavamkunnel.log;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class terminal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminal);
        final TextView terminal = (TextView) findViewById(R.id.terminalscreen);
        source_terminal src = new source_terminal();
        terminal.setText("");
        for(int i = 0; i < 1; i++) {
            terminal.append(src.get()+"\n");

        }
    }
}
