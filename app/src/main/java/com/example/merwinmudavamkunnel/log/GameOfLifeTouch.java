package com.example.merwinmudavamkunnel.log;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;

/**
 * Created by merwinmudavamkunnel on 14.12.17.
 */

public class GameOfLifeTouch extends View {



    GameOfLife game = new GameOfLife(20); // passing the game itself to this class because we need access to the
    // boolean array of the gameoflife

    int square_size = 50; // setting the size for the cube size for drawing--> You can play with those
    // variables and set different numbers, to have your own GUI
    int start_position = 50; // setting the start position in the windowframe to draw--> You can play with
    // those variables and set different numbers, to have your own GUI
    int move_position = 50; // setting how much to move to draw the next cube to x-axis or y-axis--> You can
    // play with those variables and set different numbers, to have your own GUI
    ;


    Rect rect;
    Paint black;



    public GameOfLifeTouch(Context context) {
        super(context);

        this.black = new Paint();
        this.rect = new Rect();
        this.black.setColor(Color.BLACK);
        this.game.update();

    }


    @Override
    protected void onDraw(Canvas canvas) {

        this.black.setStyle(Paint.Style.STROKE);

        for (int x = 0; x < this.game.size; x++) { // Now we are accessing the game boolean array and creating the
            // squares
            for (int y = 0; y < this.game.size; y++) { // its basically the same as the tostring method of GameOfLife
                if (this.game.area[y][x] == true) { // if the cell is alive, it creates black squares
                    this.rect.set(50+(y*50+50) ,x*50+50 , y*50+50,50+(x*50+50));
                    black.setStyle(Paint.Style.FILL);
                    canvas.drawRect(rect,black);



                } else{ // if the cell is dead it creats empty cells

                    this.rect.set(50+(y*50+50) ,x*50+50 , y*50+50,50+(x*50+50));
                    black.setStyle(Paint.Style.STROKE);
                    canvas.drawRect(rect,black);
                }
                // the difference is fill.rect and draw.rect
            }
        }

        /*this.rect = new Rect(50+(2*50+50) ,3*50+50 , 2*50+50,50+(3*50+50));
        black.setStyle(Paint.Style.FILL);
        canvas.drawRect(rect,black);*/




    }

    public void updategame() { // this method updates the game 1 generation
        this.game.generations(1); // accessing the method generation in the game
        // object
        // this.frame.removeAll(); // this deletes the content in the jframe window
        redraw();
    }





    Handler handler = new Handler();
    int delay = 100; //milliseconds
    int counter = 0;
    boolean flag = true;
    public void autoUpdate(){



            handler.postDelayed(new Runnable() {
                public void run() {
                    if(flag) {
                        game.generations(1);
                        redraw();
                        counter++;
                        handler.postDelayed(this, delay);
                    }
                    else handler.removeCallbacks(this);
                }


            }, delay);



    }

    public void redraw(){
        this.invalidate();
    }

    public void restart(){
       game.restart();
    }



   /* public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                updategame();// do something
                break;
            case MotionEvent.ACTION_MOVE:
                // do something
                break;
            case MotionEvent.ACTION_UP:
                //do something
                break;
        }
        return true;
    }
*/

}
