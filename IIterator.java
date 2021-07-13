
package collection;


public interface IIterator<E> {

    boolean hasNext();
    boolean hasPrevious();
    E next();      
    E previous() ;

}
