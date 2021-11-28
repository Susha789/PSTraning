package service;

import java.util.ArrayList; 

import bean.Element; 

public interface ElementService {

	ArrayList<Element> readElement(); 
	Element getElementByAtomicNumber(int atomicNumber);
	boolean insertElement(Element element);
	boolean updateElement(int atomicNumber, String atomicWeight);
	boolean deleteElement(int atomicNumber);
	
	
}
