package imc;
import java.util.*;
class Test {
    public int solution(int[] A, int[] B, int M, int X, int Y) {
        // write your code in Java SE 8
        int weight = 0;
        int[] floors = new int[M];
        int solution = 0;
        int i =0;
        int capacity = 0;
        while(i < A.length) {
            weight = 0;
            capacity = 0;
            floors = new int[M];
            int start = i;
            while(capacity < X && weight < Y && i < A.length) {
                weight += A[i++];
            }
            if(i != A.length) {
                i--;
            }
            for(int j = start; j<i ;j++) {
                floors[B[j]-1]++;
            }
            for(int j=0;j<M;j++) {
                if(floors[j] > 0) {
                    solution++;
                }
            }
            solution++;
            if(i != A.length) {
                i--;
            }

        }
        int h = -1000000000;
        System.out.println(solution);
        for(int k=1;k<3000000;k++) {
            System.out.print("["+k+"],");
        }
        Set mySet = new HashSet<>(Arrays.asList(A));
        return solution;

    }

    public static void main(String[] args) {
        new Test().solution(new int[]{40, 40, 100, 80, 20}, new int[]{3, 3, 2, 2, 3}, 3, 5, 200);
    }
}