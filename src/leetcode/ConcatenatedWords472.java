package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> answer = new ArrayList<>();
        for(String word : words) {
            boolean[] isConcatenated = new boolean[word.length()+1];
            int concatNumber = 0;
            isConcatenated[0] = true;
            for(int i=0; i<word.length(); i++) {
                if(isConcatenated[i]) {
                    String temp = word.substring(i);
                    for(String concat: words) {
                        if(temp.startsWith(concat)) {
                            isConcatenated[i+concat.length()] = true;
                        }
                    }
                    concatNumber++;
                }
            }
            if(concatNumber > 1 && isConcatenated[word.length()]) {
                answer.add(word);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        new ConcatenatedWords472().findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"});
    }
}
