package leetcode;

import java.util.*;

public class WordSearchII {

//    public List<String> findWords(char[][] board, String[] words) {
//        int rows = board.length;
//        int cols = board[0].length;
//        int[][] visited = new int[rows][cols];
//        Set<String> listOfWords = new HashSet<String>();
//        for(int i=0; i<board.length; i++) {
//            for(int j=0; j<cols; j++) {
//                for(String word: words) {
//                    String str = new String();
//                    findWord(visited, board, i, j, word, 0, str, listOfWords);
//                    for (int k = 0; k < board.length; k++) {
//                        for (int l = 0; l < cols; l++) {
//                            visited[k][l] = 0;
//                        }
//                    }
//                }
//            }
//        }
//        List<String> answer = new ArrayList<>();
//        for(String word: listOfWords) {
//            answer.add(word);
//        }
//        return answer;
//    }
//
//    private static void findWord(int[][] visited, char[][] board, int row, int col, String word, int index, String boardWord, Set<String> listOfWords) {
//        if(boardWord.toString().equals(word)) {
//            listOfWords.add(word);
//            return;
//        }
//
//        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length
//                || visited[row][col] == -1 || index >= word.length()) {
//            return;
//        }
//
//        if(word.charAt(index) == board[row][col]) {
//            visited[row][col] = -1;
//            //boardWord.append(word.charAt(index));
//            findWord(visited, board, row, col-1, word, index+1, boardWord + word.charAt(index), listOfWords);
//            findWord(visited, board, row, col+1, word, index+1, boardWord + word.charAt(index), listOfWords);
//            findWord(visited, board, row-1, col, word, index+1, boardWord + word.charAt(index), listOfWords);
//            findWord(visited, board, row+1, col, word, index+1, boardWord + word.charAt(index), listOfWords);
//            visited[row][col] = 0;
//        }
//    }

    static class Trie {
        Trie[] children = new Trie[26];
        boolean endOfWord;
        String word;
        public static Trie buildTrie (String[] words) {
            Trie root = new Trie();
            for(String word: words) {
                Trie node = root;
                for(int i=0; i< word.length(); i++) {
                    if(node.children[word.charAt(i) - 'a'] == null) {
                        node.children[word.charAt(i) - 'a'] = new Trie();
                    }
                    node = node.children[word.charAt(i) - 'a'];
                }
                node.endOfWord = true;
                node.word = word;
            }
            return root;
        }

    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie dictionaryTrie = Trie.buildTrie(words);
        boolean[][] visited = new boolean[board.length][board[0].length];
        List<String> wordSearch = new ArrayList<>();
        for(int i=0; i < board.length; i++) {
            for(int j=0; j < board[i].length; j++) {
                searchWord(board, visited, dictionaryTrie, wordSearch, i, j);
            }
        }

        return wordSearch;
    }

    private static void searchWord(char[][] board, boolean[][] visited, Trie root, List<String> wordSearch, int i,
                                   int j) {
        if(visited[i][j]) {
            return;
        }
        if(root == null || root.children[board[i][j] - 'a'] == null) {
            return;
        }
        if(root.children[board[i][j] - 'a'].endOfWord) {
            wordSearch.add(root.children[board[i][j] - 'a'].word);
            root.children[board[i][j] - 'a'].endOfWord = false;
        }
        visited[i][j] = true;
        if(i-1 > 0) {
            searchWord(board, visited, root, wordSearch, i-1, j);
        }
        if(j+1 < board[0].length) {
            searchWord(board, visited, root, wordSearch, i, j+1);
        }
        if(i+1 < board.length) {
            searchWord(board, visited, root, wordSearch, i+1, j);
        }
        if(j-1 > 0) {
            searchWord(board, visited, root, wordSearch, i, j-1);
        }
        visited[i][j] = false;
    }


