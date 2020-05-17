package Trees;

import apple.laf.JRSUIUtils;

import java.util.*;

public class VerticalOrder {

    static class TreeNode {
        TreeNode root;
        TreeNode left;
        TreeNode right;
        int data;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public int maxDuplicateCountLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        queue.offer(root);
        int count = 0;

        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            if (front.left != null) {
                if (!map.containsKey(front.left.data)) {
                    map.put(front.left.data, 1);
                    queue.offer(front.left);
                } else if (map.containsKey(front.left.data)) {
                    map.put(front.data, map.get(front.left.data) + 1);
                }
            }

            if (front.right != null) {
                if (!map.containsKey(front.right.data)) {
                    map.put(front.right.data, 1);
                    queue.offer(front.right);
                } else if (map.containsKey(front.right.data)) {
                    map.put(front.right.data, map.get(front.right.data) + 1);
                }
            }

        }
        return Collections.max(map.values());
    }


    void count(String str) {
        for(int i = 0; i < str.length(); i++) {
            for(int j = 0; j < str.length(); j++) {
                if(i < j)
                System.out.println(str.substring(i,j+1));
            }
        }
    }


    public void verticalOrder(TreeNode root) {
        int level = 0;
        List<Integer> counter = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        TreeNode node = null;

        counter.add(root.data);

        queue.add(root);

        // Initial root node values
        map.put(level, counter);


        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            if (front.left != null) {
                level--;
                front = front.left;
                queue.offer(front);
            } else if (front.right != null) {
                level++;
                front = front.right;
                queue.offer(front);
            }

            counter = map.get(level);

            if (counter == null) {
                counter = new ArrayList<>();
                counter.add(front.data);
                map.put(level, counter);
            } else if (counter != null) {
                counter.add(front.data);
                map.put(level, counter);
            }

        }
        System.out.println(map);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(5);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(7);

        VerticalOrder vo = new VerticalOrder();
        //    vo.verticalOrder(root);
        // System.out.println(vo.maxDuplicateCountLevelOrder(root));

        vo.count("catgocat");
    }
}
