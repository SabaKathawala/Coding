package leetcode;

import java.util.Stack;

public class BasicCalculatorII227 {
    public int calculate(String s) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int i = 0;
        s = s+"+0";
        while(i<s.length()) {
            if(s.charAt(i) == ' ') {
                i++;
                continue;
            }
            if(isDigit(s.charAt(i))) {
                int k=i;
                while(k+1<s.length() && isDigit(s.charAt(k+1))) {
                    k++;
                }
                operands.push(Integer.parseInt(s.substring(i,k+1)));
                i=k;
            } else {
                while (!operators.isEmpty() && isDivideOrMultiply(operators.peek())) {
                    operands.push(operation(operators.pop(), operands.pop(), operands.pop()));
                }
                operators.push(s.charAt(i));
            }
            i++;
        }

        while(!operators.isEmpty()) {
            operands.push(operation(operators.pop(), operands.pop(), operands.pop()));
        }
        return operands.pop();
    }

    private static int operation(char op, int o2, int o1) {
        switch(op) {
            case '+':
                return o1 + o2;
            case '-':
                return o1 - o2;
            case '*':
                return o1 * o2;
            case '/':
                return o1 / o2;
        }
        return -1;
    }

    private static boolean isDivideOrMultiply(char op) {
        return (op == '*' || op == '/');
    }

    private static boolean isDigit(char c) {
        return c >='0' && c <='9';
    }

    public static void main(String[] args) {
        System.out.println(1-1+1);
        new BasicCalculatorII227().calculate("1-1+1");
    }
}
