package cdExample;

import java.util.Comparator;

public class CDsort implements Comparator<CD> {

	@Override
	public int compare(CD cdOne, CD cdTwo) {
		return cdOne.getSinger().compareTo(cdTwo.getSinger());
	}
	
	
	

}
