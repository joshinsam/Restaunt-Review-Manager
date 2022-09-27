
import java.io.Serializable;

public class Cuisine implements Serializable {
    
    private static final long serialVersionUID = 205L; 
    private String signatureDish;
    private String name;

    public Cuisine(String signatureDish, String name) {
        this.name = name;
        this.signatureDish = signatureDish;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " Cuisine\n" +
                "Signature Dish:\t" + signatureDish + '\n';
    }
}
