package collection;


import java.util.NoSuchElementException;

public final class DoublyLinkedList<E> extends AbstractLinkedList<E> {

    @Override
    public void addFirst(E element){
        Node<E> newNode = new Node<>(null, element, head);
         if (head == null){
           head = newNode;
           tail = newNode;
         }   
         else {
            head.prevNode = newNode;
            head = newNode;
         }    
        size++;
    }
    
    @Override
    public void addLast(E element){    
         Node<E> newNode = new Node<>(tail, element, null);   
          if (head == null) {
             head = newNode;
             tail = newNode;
          }            
          else {
            tail.nextNode = newNode;
            tail = newNode;
          }
        size++;
    }
    
    @Override
      public E deleteFirst() {  
        if (head == null) 
            throw new NoSuchElementException("list is empty");
        E element = head.element;
        Node<E> tempNode = head;
        head = head.nextNode;
        tempNode.element = null;
        if (head == null)  tail = null;
        else {
          tempNode.nextNode = null;
          head.prevNode = null;
        }
        size--;
        return element;
    }
   
    @Override
    public E deleteLast(){      
      if (head == null) 
          throw new NoSuchElementException("list is empty");   
       E element = tail.element;      
       Node<E> tempNode = tail;
       tail = tail.prevNode;
      
       tempNode.element =null;   
       if (tail == null) head = null;  
       else{
           tempNode.prevNode =null;
           tail.nextNode = null;
       }
       size--;
       return element;
    }
   
    @Override
    public IIterator iterator () {      
         return new DLinkedListIterator(this) ;         
     }

}