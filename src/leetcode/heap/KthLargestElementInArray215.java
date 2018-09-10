package leetcode.heap;

import  data_structures.MaxHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthLargestElementInArray215 {

    public static int findKthLargest(int[] nums, int k) {
        MaxHeap heap = new MaxHeap(nums.length);
        for(int i=0; i<nums.length; i++) {
            heap.insertKey(nums[i]);
        }

        while(--k!= 0) {
            heap.extractMax();
        }

        return heap.extractMax();

    }
    static List<String> sentences = new ArrayList<>();
    public static List<String> wordBreak(String s, List<String> wordDict) {
        addSentences(s, wordDict, new StringBuilder(), "");
        return sentences;
    }

    public static void addSentences(String s, List<String> wordDict,StringBuilder sentence, String add) {
        sentence.append(add + " ");
        if(s.isEmpty()) {
            sentences.add(sentence.toString());
            return;
        }

        for(String word: wordDict) {
            if(s.startsWith(word)) {
                addSentences(s.substring(word.length()), wordDict, sentence, word);
                sentence.delete(sentence.lastIndexOf(word), sentence.length());
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(wordBreak("catsanddog", Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"})));
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 6));
    }
}


