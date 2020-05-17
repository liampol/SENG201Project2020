package animalExtend;
import MainClassesPackage.Animal;

public class Pig extends Animal {
	
	public Pig() {
		super("Pig", "Pig", 10.00, 100.00, "Healthy", "Happy");
	}
	
	public Pig(String name) {
		super(name, "Pig", 10.00, 100.00, "Healthy", "Happy");
	}

}
