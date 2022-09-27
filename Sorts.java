
import java.util.ArrayList;
import java.util.Comparator;

public class Sorts {
	
	public static void sort(ArrayList<Restaurant> reviewList, Comparator<Restaurant> xComparator) {
		
		//selection sort 
		int min; 
		for (int i = 0; i < reviewList.size()-1 ; i++) {
			min = i ; 
			
			for (int j = i +1 ; j < reviewList.size(); j++) 
				if (xComparator.compare(reviewList.get(j), reviewList.get(min)) < 0)
					min = j ; 
			
			swap (reviewList, min, i) ; 
		}
	}

	private static void swap(ArrayList<Restaurant> reviewList, int min, int i) {
		
		Restaurant temp = reviewList.get(min); 
		reviewList.set(min,reviewList.get(i) ) ; 
		reviewList.set(i,temp) ; 
		
		 
	}
}
