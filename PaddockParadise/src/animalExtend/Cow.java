package animalExtend;
import MainClassesPackage.Animal;

public class Cow extends Animal{
	
	public Cow() {
		super("Cow", "Cow", (float) 400.00, (float) 50.00, "Healthy", "Happy");
	}
	
	public Cow(String name) {
		super(name, "Cow", (float) 400.00, (float) 50.00, "Healthy", "Happy");
	}

}
