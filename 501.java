public class Solution
{
	Integer prev;
	int count;
	int max;
	List<Integer> list;

	public int [] findMode(TreeNode root)
	{
		if(root == null)
			return new int [0];

		prev = null;
		count = 1;
		max = 0;
		list = new ArrayList<>();

		traversal(root);

		int [] result = new int [list.size()];

		for(int i = 0;i < list.size();i++)
		    result[i] = list.get(i);

        return result;
	}

	private void traversal(TreeNode node)
	{
		if(node == null)
			return;

		traversal(node.left);

		if(prev != null)
		{
			if(node.val == prev)
				count++;
			else
				count = 1;
		}

		if(count > max)
		{
			max = count;
			list.clear();
			list.add(node.val);
		}
		else if(count == max)
			list.add(node.val);

		prev = node.val;
		traversal(node.right);
	}
}