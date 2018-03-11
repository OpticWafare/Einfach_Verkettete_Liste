package src;

public class ListElement {

	private ListElement next;
	private int value;


	public ListElement() {
		super();
		this.next = null;
		this.value = 0;
	}

	public ListElement(int value) {
		super();
		this.next = null;
		this.value = value;
	}

	public ListElement getNext() {
		return next;
	}

	public void setNext(ListElement next) {
		this.next = next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public String toString()
	{
		return "[" + value + "]->";
	}
	
	
}
