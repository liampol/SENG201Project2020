package animalExtend;
import MainClassesPackage.Animal;

public class Sheep extends Animal {
	
	public Sheep() {
		super("Sheep", "Sheep", 20.00, 200.00, "Healthy", "Happy");
	}
	
	public Sheep(String name) {
		super(name, "Sheep", 20.00, 200.00, "Healthy", "Happy");
	}

}
