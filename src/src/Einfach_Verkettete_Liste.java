package src;

import java.util.ArrayList;

public class Einfach_Verkettete_Liste {

	private ListElement startElement;;

	public void selectionSort(Einfach_Verkettete_Liste evl1, ListElement le) {
		System.out.println("Aktuelle Einfach_Verkette_Liste " );
		evl1.Einfach_Verkettete_ListeToString(evl1);
		le.toString();
		System.out.println(
				"Es wird selectionsSort angewendet, um angegebene Liste in Einfach_Verkettete_Liste einzuorden");
		ListElement listelement = evl1.startElement;

		if (evl1.size() == 1) {
			evl1.startElement.setNext(le);
		} else {

			while ((listelement.getNext()) != null) {
				listelement = listelement.getNext();
				if (listelement.getNext() == null) {
					listelement.setNext(le);
					break;
				}
			}
		}
		System.out.println("Die neue angegebene Liste ist an der Einfach_Verkettete_Liste angehängt");
		System.out.println("Die neue Größe der Liste ist " + evl1.size());
		evl1.Einfach_Verkettete_ListeToString(evl1);
		for (int i = 0; i < evl1.size() - 1; i++) {
			int min_index = i;
			int minValue = evl1.getElementFromList(i).getValue();
			System.out.println("Es wird der kleinste Wert gesucht");
			for (int j = i + 1; j < evl1.size(); j++) {
				int currentValue = evl1.getElementFromList(j).getValue();
				if (currentValue < minValue) {
					min_index = j;
					minValue = currentValue;
				}
			}
			System.out.println("Der kleinste Wert ist " + minValue + " und befindet sich an " + min_index);
			swapElements(evl1, min_index, i);
			System.out.println("Die Werte von " + min_index + " und " + i + " sind vertauscht worden");
		}

	}

	public void insertionSort2(Einfach_Verkettete_Liste evl1, ListElement le)
	{
		System.out.println("----------");
		ListElement temp = le;
		ListElement temp2 = temp.getNext();
		while(temp2 != null) {
			temp2 = temp.getNext();
			System.out.println("Versuche " + temp.getValue() + " einzusortieren");
			if (temp.getValue() <= evl1.startElement.getValue()) {
				temp.setNext(evl1.startElement);
				evl1.startElement = temp;
				System.out.println(
						"Element wird an Anfang der Liste eingeordnet, da es kleiner als das erste Element der Liste ist");
				evl1.Einfach_Verkettete_ListeToString(evl1);
				System.out.println();
				temp = temp2;
				continue;
			}

			System.out.print("-" + temp.getValue());
			 for(int j = 0; j < evl1.size(); j++) {
				if ((temp.getValue() >= evl1.getElementFromList(j).getValue() && evl1.getElementFromList(j).getNext() == null)
						|| (temp).getValue() >= evl1.getElementFromList(j).getValue()
								&& temp.getValue() <= evl1.getElementFromList(j).getNext().getValue()) {
					if (evl1.getElementFromList(j).getNext() == null)
						System.out.println("-Ende der Liste erreicht, Element wird hier eingeordnet");
					else
						System.out.println("-Element ist groessergleich " + evl1.getElementFromList(j).getValue() + " und kleinergleich "
								+ evl1.getElementFromList(j).getNext().getValue() + ", wird dazwischen eingeordnet");
					temp.setNext(evl1.getElementFromList(j).getNext());
					evl1.getElementFromList(j).setNext(temp);
					System.out.println();
					evl1.Einfach_Verkettete_ListeToString(evl1);
					System.out.println();
					break;
				}
				System.out.print("-" + evl1.getElementFromList(j).getValue());
			}
		temp = temp2;
		}
		System.out.println("----------");		
	}
	
	public void insertionSort(Einfach_Verkettete_Liste evl1, ListElement le) {
		int i = 0;
		ArrayList<ListElement> liste = new ArrayList<ListElement>();

		liste.add(le);
		while ((le.getNext()) != null) {
			liste.add(le.getNext());
			le = le.getNext();
		}

		if (evl1.isListEmpty()) {
			System.out.println("liste was empty");
			evl1.startElement = le;
			le.setNext(null);
			i = 1;
		}
		System.out.println("----------");
		for (; i < liste.size(); i++) {
			System.out.println("Versuche " + liste.get(i).getValue() + " einzusortieren");
			ListElement element2;
			if (liste.get(i).getValue() <= evl1.startElement.getValue()) {
				liste.get(i).setNext(evl1.startElement);
				evl1.startElement = liste.get(i);
				System.out.println(
						"Element wird an Anfang der Liste eingeordnet, da es kleiner als das erste Element der Liste ist");
				evl1.Einfach_Verkettete_ListeToString(evl1);
				System.out.println();
				continue;
			}
			element2 = evl1.startElement;
			System.out.print("-" + element2.getValue());
			while (element2 != null) {
				if ((liste.get(i).getValue() >= element2.getValue() && element2.getNext() == null)
						|| (liste.get(i).getValue() >= element2.getValue()
								&& liste.get(i).getValue() <= element2.getNext().getValue())) {
					if (element2.getNext() == null)
						System.out.println("-Ende der Liste erreicht, Element wird hier eingeordnet");
					else
						System.out.println("-Element ist groessergleich " + element2.getValue() + " und kleinergleich "
								+ element2.getNext().getValue() + ", wird dazwischen eingeordnet");
					liste.get(i).setNext(element2.getNext());
					element2.setNext(liste.get(i));
					System.out.println();
					evl1.Einfach_Verkettete_ListeToString(evl1);
					System.out.println();
					break;
				}
				element2 = element2.getNext();
				System.out.print("-" + element2.getValue());
			}
		}
		System.out.println("----------");
	}

