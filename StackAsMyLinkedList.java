public class StackAsMyLinkedList<E> {
    MyLinkedList<E> theStack;
    
    public StackAsMyLinkedList() {
        theStack = new MyLinkedList<E>();
    }
    
    public void push(E newElement) {
        theStack.prepend(newElement);
    }
    
    public E pop() {
        E temp = null;
        boolean isDone = false;
        temp = theStack.getFirst();
        if (temp != null) {
            isDone = theStack.delete(temp);
        }
        if (isDone) {
            return temp;
        } else {
            return null;
        }
    }
    
    public E peek() {
        return theStack.getFirst();
    }
    
    public int size() {
     
        
        //using different approach since we can't access the private Node class 
       
        if (theStack.getFirst() == null) {
            return 0;
        }
        
        int count = 0;
        StackAsMyLinkedList<E> tempStack = new StackAsMyLinkedList<E>();
        
        // Pop Elements
        while (this.peek() != null) {
            tempStack.push(this.pop());
            count++;
        }
        
        // Push all elements back
        while (tempStack.peek() != null) {
            this.push(tempStack.pop());
        }
        
        return count;
    }
    
    public boolean isEmpty() {
        return theStack.getFirst() == null;
    }
    
    public String toString() {
        return theStack.toString();
    }
}