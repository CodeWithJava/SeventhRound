public class WordDictionary
{
	Node root;

	/** Initialize your data structure here. */
	WordDictionary()
	{
		root = new Node();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word)
	{
		Node node = root;

		for(char x: word.toCharArray())
		{
			if(node.children[x - 'a'] == null)
				node.children[x - 'a'] = new Node();

			node = node.children[x - 'a'];
		}

		node.isLeaf = true;
	}

	/** Returns if the word is in the data structure. A word could contian the dot character '.' to represent any one letter. */
	public boolean search(String word)
	{
		if(root == null)
			return false;

		return search(root, 0, word);
	}

	private boolean search(Node node, int k, String word)
	{
		if(node == null)
			return false;
		else if(k == word.length())
			return node.isLeaf;

		char c = word.charAt(k);

		if(c == '.')
		{
			for(Node x: node.children)
			{
				if(search(x, k + 1, word))
					return true;
			}

			return false;
		}
		else
		{
			Node x = node.children[c - 'a'];

			return search(x, k + 1, word);
		}
	}
}
class Node
{
	Node [] children;
	boolean isLeaf;

	Node()
	{
		children = new Node [26];
		isLeaf = false;
	}
}