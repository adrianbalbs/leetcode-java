package grumpybookstoreowner;

public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int[] maxSatisfactionRange = { 0, 0 };
        int currSatisfaction = 0;
        int maxSatisfactionLost = 0;
        int l = 0;

        for (int r = 0; r < n; r++) {
            if (grumpy[r] == 1) {
                currSatisfaction += customers[r];
            }
            if (r >= minutes) {
                if (grumpy[l++] == 1) {
                    currSatisfaction -= customers[r - minutes];
                }
            }
            if (currSatisfaction > maxSatisfactionLost) {
                maxSatisfactionRange[0] = l;
                maxSatisfactionRange[1] = r;
                maxSatisfactionLost = currSatisfaction;
            }
        }

        for (int i = maxSatisfactionRange[0]; i <= maxSatisfactionRange[1]; i++) {
            grumpy[i] = 0;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                res += customers[i];
            }
        }
        return res;
    }
}
