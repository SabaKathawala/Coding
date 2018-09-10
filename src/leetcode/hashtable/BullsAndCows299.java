package leetcode.hashtable;

import java.util.*;

public class BullsAndCows299 {
    public static long substringCalculator(String s) {
        // Write your code here
        Set<String> uniqueSubStrings = new HashSet<>();
        findUniqueSubStrings(s, 0, s.length(), uniqueSubStrings);
        return uniqueSubStrings.size();
    }

    public static void findUniqueSubStrings(String s, int start, int end, Set<String> uniqueSubStrings) {
        if(start == end || uniqueSubStrings.contains(s.substring(start, end))) {
            return;
        }
        uniqueSubStrings.add(s.substring(start, end));
        findUniqueSubStrings(s, start+1, end, uniqueSubStrings);
        findUniqueSubStrings(s, start, end-1, uniqueSubStrings);
    }

    public String getHint(String secret, String guess) {
        //create hashtable mapping digit to its position for "secret"

        List<List<Integer>> secretMap = new ArrayList<List<Integer>>();
        for (int i=0; i<10; i++) {
            secretMap.add(new ArrayList<Integer>());
        }

        for(int i=0; i<secret.length(); i++) {
            char c = secret.charAt(i);
            secretMap.get(c-'0').add(i);
        }

        List<List<Integer>> guessMap = new ArrayList<List<Integer>>();
        for (int i=0; i<10; i++) {
            guessMap.add(new ArrayList<Integer>());
        }

        for(int i=0; i<guess.length(); i++) {
            char c = guess.charAt(i);
            guessMap.get(c-'0').add(i);
        }

        int bulls = 0;
        int cows = 0;
        for(int i=0; i<10; i++) {
            List<Integer> secretIndices = secretMap.get(i);
            if(secretIndices.size() != 0) {
                List<Integer> guessIndices = guessMap.get(i);
                int temp=0;
                for (Integer index : guessIndices) {
                    if (secretIndices.contains(index)) {
                        temp++;
                    }
                }
                cows += Math.min(guessIndices.size(), secretIndices.size()) - temp;
                bulls += temp;
            }
        }

        // create hint
        return bulls + "A" + cows + "B";
    }

    public String getHintFast(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] c = new int[10];
        char[] cs = secret.toCharArray();
        char[] cg = guess.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            int s = cs[i]-'0';
            int g = cg[i]-'0';
            if(s==g) {
                bulls++;
            } else {
                if (c[s]++<0) {
                    cows++;
                }
                if (c[g]-->0) {
                    cows++;
                }
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        System.out.println(
                substringCalculator("ghaqjdrmnegmrlrlfpjmnnngpwalzknsencuzwsnhfltwohdgbmvfuwtquosrnyerucntxxkfqehjqygcarxogvcfkljzbzutxphpyykapncjfclnhndzxghelyvzpylazhuutmcquusexzbhsfsmbnlvnlemzvfqbfzwquairhpylnbvyhiyamztlhfchhbwrqddmuzsprfdwuqqchcpeakkexackwwzihkfenwzwckynymgqydvjtovaoezkjjurylqcuonsujycziobnfnmuwnoxcdtahpituykvgpyyshvukrstcbmnsqtjseflwywnslmvnqrtnzkyaddkjamrezprqgoenzsdryygbkeahfiduozpwkrgmatszaxmwodsqiocvagbvxyqotpaujnqvqgjmfxnxhfbwqjpgodlxdrxpjpmzeabpgqrzpxomniknjkdiwtfgyvwvekrnoupwkcbtmpcfamzrghgrznuedkybmfwctdghcfawajlxfkzhdamuygjbcwnyglkjlfmpxfdtovkqbshhrfrnyjrgxgiozsuuncnwofkqzsypwgeikpfbhryhpszegdfajzvqlwwqlnvdtdiuckcvvosrdweohnmawqonjbxyjjhlccuteeshfrxxdhzgakwjqbymnaeudcmibsytyajsgdpfvrutcpglzxdevenevmkgalcrpknuvcrnkuboennhyzirfwvtozzijujsckbxqpocakzrbwgpqgjjmsrtwmvhwyraukbuxfvebeylfpipzwjdzlmgslbtwzataxgqpasrssnfwndldwkdutdqcmcpyanrbdsxrvcvpsywjambtbzlcrvzesuhvyvwwuwwdznigxjxknfajpknqutfvvqynkpvkzgypasevrpxofbymdzcitoqolwqegocuyqsexhumzmckzuuwkamolbltlifongpvkcnrnnuplftqbxpdnegdqlymftqyrxcnzmu"));
        //System.out.println(new BullsAndCows299().getHint("1123", "0111"));
    }
}
