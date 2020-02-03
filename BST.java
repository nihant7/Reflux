import java.util.LinkedList;
import java.util.Queue;

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


    // Leetcodee : Level Order Search Traversal / BFS
    public void LOS(TreeNode node) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()) {
            TreeNode top = q.poll();
            System.out.println(top.data);
            if(top.left != null && top.right != null) {
                q.add(top.left);
                q.add(top.right);
            }
        }
    }

    // Leetcode : Find the next right pointers in a Binary Tree
    public TreeNode findNextRight(TreeNode root) {
        root.next = null;
        while(root != null) {
            if(root != null) {
                if(root.right != null) {
                    root.left.next = root.right;
                    root.right.next = null;
                }
                root = root.left;
            }
        }
        return root;
    }




    public static void main(String[] args) {
        BST b = new BST();
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(7);
        node.right = new TreeNode(15);
      //  System.out.println(b.search(10, node));
        b.insert(18, node);

      //  System.out.println(b.search(24, node));
      //  b.LOS(node);

        b.findNextRight(node);
        System.out.print(node.data);
        if(node.next == null)
            System.out.print("," + "-1" + ",");
        System.out.print(node.left.data + ",");
        if(node.left.next == null)
            System.out.print("," + "-1" + ",");
        System.out.print(node.right.data + ",");
        if(node.right.next == null)
            System.out.print("-1");

    }
}
