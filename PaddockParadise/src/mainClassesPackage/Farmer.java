package mainClassesPackage;

/**
 * <h2>Farmer</h2> 
 * 
 * <p> Creates a farmer object with a name, age, and type. Instantiated in the setup class
 * 
 */
public class Farmer {
	
	private String name;
	private int age;
	private String type;  // Different types: "Male Farmer", "Female Farmer", "Alien farmer", the types are used to differentiate between avatars.
	
	
	public Farmer(String newName, int newAge, String newType) {
		name = newName;
		age = newAge;
		type = newType;
	}
	
	public Farmer() { // Default constructor for testing
		name = "Farmer Doe";
		age = 22;
		type = "Male Farmer";
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getType() {
		return type;
	}
	
	
	public String viewFarmerStatus() {
		return "Name: " + name + ",\n"
				+ "Age: " + age + ",\n"
				+ "Type: " + type + ",\n";
	}

}
