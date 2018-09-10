package leetcode;

import java.util.*;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class MergeIntervals56 {

    class SortedIntervals implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2){
            if(i1.start < i2.start){
                return -1;
            }
            if(i1.start > i2.start){
                return 1;
            }
            return 0;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new ArrayList<>();
        if(intervals.size() == 0) {
            return mergedIntervals;
        }
        Collections.sort(intervals, new SortedIntervals());
        for(int i=1; i<intervals.size(); i++) {
           Interval i1 = intervals.get(i-1);
           Interval i2 = intervals.get(i);
           if(i2.start <= i1.end) {
               i1.end = Math.max(i1.end, i2.end);
               intervals.remove(i);
               i--;
           }
        }
        return intervals;
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();

//        list.add(new Interval(2,3));
//        list.add(new Interval(3,4));
//        list.add(new Interval(15,18));
//        list.add(new Interval(1,8));

//        list.add(new Interval(2,3));
//        list.add(new Interval(6,7));
//        list.add(new Interval(4,5));
//        list.add(new Interval(1,10));

        list.add(new Interval(2,3));
        list.add(new Interval(3,4));
//        list.add(new Interval(15,18));
//        list.add(new Interval(1,8));
        new MergeIntervals56().merge(list);
    }
}
