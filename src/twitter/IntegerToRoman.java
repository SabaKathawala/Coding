package twitter;

public class IntegerToRoman {
    final static String[] oneToTen =
            {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    final static String FORTY = "XL";
    final static String FIFTY = "L";
    final static String NINETY = "XC";
    final static String HUNDRED = "C";
    final static String FOUR_HUNDRED = "CD";
    final static String FIVE_HUNDRED = "D";
    final static String NINE_HUNDRED = "CM";
    final static String THOUSAND = "M";

    public String intToRoman(int A) {
        int temp = A;
        int ten = 1;
        StringBuilder string = new StringBuilder();
        while(temp != 0) {
            string.insert(0 ,createRoman((temp%10)*ten));
            ten*=10;
            temp/=10;
        }
        return string.toString();
    }

    private static String createRoman(int A) {
        if (A == 0) {
            return "";
        }
        if(A <= 10) {
            return oneToTen[A-1];
        }

        if(A < 40) {
            int tens = A/10;
            StringBuilder string = new StringBuilder();
            while(tens-- > 0) {
                string.append(oneToTen[9]);
            }
            return string.toString();
        }
        if(A == 40) {
            return FORTY;
        }
        if(A == 50) {
            return FIFTY;
        }

        if(A < 90) {
            StringBuilder string = new StringBuilder();
            string.append(FIFTY);
            int tens = A/10 - 5;
            while(tens-- > 0) {
                string.append(oneToTen[9]);
            }
            return string.toString();
        }

        if(A == 90) {
            return NINETY;
        }
        if(A == 100) {
            return HUNDRED;
        }

        if(A < 400) {
            StringBuilder string = new StringBuilder();
            int hundred = A/100;
            while(hundred-- >0) {
                string.append(HUNDRED);
            }
            return string.toString();
        }

        if(A == 400) {
            return FOUR_HUNDRED;
        }

        if(A == 500) {
            return FIVE_HUNDRED;
        }

        if(A < 900) {
            StringBuilder string = new StringBuilder();
            string.append(FIVE_HUNDRED);
            int hundred = A/100 - 5;
            while(hundred-- >0) {
                string.append(HUNDRED);
            }
            return string.toString();
        }

        if(A == 900) {
            return NINE_HUNDRED;
        }

        if(A == 1000) {
            return THOUSAND;
        }

        StringBuilder string = new StringBuilder();
        int thousand = A/1000 - 5;
        while(thousand-- >0) {
            string.append(THOUSAND);
        }
        return string.toString();
    }


    public static void main(String[] args) {
        IntegerToRoman ir = new IntegerToRoman();
        System.out.println(ir.intToRoman(1));
        System.out.println(ir.intToRoman(200));
        System.out.println(ir.intToRoman(40));
        System.out.println(ir.intToRoman(400));
        System.out.println(ir.intToRoman(500));
        System.out.println(ir.intToRoman(3999));
    }
}
