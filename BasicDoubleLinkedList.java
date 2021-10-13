
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

 
public class BasicDoubleLinkedList<T> implements Iterable<T> {
  protected Node one;
  protected Node two;
  protected int size;

  public BasicDoubleLinkedList() {
    this.one = null;
    this.two = null;
    this.size = 0;
  }

  
  public BasicDoubleLinkedList<T> addToEnd(T data) {
    Node newtwo = new Node(data);

    if (size == 0) {
     one = newtwo;
      two =one;
    } else {
      two.next = newtwo;
      newtwo.prev = two;
      two = newtwo;
    }
    size++;
    return this;
  }

   
  public BasicDoubleLinkedList<T> addToFront(T data) {
    Node newHead = new Node(data);
    if (size == 0) {
     one = newHead;
      two =one;
    } else {
     one.prev = newHead;
      newHead.next =one;
     one = newHead;
    }
    size++;
    return this;
  }

 
  public T getLast() {
    if (size == 0) {
      return null;
    }
    return two.data;
  }

  public T getFirst() {
	    if (size == 0) {
	      return null;
	    }
	    return one.data;
	  }

  
  public int getSize() {
    return size;
  }

   
  public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
    return new NodeIterator();
  }

   
  public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {
    Node cNode =one;
    
    while (cNode != null) {
    	
      if (comparator.compare(targetData, cNode.data) == 0) {
        if (cNode ==one) {
         one =one.next;
        } else if (cNode == two) {
          two = two.prev;
        } else {
          cNode.prev.next = cNode.next;
        }
        size--;
        return this;
      }
      cNode = cNode.next;
    }
    
    return this;
  }

  public ArrayList<T> toArrayList() {
	    ArrayList<T> list = new ArrayList<>();
	    Node cNode =one;

	    while (cNode != null) {
	      list.add(cNode.data);
	      cNode = cNode.next;
	    }
	    return list;
	  }
   
  public T retrieveFirstElement() {
    if (size == 0) {
      return null;
    }
    T first =one.data;
    if (size == 1) {
     one = null;
      two = null;
    } else {
     one =one.next;
     one.prev = null;
    }
    size--;
    return first;
  }

  
  public T retrieveLastElement() {
    if (size == 0) {
      return null;
    }
    T last = two.data;
    if (size == 1) {
     one = null;
      two = null;
    } else {
      two = two.prev;
      two.next = null;
    }
    size--;
    return last;
  }

  
  public class Node {
    protected Node prev;
    protected Node next;
    protected T data;

    public Node(T data) {
      this.prev = null;
      this.next = null;
      this.data = data;
    }
  }

  
  public class NodeIterator implements ListIterator<T> {

    protected Node current =one;
    protected Node last;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public T previous() throws NoSuchElementException {
      if (hasPrevious()) {
        current = last;
        last = last.prev;
        return current.data;
      }
      throw new NoSuchElementException("No previous elements available in List");
    }
    
    
    @Override
    public boolean hasPrevious() {
      return last != null;
    }

    
    @Override
    public T next() throws NoSuchElementException {
      if (hasNext()) {
        last = current;
        current = current.next;
        return last.data;
      }
      throw new NoSuchElementException("No next elements available in List");
    }

    @Override
    public int nextIndex() throws UnsupportedOperationException {
      throw new UnsupportedOperationException();
    }

    @Override
    public int previousIndex() throws UnsupportedOperationException {
      throw new UnsupportedOperationException();
    }

    @Override
    public void remove() throws UnsupportedOperationException {
      throw new UnsupportedOperationException();
    }

    @Override
    public void set(T data) throws UnsupportedOperationException {
      throw new UnsupportedOperationException();
    }

    @Override
    public void add(T data) throws UnsupportedOperationException {
      throw new UnsupportedOperationException();
    }

  }

}