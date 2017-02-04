public class Solution
{
	public int maximalRectangle(char [][] matrix)
	{
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int r = matrix.length;
		int c = matrix[0].length;

		int [][] heights = new int [r][c + 1];

		for(int i = 0;i < r;i++)
		{
			for(int j = 0;j < c;j++)
			{
				if(matrix[i][j] == '1')
					heights[i][j] = i == 0 ? 1:1 + heights[i - 1][j];
			}
		}

		int max = 0;

		for(int i = 0;i < r;i++)
		{
			int area = maxArea(heights[i]);

			if(max < area)
				max = area;
		}

		return max;
	}

	private int maxArea(int [] heights)
	{
		if(heights == null || heights.length == 0)
			return 0;

		int max = 0;

		Stack<Integer> stack = new Stack<>();

		int i = 0;

		while(i < heights.length)
		{
			if(stack.isEmpty() || heights[stack.peek()] <= heights[i])
				stack.push(i++);
			else
			{
				int x = stack.pop();
				max = Math.max(max, heights[x] * (stack.isEmpty() ? i:i - 1 - stack.peek()));
			}
		}

		return max;
	}
}