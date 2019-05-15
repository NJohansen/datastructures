/**
 * DM507 Algoritmer og datastrukturer
 *
 * @author Niclas Westergaard Johansen, njoha17@student.sdu.dk
 * @author Frederik Kvartborg Albertsen, fralb17@student.sdu.dk
 */
public class Huffman {
  /**
   * Initialize a new huffman tree from a frequency table
   * @param  frequencies table
   * @return Dict which is a new huffman tree
   */
  public static Dict init(int[] frequencies) {
    //initializes the heap with the same size as the frequencies array
    PQ heap = new PQHeap(frequencies.length);

    //fill the heap with elements
    for (int i = 0; i < frequencies.length; i++) {
      heap.insert(new Element(frequencies[i], i));
    }

    // Extract two minimum elements from the heap and construct the huffman tree
    for (int i = 0; i < frequencies.length - 1; i++) {
      Element a = heap.extractMin();
      Element b = heap.extractMin();

      Dict tree = new DictBinTree(a, b);
      heap.insert(new Element(a.getKey() + b.getKey(), tree));
    }

    return (Dict) heap.extractMin().getData();
  }
}
