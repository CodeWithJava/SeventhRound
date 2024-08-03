// Solution One
class Solution {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            throw new IllegalArgumentException("Input is invalid.");
        }

        TreeNode p = root;
        int result = root.val;

        while (p != null) {
            double d1 = Math.abs(p.val - target);
            double d2 = Math.abs(result - target);

            if (d1 == d2) {
                result = Math.min(result, p.val);
            } else if (d1 < d2){
                result = p.val;
            }
            
            p = target < p.val ? p.left:p.right;
        }

        return result;
    }
}

// Solution Two
public class Solution
{
	double min = Double.MAX_VALUE;
	int result = 0;

	public int closestValue(TreeNode root, double target)
	{
		if(root == null)
			throw new IllegalArgumentException("Input is invalid");

		traversal(root, target);

		return result;
	}

	private void traversal(TreeNode node, double target)
	{
		if(node == null)
			return;

		double d = Math.abs(node.val - target);

		if(d < min)
		{
			min = Math.abs(node.val - target);
			result = node.val;
		} 
		else if (d == min)
        	{
            	result = Math.min(result, node.val);
        	}

		if(target < node.val)
			traversal(node.left, target);
		else
			traversal(node.right, target);
	}
}
