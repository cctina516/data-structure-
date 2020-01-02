package projectbb;
import java.util.Arrays;

public class ArrayHeadTailList<T> implements HeadTailListInterface<T> {
    private T[] listArray;
    private int numberOfElements;


    public ArrayHeadTailList(int initialCapacity) {

        @SuppressWarnings("unchecked")
        T[] tempArray = (T[])new Object[initialCapacity];
        listArray = tempArray;
        numberOfElements = 0;
    }

    public void addFront(T newEntry) {
   
        for (int index = numberOfElements - 1; index >= 0; index--) {
            listArray[index + 1] = listArray[index];
        }
        listArray[0] = newEntry;
        numberOfElements++;
        ensureCapacity();
    }
    
    private void ensureCapacity() {
    	int capacity = listArray.length-1;
        int newCapacity;

        if (numberOfElements >= capacity) {
        	newCapacity = 2 * listArray.length;
            listArray = Arrays.copyOf(listArray, newCapacity);
        }
    }


    public void addBack(T newEntry) {

        ensureCapacity();
        listArray[numberOfElements] = newEntry;
        numberOfElements++;
    }


    public T removeFront() {
    	T result = null;
		if (!isEmpty()) {
			result = listArray[0];
			for (int index = 1; index < numberOfElements; index++) {
				listArray[index - 1] = listArray[index];
			}
			listArray[numberOfElements] = null;
			numberOfElements--;
		}
		return result;
	}


    public T removeBack() {
		T newList = null;
		if (!isEmpty()) {
			if (numberOfElements == 1) {
				newList = listArray[0];
                listArray[0] = null;
		}
			else {
				newList = listArray[numberOfElements];
				listArray[numberOfElements] = null;
			}
			numberOfElements--;
		}
		return newList;
	}
    
    public boolean contains(T anEntry) {
        if (indexOf(anEntry) == -1) {
            return false;
        }
        else {
            return true;
        }
    }
    
    public int indexOf(T anEntry) {
		int indexFound = -1;
		
		if (!isEmpty()) {
			for (int i = 0; i < numberOfElements; i++) {
				if (getEntry(i).equals(anEntry)) {
					indexFound = i;
					i = numberOfElements;
				}
			}
		}
		return indexFound;
	}
    
    public int lastIndexOf(T anEntry) {
		int indexFound = -1;
		
		if (!isEmpty()) {
			for (int first = 0, last = numberOfElements - 1; first <= last; first++, last--){
				if (listArray[first].equals(anEntry)) {
					indexFound = first;
					}else if (listArray[last].equals(anEntry)) {
						indexFound = last;
						last = first - 1;
					}
				}
			}
			return indexFound;					
		}
    
    public T getEntry(int givenPosition) {
		if (givenPosition < 0) {
			return null;			
		}
		else {
			return listArray[givenPosition];
		}
	}
    
	public void display() {
		System.out.print(numberOfElements + " elements; ");
		System.out.print("capacity = " +listArray.length + "\t");
		if (!isEmpty()) {
			for (int i = 0; i < numberOfElements - 1; i++) {
				System.out.print(listArray[i] + ", ");
			}
			System.out.println(listArray[numberOfElements - 1]);
		}
	}

	public void clear() {
		for (int index = 0; index < numberOfElements; index++) {
			listArray[index] = null;
		}
		numberOfElements = 0;
	}

	public boolean isEmpty() {
        return numberOfElements == 0;
    }
	
	public int size() {
	    return numberOfElements;
	}

}