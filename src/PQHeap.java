package PQ;

public class PQHeap implements PQ {

  private Element[] elements;
  private int heapSize = -1;

  public PQHeap(int maxElms) {
    elements = new Element[maxElms];
  }

  @Override
  public Element extractMin() {
    Element min = elements[0];

    elements[0] = elements[heapSize];
    heapSize--;
    minHeapify(0);

    return min;
  }

  @Override
  public void insert(Element e) {
    heapSize++;
    elements[heapSize] = e;

    increaseKey(e);
  }

  public void increaseKey(Element e){
    int i = heapSize;
    if(elements[parent(i)] == null){
      return;
    }
    while(i > 0 && elements[parent(i)].getKey() > elements[i].getKey()){
      Element temp = elements[i];
      elements[i] = elements[parent(i)];
      elements[parent(i)] = temp;
      i = parent(i);
    }
  }

  public void minHeapify(int i){
    int l = left(i);
    int r = right(i);
    int minimum;

    if(l <= heapSize && elements[l].getKey() < elements[i].getKey()){
      minimum = l;
    } else{
      minimum = i;
    }

    if(r <= heapSize && elements[r].getKey() < elements[minimum].getKey()){
      minimum = r;
    }

    if(minimum != i){
      Element temp = elements[minimum];
      elements[minimum] = elements[i];
      elements[i] = temp;

      minHeapify(minimum);
    }

  }

  private int parent(int i){
    return i / 2;
  }

  private int left(int i){
    return i * 2;
  }

  private int right(int i){
    return i * 2 + 1;
  }

}
