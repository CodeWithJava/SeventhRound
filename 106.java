public class Solution
{
	public TreeNode buildTree(int [] inorder, int [] postorder)
	{
		if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0 || inorder.length != postorder.length)
			return null;

		return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	private TreeNode build(int [] inorder, int iL, int iR, int [] postorder, int pL, int pR)
	{
		if(iL > iR || pL > pR)
			return null;

		int root = postorder[pR];
		int k = iL;

		for(int i = iL;i <= iR;i++)
		{
			if(inorder[i] == root)
			{
				k = i;
				break;
			}
		}

		TreeNode node = new TreeNode(root);
		node.left = build(inorder, iL, k - 1, postorder, pL, pL + k - iL - 1);
		node.right = build(inorder, k + 1, iR, postorder, pL + k - iL, pR - 1);

		return node;
	}
}