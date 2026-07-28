package homeworkDSA.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;



public class Tree {
  public TreeNode root;

  public TreeNode bfs(int value) {
    LinkedList<ArrayList<TreeNode>> queue = new LinkedList<ArrayList<TreeNode>>();
    ArrayList<TreeNode> rootArr = new ArrayList<>(Arrays.asList(root));
    queue.add(rootArr);
    ArrayList<TreeNode> current = new ArrayList<TreeNode>();

    while (!queue.isEmpty()) {
      current = queue.remove();
      for (TreeNode node:current) {
        if (node.value == value) {
          return node;
        } else {
          queue.add(node.children);
        }
      }
    };  

    return null;
  }

  public TreeNode dfs(int value, TreeNode currNode) {
    if (currNode == null) {
      return null;
    }
    ArrayList<TreeNode> nodeChildren = currNode.children;
    for (TreeNode node:nodeChildren) {
      if (node.value == value) {
        return node;
      } else {
        dfs(value, node);
      }
    }

    return null;
  }
}
