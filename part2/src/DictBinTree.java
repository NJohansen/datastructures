/**
 * DM507 Algoritmer og datastrukturer
 *
 * @author Niclas Westergaard Johansen, njoha17@student.sdu.dk
 * @author Frederik Kvartborg Albertsen, fralb17@student.sdu.dk
 */
public class DictBinTree implements Dict {
  /**
   * Root is null or cointains the root node of the tree
   */
  private Node root = null;

  /**
   * Count is used to count how many elements is wiithin the tree
   */
  private int count;

  /**
   * Index is used to construct an ordered array of integers when we
   * walk the tree
   */
  private int index;

  /**
   * Insert integer into a tree of nodes ordered nodes
   * @param k integer to insert
   */
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

  /**
   * orderedTraversal returns an ordered array of the inserted integers
   * @return ordered list of integers
   */
  @Override
  public int[] orderedTraversal() {
    index = 0;
    return inorderedWalk(root, new int[count]);
  }

  /**
   * inorderedWalk is a recursive function which takes a node and the current
   * constructed list of ordered integers, it will then check the corresponding
   * left and rigth node and insert the key into the ordered list.
   * @param  node to get key and further check right and left nodes
   * @param  list of ordered integers
   * @return list of ordered integers
   */
  private int[] inorderedWalk(Node node, int[] list) {
    if (node != null) {
      inorderedWalk(node.left, list);
      list[index] = node.key;
      index++;
      inorderedWalk(node.right, list);
    }

    return list;
  }

  /**
   * Search will walk the tree to see if the given integer is within it.
   * @param  k given integer to search for
   * @return boolean
   */
  @Override
  public boolean search(int k) {
    return walk(root, k) != null;
  }

  /**
   * Walk is a recursive function which takes a node and a corresponding integer
   * it will then compare the given integer with the given node key, if they
   * do not match call walk agian with the left or right child node
   * @param  node to compare to or call childrens on
   * @param  k integer value to look for
   * @return the found node where k == node.key
   */
  private Node walk(Node node, int k) {
    if (node == null || k == node.key) {
      return node;
    }

    if (k < node.key) {
      return walk(node.left, k);
    }

    return walk(node.right, k);
  }

}
