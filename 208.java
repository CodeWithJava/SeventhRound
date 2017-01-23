public class Trie
{
	Node root;

	/** Initialize your data structure here. */
	Trie()
	{
		root = new Node();
	}

	/** Inserts a word into the trie. */
	public void insert(String word)
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

	/** Returns if the word is in the trie. */
	public boolean search(String word)
	{
		Node node = root;

		for(char x: word.toCharArray())
		{
			if(node.children[x - 'a'] == null)
				return false;

			node = node.children[x - 'a'];
		}

		return node.isLeaf;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix)
	{
		Node node = root;

		for(char x: prefix.toCharArray())
		{
			if(node.children[x - 'a'] == null)
				return false;

			node = node.children[x - 'a'];
		}

		return true;
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