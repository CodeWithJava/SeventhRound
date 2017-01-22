public class MinStack
{
	Node head;

	MinStack()
	{
		head = null;
	}

	public void push(int x)
	{
		if(head == null)
			head = new Node(x);
		else
		{
			Node t = new Node(x);
			t.min = Math.min(x, head.min);
			t.next = head;
			head = t;
		}
	}

	public void pop()
	{
		if(head != null)
			head = head.next;
	}

	public int top()
	{
		if(head != null)
			return head.x;

		throw new IllegalArgumentException("MinStack is empty");
	}

	public int getMin()
	{
		if(head != null)
			return head.min;

		throw new IllegalArgumentException("MinStack is empty");
	}
}
class Node
{
	int x;
	int min;
	Node next;

	Node(int val)
	{
		x = val;
		min = val;
	}
}