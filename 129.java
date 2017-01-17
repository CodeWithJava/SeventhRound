public class Solution
{
	public int sumNumbers(TreeNode root)
	{
		if(root == null)
			return 0;

		List<String> numbers = new ArrayList<>();

		traversal(root, String.valueOf(root.val), numbers);

		int sum = 0;

		for(String number: numbers)
			sum += Integer.valueOf(number);

		return sum;
	}

	private void traversal(TreeNode node, String t, List<String> numbers)
	{
		if(node.left == null && node.right == null)
			numbers.add(t);
		else
		{
			if(node.left != null)
				traversal(node.left, t + node.left.val, numbers);

			if(node.right != null)
				traversal(node.right, t + node.right.val, numbers);
		}
	}
}