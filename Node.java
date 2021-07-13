package collection;

public class Node<E> {

    E element;
    Node<E> nextNode;
    Node<E> prevNode;

    public Node(Node prevNode, E element, Node nextNode) {
        this.element = element;
        this.nextNode = nextNode;
        this.prevNode = prevNode;
    }

}
