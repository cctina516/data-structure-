package projectaa;
import java.util.ArrayList;

public class Trio<T> {
	private T item1, item2, item3;

	public Trio(T item1, T item2, T item3) {
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
	}
	
	public Trio(T item) {
	      this(item, item, item);
	}

	public T getItem1() {
		return item1;
	}

	public void setItem1(T item1) {
		this.item1 = item1;
	}

	public T getItem2() {
		return item2;
	}

	public void setItem2(T item2) {
		this.item2 = item2;
	}

	public T getItem3() {
		return item3;
	}

	public void setItem3(T item3) {
		this.item3 = item3;
	}

	public String toString() {
		return "\n Item1 shoud be " + item1.toString() + ", Item2 shoud be " + item2.toString() + ", Item3 shoud be "
				+ item3.toString() + "\n";
	}

	public void reset(T item) {
		this.setItem1(item);
		this.setItem2(item);
		this.setItem3(item);
	}

	public int count(T item) {
		int count = 0;

		if (item1.equals(item))
			count++;

		if (item2.equals(item))
			count++;

		if (item3.equals(item))
			count++;

		return count;
	}

	public boolean hasDuplicates() {
		return item1.equals(item2) || item2.equals(item3) || item3.equals(item1);
	}

	@Override
	public boolean equals(Object other) {

		if (other instanceof Trio<?>) {

			Trio<?> otherTrio = (Trio<?>) other;

			boolean possible1 = (this.item1.equals(otherTrio.item1) & this.item2.equals(otherTrio.item2) & this.item3.equals(otherTrio.item3));
            boolean possible2 = (this.item1.equals(otherTrio.item2) & this.item2.equals(otherTrio.item1) & this.item3.equals(otherTrio.item3));
            boolean possible3 = (this.item1.equals(otherTrio.item3) & this.item2.equals(otherTrio.item2) & this.item3.equals(otherTrio.item1));
            boolean possible4 = (this.item1.equals(otherTrio.item1) & this.item2.equals(otherTrio.item3) & this.item3.equals(otherTrio.item2));
            boolean possible5 = (this.item1.equals(otherTrio.item2) & this.item2.equals(otherTrio.item3) & this.item3.equals(otherTrio.item1));
            boolean possible6 = (this.item1.equals(otherTrio.item3) & this.item2.equals(otherTrio.item1) & this.item3.equals(otherTrio.item2));
            
            return (possible1 | possible2 | possible3 | possible4 | possible5 | possible6);
           
		}
		return false;
	}

}
