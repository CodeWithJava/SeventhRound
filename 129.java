class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<Integer> numbers = new ArrayList<>();

        traversal(root, root.val, numbers);

        int sum = 0;

        for (int x: numbers) {
            sum += x;
        }

        return sum;
    }

    private void traversal(TreeNode node, int t, List<Integer> result) {
        if (node.left == null && node.right == null) {
            result.add(t);
        } else {
            if (node.left != null) {
                traversal(node.left, t * 10 + node.left.val, result);
            }

            if (node.right != null) {
                traversal(node.right, t * 10 + node.right.val, result);
            }
        }
    }
}
