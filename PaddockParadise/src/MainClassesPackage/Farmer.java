package MainClassesPackage;

public class Farmer {
	
	private String name;
	private int age;
	private String imageType;
	private String type;  // Different types: "Male Farmer", "Female Farmer", "Alien farmer", the types are used to differentiate between avatars.
	
	/**
	 * Overloader Initialiser for creating a farmer
	 * @param newName
	 * @param newAge
	 * @param newType
	 */
	public Farmer(String newName, int newAge, String newType) {
		name = newName;
		age = newAge;
		type = newType;
	}
	
	
	/**
	 * Default Initialiser for creating a farmer
	 */
	public Farmer() {
		name = "Farmer Doe";
		age = 22;
		type = "Male Farmer";
	}
	/**
	 * Returns name of farmer
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets name of farmer
	 * @param newName
	 */
	public void setName(String newName) {
		name = newName;
	}
	
	
	/**
	 * returns farmers age
	 * @return
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Sets farmers age
	 * @param newAge
	 */
	public void setAge(int newAge) {
		age = newAge;
	}
	
	/**
	 * returns farmer type
	 * @return
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the farmers avatar as a image
	 * @param newImage
	 */
	public void setImageType(String newImage) {
		imageType  = newImage;
	}
	
	/**
	 * gets the players avatar Image
	 * @return
	 */
	public String getImageType() {
		return imageType;
	}
	
	/**
	 * sets the farmers type
	 * @param newType
	 */
	public void setType(String newType) {
		type = newType;
	}
	
	/**
	 * returns the details ofthe farmer
	 * @return
	 */
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
