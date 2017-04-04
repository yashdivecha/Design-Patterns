package studentOrientation.util;

/**
 * Duration - This class is used to calculate duration.
 * 
 * @author Yash
 *
 */
public class Duration implements DurationI {
	double duration = 0.0; // Initializes duration

	/**
	 * This method is used to set the Duration of an object
	 * 
	 * @param durationIn:
	 *            After calculating the duration, this method is used to set the
	 *            same.
	 * @return: void
	 */
	public void setDuration(double durationIn) {
		this.duration = durationIn;
	}

	/**
	 * This method is used to get the Duration of the object
	 * 
	 * @param void
	 * @return double It returns the current value of duration
	 */
	public double getDuration() {
		return duration;
	}
	
	/**
	 * This method calculates the Duration
	 * 
	 * @param temp
	 *            duration Value
	 * @return It returns the duration value
	 */
	public double calculateDuration(double temp){
		return temp;
	}
}
