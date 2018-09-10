package adobe;

import java.util.Stack;

public class ValidOperations {
    public static int evaluate(String exp)
    {
        String[] tokens = exp.split("\\s+");
        Stack<String> ops = new Stack<>();
        Stack<Integer> values = new Stack<>();

        for (String token : tokens) {
            if (isInteger(token)) {
                values.push(Integer.parseInt(token));
            } else {
                while (!ops.empty() && hasPrecedence(token, ops.peek()))
                    values.push(doOperation(ops.pop(), values.pop(), values.pop()));

                ops.push(token);
            }
        }
        while (!ops.empty())
            values.push(doOperation(ops.pop(), values.pop(), values.pop()));

        return values.pop();
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    public static boolean hasPrecedence(String op1, String op2)
    {
        return !(("*".equals(op1) || "/".equals(op1)) && ("+".equals(op2) || "-".equals(op2)));
    }

    public static int doOperation(String op, int b, int a)
    {
        switch (op)
        {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }

        return 0;
    }

    public static void main(String... args) {
        System.out.println(evaluate("12 / 2 / 3 * 6"));
        System.out.println(evaluate("1 * 2 - 3 / 4 + 5 * 6 - 7 * 8 + 9 / 10"));
    }
}
