package imc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.HashMap;
public class Main {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            String array = line.substring(0, line.length()-2);
            int[] numbersArray = getArray(array);
            int sum = Integer.parseInt(line.substring(line.indexOf(";")));
            Map<Integer, Integer> hashMap = new HashMap<>();

//            for (int i=0; i<n; i++) {
//                if( !hashMap.containsKey(numbersArray[i]) )
//                    hashMap.put(arr[i],0);
//                hashMap.put(arr[i], hm.get(arr[i])+1);
//            }
            int twice_count = 0;

//            for (int i=0; i<n; i++)
//            {
//                if(hashMap.get(sum-numbersArray[i]) != null)
//                    twice_count += hashMap.get(sum-numbersArray[i]);
//
//                if (sum-numbersArray[i] == numbersArray[i])
//                    twice_count--;
//            }

            // return the half of twice_count
            System.out.println(twice_count/2);
        }
    }

    private static int[] getArray(String array) {
        String[] numbers = array.split(",");
        int[] numbersArray = new int[numbers.length];

        for(int i=0;i<numbersArray.length;i++) {
            numbersArray[i] = Integer.parseInt(numbers[i]);
        }
        return numbersArray;
    }
}
