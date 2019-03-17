/**
 * DM507 Algoritmer og datastrukturer
 *
 * @author Niclas Westergaard Johansen, njoha17@student.sdu.dk
 * @author Frederik Kvartborg Albertsen, fralb17@student.sdu.dk
 */
public class PQHeap implements PQ {

  // Array with the object type Element
  private Element[] elements;
  // The current heap size
  private int heapSize = -1;

  /**
   * The constructor for the class which initializes the object.
   * @param maxElms defines the max size of the array.
   */
  public PQHeap(int maxElms) {
    elements = new Element[maxElms];
  }

  /**
   * Extract the smallest Element from the array or heap and then decrease the
   * size of the array or heap.
   * @return the smallest Element from the array after it has been heapified.
   */
  @Override
  public Element extractMin() {

    // The minimum Element min is assigned to index 0 in the array elements.
    Element min = elements[0];

    // Index 0 in elements is set to the highest Element.
    elements[0] = elements[heapSize];

    // Decrease the size of the heap
    heapSize--;

    // Use the method minHeapify() to
    //TODO
    minHeapify(0);

    // Returns the smallest Element from the heap
    return min;
  }

  /**
   * Insert Element e into the heap
   * @param e is an Element which gets inserted into the array/heap.
   */
  @Override
  public void insert(Element e) {

    //First increase the size of the heap with 1
    heapSize++;

    // Insert the new Element e in the heap on the highest index.
    elements[heapSize] = e;

    increaseKey(e);
  }

  public void increaseKey(Element e) {
    int i = heapSize;
    if (elements[parent(i)] == null) {
      return;
    }
    while (i > 0 && elements[parent(i)].getKey() > elements[i].getKey()) {
      Element temp = elements[i];
      elements[i] = elements[parent(i)];
      elements[parent(i)] = temp;
      i = parent(i);
    }
  }

  /**
   *
   * @param i
   */
  public void minHeapify(int i) {
    int l = left(i);
    int r = right(i);
    int minimum;

    if (l <= heapSize && elements[l].getKey() < elements[i].getKey()) {
      minimum = l;
    } else {
      minimum = i;
    }

    if (r <= heapSize && elements[r].getKey() < elements[minimum].getKey()) {
      minimum = r;
    }

    if (minimum != i) {
      Element temp = elements[minimum];
      elements[minimum] = elements[i];
      elements[i] = temp;

      minHeapify(minimum);
    }

  }

  /**
   * Get the index of the parent
   * @param i int which is the index
   * @return the parent index
   */
  private int parent(int i) {
    return i / 2;
  }

  /**
   * Get the index of the element to the left
   * @param i int which is the index
   * @return index of the element to the left
   */
  private int left(int i) {
    return i * 2;
  }

  /**
   * Get the index of the element to the right
   * @param i int which is the index
   * @return index of the element to the right
   */
  private int right(int i) {
    return i * 2 + 1;
  }

}
