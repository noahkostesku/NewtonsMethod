public class OrderedLinkedList<T extends Comparable<T>> {
	
	private Node<T> head;
	private int size;
	
	public OrderedLinkedList() {
		head = null;
		size = 0;	
	}
	
	public void insert(T value)  {
	
		Node<T> newNode = new Node<>(value, null);
		
        if (head == null || head.getData().compareTo(value) <= 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node<T> currentNode = head;
            while (currentNode.getNext() != null && currentNode.getNext().getData().compareTo(value) > 0) {
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
        }
        size++;
	}
	
	public T get(int i){
		
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("The value at index" + i + " is out of range.");
		}
		
		int count = 0;
		Node<T> currentNode = head;
		
		for (int j = 0; j < i; j++) {
			currentNode = currentNode.getNext();
			count++;
			
	        if (count - 1  == i) {
	            return currentNode.getData();
	        } 
	
		}
		return currentNode.getData();
	}
	public int getSize() {
		return size;
	}

}
