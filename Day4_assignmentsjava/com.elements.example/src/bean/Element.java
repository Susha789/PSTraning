package bean;

public class Element {
	
	private int AtomicNumber ;
	private String AtomicWeight;
	private String Name;
	private String ChemicalSymbol;
	
	private Element() {
		
	}
	
	public Element(int atomicNumber, String atomicWeight, String name, String chemicalSymbol) {
		super();
		AtomicNumber = atomicNumber;
		AtomicWeight = atomicWeight;
		Name = name;
		ChemicalSymbol = chemicalSymbol;
	}

	public int getAtomicNumber() {
		return AtomicNumber;
	}

	public String getAtomicWeight() {
		return AtomicWeight;
	}

	public String getName() {
		return Name;
	}

	public String getChemicalSymbol() {
		return ChemicalSymbol;
	}

	public void setAtomicNumber(int atomicNumber) {
		AtomicNumber = atomicNumber;
	}

	public void setAtomicWeight(String atomicWeight) {
		AtomicWeight = atomicWeight;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setChemicalSymbol(String chemicalSymbol) {
		ChemicalSymbol = chemicalSymbol;
	}

	@Override
	public String toString() {
		return "Element [AtomicNumber=" + AtomicNumber + ", AtomicWeight=" + AtomicWeight + ", Name=" + Name
				+ ", ChemicalSymbol=" + ChemicalSymbol + "]";
	}
	
	
	
	
	

}
