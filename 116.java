// The solution for the current version
class Solution {
    public Node connect(Node root) {
        Node lastHead = root;
        Node lastCurrent = null;
        Node currentHead = null;
        Node current = null;

        while (lastHead != null) {
            lastCurrent = lastHead;

            while (lastCurrent != null) {
                if (currentHead == null) {
                    currentHead = lastCurrent.left;
                    current = currentHead;
                } else {
                    current.next = lastCurrent.left;
                    current = current.next;
                }

                if (currentHead != null) {
                    current.next = lastCurrent.right;
                    current = current.next;
                }

                lastCurrent = lastCurrent.next;
            }

            lastHead = currentHead;
            currentHead = null;
        }

        return root;
    }
}

// The solution for the older version
public class Solution
{
	public void connect(TreeLinkNode root)
	{
		TreeLinkNode lastHead = root;
		TreeLinkNode lastCurrent = null;
		TreeLinkNode currentHead = null;
		TreeLinkNode current = null;

		while(lastHead != null)
		{
			lastCurrent = lastHead;

			while(lastCurrent != null)
			{
				if(currentHead == null)
				{
					currentHead = lastCurrent.left;
					current = currentHead;
				}
				else
				{
					current.next = lastCurrent.left;
					current = current.next;
				}

				if(currentHead != null)
				{
					current.next = lastCurrent.right;
					current = current.next;
				}

				lastCurrent = lastCurrent.next;
			}

			lastHead = currentHead;
			currentHead = null;
		}
	}
}
