package animalExtend;
import MainClassesPackage.Animal;

/**
 * The 'Cow' class extends the animal class, and only has a default constructor() and a overload constructor(String name)
 * that takes a name as a parameter 
 * 
 * 
 * @author Te Wehenga Johnson
 *
 */
public class Cow extends Animal{
	
	public Cow() {
		super("Mooody", "Cow", 100.00, 1000.00, "Healthy", "Happy");
	}
	
	public Cow(String name) {
		super(name, "Cow", 100.00, 1000.00, "Healthy", "Happy");
	}

}
