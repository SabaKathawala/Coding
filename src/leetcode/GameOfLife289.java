package leetcode;

public class GameOfLife289 {
    public void gameOfLife(int[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 1) {
                    findNextStateForLiveCell(board,i,j);
                } else {
                    findNextStateForDeadCell(board,i,j);
                }
            }
        }
    }

    private static void findNextStateForLiveCell(int[][] board, int row, int col) {
        int liveNeighbours = 0;

        if(row-1 >= 0 && col-1 >= 0 && board[row-1][col-1] == 1) {
            liveNeighbours++;
        }
        if(row-1 >= 0 && board[row-1][col] == 1) {
            liveNeighbours++;
        }
        if(row-1 >= 0 && col+1 < board[0].length && board[row-1][col+1] == 1) {
            liveNeighbours++;
        }
        if(col-1 >= 0 && board[row][col-1] == 1) {
            liveNeighbours++;
        }
        //Any live cell with more than three live neighbors dies, as if by over-population..
        if(liveNeighbours == 4) {
            board[row][col] = 0;
            return;
        }
        if(col+1 < board[0].length && board[row][col+1] == 1) {
            liveNeighbours++;
        }
        if(row+1 < board.length && col-1 >= 0 && board[row+1][col-1] == 1) {
            liveNeighbours++;
        }
        if(row+1 < board.length && board[row+1][col] == 1) {
            liveNeighbours++;
        }
        if(row+1 < board.length && col+1 < board[0].length && board[row+1][col+1] == 1) {
            liveNeighbours++;
        }

        if(liveNeighbours > 3 || liveNeighbours < 2) {
            board[row][col] = 0;
        }
    }

    private static void findNextStateForDeadCell(int[][] board, int row, int col) {
        int liveNeighbours = 0;

        if(row-1 >= 0 && col-1 >= 0 && board[row-1][col-1] == 1) {
            liveNeighbours++;
        }
        if(row-1 >= 0 && board[row-1][col] == 1) {
            liveNeighbours++;
        }
        if(row-1 >= 0 && col+1 < board[0].length && board[row-1][col+1] == 1) {
            liveNeighbours++;
        }
        if(col-1 >= 0 && board[row][col-1] == 1) {
            liveNeighbours++;
        }
        if(col+1 < board[0].length && board[row][col+1] == 1) {
            liveNeighbours++;
        }
        if(row+1 < board.length && col-1 >= 0 && board[row+1][col-1] == 1) {
            liveNeighbours++;
        }
        if(row+1 < board.length && board[row+1][col] == 1) {
            liveNeighbours++;
        }
        if(row+1 < board.length && col+1 < board[0].length && board[row+1][col+1] == 1) {
            liveNeighbours++;
        }
        if(liveNeighbours == 3) {
            board[row][col] = 1;
        }

    }

    public static void main(String[] args) {
        new GameOfLife289().gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }
}
