public class Solution
{
	private static String [] LESS_TEN = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	private static String [] LESS_TWENTY = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private static String [] LESS_HUNDRED = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

	public String numberToWords(int num)
	{
		if(num < 0)
			return "";

		if(num == 0)
			return "Zero";

		return traversal(num);
	}

	private String traversal(int num)
	{
		String result = "";

		if(num < 10)
			result += LESS_TEN[num];
		else if(num < 20)
			result += LESS_TWENTY[num - 10];
		else if(num < 100)
			result += LESS_HUNDRED[num / 10] + " " + LESS_TEN[num % 10];
		else if(num < 1000)
			result += traversal(num / 100) + " Hundred " + traversal(num % 100);
		else if(num < 1000000)
			result += traversal(num / 1000) + " Thousand " + traversal(num % 1000);
		else if(num < 1000000000)
			result += traversal(num / 1000000) + " Million " + traversal(num % 1000000);
		else
			result += traversal(num / 1000000000) + " Billion " + traversal(num % 1000000000);

		return result.trim();
	}
}