	public void bubblesort2(Einfach_Verkettete_Liste evl1, ListElement le) {
		int temp = 0;
		ListElement le2 = le;
		while (le2 != null) {
			System.out.print("Versuche " + le2.getValue() + " in ");
			Einfach_Verkettete_ListeToString(evl1);
			System.out.println(" einzufügen");
			le = le2;
			le2 = le2.getNext();
			le.setNext(evl1.startElement);
			evl1.startElement = le;
			ListElement evl1element = evl1.startElement;
			while (evl1element != null) {
				if (evl1element.getNext() == null) {
					System.out.println("Ende der Liste ist errreicht, Element wurde einsortiert");
					break;
				}
				if (evl1element.getValue() > evl1element.getNext().getValue()) {
					System.out.println(
							"Vertausche " + evl1element.getValue() + " mit " + evl1element.getNext().getValue());
					temp = evl1element.getValue();
					evl1element.setValue(evl1element.getNext().getValue());
					evl1element.getNext().setValue(temp);
				}
				evl1element = evl1element.getNext();
			}
		}

	}

	public void bubblesort(Einfach_Verkettete_Liste evl1) {
		ListElement temp = null;
		ListElement newListElement = startElement;
		ListElement newListElement2 = startElement.getNext();
		for (int i = 0; i < evl1.size(); i++) {
			newListElement = startElement;
			newListElement2 = startElement.getNext();
			for (int j = 0; j < evl1.size() - 1; j++) {
				boolean b = false;
				newListElement2 = newListElement.getNext();

				try {
					ListElement before = getbefore(newListElement);
					if (before != null) {
						b = true;
					}
				} catch (Exception e) {
				}

				if (newListElement.getValue() > newListElement2.getValue() && b) {

					ListElement lebefore = getbefore(newListElement);
					temp = newListElement;
					newListElement.setNext(newListElement2.getNext());
					newListElement2.setNext(temp);
					lebefore.setNext(newListElement2);

				} else if (newListElement.getValue() > newListElement2.getValue() && !b) {
					temp = newListElement;
					newListElement.setNext(newListElement2.getNext());
					newListElement2.setNext(temp);
					startElement = newListElement2;
				}

				else {
					newListElement = newListElement.getNext();
				}
			}
		}
	}

	public Einfach_Verkettete_Liste swapElements(Einfach_Verkettete_Liste evl1, int index1, int index2) {
		int temp = evl1.getElementFromList(index1).getValue();
		evl1.getElementFromList(index1).setValue(evl1.getElementFromList(index2).getValue());
		evl1.getElementFromList(index2).setValue(temp);

		return evl1;
	}

	public ListElement getbefore(ListElement le1) {
		ListElement le = startElement;
		while (le.getNext() != null) {
			if (le.getNext().equals(le1)) {
				return le;
			} else {
				le = le.getNext();
			}
		}
		return null;
	}

	public void insertElements(int anz, Einfach_Verkettete_Liste evl1) {
		Einfach_Verkettete_Liste evl = evl1;
		for (anz = 1; anz < 11; anz++) {
			int zahl = (int) (Math.random() * 10);
			evl.insertFirst(zahl);
		}
	}

	public void insertFirst(int value) {
		ListElement newListElement = new ListElement(value);
		if (isListEmpty() == true) {
			startElement = newListElement;
		} else {
			newListElement.setNext(startElement);
			startElement = newListElement;
		}
	}

	public void insertLast(int value) {
		ListElement newListElement = new ListElement(value);
		if (isListEmpty() == true) {
			startElement = newListElement;
		} else {
			ListElement le = startElement;
			while (le.getNext() != null) {
				le = le.getNext();
			}
			le.setNext(newListElement);
		}
	}

	public int size() {
		if (isListEmpty()) {
			return 0;
		} else {
			ListElement le = startElement;
			int count = 1;
			while (le.getNext() != null) {
				count++;
				le = le.getNext();
			}
			return count;
		}
	}

	public boolean isListEmpty() {
		if (startElement == null) {
			return true;
		} else {
			return false;
		}
	}

	public void RemoveFirstElement() {
		if (isListEmpty()) {

		} else {
			startElement = startElement.getNext();
		}
	}

	public void RemoveLastElement() {
		if (isListEmpty()) {

		}
		ListElement le = startElement;
		while (le.getNext().getNext() != null) {
			le = le.getNext();
		}
		le.setNext(null);
	}

