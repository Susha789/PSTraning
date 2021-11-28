package persistance;

import java.util.ArrayList;

import bean.Element;

public interface ElementDao {

	ArrayList<Element> getAllElements();
	Element getElementByAtomicNumber(int atomicNumber);
	boolean addElement(Element element);
	boolean updateElementByAtomicNumber(int atomicNumber, String atomicWeight );
	boolean removeElementByAtomicNumber(int atomicNumber );

}
