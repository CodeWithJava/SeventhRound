public class Solution
{
	public TreeNode buildTree(int [] preorder, int [] inorder)
	{
		if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length)
			return null;

		return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private TreeNode build(int [] preorder, int pL, int pR, int [] inorder, int iL, int iR)
	{
		if(pL > pR || iL > iR)
			return null;

		int root = preorder[pL];
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
		node.left = build(preorder, pL + 1, pL + k - iL, inorder, iL, k - 1);
		node.right = build(preorder, pL + k - iL + 1, pR, inorder, k + 1, iR);

		return node;
	}
}