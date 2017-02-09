public class Solution
{
	/** @param head The linked list's head.
	    Note that the head is guaranteed to be not null, so it contains at least one node. */

	ListNode h;
	Random r;

	Solution(ListNode head)
	{
		h = head;
		r = new Random();
	}

	/** Returns a random node's value */
	public int getRandom()
	{
		ListNode p = h;
		int count = 1;

		int result = 0;

		while(p != null)
		{
			if(r.nextInt(count) == 0)
				result = p.val;

			count++;
			p = p.next;
		}

		return result;
	}
}