public class Solution
{
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList)
	{
		List<List<String>> result = new ArrayList<>();

		if(wordList == null || wordList.size() == 0)
			return result;

		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(null, beginWord, 1));

		wordList.add(endWord);

		Set<String> unvisited = new HashSet<>();
		Set<String> visited = new HashSet<>();

		unvisited.addAll(wordList);

		int min = 0;
		int prev = 1;

		while(!q.isEmpty())
		{
			Node x = q.poll();
			int curr = x.step;
			String word = x.word;

			if(word.equals(endWord))
			{
				if(min == 0)
					min = x.step;

				if(x.step == min && min != 0)
				{
					List<String> t = new ArrayList<>();

					while(x != null)
					{
						t.add(0, x.word);
						x = x.prev;
					}

					result.add(new ArrayList<>(t));
				}
			}

			if(prev < curr)
			{
				prev = curr;
				unvisited.removeAll(visited);
			}

			char [] alphabets = word.toCharArray();

			for(int i = 0;i < alphabets.length;i++)
			{
				char t = alphabets[i];

				for(char c = 'a';c <= 'z';c++)
				{
					alphabets[i] = c;

					String newWord = new String(alphabets);

					if(unvisited.contains(newWord))
					{
						q.offer(new Node(x, newWord, curr + 1));
						visited.add(newWord);
					}
				}

				alphabets[i] = t;
			}
		}

		return result;
	}
}
class Node
{
	Node prev;
	int step;
	String word;

	Node(Node prev, String word, int step)
	{
		this.prev = prev;
		this.step = step;
		this.word = word;
	}
}