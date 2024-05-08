package relativeranks;

import java.util.PriorityQueue;

record Pair<K, V>(K key, V value) {
}

public class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] res = new String[score.length];

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((p1, p2) -> p2.key() - p1.key());
        for (int i = 0; i < score.length; i++) {
            pq.add(new Pair<>(score[i], i));
        }

        for (int i = 0; i < score.length; i++) {
            String place = switch (i) {
                case 0 -> "Gold Medal";
                case 1 -> "Silver Medal";
                case 2 -> "Bronze Medal";
                default -> String.valueOf(i + 1);
            };
            res[pq.remove().value()] = place;
        }
        return res;
    }
}