	public void RemoveElementFromList(int position) {
		if (position > size() || position < 0) {

		} else if (position == 1) {
			startElement = startElement.getNext();
		}

		else {
			ListElement previous = getElementFromList(position - 1);

			previous.setNext(getElementFromList(position + 1));
		}
	}

	public ListElement getElementFromList(int position) {
		if (position > size() || position < 0) {
			return null;
		} else {
			ListElement le = startElement;
			int currentPositon = 0;
			while (currentPositon < position) {
				currentPositon++;
				le = le.getNext();
			}
			return le;
		}
	}

	public static void main(String[] args) {
		// Einfach_Verkettete_Liste evl = new Einfach_Verkettete_Liste();
		// System.out.println("Element an letzter Stelle hinzufügen!");
		// evl.insertLast(new ListElement("2"));
		// evl.insertLast(new ListElement("3"));
		// evl.insertLast(new ListElement("4"));
		// evl.insertLast(new ListElement("5"));
		// evl.Einfach_Verkettete_ListeToString(evl);
		// System.out.println();
		//
		// System.out.println("Element an erster Stelle hinzufügen!");
		// evl.insertFirst(new ListElement("1"));
		// evl.Einfach_Verkettete_ListeToString(evl);
		// System.out.println();
		//
		// System.out.println("Die Liste hat folgende Größe:" + evl.size());
		//
		// System.out.println("Das Element an der vierten Stelle der Liste: " +
		// evl.getElementFromList(3));
		//
		// System.out.println("Das erste Element der Liste entfernen!");
		// evl.RemoveFirstElement();
		// evl.Einfach_Verkettete_ListeToString(evl);
		// System.out.println();
		//
		// System.out.println("Das letzte Element der Liste entferen!");
		// evl.RemoveLastElement();
		// evl.Einfach_Verkettete_ListeToString(evl);
		// System.out.println();
		//
		// System.out.println("Gewünschtes Element aus der Liste entferen!");
		// evl.RemoveElementFromList(2);
		// evl.Einfach_Verkettete_ListeToString(evl);

		Einfach_Verkettete_Liste evl1 = new Einfach_Verkettete_Liste();
		Einfach_Verkettete_Liste evl2 = new Einfach_Verkettete_Liste();
		evl2.insertElements(10, evl2);
		// evl1.Einfach_Verkettete_ListeToString(evl1);
		// System.out.println();

		// evl1.bubblesort(evl1);
		// evl1.Einfach_Verkettete_ListeToString(evl1);

		// evl2.Einfach_Verkettete_ListeToString(evl2);
		// evl1.startElement = new ListElement(5);
		// evl1.insertionSort(evl1, new ListElement(8));
		// System.out.println();
		// evl1.insertionSort(evl1, new ListElement(7));
		// System.out.println();
		// evl1.insertionSort(evl1, new ListElement(9));
		// System.out.println();
		// evl1.insertionSort(evl1, new ListElement(4));
		// System.out.println("sdagsdf");
		// evl1.Einfach_Verkettete_ListeToString(evl1);
		// System.out.println("Hallo");
		// evl1.insertionSort(evl1, evl2.startElement);
		// evl1.Einfach_Verkettete_ListeToString(evl1);

		// System.out.println(evl1.size());

		// Einfach_Verkettete_Liste evl3 = new Einfach_Verkettete_Liste();
		// Einfach_Verkettete_Liste evl4 = new Einfach_Verkettete_Liste();
		// evl3.insertElements(10, evl3);
		// evl4.bubblesort2(evl4, new ListElement(7));
		// evl3.Einfach_Verkettete_ListeToString(evl3);
		// System.out.println();
		// evl4.bubblesort2(evl4, evl3.startElement);
		// System.out.println();
		// evl4.Einfach_Verkettete_ListeToString(evl4);

//		evl1.startElement = new ListElement(5);
//		evl1.selectionSort(evl1, new ListElement(8));
//		System.out.println();
//		evl1.selectionSort(evl1, new ListElement(7));
//		System.out.println();
//		evl1.selectionSort(evl1, new ListElement(9));
//		System.out.println();
//		evl1.selectionSort(evl1, new ListElement(4));
//		evl1.selectionSort(evl1, evl2.startElement);
//		evl1.Einfach_Verkettete_ListeToString(evl1);
	
	
		 evl2.Einfach_Verkettete_ListeToString(evl2);
		 evl1.startElement = new ListElement(5);
		 evl1.insertionSort2(evl1, new ListElement(8));
		 System.out.println();
		 evl1.insertionSort2(evl1, new ListElement(7));
		 System.out.println();
		 evl1.insertionSort2(evl1, new ListElement(9));
		 System.out.println();
		 evl1.insertionSort2(evl1, new ListElement(4));
		 evl1.Einfach_Verkettete_ListeToString(evl1);
		 evl1.insertionSort2(evl1, evl2.startElement);
		 evl1.Einfach_Verkettete_ListeToString(evl1);	
	}

	public void Einfach_Verkettete_ListeToString(Einfach_Verkettete_Liste evl) {
		ListElement le = startElement;
		while (le != null) {
			System.out.print(le.toString());
			le = le.getNext();
		}
	}
}
