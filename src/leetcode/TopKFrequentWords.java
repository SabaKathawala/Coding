package leetcode;

import java.util.List;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Trie trie = new Trie();
        for(String word: words) {
            if(trie.search(word)) {
            }
            trie.insert(word);
        }


    }
}
// on Trie
class Trie {

    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;

    // trie node
    class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;
        int frequency;
        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
            frequency = 0;
        }
    };

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    // If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node
    void insert(String key) {
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }

        // mark last node as leaf
        pCrawl.isEndOfWord = true;
        pCrawl.frequency++;
    }

    // Returns true if key presents in trie, else false
    boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';

            if (pCrawl.children[index] == null)
                return false;

            pCrawl = pCrawl.children[index];
        }

        return (pCrawl != null && pCrawl.isEndOfWord);
    }
}
