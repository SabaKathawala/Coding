package twitter;

import leetcode.FirstAndLast34;

import java.util.ArrayList;
import java.util.List;

public class First {

    // Complete the roverMove function below.
    static int roverMove(int matrixSize, List<String> cmds) {
        int row = 0;
        int col = 0;
        for(String cmd: cmds) {
            switch(cmd) {
                case "UP" :
                    if(row != 0) {
                        row -= 1;
                    }
                    break;
                case "DOWN" :
                    if(row != matrixSize-1) {
                        row += 1;
                    }
                    break;
                case "RIGHT" :
                    if(col != matrixSize-1) {
                        col+=1;
                    }
                    break;
                case "LEFT" :
                    if(col != 0) {
                        col-=1;
                    }
                    break;
            }
        }
        return (row*(matrixSize)) + col;
    }

    static List<Integer> minimalOperations(List<String> words) {
        List<Integer> minOp = new ArrayList<>();
        for(String word: words) {
            minOp.add(calculateMinOp(word));
        }
        return minOp;
    }

    static int calculateMinOp(String word) {
        char[] wordArray = word.toCharArray();
        int minOp = 0;
        int i=0;
        while(i < wordArray.length) {
            int count = 0;

            while(i < wordArray.length && wordArray[i] == wordArray[++i]) {
                count++;
            }
            minOp += count/2;

        }
        return minOp;
    }


    public static void main(String[] args) {

    }
}
