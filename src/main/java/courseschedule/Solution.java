package courseschedule;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> courses = new ArrayList<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Construct an adjacency list through looping through prereqs
        for (int i = 0; i < numCourses; ++i) {
            courses.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            courses.get(prereq[1]).add(prereq[0]);
        }

        // Then do a DFS cycle detection
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (!(dfs(i, visited))) {
                return false;
            }
        }
        return true;
    }

    boolean dfs(int course, int[] visited) {
        if (visited[course] == 2) {
            return false;
        } else if (visited[course] == 1) {
            return true;
        }
        visited[course] = 2;
        for (int nei : this.courses.get(course)) {
            if (!dfs(nei, visited)) {
                return false;
            }
        }
        visited[course] = 1;
        return true;
    }
}
