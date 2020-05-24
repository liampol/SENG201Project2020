package animalExtend;
import mainClassesPackage.Animal;

/**
 * <h2>Cow</h2>
 * <p>The 'Cow' class extends the Animals class, and only has a default constructor() and a overload constructor(String name)
 * that takes a name as a parameter 
 * 
 * 
 * @author Te Wehenga Johnson
 * @see Animal
 */
public class Cow extends Animal{
	
	public Cow() {
		super("Mooody", "Cow", 100.00, 1000.00, "Healthy", "Happy");
	}
	
	public Cow(String name) {
		super(name, "Cow", 100.00, 1000.00, "Healthy", "Happy");
	}

}
