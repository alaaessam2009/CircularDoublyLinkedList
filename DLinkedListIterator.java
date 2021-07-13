
package collection;

import java.util.NoSuchElementException;

public class DLinkedListIterator<E> implements IIterator<E>{

    DoublyLinkedList<E> dll ;  
    Node<E> tempNode ;
    int position;
  
    
    public DLinkedListIterator(DoublyLinkedList<E> dll) {
        this.dll = dll;
        tempNode = dll.head ;
    }
            
    @Override
    public boolean hasNext() {
       return position < dll.getSize();  
    }
    
    @Override
    public boolean hasPrevious() {                 
      return position > 0 ;     
    }
  
    @Override
    public E next() {    
     if (tempNode == null && position == 0 ) tempNode = dll.head ;
     else if (tempNode == null && position == dll.getSize()) throw new NoSuchElementException();
     E element = tempNode.element ; 
     tempNode = tempNode.nextNode ; 
     position++;
     return element ;        
  }


    public E previous(){      
         if (tempNode == null && position == 0 ) throw new NoSuchElementException() ;
         else if (tempNode == null && position == dll.getSize()){
              tempNode = dll.tail;
               position--;
              return tempNode.element;
         }   
        tempNode = tempNode.prevNode ;        
        if (tempNode == null)  throw new NoSuchElementException() ;
        E element = tempNode.element ;
         position--;
        return element ;    
    }


}


