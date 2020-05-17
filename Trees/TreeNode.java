package Trees;

public class TreeNode {

    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    public static int countL(Node root) {
        int count = 0;
        Node curr = root;
        if(root.left == null) return 0;
        while(curr != null) {
            if(curr.left != null) {
                curr = curr.left;
                count++;
            }
            else if(curr.right != null) {
                curr = curr.right;
                count++;
            }
            else break;
        }

        return count;
    }

    public static int countR(Node root) {
        int count = 0;
        Node curr = root;
        if (root.right == null) return 0;
        while(curr != null) {
            if(curr.right != null) {
                curr = curr.right;
                count++;
            }
            else if(curr.left != null) {
                curr = curr.left;
                count++;
            }
            else break;
        }

        return count;
    }



    public static void main(String[] args) {
        Node node = new Node(4);
        node.left = new Node(2);
       node.left.left = new Node(3);
        node.left.right = new Node(1);
     //   node.left.left.left = new Node(3);
     //   node.left.left.right = new Node(3);
        node.left.right.left = new Node(5);



        TreeNode t = new TreeNode();

        System.out.println(countL(node) + countR(node));
    }
}
