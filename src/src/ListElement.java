package src;

public class ListElement {

	private ListElement next;
	private String value;

	
	
	public ListElement() {
		super();
		this.next = null;
		this.value = "default";
	}

	public ListElement(String value) {
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

	public String getValue() {
		return value;
	}

	public void setStelle(String value) {
		this.value = value;
	}
	
	public String toString()
	{
		return "[" + value + "]->";
	}
	
	
}
