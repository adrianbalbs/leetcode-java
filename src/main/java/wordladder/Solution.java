package wordladder;

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> words = new HashMap<>();
        wordList.add(beginWord);
        for (String word : wordList) {
            StringBuilder patt;
            for (int i = 0; i < word.length(); i++) {
                patt = new StringBuilder(word);
                patt.setCharAt(i, '*');
                List<String> nei = words.getOrDefault(patt.toString(), new ArrayList<>());
                nei.add(word);
                words.put(patt.toString(), nei);
            }
        }

        Set<String> vis = new HashSet<>();
        vis.add(beginWord);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int steps = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                String word = q.remove();
                StringBuilder patt;
                for (int i = 0; i < word.length(); i++) {
                    patt = new StringBuilder(word);
                    patt.setCharAt(i, '*');
                    for (String nei : words.get(patt.toString())) {
                        if (nei.equals(endWord)) {
                            return steps;
                        }
                        if (vis.contains(nei)) {
                            continue;
                        }
                        q.add(nei);
                        vis.add(nei);
                    }
                }
            }
            steps++;
        }
        return 0;
    }
}
