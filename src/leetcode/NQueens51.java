package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NQueens51 {

    int n = 0;
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> nQueens = new ArrayList<List<String>>();
        char[][] board = new char[n][n];
        int[] rows = new int[n];
        this.n = n;
        solveNQueens(board, 0, nQueens, rows);
        return nQueens;
    }

    private char[][] getCopy(char[][] board) {
        char[][] copy = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }

    private void solveNQueens(char[][] board, int row, List<List<String>> nQueens, int[] rows) {
        if(row == n-1) {
            for(int j=0; j<n; j++) {
                if(board[row][j] == '\u0000') {
                    board[row][j] = 'Q';
                    int sum = 0;
                    for(int i=0; i<n; i++) {
                        sum+=rows[i];
                    }
                    if(sum == n-1) {
                        List<String> string = new ArrayList<>();
                        for(int i=0; i<n; i++) {
                            StringBuilder sb = new StringBuilder();
                            for(int k=0; k<n; k++) {
                                sb.append(board[i][k]);
                            }
                            string.add(sb.toString());
                        }
                        nQueens.add(string);
                    }
                    board[row][j] = '.';
                }

            }
            return;
        }
        for(int j=0; j<n; j++) {
            if(board[row][j] == '\u0000') {
                solveNQueens(attack(getCopy(board), row, j, n, rows), row+1, nQueens, rows);
                board[row][j] = '.';
                rows[row] = 0;
            }
        }
    }

    private char[][] attack(char[][] board, int row, int col, int n, int[] rows) {
        for (int j = 0; j < n; j++) {
            board[row][j] = '.';
        }
        for (int i = 0; i < n; i++) {
            board[i][col] = '.';
        }

        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            board[i][j] = '.';
            i--;
            j--;
        }
        i = row + 1;
        j = col + 1;
        while (i < n && j < n) {
            board[i][j] = '.';
            i++;
            j++;
        }
        i = row + 1;
        j = col - 1;
        while (i < n && j >= 0) {
            board[i][j] = '.';
            i++;
            j--;
        }
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < n) {
            board[i][j] = '.';
            i--;
            j++;
        }

        board[row][col] = 'Q';
        rows[row] = 1;
        return board;
    }

    public static void main(String[] args) {
        new NQueens51().solveNQueens(5);
    }

    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        int level = 1;
        int minDepth = Integer.MAX_VALUE;
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if(curr.right != null) {
                stack.push(curr.right);
            }
            while(curr.left != null) {
                stack.push(curr.left);
                curr = curr.left;
                level++;
            }
            if(curr.right == null) {
                minDepth = Math.min(level, minDepth);
                stack.pop();
                level--;
            }
            else {
                stack.push(curr.right);
                level++;
            }
        }
        return minDepth;
    }
}