package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII210 {
    static boolean loop = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> prerequisiteMap = new HashMap<>();

        for(int i =0; i< prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];

            if(prerequisiteMap.containsKey(prereq)) {
                prerequisiteMap.get(prereq).add(course);
            } else {
                List<Integer> courses = new ArrayList<>();
                courses.add(course);
                prerequisiteMap.put(prereq, courses);
            }
        }

        // check for loop

        int[] visited = new int[numCourses];
        Stack<Integer> courseList = new Stack<>();

        for(int i=0; i<numCourses; i++)
        {
            printCourses(prerequisiteMap, visited, i, courseList);
            if(loop) {
                return new int[]{};
            }
        }

        int i=0;
        int[] order = new int[numCourses];
        while(!courseList.isEmpty()) {
            order[i++] = courseList.pop();
        }
        return order;

    }

    private static void printCourses(HashMap<Integer, List<Integer>> prerequisiteMap,
                                     int[] visited, int i, Stack<Integer> courseList) {

        if(visited[i] == -1) {
            loop = true;
            return;
        }
        if(visited[i] == 1) {
            return;
        }
        if(!prerequisiteMap.containsKey(i)) {
            visited[i] = 1;
            courseList.push(i);
            return;
        }
        visited[i] = -1;
        List<Integer> courses = prerequisiteMap.get(i);
        for(Integer course: courses) {
            printCourses(prerequisiteMap, visited, course, courseList);
        }
        visited[i] = 1;
        courseList.push(i);
    }

    public static void main(String[] args) {
        new CourseScheduleII210().findOrder(4, new int[][]{{3,0},{0,1}});
    }
}

