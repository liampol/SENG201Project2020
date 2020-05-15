package animalExtend;
import MainClassesPackage.Animal;

public class Cow extends Animal{
	
	public Cow() {
		super("Cow", "Cow", 400.00, 50.00, "Healthy", "Happy");
	}
	
	public Cow(String name) {
		super(name, "Cow", 400.00, 50.00, "Healthy", "Happy");
	}

}
