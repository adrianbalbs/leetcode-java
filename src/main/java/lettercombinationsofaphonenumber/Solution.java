package lettercombinationsofaphonenumber;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {
    private Map<Character, String> digitToChar = Map.of(
            '2',
            "abc",
            '3',
            "def",
            '4',
            "ghi",
            '5',
            "jkl",
            '6',
            "mno",
            '7',
            "pqrs",
            '8',
            "tuv",
            '9',
            "wxyz"
    );


    public List<String> letterCombinations(String digits) {
        if (digits.isBlank()) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        backtrack(digits, res, "", 0);
        return res;
    }

    void backtrack(String digits, List<String> res, String cur, int index) {
        if (index == digits.length()) {
            res.add(cur);
            return;
        }
        String letters = this.digitToChar.get(digits.charAt(index));
        for (char c : letters.toCharArray()) {
            backtrack(digits, res, cur + c, index + 1);
        }
    }
}
