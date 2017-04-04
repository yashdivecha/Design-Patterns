package studentOrientation.util;

/**
 * Cost - This class is used to calculate cost.
 *
 * @author Yash
 *
 */
public class Cost implements CostI {
	private double cost = 0.0; // Initializes the cost to 0.0

	/**
	 * This method is used to set the Cost of the object
	 * 
	 * @param costIn:
	 *            After calculating the cost, this method is used to set the
	 *            same.
	 * @return: void
	 */
	public void setCost(double costIn) {
		this.cost = costIn;
	}

	/**
	 * This method is used to get the Cost of the object
	 * 
	 * @param void
	 * @return double It returns the current value of cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * This method is used to get the convert Cost of the object
	 * 
	 * @param void
	 * @return double It returns the current value of cost
	 */
	public static String getCost(CurrencyCost currency, double cost) {

		switch (currency) {
		case DOLLARS:
			return String.format("%.2f", cost) + " dollars";
		case POUNDS:
			return String.format("%.2f", cost * 0.8) + " pounds";
		case RUPEES:
			return String.format("%.2f", cost * 68) + " rupees";
		default:
			return cost + " dollars";
		}
	}

	/**
	 * This method calculates the Cost
	 * 
	 * @param temp
	 *            cost Value
	 * @return It returns the cost value
	 */
	public double calculateCost(double temp) {
		return temp;
	}

	/**
	 * This method calculates the Cost
	 * 
	 * @param temp
	 *            cost Value
	 * @param percent
	 *            how much percent to increment or decrement.
	 * @param increamentDecrementVal
	 *            if it's 1 then percentage increment if it's 0 then percentage
	 *            decrement.
	 * @return It returns the cost value
	 */
	public double calculateCost(double temp, double percent, int increamentDecrementVal) {
		if (increamentDecrementVal == 1)
			return (temp + temp * (percent / 100));
		else if (increamentDecrementVal == 0)
			return (temp - temp * (percent / 100));
		else
			return -1;

	}
}
