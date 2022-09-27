public class Restaurant implements java.io.Serializable {
	
	
	private static final long serialVersionUID = 205L;
	private String restaurantName ;
	private int stars ; 
	private String review ;
	private int priceRange ;
	private String location;
	private Cuisine cuisine ; 
	
	public Restaurant(String restaurantName, int stars, String review, int price, String location,Cuisine cuisine) {
		this.restaurantName = restaurantName ; 
		this.stars = stars; 
		this.review = review ; 
		this.priceRange = price ;
		this.location = location; 
		this.cuisine = cuisine ; 
	}
	
	
	public String getRestaurantName() {
		return restaurantName;
		
	}
	
	public String starSymbol() { //loops through each stars to print "*" symbol 
		
		String symbol = "*" ;
		
		for (int i = 0 ; i < getStar()- 1 ; ++i) {
			symbol += "*" ;
		}
		
		return symbol ; 
	}
	
	public int getStar() {
		return stars ;
	}
	// for (int i = 0 ; i < getStar() ; ++i) {      }
	
	
	
	public int getPriceRange() {
		return priceRange; 
	}
	
	public String getLocation() {
		return location; 
	}
	
	public String getReview() {
		return review ; 
	}
	
	public Cuisine getCuisine() {
		return cuisine ; 
	}
	
	public String priceRangeSymbol() { //loops through each price range symbol to print "$" symbol 
		
		String priceRange = "$" ; 
		
		for (int i = 0 ; i < getPriceRange() -1 ; ++i) {
			
			 priceRange += "$" ; 
			
		}
		return priceRange ; 
		
	}
	
	public String toString() {
		return String.format(restaurantName + " restaurant\n" + starSymbol() + "\t\t" + priceRangeSymbol() + "\n" +                 cuisine.toString() + "Location: " + location + "\n" + "Review:\t" + review + "\n\n") ; 
	}
}
