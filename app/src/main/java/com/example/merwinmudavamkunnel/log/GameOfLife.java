package com.example.merwinmudavamkunnel.log;

import java.util.Random;

/**
 * Created by merwinmudavamkunnel on 14.12.17.
 */

public class GameOfLife {

    boolean area[][];
    int size = 5;
    boolean areaCopy[][];
    int step = 0;

    GameOfLife(int size) {
        this.size = size;
        this.area = new boolean[size][size];
        this.areaCopy = new boolean[this.size][this.size]; // creating an empty boolean array for later purpose
        int prozent = 30;
        int totalProzent = 100; // Got rid of magic Numbers updated
        int amount = (size * size * prozent) / totalProzent; // calculating the 30% of the field
        int count = 0;
        Random random = new Random();

        while (amount > count) { // filling the the boolean array with true by putting it in random position but
            // only 30% of the field is filled up with true, the rest is false
            this.area[random.nextInt(size)][random.nextInt(size)] = true;
            count++; // counting until the certain amount of area is filled
        }
        System.out.print(this); // displays the origin field, this means the class object

    }

    GameOfLife() {
        this.area = new boolean[this.size][this.size]; // this empty is going to be filled up
        this.areaCopy = new boolean[this.size][this.size]; // creating an empty boolean array for later purpose
        this.area[1][1] = true; // setting the certain squares with true, based on the question
        this.area[1][3] = true;
        this.area[2][2] = true;
        this.area[2][3] = true;
        this.area[3][2] = true;

        System.out.print(this); // display the field, this mean the class object

    }

    public void update() { // If you have not read the counter function , you wont understand this funcion
        // we need an empty field again, this field is never
        // going to be filled, because once we copy from origin
        // area to the areaCopy we need the delete
        // the data from areaCopy, you will see below
        for (int x = 0; x < this.size; x++) { // this loop does the manipulation process, it changes the areaCopy field
            // until it is filled with the newest data
            for (int y = 0; y < this.size; y++) {
                counter(x, y); // checks counter function below
            }
        }
        this.area = this.areaCopy; // Once we have our new areaCopy with the newest data it is copied to the
        // originating area
        this.areaCopy = new boolean[this.size][this.size]; // This sets all the values from the areaCopy to false, just
        // declaring the same array , updated

        System.out.println();// the areaCopy is deleted with help of delete boolean array see above
        System.out.print(this); // this prints out the newest field which is saved in the originating area, this
        // means the class
        System.out.println();
        this.step++;
        System.out.print("Evolution steps: " + this.step);

    }

    // THIS FUNCTION IS NOT FOR SIMULATING PURPOSE, ITS ONLY FOR CHECKING THE NEXT
    // GENERATION

    public void generations(int n) {

        // Interupted Exception is needed for running the
        // program slow
        // this function gets number n; then the update will
        // be
        // runned n times. how many
        // times the it updates

        for (int i = 0; i < n; i++) {
            update();
            // This performs the update function every 1 second used to print the program on
            // the terminal 1s
        }
    }




    public void generations()  { // Interupted Exception is needed for running the program
        // slow
        int count = 0;
        while (count < this.size * this.size) { // With this while loop the game simulates until all cells are dead
            count = 0; // count is for count all dead cells, if all are dead , then simulation stops
            update(); // explained above
             // This performs the update function every 1 second used to print the program on
            // the terminal 1s

            for (int x = 0; x < this.size; x++) { // This 2 for loop goes each cells , and counts all dead cells, if all
                // are dead, then program is stopped
                for (int y = 0; y < this.size; y++) {
                    if (this.area[x][y] == false) {
                        count++; //
                    }
                }
            }

        }

    }

    private void counter(int x, int y) {
        // this function is a pointer, this pointer points to every pixel, the pointer
        // counts all the neigbour cells from the position where the marker is at.
        // It also checks if the current cell where the pointer is pointed at is living
        // or not
        // It also applies the rule of the game and creates or deletes the cell which
        // are copied to the areaCopy boolean
        // See the steps;

        int count = 0; // the counter is required for counting the neighbours
        int truex = 0; // true x is required, if we reach the edge of the field, it needs to go back to
        // the starting position
        int truey = 0; // true y is required, if we reach the edge of the field, it needs to go back to
        // the starting position

        if (area[x][y] == true) // this checks if pointer pointin a true cell, if yes count is reduced to -1
            // because, if we start to count the
            // the neigbouring cell, the pointer accidently counts also the cell where it is
            // pointing at.
            count--;

        for (int i = x - 1; i <= x + 1; i++) { // these 2 Loop helps us to go to each neighbourcell
            for (int s = y - 1; s <= y + 1; s++) {

                truex = (i + this.size) % this.size; // here as i explained above this calculation helps to back to
                // first position if a cell is at edge
                truey = (s + this.size) % this.size; // explained above

                if (this.area[truex][truey] == true) { // here we are counting if the neigbour is living
                    count++;
                }
                if (count >= 4 || count <= 1) { // once we are done with the counting, we are going create or kill a
                    // cell with the games rule
                    // and we are creating or killing the cell in areaCopy, we are NOT touching the
                    // originating field
                    this.areaCopy[x][y] = false;
                }

                if (count == 2) { // once we are done with the counting, we are going create or kill a cell with
                    // the games rule
                    // and we are creating or killing the cell in areaCopy, we are NOT touching the
                    // originating field
                    if (this.area[x][y] == true)
                        this.areaCopy[x][y] = true;
                    else
                        this.areaCopy[x][y] = false;
                }

                if (count == 3) {// once we are done with the counting, we are going create or kill a cell with
                    // the games rule
                    // and we are creating or killing the cell in areaCopy, we are NOT touching the
                    // originating field
                    this.areaCopy[x][y] = true;
                }
            }
        }
    }

	/*
	 * DEBUGGING CODE, ONLY FOR TESTING
	 *
	 * public void show(boolean array[][], int size) { // this function helps us to
	 * print out the field of cells for (int x = 0; x < size; x++) {
	 * System.out.println(); for (int y = 0; y < size; y++) { if (array[x][y] ==
	 * true) { System.out.print("@"); } else { System.out.print("."); } } }
	 * System.out.println(); }
	 */

    public String toString() {
        StringBuffer game = new StringBuffer();
        for (int x = 0; x < this.size; x++) {
            game.append("\n");
            for (int y = 0; y < this.size; y++) {
                if (this.area[x][y] == true) {
                    game.append("@");
                } else {
                    game.append(".");
                }
            }
        }
        return game.toString();
    }

    public void init(){
        this.area = new boolean[size][size];
        this.areaCopy = new boolean[this.size][this.size];
        int prozent = 30;
        int totalProzent = 100; // Got rid of magic Numbers updated
        int amount = (size * size * prozent) / totalProzent; // calculating the 30% of the field
        int count = 0;
        Random random = new Random();

        while (amount > count) { // filling the the boolean array with true by putting it in random position but
            // only 30% of the field is filled up with true, the rest is false
            this.area[random.nextInt(size)][random.nextInt(size)] = true;
            count++; // counting until the certain amount of area is filled
        }
        System.out.print(this); // displays the origin field, this means the class object
    }

    public void restart(){
        init();
    }
}
