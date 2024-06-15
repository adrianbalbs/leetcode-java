package ipo;

import java.util.*;

record Pair (int fst, int snd) {}
public class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<Pair> pairs = new ArrayList<>(n);
        for (int i = 0; i < n;  i++) {
            pairs.add(new Pair(profits[i], capital[i]));
        }

        pairs.sort(Comparator.comparingInt(Pair::snd));

        int j = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            while (j < pairs.size() && pairs.get(j).snd() <= w) {
                pq.add(pairs.get(j++).fst());
            }
            if (pq.isEmpty()) break;
            w += pq.remove();
        }
        return w;
    }
}
