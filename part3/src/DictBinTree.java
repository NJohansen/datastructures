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
   * Index is used to construct an ordered array of integers when we
   * walk the tree
   */
  private int index;

  /**
   * Build the keyword code for each node
   */
  public StringBuilder keyword = new StringBuilder();

  public DictBinTree(Element a, Element b) {
    root = new Node(a.getKey() + b.getKey(), -1);

    if (a.getData() instanceof Dict) {
      root.left = ((Dict) a.getData()).getRoot();
    } else {
      root.left = new Node(a.getKey(), Integer.parseInt(a.getData().toString()));
    }

    if (b.getData() instanceof Dict) {
      root.right = ((Dict) b.getData()).getRoot();
    } else {
      root.right = new Node(b.getKey(), Integer.parseInt(b.getData().toString()));
    }
  }

  /**
   * Traverse the tree of nodes and create an array of strings containing the
   * codes for each index which coresponds to an character.
   * @return list of codes
   */
  @Override
  public String[] orderedTraversal() {
    return orderedWalk(root, new String[256]);
  }

  /**
   * ordered walk is a recursive function which walks the tree of nodes and creates
   * its codes by adding a 0 if it walks left and otherwise adds 1 if it walks
   * right
   * @param  node to walk
   * @param  list current list of codes
   * @return list of codes
   */
  private String[] orderedWalk(Node node, String[] list) {
      if (node != null) {
        index = node.index;

        keyword.append("0");
        orderedWalk(node.left, list);

        keyword.append("1");
        orderedWalk(node.right, list);

        if (node.index != -1) {
          list[index] = keyword.toString();
        }
      }

      return list;
  }

  /**
   * Get root of tree
   * @return root node
   */
  public Node getRoot() {
    return root;
  }
}
