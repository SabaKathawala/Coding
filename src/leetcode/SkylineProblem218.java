package leetcode;

import java.util.*;

public class SkylineProblem218 {

    class Point {
        int y;
        boolean isStart;
        Point(int y, boolean isStart) {
            this.y = y;
            this.isStart = isStart;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        //sorted on x -> mapped to y and start or end
        Map<Integer, List<Point>> mapping  = new TreeMap<>();
        List<int[]> skyLine = new ArrayList<>();
        int buildingsPoints = buildings.length;
        for(int i=0; i<buildingsPoints; i++) {
            int[] temp = buildings[i];
            if(mapping.containsKey(temp[0])) {
                Point point = new Point(temp[2], true);
                List listOfPoints = mapping.get(temp[0]);
                listOfPoints.add(point);
//                mapping.put(temp[0], point);
            } else {
                Point point = new Point(temp[2], true);
                List listOfPoints = new ArrayList<>();
                listOfPoints.add(point);;
                mapping.put(temp[0], listOfPoints);
            }
            if(mapping.containsKey(temp[1])) {
                Point point = new Point(temp[2], false);
                List listOfPoints = mapping.get(temp[1]);
                listOfPoints.add(point);
            } else {
                Point point = new Point(temp[2], false);
                List listOfPoints = new ArrayList<>();
                listOfPoints.add(point);;
                mapping.put(temp[1], listOfPoints);
            }
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1.intValue() == o2.intValue()) {
                    return 0;
                }
                return o1.intValue() > o2.intValue() ? -1 : 1 ;
            }
        });
        maxHeap.add(0);
        int max = maxHeap.peek();
        int prevMax = max;
        Set<Map.Entry<Integer, List<Point>>> sets = mapping.entrySet();
        for(Map.Entry entry: sets) {
            List<Point> points = (ArrayList<Point>)entry.getValue();
            for(Point p: points) {
                if(p.isStart) {
                    maxHeap.add(p.y);
                } else {
                    maxHeap.remove(p.y);
                }
            }
            max = maxHeap.peek();
            if(max != prevMax) {
                skyLine.add(new int[]{(int)entry.getKey(),max});
                prevMax = max;
            }
        }
        return skyLine;
    }


    public static void main(String[] args) {
        new SkylineProblem218().getSkyline(new int[][] {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}});

    }
}
