package animalExtend;
import mainClassesPackage.Animal;


/**
 * <h2>Pig</h2>
 * <p>The 'Pig' class extends the Animals class, and only has a default constructor() and a overload constructor(String name)
 * that takes a name as a parameter 
 * @author Te Wehenga Johnson
 * @see Animal
 */
public class Pig extends Animal {
	
	public Pig() {
		super("Oinkers", "Pig", 40.00, 400.00, "Healthy", "Happy");
	}
	
	public Pig(String name) {
		super(name, "Pig", 40.00, 400.00, "Healthy", "Happy");
	}

}
