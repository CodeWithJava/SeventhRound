class Solution {
    public int maxProduct(int [] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input is invalid");
        }

        double globalMax = nums[0];
        double localMax = nums[0];
        double localMin = nums[0];

        for (int i = 1;i < nums.length;i++) {
            double t = localMax;
            localMax = Math.max(nums[i], Math.max(localMax * nums[i], localMin * nums[i]));
            localMin = Math.min(nums[i], Math.min(t * nums[i], localMin * nums[i]));

            globalMax = Math.max(globalMax, localMax);
        }

        return (int)globalMax;
    }
}
