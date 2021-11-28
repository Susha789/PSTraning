package cdExample;

import java.util.Set;
import java.util.TreeSet;

public class CDMain {
	
	public static void main(String[] args) {

        Set<CD> CDCollection = new TreeSet<>(new CDsort());

        CDCollection.add(new CD("ONE PUCH MAN", "One Punch"));
        CDCollection.add(new CD("DORAEMON", "Doremi"));
        CDCollection.add(new CD("NINJA HOATORI", "Mina"));
        CDCollection.add(new CD("Naruto","kishimoto"));
        
        System.out.println(CDCollection);
        System.out.println("Sorting CD's according to singer's name!");
        System.out.println("Size of Collection :" + CDCollection.size());

        for (CD cd : CDCollection) {
            System.out.println(cd);
        }

    }



}
