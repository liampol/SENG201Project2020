package animalExtend;
import MainClassesPackage.Animal;

public class Sheep extends Animal {
	
	public Sheep() {
		super("Sheep", "Sheep", (float) 200.00, (float) 20.00, "Healthy", "Happy");
	}
	
	public Sheep(String name) {
		super(name, "Sheep", (float) 200.00, (float) 20.00, "Healthy", "Happy");
	}

}
