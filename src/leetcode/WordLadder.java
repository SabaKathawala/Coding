package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WordLadder {

    public static void main (String... args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        new WordLadder().ladderLength("hit", "cog", wordList);
    }

    int min = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 0;
        boolean[] visited = new boolean[wordList.size()];
        ladderLength(beginWord, endWord, wordList, 0, visited, 0);
        return min;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList, int index, boolean[] visited, int count) {
        count++;
        if(endWord.equals(beginWord)) {
            return count;
        }

        int i = 0;
        while(i < wordList.size()) {
            if(visited[i]) {
                i++;
                continue;
            }
            if(diffBy1(beginWord, wordList.get(i))) {
                visited[i] = true;
                int length = ladderLength(wordList.get(i), endWord, wordList, i, visited, count);
                if(length != 0) {
                    min = Math.min(length, min);
                }
                visited[i] = false;
            }

            i++;
        }
        return 0;
    }

    private static boolean diffBy1(String word1, String word2) {
        char[] first = word1.toCharArray();
        char[] second = word2.toCharArray();
        int count = 0;
        for(int i=0; i<first.length; i++) {
            if(first[i] != second[i] && ++count > 1) {
                return false;
            }
        }
        return true;
    }


}
