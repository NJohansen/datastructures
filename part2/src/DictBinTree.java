/**
 * DM507 Algoritmer og datastrukturer
 *
 * @author Niclas Westergaard Johansen, njoha17@student.sdu.dk
 * @author Frederik Kvartborg Albertsen, fralb17@student.sdu.dk
 */
public class DictBinTree implements Dict {
  /**
   * Root is null or contains the root node of the tree
   */
  private Node root = null;

  /**
   * Count is used to count how many nodes there is within the tree
   */
  private int count;

  /**
   * Index is used to construct an ordered array of integers when we
   * walk through the tree
   */
  private int index;

  /**
   * No-arg constructor
   */
  public DictBinTree() {
  }

  /**
   * Insert integer into a tree of ordered nodes
   * @param k integer to insert
   */
  @Override
  public void insert(int k) {
    Node y = null;
    Node x = root;

    // while x is not equals null
    while (x != null) {
      y = x;
      //if the integer k is smaller than the root key
      if (k < x.key) {
        //insert the left node on x
        x = x.left;
      } else {
        //insert the right node on x
        x = x.right;
      }
    }

    //initiate child node object with the integer k as parameter
    Node child = new Node(k);

    //if y is not set
    if (y == null) {
      //set the root as the child because the root wasnt set yet then
      root = child;
    } else if (k < y.key) {
      //set the child node as the left node
      y.left = child;
    } else {
      //set the child node as the right node
      y.right = child;
    }

    //increment the variable count so we are aware if insertions
    count++;
  }

  /**
   * orderedTraversal returns an ordered array of the inserted integers
   * @return ordered array of integers
   */
  @Override
  public int[] orderedTraversal() {
    index = 0;
    return inorderedWalk(root, new int[count]);
  }

  /**
   * inorderedWalk is a recursive function which takes a node and the current
   * constructed array of ordered integers, it will then check the corresponding
   * left and rigth node and insert the key into the ordered list.
   * @param  node to get key and further check right and left nodes
   * @param  list is a array of ordered integers
   * @return array of ordered integers
   */
  private int[] inorderedWalk(Node node, int[] list) {
    //if the node is equals null we should do nothing
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
   * @param  k is a given integer to search for
   * @return boolean if the searched integer was found
   */
  @Override
  public boolean search(int k) {
    return walk(root, k) != null;
  }

  /**
   * Walk is a recursive function which takes a node and a corresponding integer
   * it will then compare the given integer with the given node key, if they
   * do not match call walk agian with the left or right child node
   * @param  node to compare with or call the childrens on
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
