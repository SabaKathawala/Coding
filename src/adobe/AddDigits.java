package adobe;

/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
For example:
Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 */

public class AddDigits {
    public int addDigitsSaba(int num) {
        if(num < 10) {
            return num;
        }
        //add two digits until its a single digit
        int first = num % 10, second;
        num /= 10;
        while(num != 0) {
            second = num%10;
            first = addTillOneDigit(first, second);
            num /= 10;
        }
        return first;

    }

    private int addTillOneDigit(int first, int second) {
        int sum = first + second;
        if(sum > 9) {
            return addTillOneDigit(sum/10, sum%10);
        }
        return sum;
    }

    // add the digits in any combination -> you will get the same answer
    public int addDigits(int num) {
        while (num >= 10) {
            num = num/10 + num % 10;
        }
        return num;
    }

    public int addDigitsConstantTime(int num) {
//       if( num == 0 ){
//           return num;
//       }
//       if (num % 9 == 0 )
//           return 9;
//       return num % 9;
        //above ifs written as ternary operator
       return num == 0 ? 0 : num % 9 == 0 ? 9 : num % 9;
    }

}
