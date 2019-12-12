public class SortedArrayToBST {
    TreeNode left;
    TreeNode right;

    public void SToBST(TreeNode root, int[] array, int start, int end) {
        if(start < 0 || end > array.length) return;
        int mid = (start + end) / 2;

        root = new TreeNode(array[mid]);

        SToBST(root.left, array, 0, mid);

        SToBST(root.right, array, mid+1, end);
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4};

        SortedArrayToBST stb = new SortedArrayToBST();

        TreeNode root = null;

        stb.SToBST(root, array, 0, array.length);
    }
}
