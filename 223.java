public class Solution
{
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H)
	{
		int result = (D - B) * (C - A) + (H - F) * (G - E);

		if(D < F || C < E)
			return result;

		if(A > G || B > H)
			return result;

		int left = Math.max(A, E);
		int right = Math.min(C, G);
		int top = Math.min(D, H);
		int bottom = Math.max(B, F);

		return result - (right - left) * (top - bottom);
	}
} 