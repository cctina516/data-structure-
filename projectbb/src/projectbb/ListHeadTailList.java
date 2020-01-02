package projectbb;
import java.util.List;
import java.util.ArrayList;

public class ListHeadTailList<T> implements HeadTailListInterface<T>{
	List<T> list;
	private int numberOfElements;
	
	public ListHeadTailList(int initialCapacity) {
		ArrayList<T> tempList = new ArrayList<>(initialCapacity);
		numberOfElements = 0;
	}
	
	public void addFront(T newEntry) {
		list.add(0, newEntry);
		numberOfElements++;
	}
	
	public void addBack(T newEntry) {
		list.add(newEntry);
		numberOfElements++;
	}
	
	public T removeFront() {
		if(!isEmpty())
            return list.remove(0);
        else
            return null;
	}
	
	public T removeBack() {
        if(!isEmpty())
            return list.remove(list.size()-1);
        else
            return null;
    }
	
	public boolean contains(T anEntry) {
	    return list.contains(anEntry);
	}
	
	public int indexOf(T anEntry) {
        return list.indexOf(anEntry);
    }
	
	public int lastIndexOf(T anEntry){
        return list.lastIndexOf(anEntry);
    }
	
	public T getEntry(int givenPosition) {
		if (givenPosition>=0 && givenPosition<list.size()) {
			return list.get(givenPosition);
		}
		else {
			return null;
		}
	}
	
	public void display() {
		System.out.print(numberOfElements + " elements; ");
		System.out.print("capacity " + "\t");
		if (!isEmpty()) {
			for (int i = 0; i < numberOfElements - 1; i++) {
				System.out.print(getEntry(i) + ", ");
			}
			System.out.println(getEntry(numberOfElements - 1));
		}
	}
	
    public void clear() {

        list.clear();
        numberOfElements = 0;
    }
	
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public int size() {
        return numberOfElements;
    }
	
}


