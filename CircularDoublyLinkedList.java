
package collection;

import java.util.NoSuchElementException;

public final class CircularDoublyLinkedList<E> extends AbstractLinkedList<E>{
    
      private void addElementforFirstTime(E element ){         
         Node<E> newNode = new Node<>(null, element ,null );      
         newNode.prevNode = newNode;
         newNode.nextNode = newNode;
         tail = newNode;      
         head = newNode;      
      }
        
    @Override
     public void addFirst(E element){                                 
         if (tail == null) addElementforFirstTime(element) ;  
         else {            
          Node<E> newNode = new Node<>(tail, element ,head );    
          head.prevNode = newNode;          
          tail.nextNode = newNode; 
          head = newNode;
         }       
         size++;
     }
     

    @Override
     public void addLast(E element){   
        if (tail == null) addElementforFirstTime(element) ;    
        else {           
        Node<E> newNode = new Node<>(tail, element ,head);    
        head.prevNode = newNode;      
        tail.nextNode = newNode;         
        tail = newNode; 
        }       
         size++;        
     }
    
    
     @Override
     public E deleteFirst(){            
         E element ;
         // test if linked list no conatian any element
         if (tail == null) 
            throw new NoSuchElementException("list is empty");      
         // test if linked list conatian one element
          else if (head == tail )  element = deleteHeadTailNode() ;    
          else {     
                Node<E> tempNode = head.nextNode;                     
                tempNode.prevNode =tail ;
                tail.nextNode = tempNode ;             
                head.prevNode = null;                
                element = head.element ;
                head.element = null;             
                head.nextNode = null ;              
                head = tempNode ;              
            }
           size--;
           return element ;
     }
         

     @Override
     public E deleteLast(){     
          E element ;
         // test if linked list no conatian any element
         if (tail == null) 
            throw new NoSuchElementException("list is empty"); 
          // test if linked list conatian one element
           else if (head == tail )  element = deleteHeadTailNode() ;                      
           else {        
                Node<E> tempNode = tail.prevNode;                     
                tempNode.nextNode = head ;
                head.prevNode = tempNode ;               
                element = tail.element ;
                tail.prevNode = null;
                tail.element = null;
                tail.nextNode = null ;           
                tail = tempNode ;     
           } 
         size-- ;
         return element ;
     }
        
       
     private E deleteHeadTailNode(){    
        head.prevNode = null;
        E element =  head.element ;         
        head.element = null;   
        head.nextNode = null;
        head = null;
        tail = null ;
       return element ;  
     }
     
      @Override
       public IIterator iterator (){      
           return new CDLinkedListIterator(this) ;         
       }       
}


