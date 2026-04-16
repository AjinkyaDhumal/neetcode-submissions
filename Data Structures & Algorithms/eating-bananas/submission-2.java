class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int length = piles.length;
        
        // find max of piles.
        int maxOfPiles = 0;
        for (int i = 0; i < length; i++) {
            if (piles[i] > maxOfPiles) maxOfPiles = piles[i];
        }
        // int maxOfPiles = Arrays.streams(piles).max().getAsInt();

        int maxHour =  (int) Math.ceil((float) length / h);
        int maxK = (int) Math.ceil((float) maxOfPiles / maxHour);
        int minK = maxK;
        int l = 0, r = maxK;
        while (l <= r) {
            int mid = l + (r - l)/2;
            long totalTime = 0;
            for (int p : piles) {
                totalTime += Math.ceil((double) p / mid);
            }

            if (totalTime <= h) {
                minK = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return minK;
    }
}
