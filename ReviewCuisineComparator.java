import java.util.Comparator;

public class ReviewCuisineComparator implements Comparator<Restaurant>{

	@Override
	public int compare(Restaurant o1, Restaurant o2) {

		
		if (o1.getCuisine().getName().equals(o2.getCuisine().getName())) {  
			if (o1.getPriceRange() == o2.getPriceRange()) { 
				if (o1.getRestaurantName().compareTo(o2.getRestaurantName()) == 0) {
					if (o1.getLocation().compareTo(o2.getLocation()) == 0) { 
						if (o1.getReview().compareTo(o2.getReview()) == 0){ 
							return 0 ; 
						}
						else {
							return o1.getReview().compareTo(o2.getReview());
						}
					}
					else {
						if (o1.getLocation().compareTo(o2.getLocation()) > 0) {
							return 0 ; 
						}
						else {
							return -1; 
						}
					}
				}
				else {
					if (o1.getRestaurantName().compareTo(o2.getRestaurantName()) > 0) {
						return 0 ;
					}
					else {
						return -1 ; 
					}
				}
			}
			else {
			return Integer.compare(o1.getPriceRange(), o2.getPriceRange()); 
			}
		}
		else {
			
			return o1.getCuisine().getName().compareTo(o2.getCuisine().getName()) ; 
		}

	}
}