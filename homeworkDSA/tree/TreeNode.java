package homeworkDSA.tree;

import java.util.ArrayList;

public class TreeNode {
  public int value;
  public ArrayList<TreeNode> children;


  public TreeNode(int value) {
    this.value = value;
    this.children = new ArrayList<TreeNode>();
  }
}
