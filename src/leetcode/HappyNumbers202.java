package leetcode;

public class HappyNumbers202 {
    public boolean isHappy(int n) {

//         Set<Integer> unique_num = new HashSet<Integer>();
//         //to avoid endless squaring
//         while (unique_num.add(n))
//         {
//             int value = 0;
//             //add squares together
//             while (n > 0)
//             {
//                 value += Math.pow(n % 10, 2);
//                 n /= 10;
//             }
//             n = value;
//         }

//         return n == 1;

        while (n != 1 && n != 4) {
            int cur = n;
            n = 0;
            while (cur > 0) {
                int d = cur % 10;
                n += d*d;
                cur /= 10;
            }
        }

        return n == 1;

    }
}