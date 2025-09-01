public class QueueAsMyLinkedList<E> {
    MyLinkedList<E> theQueue;
    
    public QueueAsMyLinkedList() {
        theQueue = new MyLinkedList<>();
    }
    
    public void enqueue(E newElement) {
        theQueue.append(newElement);
    }
    
    public E dequeue() {
        E temp = null;
        boolean isDone = false;
        temp = theQueue.getFirst();
        if (temp != null) {
            isDone = theQueue.delete(temp);
        }
        if (isDone) {
            return temp;
        } else {
            return null;
        }
    }
    
    public E peek() {
        return theQueue.getFirst();
    }
    
    public int size() {
        // Count elements by dequeuing and re-enqueuing them
        if (isEmpty()) {
            return 0;
        }
        
        int count = 0;
        MyLinkedList<E> tempList = new MyLinkedList<E>();
        
        // Remove all elements and count them
        while (!isEmpty()) {
            E element = dequeue();
            if (element != null) {
                tempList.append(element);
                count++;
            }
        }
        
        // Put all elements back
        while (tempList.getFirst() != null) {
            E element = tempList.getFirst();
            theQueue.append(element);
            tempList.delete(element);
        }
        
        return count;
    }
    
    public boolean isEmpty() {
        return theQueue.getFirst() == null;
    }
    
    public String toString() {
        return theQueue.toString();
    }
}