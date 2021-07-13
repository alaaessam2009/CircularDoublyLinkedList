
package collection;

public abstract class AbstractLinkedList<E> implements IDoublyLinkedList<E>{
    
  protected Node<E> head, tail ;
  protected int size ;
    
  public void add(int index, E element){
        if (index < 0 || index > size-1)            
           throw new IndexOutOfBoundsException("index must be >= 0 and <= "+String.valueOf(size-1));
        else if (index==0) 
            addFirst(element);     
        else if (index == size)
            addLast(element);    
        else {
           Node<E> tempNode = head ;          
            for (int i = 0; i < index-1 ; i++)             
                tempNode = tempNode.nextNode ;             
            Node<E> newNode = new Node<>(tempNode, element, tempNode.nextNode);            
            tempNode.nextNode.prevNode = newNode;         
            tempNode.nextNode = newNode;           
            size++;                     
        }
     }
     
   public E delete(int index){
        if (index < 0 || index > size-1)            
           throw new IndexOutOfBoundsException("index must be >= 0 and <= "+String.valueOf(size-1));
        else if (index == 0) 
          return deleteFirst();    
        else if (index == size-1)
            return deleteLast();       
        else {                   
             Node<E> tempNode = head ;            
              for (int i = 0; i < index-1 ; i++)          
                 tempNode = tempNode.nextNode ;    
     
              Node<E> targetDeleted= tempNode.nextNode ; 
              Node<E> afterDeletedNode = tempNode.nextNode.nextNode ;   
              
               E element = targetDeleted.element; 
               targetDeleted.element = null;
               targetDeleted.prevNode = null;
               targetDeleted.nextNode = null;  
                
               tempNode.nextNode= afterDeletedNode;              
               afterDeletedNode.prevNode = tempNode ;             
             
               size-- ;         
          return element ;  
        }
     }
  
     public E getFirst()  {
        return head.element ;
     }
    
     public E getLast()  {
        return tail.element ;
     }
        
  
    public int getSize(){
        return size ;
    }
    
      public E get(int index){  
      if (index < 0 || index > size-1) 
         throw new IndexOutOfBoundsException("index must be >= 0 and <= "+String.valueOf(size-1));
      else if (index == 0 ) return head.element ;
      else if (index == size-1) return tail.element ;  
      else {
         Node<E> tempNode = head ;              
         for (int i = 0; i < index ; i++)             
             tempNode = tempNode.nextNode ;        
         return tempNode.element ;  
      }  
    }
          
    public E set(int index, E element) {
        E replacedElement;
        if (index < 0 || index > size - 1) 
            throw new IndexOutOfBoundsException("index must be >= 0 and <= " + String.valueOf(size - 1));
        else if (index == 0) {
            replacedElement = head.element;
            head.element = element;
        } 
        else if (index == size - 1) {
            replacedElement = tail.element;
            tail.element = element;
        } 
        else {
            Node<E> tempNode = head;
            for (int i = 0; i < index; i++) 
                tempNode = tempNode.nextNode;
            replacedElement = tempNode.element;
            tempNode.element = element;
        }
        return replacedElement;
    }

    public boolean isEmpty() {
        return size == 0 ;
    }
    
    @Override
    public void clear() {
        while (head!=tail)        
            deleteFirst(); 
        deleteFirst();
    }
    
     @Override
     public boolean contain(E element) { 
      Node<E> tempNode = head ;
      
      while ( tempNode != tail)        
          if (element == tempNode.element ) return true;           
          else tempNode = tempNode.nextNode ;

     if (element == tempNode.element ) return true;  
     else return false ;    
  }
     
    @Override
    public String toString() {          
        if (head == null)
           return "[]";       
        
       StringBuilder elements = new StringBuilder  ("[") ;
     
        IIterator itr = iterator() ;
        while (itr.hasNext())
            elements = elements.append(itr.next() + ", ");
        
        elements.setCharAt(elements.lastIndexOf(","), ']');
       return  elements.toString() ; 
    }
      
}
