package MainClassesPackage;

public class Farmer {
	
	private String name;
	private int age;
	private String type;  // Different types: "Male Farmer", "Female Farmer", "Alien farmer", the types are used to differentiate between avatars.
	
	
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
	
	public void setName(String newName) {
		name = newName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int newAge) {
		age = newAge;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String newType) {
		type = newType;
	}
	
	
	public String viewFarmerStatus() {
		return "Name: " + name + ",\n"
				+ "Age: " + age + ",\n"
				+ "Type: " + type + ",\n";
	}
	public static void main(String[] args) {
		
		// Implemented for testing
		Farmer newFarmer = new Farmer();
		System.out.println(newFarmer.getAge());
	}
}
