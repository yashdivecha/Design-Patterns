package studentOrientation.util;

/**
 * CarbonFootPrint - This class is used to calculate carbon foot prints.
 * 
 * @author Yash
 *
 */
public class CarbonFootprint implements CarbonFootprintI {
	double cfp = 0.0; // Initialize to 0.0

	/**
	 * This method is used to set the Carbon Foot Print of the object
	 * 
	 * @param cfpIn:
	 *            After calculating the carbon foot print, this method is used
	 *            to set the same.
	 * @return: void
	 */
	public void setCarbonFootprint(double cfpIn) {
		this.cfp = cfpIn;
	}

	/**
	 * This method is used to get the Carbon Foot Print of the object
	 * 
	 * @param void
	 * @return double It returns the current value of carbon foot prints
	 */
	public double getCarbonFootprint() {
		return cfp;
	}

	/**
	 * This method calculates the carbon foot prints
	 * 
	 * @param temp
	 *            carbon foot print value
	 * @return It returns the entered carbon foot print value
	 */
	public double calculateCarbonFootPrint(double temp) {
		return temp;
	}

}
