import java.io.Serializable;
import java.util.ArrayList;

public class ReviewManager implements Serializable {
    
    private static final long serialVersionUID = 205L;
    ArrayList<Restaurant> reviewList;
     public ReviewManager() {
        reviewList = new ArrayList<>();
    }     
     
    public boolean addReview(String restaurantName, int stars, String review, String priceRange, String cuisineName, String location, String signatureDish) {
        if (restaurantExists(restaurantName, location) == -1) {
            int price = priceRange.length();
            Cuisine newCuisine = new Cuisine(signatureDish, cuisineName);
            Restaurant newRestaurant = new Restaurant(restaurantName, stars, review, price, location, newCuisine);
            reviewList.add(newRestaurant);
            return true;
        }
        return false;
    }
    
    public int restaurantExists(String restaurantName, String location) {
    	int j = -1 ; 
    	for (int i = 0 ; i < reviewList.size() ; ++i) {
    		if ((reviewList.get(i).getRestaurantName().equals(restaurantName))) {
    			if (reviewList.get(i).getLocation().equals(location)) {
    				return i ; 
    			}
    			}
    		}
    		return j ; 
    	
    	}

 
    
    public ArrayList<Integer> cuisineExists(String cuisine){
        ArrayList<Integer> numbers = new ArrayList<>(); 
		for (int i = 0 ; i < reviewList.size() ; ++i) { 
			if (reviewList.get(i).getCuisine().getName().equals(cuisine)) {
				  numbers.add(i);	
			}
		}
		return numbers; 
    }
    
    public Restaurant getRestaurant(int index) {
		return reviewList.get(index); 
    }
    
    public boolean removeReview(String restaurantName, String location) {
        for (int i = 0 ; i < reviewList.size() ; ++i) {
    		if (reviewList.get(i).getRestaurantName().equals(restaurantName)) {
    			if (reviewList.get(i).getLocation().equals(location)) {	
    					reviewList.remove(i);
    					return false; }
    		}
        }
        return true; 
    }

    public void sortByRating() {
    	  Sorts.sort(reviewList, new ReviewRatingComparator());   
    	  
    }
    
    public void sortByCuisine() {
    	Sorts.sort(reviewList, new ReviewCuisineComparator()) ; 
    }
    
    
	public String listReviews() { 
		String item = "" ; 
		for (Restaurant restaurant :reviewList)
			item += restaurant.toString(); 
		
		return item ;  
    }
    
    public void closeReviewManager() {
    	reviewList.clear(); 
    }
}
