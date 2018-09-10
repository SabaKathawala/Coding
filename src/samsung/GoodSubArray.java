package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class GoodSubArray {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int T = Integer.parseInt(br.readLine());
            for(int i=0; i<T;i++) {
                int size = Integer.parseInt(br.readLine());
                Stack<Integer> smallest = new Stack<>();
                int[] array = new int[size];
                String[] input = br.readLine().split(" ");
                for(int j=0; j<size; j++) {
                    array[j] = Integer.parseInt(input[j]);
                }
                int min = Integer.MAX_VALUE;
                for(int j=size-1; j>=0; j--) {
                    if(min > array[j]) {
                        smallest.push(j);
                        min = array[j];
                    }
                }
                int length = 1;
                for(int j=0; j<size && !smallest.isEmpty(); j++) {
                    for(int k= j; k<size; k++) {
                        if(k < smallest.peek() && array[k] >= array[smallest.peek()]) {
                            continue;
                        }
                        length = Math.max(length, smallest.peek()-j+1);
                        break;
                    }
                    if(j == smallest.peek()) {
                        smallest.pop();
                    }
                }
                System.out.println(length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*2

9
4 4 6 3 4 7 3 5 5
*/

