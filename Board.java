package com.gameoflife;

public class Board {

   private boolean[][] grid;
   public static boolean ALIVE = true;
   public static boolean DEAD = false;

   public Board(int length, int breadth) {
       grid = new boolean[length][breadth];
   }

   public void toggleState(int x, int y) {
       grid[x][y] = !grid[x][y];
   }

   public void makeAlive(int x, int y) {
       grid[x][y] = ALIVE;
   }

   public boolean isAlive(int x, int y) {
       return grid[x][y];
   }

   public int scanForAliveNeighbours(int x, int y) {
       return 0;
   }

   public int scanForDeadNeighbours(int x, int y) {
       return 0;
   }

   public void start() throws InterruptedException {
       int aliveNeighoursCount;
       int deadNeighoursCount;
       while (true) {
           for (int i = 0; i < grid.length; i++) {
               for (int j = 0; j < grid.length; j++) {
                   if (grid[i][j] == ALIVE) {
                       aliveNeighoursCount = scanForAliveNeighbours(i, j);
                       if (aliveNeighoursCount > 3 || aliveNeighoursCount < 2)
                           toggleState(i, j);
                   } else {

                   }
               }
           }
           printBoard();
           Thread.sleep(1000);
       }
   }

   public void printBoard() {
       for (boolean[] array : grid) {
           for (boolean cell : array) {
               if (cell)
                   System.out.print(1 + " ");
               else
                   System.out.print(0 + " ");
           }
           System.out.println();
       }
   }


}
