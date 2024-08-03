// Solution One
class Solution {
    public int addDigits(int num) {
        int x = num;

        while (x > 9) {
            int t = 0;

            while (x != 0) {
                t += x % 10;
                x /= 10;
            }

            x = t;
        }

        return x;
    }
}

// Solution Two
public class Solution
{
	public int addDigits(int num)
	{
		if(num < 0)
			throw new IllegalArgumentException("Input is invalid");

		if(num == 0)
			return 0;

		if(num % 9 == 0)
			return 9;

		return num % 9;
	}
}
