package leetcode;

/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

DeQueue: look into this
 */

import java.util.*;

public class SimplifyPath71 {

    public static String simplifyPath(String path) {
        Stack<String> paths = new Stack<>();
        //paths.push("/");
        String[] splits = path.split("/");

        for (int i = 0; i < splits.length; i++) {
            if (splits[i].isEmpty()) {
                continue;
            } else if (splits[i].equals(".")) {
                paths.clear();
                //paths.push("/");
            } else if (splits[i].equals("..")) {
                if (!paths.isEmpty())
                    paths.pop();
            } else {
                paths.push(splits[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!paths.isEmpty()) {
            sb.insert(0, "/" + paths.pop());
        }
        String ans = sb.toString();
        return ans.isEmpty() ? "/" : ans;
    }

    public static void main(String[] args) {
        String ans = simplifyPath("/home//foo/");
        System.out.println(ans.isEmpty() ? "/" : ans);

        List<String> s = Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"});
//        s.add("a");
//        s.add("aa");
//
//        s.add("aaa");
        System.out.println(new SimplifyPath71().wordBreak("catsanddog", s));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean isSuccess = false;
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                int length = word.length();
                int end = i + length;

                if (end > s.length()) {
                    continue;
                }

                if (s.substring(i, end).equals(word)) {
                    if (end == s.length()) {
                        isSuccess = true;
                    }
                    if (map.containsKey(i)) {
                        map.get(i).add(end);
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(end);
                        map.put(i, list);
                    }
                }
            }
        }
        if (!isSuccess) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = solve(map, s.length());
        List<String> res = new ArrayList<>();

        for (List<Integer> l: result) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<l.size()-1;i++) {
                sb.append(s.substring(l.get(i), l.get(i+1)));

                sb.append(" ");
            }
            res.add(sb.toString().trim());
        }

        return res;

    }

    private List<List<Integer>> solve(Map<Integer, List<Integer>> map, int end) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> r = new ArrayList<>();

        List<Integer> startPoints = map.get(0);
        r.add(0);
        for (int i : startPoints) {
            solve(map, i, result, r, end);
        }
        return result;
    }
//
    private boolean solve(Map<Integer, List<Integer>> map, int start, List<List<Integer>> mainResult, List<Integer> result, int end) {
        if (start == end) {
            result.add(end);
            mainResult.add(new ArrayList(result));
            result.remove(result.size()-1);
            return true;
        } else if (!map.containsKey(start)) {
            return false;
        }

        result.add(start);
        List<Integer> startPoints = map.get(start);

        for (int i : startPoints) {
            solve(map, i, mainResult, result, end);
        }

        result.remove(result.size()-1);
        return true;
    }
}
