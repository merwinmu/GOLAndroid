package com.example.merwinmudavamkunnel.log;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class network_receive_activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.network_receive_activity);
        final client_network cl = new client_network();
        final TextView terminal = (TextView) findViewById(R.id.terminal);
        Button net = (Button)findViewById(R.id.Test);



        net.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = cl.test();


                terminal.append(String.valueOf(result)+"\n");
            }
        });
    }
}
