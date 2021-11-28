package service;

import java.util.ArrayList;

import bean.Element;
import persistance.ElementDao;
import persistance.ElementDaoImpl;

public class ElementServiceImpl implements ElementService{
	
	private ElementDao elementDao = new ElementDaoImpl();

	@Override
	public ArrayList<Element> readElement() {
		return elementDao.getAllElements();
	}

	@Override
	public Element getElementByAtomicNumber(int atomicNumber) {
		return elementDao.getElementByAtomicNumber(atomicNumber);
	}

	@Override
	public boolean insertElement(Element element) {
		return elementDao.addElement(element);
	}

	@Override
	public boolean updateElement(int atomicNumber, String atomicWeight) {
		return elementDao.updateElementByAtomicNumber(atomicNumber, atomicWeight);
	}

	@Override
	public boolean deleteElement(int atomicNumber) {
		return elementDao.removeElementByAtomicNumber(atomicNumber);
	}

	
}
