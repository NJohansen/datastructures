/**
 * DM507 Algoritmer og datastrukturer
 *
 * @author Niclas Westergaard Johansen, njoha17@student.sdu.dk
 * @author Frederik Kvartborg Albertsen, fralb17@student.sdu.dk
 */
public class Node {
  /**
   * Left child
   */
  public Node left;

  /**
   * Rigth child
   */
  public Node right;

  /**
   * Key contains the given integer value
   */
  public int key;

  /**
   * Index of node
   */
  public int index;

  /**
   * Construct a new node by giving it a key
   * @param key is the given integer
   */
  public Node(int key, int index) {
    this.key = key;
    this.index = index;
  }
}
