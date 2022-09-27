
import java.util.Comparator;

public class ReviewRatingComparator implements Comparator<Restaurant> {
	
	@Override
	public int compare(Restaurant o1, Restaurant o2) {
		
		if (o1.getStar() == o2.getStar()) {
			
			if (o1.getRestaurantName().compareTo(o2.getRestaurantName()) == 0) {
					if (o1.getLocation().compareTo(o2.getLocation())  == 0) {
						
						if (o1.getReview().compareTo(o2.getReview()) ==  0) {
							return 0 ; 
						}
						else {
							return o1.getReview().compareTo(o2.getReview()) ; 
						}
					}
					else {
						if (o1.getLocation().compareTo(o2.getLocation()) > 0){
							return 0 ; 
						}
						else {
							return -1; 
						}
					}
			}		
			else {
					return o1.getRestaurantName().compareTo(o2.getRestaurantName()) ;
			 }
		}
		else {
			return o1.getStar() - o2.getStar() ; 
		}
	}
}