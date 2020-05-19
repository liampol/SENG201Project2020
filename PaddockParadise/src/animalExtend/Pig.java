package animalExtend;
import MainClassesPackage.Animal;


/**
 * The 'Pig' class extends the animal class, and only has a default constructor() and a overload constructor(String name)
 * that takes a name as a parameter 
 * @author Te Wehenga Johnson
 *
 */
public class Pig extends Animal {
	
	public Pig() {
		super("Oinkers", "Pig", 40.00, 400.00, "Healthy", "Happy");
	}
	
	public Pig(String name) {
		super(name, "Pig", 40.00, 400.00, "Healthy", "Happy");
	}

}
