package grumpybookstoreowner;

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int currSatisfaction = 0;
        int maxSatisfactionLost = 0;

        for (int r = 0; r < n; r++) {
            if (grumpy[r] == 1) {
                currSatisfaction += customers[r];
            }
            if (r >= minutes) {
                if (grumpy[r - minutes] == 1) {
                    currSatisfaction -= customers[r - minutes];
                }
            }
            maxSatisfactionLost = Math.max(maxSatisfactionLost, currSatisfaction);
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        return total + maxSatisfactionLost;
    }
}
