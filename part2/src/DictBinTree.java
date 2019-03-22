public class DictBinTree implements Dict {

  public Tree tree = new Tree();
  public int count;

  @Override
  public void insert(int k) {
    Node y = null;
    Node x = tree.root;

    while (x != null) {
      y = x;
        if(k < x.key){
          x = x.left;
        } else{
          x = x.right;
        }
    }
    Node child = new Node(k);

    if( y == null){
      tree.root = child;
    } else if(k < y.key){
        y.left = child;
    } else {
      y.right = child;
    }

    count++;
  }

  @Override
  public int[] orderedTraversal() {
    return inorderTreeWalk(tree.root, new int[count], 0);
  }

  private int[] inorderTreeWalk(Node node, int[] list, int i){
    if(node != null){
        inorderTreeWalk(node.left, list, i);
        list[i] = node.key;
        i++;
        inorderTreeWalk(node.right, list, i);
    }

    return list;
  }

  @Override
  public boolean search(int k) {
    return walk(tree.root, k) != null;
  }

  private Node walk(Node node, int k){
    if(node == null || k == node.key){
      return node;
    }
    if(k < node.key){
      return walk(node.left, k);
    } else{
      return walk(node.right, k);
    }
  }

}
