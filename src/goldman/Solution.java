package goldman;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
//        List<List<String>> list = new ArrayList<>();
//        List<String> l = new ArrayList<>();
        //System.out.println(latestStudent(list));
        new Solution().reverseWords("Let's take LeetCode contest");
    }

    private static long getSumOfStocks(int[] p) {
        long sum = 0;
        for(int price: p) {
            sum+=price;
        }
        return sum;
    }

    private static double getMinMean(int[][] stocks, double mean, int[] num,  int n) {
        double currMean = 0;
        for(int[] prices: stocks) {
            for(int price: prices) {
                currMean += Math.abs(price - mean);
            }
        }
        return currMean;
    }

    static class Student {
        int lateness;
        double relativeLateness;
        Student(int lateness) {
            this.lateness = lateness;
        }
    }

    static String latestStudent(List<List<String>> attendanceData) {
        Map<String, Map<String, Student>> dayToLateness = new HashMap<>();

        for (List<String> row : attendanceData) {
            int classTime = Integer.parseInt(row.get(2));
            int arrivalTime = Integer.parseInt(row.get(3));
            int lateness = arrivalTime - classTime;
            if (lateness <= 0) {
                lateness = 0;
            }
            String day = row.get(0);
            String student = row.get(1);
            Map<String, Student> studentToLateness = new HashMap<>();
            studentToLateness.put(student, new Student(lateness));
            if (dayToLateness.containsKey(day)) {
                dayToLateness.get(day).put(student, new Student(lateness));
            } else {
                dayToLateness.put(day, studentToLateness);
            }
        }


        Set<Map.Entry<String, Map<String, Student>>> entries = dayToLateness.entrySet();
        for (Map.Entry<String, Map<String, Student>> dates : entries) {
            setRelativeLatenessForDate(dates.getValue());
        }

        Map<String, Double> studentToRelative = new HashMap<>();
        for (Map.Entry<String, Map<String, Student>> dates : entries) {
            Map<String, Student> studentToLateness = dates.getValue();
            Set<Map.Entry<String, Student>> students = studentToLateness.entrySet();
            for(Map.Entry<String, Student> student: students) {
                if(studentToRelative.containsKey(student.getKey())) {
                    studentToRelative.put(student.getKey(), student.getValue().relativeLateness + studentToRelative.get(student.getKey()));
                }
                else {
                    studentToRelative.put(student.getKey(), student.getValue().relativeLateness);
                }
            }
        }
        Set<Map.Entry<String, Double>> map = studentToRelative.entrySet();
        double maxRelative = Double.MIN_VALUE;
        String student = "";
        for(Map.Entry<String, Double> relative: map) {
            if(relative.getValue() > maxRelative) {
                maxRelative = relative.getValue();
                student = relative.getKey();
            }
        }

        return student;

    }

    private static void setRelativeLatenessForDate(Map<String, Student> studentToLateness) {
        double lateness = 0;
        Collection latenessValues = studentToLateness.values();
        for(Object value: latenessValues) {
            Student s = (Student)value;
            lateness += s.lateness;
        }

        lateness =  lateness/studentToLateness.size();
        for(Object value: latenessValues) {
            Student s = (Student)value;
            double relativeLateness = s.lateness - lateness;
            s.relativeLateness = relativeLateness > 0 ? relativeLateness: 0;
        }
    }

    public String reverseWords(String s) {
        int start = 0;
        char[] stringArray = s.toCharArray();
        for(int i=0; i<stringArray.length; i++) {
            if(stringArray[i] == ' ') {
                reverseWord(start, i-1, stringArray);
                start = i+1;
            }
        }
        reverseWord(start, stringArray.length-1, stringArray);
        return new String(stringArray);
    }

    private static void reverseWord(int start, int end, char[] stringArray) {
        int mid = start + (end-start)/2;
        for(int i=start; i<mid; i++) {
            char c = stringArray[i];
            stringArray[i] = stringArray[end];
            stringArray[end] = c;
            end--;
        }
    }
}
