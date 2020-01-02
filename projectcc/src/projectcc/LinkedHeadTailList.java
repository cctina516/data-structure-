package projectcc;

public class LinkedHeadTailList<T> implements HeadTailListInterface<T> {

	private Node head, tail;
   
	public LinkedHeadTailList() {
		head = null;
		tail = null;
	}

	public void addFront(T newEntry) {
		Node newNode = new Node(newEntry);

		if (isEmpty()) {
			head = newNode;
			tail = head;
		}
		else {
			newNode.setNextNode(head);
			head = newNode;
		}
	}

	public void addBack(T newEntry) {
		Node newNode = new Node(newEntry);

		if (isEmpty()) {
			head = newNode;
			tail = head;
		}
		else {
			tail.setNextNode(newNode);
			tail = newNode;
		}
	}


	public T removeFront() {
		Node tempNode = head;

		if (isEmpty()) {
			return null;
		}
			else {
				if (size() > 1) {
					head = head.getNextNode();
					tempNode.setNextNode(null);	
				}
				else {
					tail = null;
					head = null;
				}
				return tempNode.getData();
			}		
		}


	public T removeBack() {
		Node tempNode = head;

		if (isEmpty()) {
			return null;
		}
		else {
			if (size() > 1) {
				tempNode = tempNode.getNextNode();
			
				tail = tempNode;
				tempNode = tempNode.getNextNode();
				tail.setNextNode(null);
				}
			
				else {
						tail = null;
						head = null;
				}
		return tempNode.getData();
	 }
	}
	
	public boolean contains(T anEntry) {
		Node currentNode = head;

		if (isEmpty()) {
			return false;
		}
		else {
			while (currentNode != null) {
				if(currentNode.getData().equals(anEntry)) {
					return true;
				}
				currentNode = currentNode.getNextNode();
			}
		}
		return false;
	}

	public int indexOf(T anEntry) {
		Node currentNode = head;
		int index = 0;

		while (currentNode != null) {
			if(currentNode.getData().equals(anEntry)) {
				return index;
			}
			currentNode = currentNode.getNextNode();
			index++;
		}
		
		return 0;
	}
	
	public int lastIndexOf(T anEntry) {
		Node currentNode = head;
		int index = 0;
		int firstNum = 0, lastNum = 0;


		while(currentNode != null) {
			if (currentNode.getData().equals(anEntry)) {
				if (firstNum == -1) {
					firstNum = index;
				}
				else {
					lastNum = index;
				}
			}
			currentNode = currentNode.getNextNode();
		}
		
		return 0;
	}
	
	public T getEntry(int givenPosition) {
		Node given = head;

		if (givenPosition < 0) {
			return null;
		}

		for (int index = 0; index < givenPosition; index++) {
			if (given.getNextNode() != null) {
				given = given.getNextNode();
			}
			else {
				return null;
			}
		}
		
		return given.getData();
	}
	
	public void display() {
		Node currentNode = head;

		System.out.print("[");

		while (currentNode != null) {
			System.out.print(currentNode.getData());

			if (currentNode.getNextNode() != null) {
				System.out.print(" , ");
			}
			currentNode = currentNode.getNextNode();
		}	
	
		System.out.print("]");
		
		if (!isEmpty()) {
			System.out.println("\thead= " + head.getData() + " tail= " + tail.getData());
		}
	}

	public void clear() {
		if (!isEmpty()) {
			Node tempNode = head;

			while (tempNode.getNextNode() != null) {
				head = head.getNextNode();

				tempNode.setNextNode(null);
				tempNode.setData(null);
				tempNode = head;
			}
			tempNode.setNextNode(null);
			tempNode.setData(null);
			tempNode = null;
			head = null;
			tail = null;
		}
	}
	
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}

		return false;
	}

	public int size() {
		Node tempNode = head;
		int count = 0;

		while (tempNode != null) {
			count++;
			tempNode = tempNode.getNextNode();
		}

		return count;
	}
			
	private class Node {
		private T data; 
		private Node next; 

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		}

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}

		private T getData() {
			return data;
		}

		private void setData(T newData) {
			data = newData;
		}

		private Node getNextNode() {
			return next;
		}

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} 
	}

}

