package coursescheduleii;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    List<List<Integer>> courses = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; ++i) {
            courses.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            courses.get(prereq[1]).add(prereq[0]);
        }

        int[] visited = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; ++i) {
            if (!(dfs(i, visited, stack))) {
                return new int[0];
            }
        }

        int[] res = new int[numCourses];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }
        return res;
    }

    boolean dfs(int course, int[] visited, Stack<Integer> stack) {
        if (visited[course] == 2) {
            return false;
        } else if (visited[course] == 1) {
            return true;
        }

        visited[course] = 2;
        for (int nei : this.courses.get(course)) {
            if (!dfs(nei, visited, stack)) {
                return false;
            }
        }
        visited[course] = 1;
        stack.push(course);
        return true;
    }
}
