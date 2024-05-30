package validtree;

public class Solution {
    int[] link;
    int[] size;
    public boolean validTree(int n, int[][] edges) {
        link = new int[n];
        size = new int[n];
        for (int i = 0; i < n; ++i) {
            link[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return false;
            }
            n--;
        }
        return n == 1;
    }

    int find(int x) {
        while (x != link[x]) x = link[x];
        return x;
    }

    boolean union(int a, int b) {
        int s1 = find(a);
        int s2 = find(b);
        if (s1 == s2) {
            return false;
        }

        if (size[s2] > size[s1]) {
            link[s1] = s2;
            size[s2] += size[s1];
        } else {
            link[s2] = s1;
            size[s1] += size[s2];
        }
        return true;
    }
}
