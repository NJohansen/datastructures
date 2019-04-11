import java.util.Scanner;

/**
 * DM507 Algoritmer og datastrukturer
 *
 * @author Niclas Westergaard Johansen, njoha17@student.sdu.dk
 * @author Frederik Kvartborg Albertsen, fralb17@student.sdu.dk
 */
public class Treesort {

  public static void main(String[] args) {

    //initiate DictBinTree object and assign it to dict
    Dict dict = new DictBinTree();

    //initiate scanner object to scan through the file
    Scanner sc = new Scanner(System.in);
    //as long as there is more ints in the file do this
    while (sc.hasNextInt()) {
      //insert the next int into the dictonary
      dict.insert(sc.nextInt());
    }

    // for each integer num in the orderedTraversal dictonary
    for (int num : dict.orderedTraversal()) {
      //print out the integer num
      System.out.println(num);
    }
  }

}
