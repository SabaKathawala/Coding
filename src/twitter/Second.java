package twitter;

import java.util.*;

public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<String, String> coding = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] split = s.split("\\t");
            coding.put(split[1], split[0].equals("[newline]") ? "\n" : split[0]);
        }
        String encodedString = sc.nextLine();

        String decodedString = decode(coding, encodedString);
        System.out.println(decodedString);
    }

    private static String decode(Map<String, String> coding, String encodedString) {
        StringBuilder temp = new StringBuilder("");
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < encodedString.length(); i++) {
            temp.append(encodedString.charAt(i));
            if (coding.containsKey(temp.toString())) {
                result.append(coding.get(temp.toString()));
                temp = new StringBuilder("");
            }
        }

        return result.toString();
    }
}



