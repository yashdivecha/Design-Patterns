package studentOrientation.util;

/**
 * Efforts - This class is used to calculate efforts.
 * 
 * @author Yash 
 *
 */
public class Efforts {

	double efforts = 0.0; // Initializes the efforts to 0.0

	/**
	 * This method is used to set the Efforts of an object
	 * 
	 * @param effortsIn:
	 *            After calculating the efforts, this method is used to set the
	 *            same.
	 * @return: void
	 */
	public void setEfforts(double effortsIn) {
		this.efforts = effortsIn;
	}

	/**
	 * This method is used to get the Efforts of the object
	 * 
	 * @param void
	 * @return double It returns the current value of efforts
	 */
	public double getEfforts() {
		return efforts;
	}

	/**
	 * This method calculates the Efforts
	 * 
	 * @param temp
	 *            effort Value
	 * @return It returns the effort value
	 */
	public double calculateEfforts(double temp) {
		return temp;
	}
}
