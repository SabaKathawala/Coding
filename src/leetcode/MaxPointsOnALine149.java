package leetcode;

import java.util.HashMap;

public class MaxPointsOnALine149 {

    class MyPoint extends Point {
        @Override
        public int hashCode() {
            return x + y;
        }

        @Override
        public boolean equals(Object myPoint) {
            MyPoint point = (MyPoint)myPoint;
            return this.x == point.x && this.y == point.y;
        }

        MyPoint(int a, int b) { super(a, b); }
    }

    public int maxPoints(Point[] points) {
        int N = points.length;
        if (N < 2) {
            return N;
        }
        int maxPoint = 0;


        //  looping for each point
        for (int i = 0; i < N; i++)
        {
            // map to store slope pair
            HashMap<MyPoint, Integer> slopeMap = new HashMap<>();
            int curMax, overlapPoints, verticalPoints;
            curMax = overlapPoints = verticalPoints = 0;

            //  looping from i + 1 to ignore same pair again
            for (int j = i + 1; j < N; j++)
            {
                //  If both point are equal then just
                // increase overlapPoint count
                if (points[i].x == points[j].x & points[i].y == points[j].y)
                    overlapPoints++;

                    // If x co-ordinate is same, then both
                    // point are vertical to each other
                else if (points[i].x == points[j].x)
                    verticalPoints++;

                else
                {
                    int yDif = points[j].y - points[i].y;
                    int xDif = points[j].x - points[i].x;
                    int g = findGCD(xDif, yDif);

                    // reducing the difference by their gcd
                    yDif /= g;
                    xDif /= g;

                    // increasing the frequency of current slope
                    // in map
                    MyPoint p = new MyPoint(yDif, xDif);
                    if(slopeMap.containsKey(p)) {
                        slopeMap.put(p, slopeMap.get(p)+1);
                    } else {
                        slopeMap.put(p, 1);
                    }
                    curMax = Math.max(curMax, slopeMap.get(p));
                }

                curMax = Math.max(curMax, verticalPoints);
            }

            // updating global maximum by current point's maximum
            maxPoint = Math.max(maxPoint, curMax + overlapPoints + 1);
            slopeMap.clear();
        }

        return maxPoint;
    }

    private static int findGCD(int number1, int number2) {
        //base case
        if(number2 == 0) {
            return number1;
        }
        return findGCD(number2, number1%number2);
    }

    public static void main(String[] args) {
        System.out.println(new MaxPointsOnALine149().maxPoints(new Point[]{new Point(2,3), new Point(3,3), new Point(-5,3)}));
                //new Point(4,1), new Point(2,3), new Point(1,4)}));
    }

}
