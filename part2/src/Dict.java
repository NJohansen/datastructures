/**
 * DM507 Algoritmer og datastrukturer
 *
 * @author Niclas Westergaard Johansen, njoha17@student.sdu.dk
 * @author Frederik Kvartborg Albertsen, fralb17@student.sdu.dk
 */
public interface Dict {
  public void insert(int k);

  public int[] orderedTraversal();

  public boolean search(int k);
}
