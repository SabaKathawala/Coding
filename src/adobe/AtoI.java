package adobe;

//ASCII to INT
/*
Requirements for atoi:

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.

Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number,
which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number,
or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.
If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

 */
public class AtoI {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int atoi(final String A) {
        char[] array = A.toCharArray();

        if(A.isEmpty()) {
            return 0;
        }
        //remove  trailing and leading whitespaces
        int start = 0;
        while(start < array.length && array[start] == ' ') {
            start++;
        }
        start = start == 0 ? 0 : start-1;
        int end = array.length-1;
        while(end >= 0 && array[end] == ' ') {
            end--;
        }
        end = end == array.length-1 ? end : end+1;

        // check if string starts with allowed characters +, -, digit
        long answer = 0;
        long ten = 10;
        int sign = 1;
        if(array[start] == '-' || array[start] == '+') {
            sign = sign(array[start]);
            start++;
        }
        else if(isDigit(array[start])) {
            answer += array[start] - '0';
            start++;
        }
        else {
            return 0;
        }


        for(int i = start; i <= end; i++) {
            if(!isDigit(array[i])) {
                break;
            }
            answer *= ten;
            answer += array[i] - '0';
            if(answer*sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if(answer*sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int)answer*sign;
    }

    private static int sign(char c) {
        return c == '-' ? -1: 1;
    }

    private static boolean isDigit(char c) {
        return c>='0' && c<='9';
    }
}
