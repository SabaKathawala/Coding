package google_code_jam;

import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution1 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = in.nextInt();

        for (int i = 0; i< N; i++) {
            int L = in.nextInt();
            long sum = 0;

            int j =0;
            if(L%2 == 0) {
                int k = 0;
                while (k <= L / 2 - 1) {
                    sum += Math.pow(in.nextInt() - k, 2);
                    k++;
                }
                k--;
                while (k >= 0) {
                    sum += Math.pow(in.nextInt() - k, 2);
                    k--;
                }
            }
            else {
                int k = 0;
                while (k <= ((L-1)/2)-1) {
                    sum += Math.pow(in.nextInt() - k, 2);
                    k++;
                }
                sum += Math.pow(in.nextInt() - k, 2);
                k--;
                while (k >= 0) {
                    sum += Math.pow(in.nextInt() - k, 2);
                    k--;
                }
            }
            System.out.println("Case #" + (i+1) + ": " +sum);
        }
    }
}
