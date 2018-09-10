package leetcode;

import java.util.Stack;

public class BasicCalculatorIII224 {
    public int calculate(String s) {
        Stack<Integer> sum = new Stack<>();
        Stack<Integer> sign = new Stack<>();
        int currSum = 0;
        int currSign = 1;
        int num = 0;
        int i = 0;
        s = "(" + s + ")";
        while(i < s.length()) {
            char c = s.charAt(i);
            if(c == '(') {
                sum.push(currSum);
                currSum = 0;
                sign.push(currSign);
                currSign = 1;
            } else if(c == ')') {
                int tempSum = (currSum + currSign*num) * sign.pop();
                currSum = sum.pop() + tempSum;
                num = 0;
            } else if(Character.isDigit(c)) {
                num = num*10 + (c - '0');
            } else if(c == '+' || c == '-') {
                currSum += currSign*num;
                num = 0;
                currSign = c == '+' ? 1 : -1;
            }
            i++;
        }
        return currSum;
    }

    public static void main(String[] args) {
        new BasicCalculatorIII224().calculate("2 + 2");
    }
}
