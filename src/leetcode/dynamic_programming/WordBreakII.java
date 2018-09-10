package leetcode.dynamic_programming;

import java.util.*;

public class WordBreakII {
    public static List<String> wordBreak(String s, List<String> wordDict) {
            boolean[] canSegment = new boolean[s.length()+1];
            Map<Integer, List<String>> indexToString = new HashMap<>();
            canSegment[0] = true;
            for(int i=0; i<s.length(); i++) {
                if(canSegment[i]) {
                    String temp = s.substring(i);
                    for(String word: wordDict) {
                        if(temp.startsWith(word)) {
                            canSegment[i+word.length()] = true;
                            if(indexToString.containsKey(i)) {
                                indexToString.get(i).add(word);
                            } else {
                                List<String> list = new ArrayList<>();
                                list.add(word);
                                indexToString.put(i, list);
                            }
                        }
                    }
                }
            }

            if(canSegment[s.length()]){
                List<String> initialWord = indexToString.get(0);
                List<String> answer = new ArrayList<>();
                for(String word: initialWord) {
                    addSentence(indexToString, word.length(), s, word, answer);
                }
                return answer;
            }

            return new ArrayList<>();
        }

        private static void addSentence(Map<Integer, List<String>> indexToString, int key,
                                           String s, String word, List<String> answer) {
            if (key == s.length()) {
                answer.add(word);
                return;
            }
            if (!indexToString.containsKey(key)) {
                return;
            }
            List<String> initialWord = indexToString.get(key);
            for (String cWord : initialWord) {
                String nWord = word + " " + cWord;
                int length = key+cWord.length();
                addSentence(indexToString, length, s, nWord, answer);
            }

        }

    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddog", Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"})));
    }
}
