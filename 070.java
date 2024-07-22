// Space Complexity: O(n)
public class Solution
{
	public int climbStairs(int n)
	{
		if(n < 1)
			return 0;

		int [] dp = new int [n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for(int i = 2;i < dp.length;i++)
			dp[i] = dp[i -1] + dp[i - 2];

		return dp[n];
	}
}

// Space Complexity: O(1)
class Solution {
    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }

        int prev = 1;
        int curr = 1;

        for (int i = 2;i <= n;i++) {
            int t = curr;
            curr += prev;
            prev = t;
        }

        return curr;
    }
}
