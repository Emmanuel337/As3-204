import java.util.Comparator;
import java.util.ListIterator;
 
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> implements Iterable<T> {

  private Comparator<T> comparator;

  
  
  public SortedDoubleLinkedList(Comparator<T> comparator) {
    this.comparator = comparator;
  }
  
  public SortedDoubleLinkedList<T> add(T data) {
	    Node newNode = new Node(data);
	    Node cNode = one;

    
    if (size == 0) {
      one = newNode;
      two = one;
      size++;
      return this;
  
    } else if (comparator.compare(one.data, data) > 0) {
      newNode.next = one;
      one.prev = newNode;
      one = newNode;
      size++;
      return this;
 
    } else {
      while (comparator.compare(cNode.data, data) < 0) {
  
        if (cNode.next == null) {
          cNode.next = newNode;
          newNode.prev = cNode;
          two = newNode;
          size++;
          return this;
        } else {
          cNode = cNode.next;
        }
      }
   
      cNode.prev.next = newNode;
      newNode.prev = cNode.prev;
      cNode.prev = newNode;
      newNode.next = cNode;
      size++;
      return this;
    }
  }

  
  @Override
  public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
    return (SortedDoubleLinkedList<T>) super.remove(data, comparator);
  }

  
  @Override
  public ListIterator<T> iterator() {
    return super.iterator();
  }

   
  @Override
  public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Invalid operation for sorted list");
  }

   
  @Override
  public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Invalid operation for sorted list");

  }

}