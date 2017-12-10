package src;

public class Einfach_Verkettete_Liste {

	private ListElement startElement;
	
	public void insertFirst(ListElement newListElement)
	{
		if(isListEmpty())
		{
			startElement = newListElement;
		}
		else
		{
			newListElement.setNext(startElement);
			startElement = newListElement;
		}
	}

	public void insertLast(ListElement newListElement)
	{
		if(isListEmpty())
		{
			startElement = newListElement;
		}
		else
		{
			ListElement le = startElement;
			while(le.getNext() != null)
			{
				le = le.getNext();
			}
			le.setNext(newListElement);
		}
	}
	
	public int size()
	{
		if(isListEmpty())
		{
			return 0;
		}
		else
		{
			ListElement le = startElement;
			int count = 0;
			while(le != null)
			{
				count++;
				le = le.getNext();
			}
		return count;
		}
	}
	
	public boolean isListEmpty()
	{
		return startElement == null;
	}

	public void RemoveFirstElement()
	{
		if(isListEmpty())
		{
			
		}
		else
		{
			startElement = startElement.getNext();
		}
	}
	
	public void RemoveLastElement()
	{
		if(isListEmpty())
		{
			
		}
		else
		{
			ListElement le = startElement;
			while(le.getNext() != null)
			{
				le = le.getNext();
			}
		le.setNext(null);
		}
	}
	
	public void RemoveElementFromList(int position)
	{
		if(position > size() || position <= 0)
		{
			
		}
		else if(position == 1)
		{
			startElement = startElement.getNext();
		}
		
		else
		{
			ListElement previous = getElementFromList(position -1);
			previous.setNext(getElementFromList(position +1));
		}
	}
	
	public ListElement getElementFromList(int position)
	{
		if(position > size() || position <= 0)
		{
			return null;
		}
		else
		{
			ListElement le = startElement;
			int currentPositon = 1;
			while(currentPositon < position)
			{
				currentPositon++;
				le = le.getNext();
			}
		return le;
		}
	}
	public static void main(String[] args) {
		Einfach_Verkettete_Liste evl = new Einfach_Verkettete_Liste();
		System.out.println("Element an letzter Stelle hinzufügen!");
		evl.insertLast(new ListElement("2"));
		evl.insertLast(new ListElement("3"));
		evl.insertLast(new ListElement("4"));
		evl.Einfach_Verkettete_ListeToString(evl);
		System.out.println();
		
		System.out.println("Element an erster Stelle hinzufügen!");
		evl.insertFirst(new ListElement("1"));
		evl.Einfach_Verkettete_ListeToString(evl);
		System.out.println();
		
		System.out.println("Die Liste hat folgende Größe:" + evl.size());
		
		System.out.println("Das Element an der dritten Stelle der Liste: " + evl.getElementFromList(3));
		
		System.out.println("Das erste Element der Liste entfernen!");
		evl.RemoveFirstElement();
		evl.Einfach_Verkettete_ListeToString(evl);
		System.out.println();
		
		//geat no nit
		System.out.println("Das letzte Element der Liste entferen!");
		evl.RemoveLastElement();
		evl.Einfach_Verkettete_ListeToString(evl);
		System.out.println();
		
		System.out.println("Gewünschtes Element aus der Liste entferen!");
		evl.RemoveElementFromList(2);
		evl.Einfach_Verkettete_ListeToString(evl);
	}
	
	public void Einfach_Verkettete_ListeToString(Einfach_Verkettete_Liste evl)
	{
		ListElement le = startElement;
		while(le != null)
		{
			System.out.print(le.toString());
			le = le.getNext();
		}
	}
}
