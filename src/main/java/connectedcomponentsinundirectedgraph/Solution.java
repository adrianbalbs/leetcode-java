package connectedcomponentsinundirectedgraph;

public class Solution {
    private int[] link;
    private int[] size;
    public int countComponents(int n, int[][] edges) {
        this.link = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            link[i] = i;
            size[i] = 1;
        }

        int num = n;
        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                num--;
            }
        }

        return num;
    }

    int find(int x) {
        while (x != this.link[x]) {
            x = link[x];
        }
        return x;
    }

    boolean union(int a, int b) {
        int s1 = find(a);
        int s2 = find(b);
        if (s1 == s2) {
            return false;
        }

        // We add the smaller component to the larger one
        if (this.size[b] > this.size[a]) {
            this.link[a] = b;
            this.size[b] += this.size[a];
        } else {
            this.link[b] = a;
            this.size[a] += this.size[b];
        }

        return true;
    }
}
