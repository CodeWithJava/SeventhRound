public class Solution
{
	public ListNode rotateRight(ListNode head, int k)
	{
		if(head == null || head.next == null || k < 1)
			return head;

		ListNode p = head;
		int l = 0;

		
		while(p != null)
		{
			l++;
			p = p.next;
		}

		k %= l;

		if(k < 1)
			return head;

		ListNode fast = head;
		ListNode slow = head;

		for(int i = 0;i < k;i++)
			fast = fast.next;

		while(fast.next != null)
		{
			fast = fast.next;
			slow = slow.next;
		}

		ListNode t = slow.next;
		fast.next = head;
		slow.next = null;

		return t;
	}
}