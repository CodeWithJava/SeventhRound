public class MyQueue
{
	Stack<Integer> q;
	Stack<Integer> t;
	/** Initialize your data structure here. */
	MyQueue()
	{
		q = new Stack<>();
		t = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x)
	{
		if(empty())
			q.push(x);
		else
		{
			while(!q.isEmpty())
				t.push(q.pop());

			q.push(x);
		}

		while(!t.isEmpty())
			q.push(t.pop());
	}

	/** Removes the elemens from in front of queue and returns that element. */
	public int pop()
	{
		if(!empty())
			return q.pop();

		throw new IllegalArgumentException("Queue is empty");
	}

	/** Get the front element. */
	public int peek()
	{
		if(!empty())
			return q.peek();

		throw new IllegalArgumentException("Queue is empty");
	}

	/** Returns whether the queue is empty */
	public boolean empty()
	{
		return q.isEmpty();
	}
}