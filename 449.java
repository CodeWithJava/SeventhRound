import java.util.StringTokenizer;
public class Codec
{
	// Encodes a tree to a single string.
	public String serialize(TreeNode root)
	{
		StringBuilder sb = new StringBuilder();

		if(root == null)
			return sb.toString();

		serialize(root, sb);

		sb.setLength(sb.length() - 1);

		return sb.toString();
	}

	private void serialize(TreeNode node, StringBuilder sb)
	{
		if(node == null)
			sb.append("#*");
		else
		{
			sb.append(node.val + "*");
			serialize(node.left, sb);
			serialize(node.right, sb);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data)
	{
		if(data == null || data.length() == 0)
			return null;

		StringTokenizer st = new StringTokenizer(data, "*");

		return deserialize(st);
	}

	private TreeNode deserialize(StringTokenizer st)
	{
		if(!st.hasMoreTokens())
			return null;
		else
		{
			String value = st.nextToken();
			if(value.equals("#"))
				return null;

			TreeNode node = new TreeNode(Integer.valueOf(value));
			node.left = deserialize(st);
			node.right = deserialize(st);

			return node;
		}
	}
}