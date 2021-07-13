
package collection;

import java.util.NoSuchElementException;

public class CDLinkedListIterator<E> implements IIterator<E> {
    
    CircularDoublyLinkedList<E> cdll ;
    int position ;    
    Node<E> tempNode ;
    
    
    public CDLinkedListIterator(CircularDoublyLinkedList<E> cdll){ 
        this.cdll = cdll;
        tempNode = cdll.head ;
    }
    
    
    @Override
    public boolean hasNext(){  
      if (tempNode != cdll.tail && position <cdll.getSize())  return true; 
      else if (tempNode == cdll.tail && position <cdll.getSize())  return true;           
      else return false;    
    }


    @Override
    public E next(){         
       if (position >= cdll.getSize()) throw new NoSuchElementException();                
       E element = tempNode.element ;      
       tempNode = tempNode.nextNode ;  
        position++;
        return element;  
    }

    @Override
    public boolean hasPrevious() {          
      if (tempNode != cdll.head && position > 0)  return true; 
      else if (tempNode == cdll.head && position > 0)  return true;         
      else return false;    
    }
    
    
    @Override
    public E previous(){     
         tempNode = tempNode.prevNode ; 
        E element = tempNode.element ;                  
           if (position <= 0) throw new NoSuchElementException() ; 
        position--;
        return element;

    }
    
}


