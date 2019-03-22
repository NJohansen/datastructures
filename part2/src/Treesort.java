import java.util.Scanner;

public class Treesort {

  public static void main(String[] args) {

    Dict dict = new DictBinTree();

    int n = 0;
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()) {
      dict.insert(sc.nextInt());
      n++;
    }

    for (int num : dict.orderedTraversal()) {
      System.out.println(num);
    }
  }

}
