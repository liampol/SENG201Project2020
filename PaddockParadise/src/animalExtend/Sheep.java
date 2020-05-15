package animalExtend;
import MainClassesPackage.Animal;

public class Sheep extends Animal {
	
	public Sheep() {
		super("Sheep", "Sheep", 200.00, 20.00, "Healthy", "Happy");
	}
	
	public Sheep(String name) {
		super(name, "Sheep", 200.00, 20.00, "Healthy", "Happy");
	}

}
