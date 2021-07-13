
package collection;

public interface IDoublyLinkedList<E> {
    
    void addFirst(E element);

    void addLast(E element);

    E deleteFirst();

    E deleteLast();

    E getFirst();

    E getLast();

    E get(int index);

    E set(int index, E element);

    IIterator iterator();

    int getSize();

    boolean isEmpty();
    
    boolean contain(E element);

    void clear();

}


