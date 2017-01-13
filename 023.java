// Solution One
public class Solution
{
	public ListNode mergeKLists(ListNode [] lists)
	{
		if(lists == null || lists.length == 0)
			return null;

		int r = lists.length - 1;

		while(r > 0)
		{
			int l = 0;

			while(l < r)
			{
				lists[l] = merge(lists[l], lists[r]);
				l++;
				r--;
			}
		}

		return lists[0];
	}

	private ListNode merge(ListNode l1, ListNode l2)
	{
		if(l1 == null)
			return l2;

		if(l2 == null)
			return l1;

		ListNode dummyNode = new ListNode(0);
		ListNode p = dummyNode;

		while(l1 != null && l2 != null)
		{
			if(l1.val < l2.val)
			{
				p.next = l1;
				l1 = l1.next;
			}
			else
			{
				p.next = l2;
				l2 = l2.next;
			}

			p = p.next;
		}

		if(l1 != null)	p.next = l1;
		if(l2 != null)	p.next = l2;

		return dummyNode.next;
	}
}

// Solution Two
public class Solution
{
	public ListNode mergeKLists(ListNode [] lists)
	{
		if(lists == null || lists.length == 0)
			return null;

		Queue<ListNode> minHeap = new PriorityQueue<>(new ListNodeComparator());

		for(ListNode list: lists)
			if(list != null)
				minHeap.offer(list);

		ListNode dummyNode = new ListNode(0);
		ListNode p = dummyNode;

		while(!minHeap.isEmpty())
		{
			ListNode x = minHeap.poll();

			p.next = x;
			p = p.next;

			if(x.next != null)
				minHeap.offer(x.next);
		}

		return dummyNode.next;
	}
}
class ListNodeComparator implements Comparator<ListNode>
{
	public int compare(ListNode l1, ListNode l2)
	{
		return l1.val - l2.val;
	}
}