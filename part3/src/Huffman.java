public class Huffman {
  /**
   * Initialize a new huffman three from a frequency table
   * @param  frequencies table
   * @return Dict which is a new huffman tree
   */
  public static Dict init(int[] frequencies) {
    PQ heap = new PQHeap(frequencies.length);

    for (int i = 0; i < frequencies.length; i++) {
      heap.insert(new Element(frequencies[i], i));
    }

    for (int i = 0; i < frequencies.length - 1; i++) {
      Element a = heap.extractMin();
      Element b = heap.extractMin();

      Dict tree = new DictBinTree(a, b);
      heap.insert(new Element(a.getKey() + b.getKey(), tree));
    }

    return (Dict) heap.extractMin().getData();
  }
}
