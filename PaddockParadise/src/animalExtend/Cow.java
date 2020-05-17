package animalExtend;
import MainClassesPackage.Animal;

public class Cow extends Animal{
	
	public Cow() {
		super("Cow", "Cow", 50.00, 400.00, "Healthy", "Happy");
	}
	
	public Cow(String name) {
		super(name, "Cow", 50.00, 400.00, "Healthy", "Happy");
	}

}
