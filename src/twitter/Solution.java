package twitter;

import java.util.Scanner;

public class Solution {
    static void maximumCupcakes(String[] trips) {

        int T = trips.length;
        for (int i =0;i < T;i++) {
            String[] split = trips[i].split(" ");
            int n = Integer.parseInt(split[0]);
            int c = Integer.parseInt(split[1]);
            int m = Integer.parseInt(split[2]);
            solve(n, c, m);
            //System.out.println(solve(n,c,m));
        }
    }


    public static void solve(int n, int c, int m) {
        //
        int noOfCupCakesBought = n/c;
        int noOfExtraCakes = noOfCupCakesBought/m;
        int remaining = (noOfCupCakesBought%m + noOfExtraCakes)/m;
        //return noOfCupCakesBought + solve(noOfCupCakesBought%m + noOfExtraCakes, c, m);

        System.out.println(noOfCupCakesBought+noOfExtraCakes+remaining);
    }

    public static void main(String args[]) {
        maximumCupcakes(new String[]{"10 2 5", "12 4 4", "6 2 2"});
        firstOccurrence("juliasamanthasamanthajulia", "ant*as");
    }

    static int firstOccurrence(String s, String x) {
        String[] split = x.split("*");
        int index = s.indexOf(split[0]);
        while(index >= 0) {
            int secondHalf = s.indexOf(split[1], index+1);
            if(secondHalf - index + split[0].length() == 1) {
                return index;
            }
            index = s.indexOf(split[0], index+1);
        }
        return -1;
    }
}
