package leetcode;

public class HammingDistance461 {
    public static int hammingDistance(int x, int y) {
        int bits = 32;
        int count = 0;
        while(bits-- > 0) {
            if((x & 1) != (y & 1)) {
                count++;
            }
            x>>=1;
            y>>=1;
        }
        return count;
    }

    /*
        int xor = x ^ y, count = 0;
        for (int i=0;i<32;i++) count += (xor >> i) & 1;
        return count;
     */



    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
    }
}
