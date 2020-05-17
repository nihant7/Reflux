package Trees;

import java.util.HashMap;

public class TrieNode {

    TrieNode node;
    boolean isLeaf;
    char ch;
    TrieNode[] arr = new TrieNode[128];

    TrieNode(char c) {
        ch = c;
    }

    public void insert(String word) {
        TrieNode node = null;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if(node.arr[index] == null) {
                TrieNode new_node = new TrieNode(c);
                node.arr[index] = new_node;
            }
        }
        node.isLeaf = true;
    }

    public boolean search(String word, HashMap<Character, TrieNode> map) {
            return false;
    }


}
