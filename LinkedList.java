package nl.hva.ict.ds;

/**
 * A linked list that adds elements to the end of the list and that retrieves elements from the end of the list as fast
 * as from the head of the list.
 * For example if a list contains 1000 elements the time needed to retrieve element at index 999 should be (almost) the
 * same as is needed for retrieving element at index 0. Retrieving element at index 800 should take (almost) the same
 * time as retrieving element at index 199.
 * When deleting an element all elements with the same value are deleted. So when deleting "don't" from a list that
 * contains<br/>
 * {"I", "don't", "like", "Datastructures", "as", "much", "as", "I", "don't", "like", "Sorting", "and", "Searching"}
 * this should result in a list containing:<br/>
 * {"I", "like", "Datastructures", "as", "much", "as", "I", "like", "Sorting", "and", "Searching"}
 *
 * @param <T> defines the type (class) that is stored in this list.
 */
public class LinkedList<T> {
    private class Node {
        private T value;
        private Node previous;
        private Node next;

        private Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
        
        private void setPrevious(Node previous) {
            this.previous = previous;
        }
    }
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    /**
     * Adds a new element to the end of this list. The performance of this method is guaranteed to be constant, in other
     * words, the number of elements already stored in the list should have no influence on the time needed to add a new
     * element.
     * @param element the element that is added to the list.
     */
    public void add(T element) {
        Node currentLast = tail;
        Node temp = new Node(element, null);
        tail = temp;
        
        if (currentLast == null) {
            head = temp;
            size++;
        }
        else { 
            currentLast.next = temp;
            currentLast.next.setPrevious(currentLast);
            size++;
        }
    }

    /**
     * Returns an element from the list. If the index is negative or the element does not exists
     * an IllegalArgumentException is throw containing the reason in the message.
     * @param index the index, counted from the first element, of the element that must be returned.
     */
    public T get(int index) {
        Node current;

        if (index >= 0 && index < size) {
            current = tail;
            for (int i = 0; i < index; i++) {
                current = current.previous;
            }
        } else {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }
    }
        else {
            throw new IllegalArgumentException("The index is out of bounds");
        }
        
        return node.value;
    }

    /**
     * Deletes the element (if it exists) from the list. In case of multiple occurrences all the occurrences are
     * deleted.
     * @param element the element to delete.
     */
    public void delete(T element) {
        delete(head, element);
    }
    
    private void delete(Node head, T element) {
        if (head == null) {
            System.out.println("no Nodes to remove");
        }
            else{
            if (head.value == element && head.next == null) {
                head = null;
                size--;
            } else if (head.value == element && head.next != null) {
                head = head.next;
                size--;
            } else {
                head = head.next;
            }
            delete(head, element);
        }
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in the list.
     */
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }

}
