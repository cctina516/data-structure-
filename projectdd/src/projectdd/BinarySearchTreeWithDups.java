package projectdd;


import java.util.*;

public class BinarySearchTreeWithDups<T extends Comparable<? super T>> extends BinarySearchTree<T>
		implements SearchTreeInterface<T>, java.io.Serializable {

	public BinarySearchTreeWithDups() {
		super();
	}

	public BinarySearchTreeWithDups(T rootEntry) {
		super(rootEntry);
		setRootNode(new BinaryNode<T>(rootEntry));
	}

	@Override
	public T add(T newEntry) {
		T result = newEntry;
		if (isEmpty()) {
			setRootNode(new BinaryNode<T>(newEntry));
		} else {
			addEntryHelperNonRecursive(newEntry);
		}
		return result;
	}
	
	// YOUR CODE HERE! THIS METHOD CANNOT BE RECURSIVE.
	private void addEntryHelperNonRecursive(T newEntry) {
		
		boolean inserted = false;
		int comparison;
		BinaryNode<T> currentNode = getRootNode();
		
		while (!inserted) {
			comparison = newEntry.compareTo(currentNode.getData());
			if (comparison > 0) {
				if (currentNode.hasRightChild()) {
					currentNode = currentNode.getRightChild();
				}
				else {
					currentNode.setRightChild(new BinaryNode<>(newEntry));
					inserted = true;
				}
			}
			else{
				if (currentNode.hasLeftChild()) {
					currentNode = currentNode.getLeftChild();
				}
				else {
					currentNode.setLeftChild(new BinaryNode<>(newEntry));
					inserted = true;
				}
				
			}
			}
		}


	// YOUR CODE HERE! THIS METHOD CANNOT BE RECURSIVE.
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countEntriesNonRecursive(T target) {
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNode<T> currentNode = getRootNode();
		int compare;
		
		while (currentNode != null) {
			
			compare = target.compareTo(currentNode.getData());
			
			if (compare == 0) {
				count ++;
			}
			if (compare > 0) {
				currentNode = currentNode.getRightChild();
			}
			else {
				currentNode = currentNode.getLeftChild();
			}
		}

		// consider a loop!
		
		return count;
	}

	// YOUR CODE HERE! MUST BE RECURSIVE! YOU ARE ALLOWED TO CREATE A PRIVATE HELPER.
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countGreaterRecursive(T target) {
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNode<T> rootNode = getRootNode();
		
		if (rootNode != null) {
			while (rootNode.hasRightChild() && target.compareTo(rootNode.getData()) > 0) {
				rootNode = rootNode.getRightChild();
			}
			count = countHelper(rootNode, target);
		}	
		// consider a helper method!
		
		return count;
	}
	
	private int countHelper(BinaryNode<T> node, T target) {
		if (node == null) {
			return 0;
		}
		int comparison = target.compareTo(node.getData());
		int count = 0;
		
		count += countHelper(node.getLeftChild(), target) + countHelper(node.getRightChild(), target);
		return count;
	}
		
	// YOUR CODE HERE! MUST USE A STACK!! MUST NOT BE RECURSIVE! 
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countGreaterWithStack(T target) {
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNode<T> rootNode = getRootNode();
		Stack<BinaryNode<T>> nodeStack = new Stack<BinaryNode<T>>();
		nodeStack.push(rootNode);
		
		if (rootNode != null) {
			while (rootNode.hasRightChild() && target.compareTo(rootNode.getData()) > 0) {
				rootNode = rootNode.getRightChild();
			}
		}
		while (nodeStack.size() > 0 || rootNode != null) {
			while (rootNode != null) {
				rootNode = rootNode.getLeftChild();
			}
			rootNode = nodeStack.pop();
			while (target.compareTo(rootNode.getData()) < 0) {
				count++;
			}
			rootNode = rootNode.getRightChild();
			rootNode = nodeStack.pop();
		}

		// consider a loop based on the stack!
		return count;
	}
		
	// YOUR EXTRA CREDIT CODE HERE! THIS METHOD MUST BE O(n). 
	// YOU ARE ALLOWED TO USE A HELPER METHOD. THE METHOD CAN BE ITERATIVE OR RECURSIVE. 
	public int countUniqueValues() {
		int count = 0;
		BinaryNode<T> rootNode = getRootNode();
		
		if (rootNode != null) {
			List<T> uniqueValueList = new ArrayList<>();
			count = countUniqueHelper(rootNode, uniqueValueList);
		}
		return count;
	}
	private int countUniqueHelper(BinaryNode<T> node, List<T> uniqueValues) {
		while(node != null) {
			if(!uniqueValues.contains(node.getData())) {
				uniqueValues.add(node.getData());
			}
			countUniqueHelper(node.getRightChild(), uniqueValues);
			countUniqueHelper(node.getLeftChild(), uniqueValues);
			
			return uniqueValues.size();
		}
		
		return 0;		
	}
	
	
	public int getLeftHeight() {
		BinaryNode<T> rootNode = getRootNode();
		if(rootNode==null) {
			return 0;
		} else if(!rootNode.hasLeftChild()) {
			return 0;
		} else {
			return rootNode.getLeftChild().getHeight();
		}
	}

	public int getRightHeight() {
		BinaryNode<T> rootNode = getRootNode();
		if(rootNode==null) {
			return 0;
		} else if(!rootNode.hasRightChild()) {
			return 0;
		} else {
			return rootNode.getRightChild().getHeight();
		}
	}
	


}

