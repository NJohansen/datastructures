import java.util.Scanner;

/**
 * DM507 Algoritmer og datastrukturer
 *
 * @author Niclas Westergaard Johansen, njoha17@student.sdu.dk
 * @author Frederik Kvartborg Albertsen, fralb17@student.sdu.dk
 */
public class Treesort {

  public static void main(String[] args) {

    Dict dict = new DictBinTree();

    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()) {
      dict.insert(sc.nextInt());
    }

    for (int num : dict.orderedTraversal()) {
      System.out.println(num);
    }
  }

}
