package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
     public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        combination(list, 1, 0, new StringBuilder("("), n);
        return list;
    }

    private static void combination(List<String> list, int open, int close, StringBuilder comb, int n) {
         if(comb.length() == n*2) {
            list.add(comb.toString());
            return;
        }
        if(open < n) {
            combination(list, open+1, close, new StringBuilder(comb).append('('), n);
        }
        if(open > close) {
            combination(list, open, close + 1, new StringBuilder(comb).append(')'), n);
        }
    }

    public static void main(String[] args) {
        new GenerateParentheses22().generateParenthesis(3);
    }
}
