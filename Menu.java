
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Menu {
    public static void main(String[] args) {
        // Menu options
        char inputOpt = ' ';
        String inputLine;
        // Restaurant and Cuisine information
        String restaurantName, cuisineName;
        String review = null, location, signatureDish, priceRange;

        int rating;
        // Output information
        String outFilename, inFilename;
        String outMsg, inMsg;
        // Restaurant manager
        ReviewManager reviewManager = new ReviewManager();
        // Operation result
        boolean opResult;
        
        try {
            printMenu();
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do {
                System.out.print("\nWhat action would you like to perform?\n");
                inputLine = stdin.readLine().trim();
                if (inputLine.isEmpty()) {
                    continue;
                }
                inputOpt = inputLine.charAt(0);
                inputOpt = Character.toUpperCase(inputOpt);

                switch (inputOpt) {

                    case 'A': // Add a new Restaurant Review
                        System.out.print("Please enter the restaurant information:\n");
                        System.out.print("Enter the restaurant name:\n");
                        restaurantName = stdin.readLine().trim();
                        System.out.print("Enter the review:\n");
                        review = stdin.readLine().trim();
                        System.out.print("Enter the price range:\n");
                        priceRange = stdin.readLine().trim();
                        System.out.print("Enter the rating:\n");
                        rating = Integer.parseInt(stdin.readLine().trim());
                        System.out.print("Enter the cuisine name:\n");
                        cuisineName = stdin.readLine().trim();
                        System.out.print("Enter the location:\n");
                        location = stdin.readLine().trim();
                        System.out.print("Enter the signature dish\n");
                        signatureDish = stdin.readLine().trim();
                        
                    
                        
                        opResult = reviewManager.addReview(restaurantName, rating, review, priceRange, cuisineName, location, signatureDish) ; 
                        if ((opResult) == true) {
                            
                            System.out.print("Restaurant added\n"); 
                            break ; 
                        }
                        else {
                            System.out.print("Restaurant NOT added\n"); 
                            break ; 
                        }

                    case 'D':
                        System.out.print("Please enter the restaurant name to search:\n");
                        restaurantName = stdin.readLine().trim();
                        System.out.print("Please enter the restaurant's location':\n");
                        location = stdin.readLine().trim();	
                        
                        
                        int h = reviewManager.restaurantExists(restaurantName, location) ; 
                        if (h != -1 ) {
                        	System.out.print("Restaurant found. Here's the review:\n");
                        	System.out.print(reviewManager.reviewList.get(h).getReview()+ "\n"); 
                        	break ; 
                        }
                        else {
                        	System.out.print("Restaurant not found. Please try again\n");
                        	break ; 
                        }
                       

                    case 'E': 
                        System.out.print("Please enter the cuisine name to search:\n");
                        cuisineName = stdin.readLine().trim();
                        
            
                        if (((reviewManager.cuisineExists(cuisineName)) == null)) {
                        	System.out.printf("Cuisine: " + cuisineName + " was NOT found\n");
                        	break ; 
                        }
                        else {
                        	ArrayList<Integer> num = new ArrayList<>() ;

                        	num = reviewManager.cuisineExists(cuisineName) ; 
                        	
                        	System.out.print(num.size() + " Restaurants matching " + cuisineName +" cuisine were found:\n");
                                             	
                        	for (int index = 0 ; index < num.size() ; index++) {
                        			int num1 = num.get(index) ;  // gets each index from the arraylist, so that we could find the index matching from the reviewList
                        			System.out.print(reviewManager.reviewList.get(num1));
                        
                        	}
                        	break ; 
                        }
   
                    case 'L': // List restaurant's reviews
                    	if (reviewManager.reviewList.isEmpty()) {
                    		System.out.print("\nNo Reviews available\n");
                    		break; 
                    	}
                    	else {
                    		System.out.print("\n" + reviewManager.listReviews() + "\n");
                    		break;
                    	}                 
                    
                    case 'N': //sorts by rating 
                    	reviewManager.sortByRating();
                    	System.out.print("sorted by rating\n");
                    	break ; 
                    	
                    case 'P' : //sorts by cuisine name 
                    	
                    	reviewManager.sortByCuisine();
                    	System.out.print("sorted by cuisine\n");
                    	
                    	break ; 
                        
                    case 'Q': // Quit
                        break;

                    case 'R': // Remove a review
                        System.out.print("Please enter the restaurant name of the review to remove:\n");
                        restaurantName = stdin.readLine().trim();
                        System.out.print("Please enter the location to remove:\n");
                        location = stdin.readLine().trim();
                        
                       

                        if (reviewManager.removeReview(restaurantName, location) == false) {
                        	System.out.print(restaurantName + ", " + location + " was removed\n");
                        	break ; 
                        }
                        else {
                        	 System.out.print(restaurantName + ", " + location + " was NOT removed\n"); 
                        	 break ; 
                        }
                        
                        
                    case 'T': // Close reviewList
                        reviewManager.closeReviewManager();
                        System.out.print("Restaurant management system was reset\n");
                        break;

                    case 'U': // Write restaurant names and reviews to a text file
                        System.out.print("Please enter a file name that we will write to:\n");
                        outFilename = stdin.readLine().trim();
                        System.out.print("Please enter the name of the restaurant:\n");
                        restaurantName = stdin.readLine().trim();
                        System.out.println("Please enter a review to save locally:\n");
                        review = stdin.readLine().trim();
                        outMsg = restaurantName + "\n" + review + "\n";
                        
                        
                	    try {
                	    	 FileWriter fw = new FileWriter(outFilename);
                	    	 
                	    	 BufferedWriter bw = new BufferedWriter (fw);
                	    	 
                	    	 PrintWriter outfile = new PrintWriter(bw); 
                	    	 
                	    	 outfile.print(outMsg) ; 
                	    	 
                	    	 System.out.print(outFilename + " is written\n"); 
                	    	 outfile.close(); 
                	    	 bw.close();
                	    	 fw.close();
                	    	 break ; 

                	    }
                	    catch (IOException ioe) {
                	    	System.out.print("IO exception\n");
                	    	break; 
                	    }

                    case 'V': // Read strings from a text file
                        System.out.print("Please enter a file name which we will read from:\n");
                        inFilename = stdin.readLine().trim();
                       

                        try {
                        
                        FileReader fr = new FileReader(inFilename); 
                        BufferedReader inFile = new BufferedReader(fr); 
                        
                        inMsg = inFile.readLine(); 
                        
                      
                        
                        System.out.printf(inFilename + " was read\n");
                        System.out.print("The contents of the file are:\n");
                        while (inMsg != null) {
                        	System.out.print(inMsg + "\n");
                        	inMsg = inFile.readLine(); 
                        }
                        System.out.print("\n\n");
                        inFile.close();
                        fr.close(); 
                        break ; 
                        
                      } catch (FileNotFoundException exception) {
                    	  System.out.printf(inFilename + " was not found\n"); 
                    	  break ; 
                      } catch (IOException ioexception) {
                    	  System.out.print("IO exception");
                    	  break ; 
                      }
 
                    case 'W': // Serialize ReviewManager to a data file
                        System.out.print("Please enter a file name to write:\n");
                        outFilename = stdin.readLine().trim();
                        
                            
                       try {
                    	   
                        FileOutputStream fos = new FileOutputStream(outFilename); // serialize reviewManager
                        ObjectOutputStream oos = new ObjectOutputStream(fos); 
                        
                        oos.writeObject(reviewManager);
                        oos.close(); 
                        fos.close(); 
                        break ; 
                        
                       } catch (NotSerializableException exception) {
                    	   System.out.print("Not serializable exception\n");
                    	   break ;
                       }catch (IOException exp) {
                    	   System.out.print("IO exception\n");
                    	   break ; 
                       }

                    case 'X': // Deserialize ReviewManager from a data file
                        System.out.print("Please enter a file name which we will read from:\n");
                        inFilename = stdin.readLine().trim();
                        
                       
                        try { 
                        	FileInputStream fis = new FileInputStream(inFilename); //deserialize reviewManager 
                        	ObjectInputStream ois = new ObjectInputStream(fis);
                  
                        	Object any = ois.readObject(); 
                        	ReviewManager singleRestaurant = (ReviewManager)any ; 
                        	System.out.print(inFilename + " was read\n");
                        	
                        	reviewManager.closeReviewManager(); 		// closed reviewManager because all of the reviews were being replicated. 
                        	reviewManager.reviewList.addAll(singleRestaurant.reviewList) ; 
                        	fis.close() ; 
                        	ois.close();
                        	break ; 
                        }
                        catch (ClassNotFoundException excep){
                        	System.out.print("Class not found exception\n");
                        	break ; 
                        } catch (NotSerializableException exception) {
                        	System.out.print("Not serializable exception");
                        	break ; 
                        } catch (IOException excepti) {
                        	System.out.print("IO exception\n") ; 
                        	break ; 
                        }

                    case '?': // Display help
                        printMenu();
                        break;

                    default:
                        System.out.print("Unknown action\n");
                        break;
                }

            } while (inputOpt != 'Q' || inputLine.length() != 1);
        }
        catch (IOException exception) {
            System.out.print("IO Exception\n");
        }
    }

    public static void printMenu() {
        System.out.println("Welcome to Kelp! ");
        System.out.println("Find or post reviews for your favorite (and not so favorite) restaurants.");

        System.out.print("Choice\t\tAction\n" + "------\t\t------\n" + "A\t\tAdd a review\n"
                + "D\t\tSearch for a restaurant\n" + "E\t\tSearch for a cuisine\n"
                + "L\t\tList all reviews\n" + "N\t\tSort by stars\n" + "P\t\tSort by cuisine\n"
                + "Q\t\tQuit\n" + "R\t\tRemove a review\n"
                + "U\t\tAdd personal review to a local file\n" + "V\t\tRetrieve personal review from a local file\n"
                + "W\t\tSave reviews to a file\n"
                + "X\t\tUpload reviews from a file\n"
                + "T\t\t(admin) reset database\n"
                + "?\t\tDisplay Help\n");
    }
}