    public String decodeString(String s) {
        Stack<Integer> stackOfk = new Stack<>();
        Stack<StringBuilder> stackOfString = new Stack<>();
        int i=0;
        StringBuilder answer = new StringBuilder();
        StringBuilder encodedString;
        while(i<s.length()) {
            switch(s.charAt(i)) {
                case '[' :
                    encodedString = new StringBuilder();
                    while(s.charAt(i+1) != ']' && !isDigit(s.charAt(i+1))) {
                        encodedString.append(s.charAt(i+1));
                        i++;
                    }
                    stackOfString.push(encodedString);
                    i++;
                    break;
                case ']':
                    int k = stackOfk.pop();
                    encodedString = stackOfString.pop();
                    StringBuilder decode = new StringBuilder();
                    while(k-- > 0) {
                        decode.append(encodedString);
                    }
                    if(!stackOfString.isEmpty()) {
                        stackOfString.push(stackOfString.pop().append(decode));
                    }
                    else {
                        answer.append(decode);
                    }
                    i++;
                    break;
                default:
                    if(isDigit(s.charAt(i))) {
                        StringBuilder digit = new StringBuilder();
                        while(isDigit(s.charAt(i))) {
                            digit.append(s.charAt(i++));
                        }
                        stackOfk.push(Integer.parseInt(digit.toString()));
                    }
                    else {
                        encodedString = new StringBuilder();
                        while(i < s.length() && s.charAt(i) != '[' && s.charAt(i) != ']' && !isDigit(s.charAt(i))) {
                            encodedString.append(s.charAt(i++));
                        }
                        if(!stackOfString.isEmpty()) {
                            stackOfString.push(stackOfString.pop().append(encodedString));
                        }
                        else {
                            answer.append(encodedString);
                        }
                    }
            }
        }
        return answer.toString();

    }

    private static boolean isDigit(char c) {
        return c>='0' && c<='9';
    }

    public static void main(String[] args) {
//        new WordSearchII().findWords(new char[][]{{'b', 'b', 'a', 'a', 'b', 'a'},
//                                                {'b', 'b', 'a', 'b', 'a', 'a'},
//                                                {'b', 'b', 'b', 'b', 'b', 'b'},
//                                                {'a', 'a', 'a', 'b', 'a', 'a'},
//                                                {'a', 'b', 'a', 'a', 'b', 'b'}}, new String[]{"abbbababaa"});
        //new WordSearchII().decodeString("3[a]2[b4[F]c]");
        new WordSearchII().removeInvalidParentheses("()())()");
    }
    public List<String> removeInvalidParentheses(String s) {
        Queue<Character> right = new LinkedList<>();
        Stack<Character> left = new Stack<>();
        char[] array = s.toCharArray();
        List<List<String>> levels = new ArrayList<List<String>>();
        for(int i=0; i< s.length(); i++) {
            if(s.charAt(i) == '(') {
                left.push('(');
            } else if(s.charAt(i) == ')'){
                if(!left.isEmpty()) {
                    left.pop();
                } else {
                    List<String> level = new ArrayList<>();
                    level.add(s.substring(0, i));
                    StringBuilder reverse = new StringBuilder(s.substring(0, i+1));
                    reverse.reverse();
                    level.add(reverse(reverse.toString()));
                    levels.add(level);
                }
            }
        }
        return new ArrayList<>();
    }

    public String reverse(String s) {
        Queue<Character> right = new LinkedList<>();
        char[] reverseString = new char[s.length()];
        int queue = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                right.add(')');
            } else if (s.charAt(i) == '(') {
                if (!right.isEmpty()) {
                    reverseString[queue] = right.remove();
                    reverseString[i] = '(';
                }
            } else {
                reverseString[i] = s.charAt(i);
            }
        }
        return new String(reverseString);
    }
}


/*
[["b","b","a","a","b","a"],["b","b","a","b","a","a"],["b","b","b","b","b","b"],["a","a","a","b","a","a"],["a","b","a","a","b","b"]]
["abbbababaa"]
 */
