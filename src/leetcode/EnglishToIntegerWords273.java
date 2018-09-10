package leetcode;

import java.util.List;
import java.util.Stack;

public class EnglishToIntegerWords273 {
    static String[] unitsRep = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static String[] onesRep = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    static String[] tensRep = {"one", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    String[] numberWords = new String[]{};
    public String numberToWords(int num) {
        if(num <= 9) {
            return unitsRep[num];
        }

        Stack<String> english = new Stack<>();
//        if(num % 10 == 0) {
//            int position = 0;
//            while(num%10 == 0) {
//                position++;
//                num %= 10;
//                num /= 10;
//            }
//            if(num == 0) {
//                addMileStone(english, position);
//                if (isPosition741(position)) {
//                    english.push(onesRep[1]);
//                } else {
//                    addEnglishRep(english, position, 1);
//                }
//                return createEnglish(english);
//            }
//        }
        int temp = 0;
        int position = 0;
        int prev;
        while(num != 0) {
            prev = temp;
            temp = num % 10;
            if(temp != 0 )
                addMileStone(english, position);
            if(temp == 1 && isPosition741(position)) {
                if(!english.isEmpty()) {
                    english.pop();
                }
                english.push(onesRep[prev]);
            } else {
                addEnglishRep(english, position, temp);
            }
            num /= 10;
            position++;
        }
        return createEnglish(english);
    }

    private static String createEnglish(Stack english) {
        StringBuilder sb = new StringBuilder();
        while(!english.isEmpty()) {
            sb.append(english.pop()).append(" ");
        }
        return sb.toString().trim();
    }

    private static boolean isPosition741(int position) {
        return position == 7 || position == 4 || position == 1;
    }

    private static void addEnglishRep(Stack<String> english, int position, int number) {
        if(number == 0) {
            return;
        }
        switch(position) {
            case 9 :
            case 8 :
            case 6 :
            case 5 :
            case 3 :
            case 2 :
            case 0 :
                english.push(unitsRep[number]);
                break;
            case 1:
            case 7:
            case 4:
                english.push(tensRep[number-1]);
        }
    }

    private static void addMileStone(Stack<String> english, int position) {
        if(position == 2 || position == 5 || position == 8) {
            english.push("Hundred");
        } else if(position == 3) {
            english.push("Thousand");
        } else if(position == 6) {
            english.push("Million");
        } else if(position == 9) {
            english.push("Billion");
        }
    }

    public static void main(String[] args) {
        new EnglishToIntegerWords273().numberToWords(10000000);
    }
}
