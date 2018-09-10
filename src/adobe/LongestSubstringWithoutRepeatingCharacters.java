package adobe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    // brute force
    //check for all substrings
    // Time Complexity: O(n3)
    public int lengthOfLongestSubstringBruteForce(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    /*
        A sliding window is an abstract concept commonly used in array/string problems.
        A window is a range of elements in the array/string which usually defined by the start and end indices,
        i.e. [i, j)[i,j) (left-closed, right-open).
        A sliding window is a window "slides" its two boundaries to the certain direction.
        For example, if we slide [i, j)to the right by 11 element, then it becomes [i+1, j+1) (left-closed, right-open).
        We use HashSet to store the characters in current window [i, j) (j = i initially).
        Then we slide the index j to the right. If it is not in the HashSet, we slide j further. Doing so until s[j] is already in the HashSet.
        At this point, we found the maximum size of substrings without duplicate characters start with index i.
        If we do this for all i, we get our answer
     */
    //Time complexity: O(2n)
    public int lengthOfLongestSubstringSlidingWindow(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                // else will be executed until the repeated character has not been removed
                // from the start of the current window
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /*
        Map skips the execution of else till the repeated character is found.
        The mapping of character to index helps us to skip the entire window
     */
    //time complexity: O(n)
    public int lengthOfLongestSubstringSlidingWindowOptimized(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /*
        Since we know that the charset is only ASCII, we can simply use an integer array in place of a Map
     */
    //time complexity: O(n)
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[256]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
