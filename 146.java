public class LRUCache
{
	Map<Integer, Node> map;
	Node head;
	Node tail;
	int capacity;

	LRUCache(int capacity)
	{
		map = new HashMap<>();
		head = null;
		tail = null;
		this.capacity = capacity;
	}

	public int get(int key)
	{
		if(map.containsKey(key))
		{
			Node node = map.get(key);
			remove(node);
			setHead(node);
			return node.val;
		}

		return -1;
	}

	public void put(int key, int value)
	{
		if(map.containsKey(key))
		{
			Node node = map.get(key);
			remove(node);
			setHead(node);
			node.val = value;
		}
		else
		{
			if(map.size() == capacity)
			{
				map.remove(tail.key);
				remove(tail);
			}

			Node create = new Node(key, value);
			setHead(create);
			map.put(key, create);
		}
	}

	private void remove(Node node)
	{
		if(node.prev != null)
			node.prev.next = node.next;
		else
			head = node.next;

		if(node.next != null)
			node.next.prev = node.prev;
		else
			tail = node.prev;
	}

	private void setHead(Node node)
	{
		node.prev = null;
		node.next = head;

		if(head != null)
			head.prev = node;

		head = node;

		if(tail == null)
			tail = head;
	}
}
class Node
{
	int key;
	int val;
	Node prev;
	Node next;

	Node(int key, int val)
	{
		this.key = key;
		this.val = val;
	}
}