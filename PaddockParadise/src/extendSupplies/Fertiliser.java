package extendSupplies;
import MainClassesPackage.*;

/**
 * <h2>Fertiliser</h2>
 * <p>The 'Fertiliser' class extends the Supplies class, and calls the Supplies constructor with values.
 * 
 * 
 * @author Te Wehenga Johnson
 * @see Supplies
 */
public class Fertiliser extends Supplies {
	
	public Fertiliser() {
		super("Fertiliser", "Grows crop faster by 3 days", 200.00);
	}

}
