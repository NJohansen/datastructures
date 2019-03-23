public class DictBinTree implements Dict {

  private Node root = null;
  private int count;
  private int index;

  @Override
  public void insert(int k) {
    Node y = null;
    Node x = root;

    while (x != null) {
      y = x;
      if (k < x.key) {
        x = x.left;
      } else {
        x = x.right;
      }
    }

    Node child = new Node(k);

    if (y == null) {
      root = child;
    } else if (k < y.key) {
      y.left = child;
    } else {
      y.right = child;
    }

    count++;
  }

  @Override
  public int[] orderedTraversal() {
    index = 0;
    return inorderedWalk(root, new int[count]);
  }

  private int[] inorderedWalk(Node node, int[] list) {
    if (node != null) {
      inorderedWalk(node.left, list);
      list[index] = node.key;
      index++;
      inorderedWalk(node.right, list);
    }

    return list;
  }

  @Override
  public boolean search(int k) {
    return walk(root, k) != null;
  }

  private Node walk(Node node, int k) {
    if (node == null || k == node.key) {
      return node;
    }
    if (k < node.key) {
      return walk(node.left, k);
    } else {
      return walk(node.right, k);
    }
  }

}
