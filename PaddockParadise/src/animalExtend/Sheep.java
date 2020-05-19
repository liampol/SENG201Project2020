package animalExtend;
import MainClassesPackage.Animal;


/**
 * The 'Sheep' class extends the animal class, and only has a default constructor() and a overload constructor(String name)
 * that takes a name as a parameter.
 * 
 * @author Te Wehenga Johnson
 *
 */
public class Sheep extends Animal {
	
	public Sheep() {
		super("Baarbra", "Sheep", 60.00, 500.00, "Healthy", "Happy");
	}
	
	public Sheep(String name) {
		super(name, "Sheep", 60.00, 500.00, "Healthy", "Happy");
	}

}
