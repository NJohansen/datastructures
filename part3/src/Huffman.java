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

    //this for loop fills the huffman tree by exctracting the min from the heap
    for (int i = 0; i < frequencies.length - 1; i++) {
      Element a = heap.extractMin();
      Element b = heap.extractMin();
      
      Dict tree = new DictBinTree(a, b);
      heap.insert(new Element(a.getKey() + b.getKey(), tree));
    }

    return (Dict) heap.extractMin().getData();
  }
}
