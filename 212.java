public class Solution
{
	Set<String> set;
	Trie trie;

	public List<String> findWords(char [][] board, String [] words)
	{
		List<String> result = new ArrayList<>();

		if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0)
			return result;

		set = new HashSet<>();

		trie = new Trie();

		for(String word: words)
			trie.insert(word);

		int r = board.length;
		int c = board[0].length;

		boolean [][] visited = new boolean [r][c];

		for(int i = 0;i < r;i++)
			for(int j = 0;j < c;j++)
				traversal(board, i, j, "", visited);

		result.addAll(set);

		return result;
	}

	private void traversal(char [][] board, int i, int j, String sub, boolean [][] visited)
	{
		if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1)
			return;

		if(visited[i][j])
			return;

		sub += board[i][j];

		if(!trie.startsWith(sub))
			return;

		if(trie.search(sub))
			set.add(sub);

		visited[i][j] = true;

		traversal(board, i - 1, j, sub, visited);
		traversal(board, i + 1, j, sub, visited);
		traversal(board, i, j - 1, sub, visited);
		traversal(board, i, j + 1, sub, visited);

		visited[i][j] = false;
	}
}
class Trie
{
	TrieNode root;

	Trie()
	{
		root = new TrieNode();
	}

	public void insert(String word)
	{
		TrieNode node = root;

		for(char x: word.toCharArray())
		{
			if(node.children[x - 'a'] == null)
				node.children[x - 'a'] = new TrieNode();

			node = node.children[x - 'a'];
		}

		node.isLeaf = true;
	}

	public boolean search(String word)
	{
		TrieNode node = root;

		for(char x: word.toCharArray())
		{
			if(node.children[x - 'a'] == null)
				return false;

			node = node.children[x - 'a'];
		}

		return node.isLeaf;
	}

	public boolean startsWith(String prefix)
	{
		TrieNode node = root;

		for(char x: prefix.toCharArray())
		{
			if(node.children[x - 'a'] == null)
				return false;

			node = node.children[x - 'a'];
		}

		return true;
	}
}
class TrieNode
{
	TrieNode [] children;
	boolean isLeaf;

	TrieNode()
	{
		children = new TrieNode [26];
		isLeaf = false;
	}
}