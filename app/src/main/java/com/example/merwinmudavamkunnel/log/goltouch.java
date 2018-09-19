package com.example.merwinmudavamkunnel.log;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by merwinmudavamkunnel on 13.12.17.
 */

public class goltouch extends RelativeLayout{

    View rootView;
    private TextView generations;
    private TextView dummy;
    GameOfLifeTouch go;
    Button update;
    Button restart;
    Button autoupdate;
    Button stop;

    ImageView pic;
    Rect rect;
    Paint black;
    int counter = 0;

    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();





    goltouch(final Context context){
        super(context);
        init(context);
        go = new GameOfLifeTouch(context);
        addView(go);
        this.black = new Paint();
        this.rect = new Rect();
        this.black.setColor(Color.BLACK);


    }

    public void init(final Context context) {
        rootView = inflate(context, R.layout.testlay, this);

        update = rootView.findViewById(R.id.UPDATE);
        update.setBackgroundColor(Color.YELLOW);

        restart = rootView.findViewById(R.id.RESTART);
        restart.setBackgroundColor(Color.YELLOW);

        autoupdate = rootView.findViewById(R.id.autoupdate);
        autoupdate.setBackgroundColor(Color.YELLOW);

        stop = rootView.findViewById(R.id.stop);
        stop.setBackgroundColor(Color.RED);
        stop.setVisibility(INVISIBLE);




        generations = rootView.findViewById(R.id.Generation);

        dummy = rootView.findViewById(R.id.dummy);

        this.pic = new ImageView(context);
        this.setBackgroundResource(R.drawable.picture);
        this.pic.setVisibility(INVISIBLE);


        update.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                go.updategame();
                dummy.setText(""+counter);
            }
        });

        restart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                go.flag = false;
                stop.setVisibility(INVISIBLE);
                go.updategame();
                counter = 0;
                dummy.setText("\n");
                go.restart();
            }
        });

        autoupdate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                    go.flag = true;
                    stop.setVisibility(VISIBLE);
                    go.autoUpdate();
                    dummy.setText("\n");
            }
        });

        stop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                go.flag = false;
            }
        });

    }



    }

