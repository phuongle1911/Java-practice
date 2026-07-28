package homeworkDSA.tree;



public class main {
  public static void main(String[] args) {
    TreeNode node1 = new TreeNode(0);
    TreeNode node2 = new TreeNode(3);
    TreeNode node3 = new TreeNode(5);
    TreeNode node4 = new TreeNode(9);
    TreeNode node5 = new TreeNode(7);
    TreeNode node6 = new TreeNode(8);
    TreeNode node7 = new TreeNode(2);

    Tree tree = new Tree();
   
    node1.children.add(node2);
    node1.children.add(node3);
    node1.children.add(node4);
    node2.children.add(node5);
    node2.children.add(node6);
    node3.children.add(node7);

    tree.root = node1;




  }
}
