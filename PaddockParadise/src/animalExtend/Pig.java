package animalExtend;
import MainClassesPackage.Animal;

public class Pig extends Animal {
	
	public Pig() {
		super("Pig", "Pig", (float) 100.00, (float) 10.00, "Healthy", "Happy");
	}
	
	public Pig(String name) {
		super(name, "Pig", (float) 100.00, (float) 10.00, "Healthy", "Happy");
	}

}