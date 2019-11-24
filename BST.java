public class BST {
    TreeNode node;

    public boolean search(int key, TreeNode root) {
        TreeNode curr = root;
        while(curr != null) {
            if(curr.data > key) {
                curr = curr.left;
            }
            else if(curr.data < key) {
                curr = curr.right;
            }
            else if(curr.data == key) return true;
            else break;
        }
        return false;
    }

    public boolean insert(int key, TreeNode root) {
        TreeNode curr = null;
        if (root == null) {
            root = new TreeNode(key);
        }
        while(root != null) {
            curr = root;
            if (root.data > key) {
                root = root.left;
            } else if (root.data < key) {
                root = root.right;
            }
        }

        if(curr.data < key)
            curr.right = new TreeNode(key);
        else if(curr.data > key) {
            curr.left = new TreeNode(key);
        }
        return true;
    }


    public static void main(String[] args) {
        BST b = new BST();
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(7);
        node.right = new TreeNode(15);
      //  System.out.println(b.search(10, node));
        b.insert(18, node);
    }
}
