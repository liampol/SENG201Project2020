package MainClassesPackage;

public class Farmer {
	
	String name;
	int age;
	String type;  // Different types: "Male Farmer", "Female Farmer", "Alien farmer", the types are used to differentiate between avatars.
	
	
	public Farmer(String newName, int newAge, String newType) {
		name = newName;
		age = newAge;
		type = newType;
	}
	
	public Farmer() {
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
	
	public static void main(String[] args) {
		
		// Implemented for testing
		Farmer newFarmer = new Farmer();
		System.out.println(newFarmer.getAge());
	}
}
