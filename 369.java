public class Solution
{
	public ListNode plusOne(ListNode head)
	{
		if(head == null)
			return new ListNode(1);

		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		ListNode p = head;
		ListNode notNine = dummyNode;

		while(p != null)
		{
			if(p.val != 9)
				notNine = p;

			p = p.next;
		}

		notNine.val++;

		p = notNine.next;

		while(p != null)
		{
			p.val = 0;
			p = p.next;
		}

		return dummyNode.val == 1 ? dummyNode:dummyNode.next;
	}
}