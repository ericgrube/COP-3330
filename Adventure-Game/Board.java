/*Eric Grube
 * COP 3330 Section 001
 * Adventure Game Program
 * Board Class
 * 11/7/13
 */

public class Board extends Object {

        private Cave[][] board;
        private int row;
        private int column;

        //create a random game board
        public Board(int rows, int cols) {

                row = rows;
                column = cols;
                board = new Cave[rows][cols];

                for (int i = 0; i < rows; i++) {

                        for (int j = 0; j < cols; j++) {

                                if ((rows == 0 && cols == 0)
                                                || (i == (rows - 1) && j == (cols - 1))) {
                                        board[i][j] = new Cave(i, j);
                                        board[i][j].makeOpen();
                                        continue;

                                }

                                //makes the board
                                board[i][j] = new Cave(i, j);

                                //Generate a random number between 0 and 100
                                double baseRandom = Math.random(); 
                                double scaledRandom = 100 * baseRandom; 
                                                                                                                
                                int number = (int) scaledRandom; 

                                //Use this number on each tile in the array to see wheter it should be a trap or pit
                                if ((number <= 100) && (number > 90)) {
                                        (board[i][j]).makeOpen();
                                }

                                else if ((number <= 90) && (number > 80)) {
                                        (board[i][j]).makeTeleport();
                                }

                                else if ((number <= 80) && (number > 40)) {
                                        (board[i][j]).makePit();
                                }

                                else {
                                        (board[i][j]).makeBlocked();
                                }

                        }

                }

        }

        //Find the location at the location (row, column)
        public Cave getCave(int row, int column) {
                if (this.ok(row, column)) {
                        return this.board[row][column];
                }
                return null;
        }
        
        //See if the location is inside the bounds of the board or not
        public boolean ok(int row, int column) {
                if ((row < this.row) && (column < this.column) && (row >= 0) && (column >= 0)) {
                        return true;
                }

                else {
                        return false;
                }
        }

        
        //Get a random and open location from the current board.
        public Cave getUnoccupiedOpenLocation() {

                while (true) {
                        //Generate a number between 0 and 100
                        double baseRowRandom = Math.random(); 
                        double scaledRowRandom = (this.row - 1) * baseRowRandom; 
                                                                                                                                                
                        int numberRow = (int) scaledRowRandom; 

                        //Generate a number between 0 and 100
                        double baseColRandom = Math.random(); 
                        double scaledColRandom = (this.column - 1) * baseColRandom; 
                                                                                                                                                
                        int numberCol = (int) scaledColRandom;

                        if (!(this.board[numberRow][numberCol].isOccupied())
                                        && (this.board[numberRow][numberCol].isOpen())) {

                                return this.board[numberRow][numberCol];

                        }

                }

        }

}
