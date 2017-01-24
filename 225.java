public class MyStack
{
	Queue<Integer> q1;
	Queue<Integer> q2;

	/** Initialize your data structure here. */
	MyStack()
	{
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
	}

	/** Push element x onto stack. */
	public void push(int x)
	{
		if(empty())
			q1.offer(x);
		else
		{
			if(q1.isEmpty())
			{
				q1.offer(x);
				while(!q2.isEmpty())
					q1.offer(q2.poll());
			}
			else
			{
				q2.offer(x);
				while(!q1.isEmpty())
					q2.offer(q1.poll());
			}
		}
	}

	/** Removes the element on top of the stack and returns that elements. */
	public int pop()
	{
		if(!q1.isEmpty())
			return q1.poll();
		else if(!q2.isEmpty())
			return q2.poll();

		throw new IllegalArgumentException("Stack is empty");
	}

	/** Get the top elements. */
	public int top()
	{
		if(!q1.isEmpty())
			return q1.peek();
		else if(!q2.isEmpty())
			return q2.peek();

		throw new IllegalArgumentException("Stack is empty");
	}

	/** Returns whether the stack is empty. */
	public boolean empty()
	{
		return q1.isEmpty() && q2.isEmpty();
	}
}