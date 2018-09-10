package twitter;

public class BinaryGap868 {
    public int binaryGap(int N) {
        int i = 0;
        int and = 1;
        int pos = -1;
        int length = 0;
        while(i <= 31) {
            if((N & and) == and) {
                if(pos != -1) {
                    length = Math.max(i-pos, length);
                    pos = i;
                } else {
                    pos = i;
                }
            }
            and <<= 1;
            i++;
        }
        return length;
    }

    public static void main(String[] args) {
        new BinaryGap868().binaryGap(22);
    }
}
