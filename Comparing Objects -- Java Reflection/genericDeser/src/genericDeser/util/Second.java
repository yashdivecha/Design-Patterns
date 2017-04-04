package genericDeser.util;

/**
 * Second - This class has data members, getter and setter methods and hashCode,
 * equals methods and toString methods have been overridden.
 * 
 * @author Yash Divecha
 *
 */
public class Second {

	// Data Members of the Class.
	private int IntValue;
	private double DoubleValue;
	private boolean BooleanValue;

	// Public Constructor
	public Second() {
		Logger.writeMessage("Constructor of Second: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
	}

	// Getter and Setter Methods of the Data Members.
	/**
	 * @return the intValue
	 */
	public int getIntValue() {
		return IntValue;
	}

	/**
	 * @param intValue
	 *            the intValue to set
	 */
	public void setIntValue(int intValueIn) {
		IntValue = intValueIn;
	}

	/**
	 * @return the doubleValue
	 */
	public double getDoubleValue() {
		return DoubleValue;
	}

	/**
	 * @param doubleValue
	 *            the doubleValue to set
	 */
	public void setDoubleValue(double doubleValueIn) {
		DoubleValue = doubleValueIn;
	}

	/**
	 * @return the booleanValue
	 */
	public boolean isBooleanValue() {
		return BooleanValue;
	}

	/**
	 * @param booleanValue
	 *            the booleanValue to set
	 */
	public void setBooleanValue(boolean booleanValueIn) {
		BooleanValue = booleanValueIn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (BooleanValue ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(DoubleValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + IntValue;
		return result;
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Second other = (Second) obj;
		if (BooleanValue != other.BooleanValue)
			return false;
		if (Double.doubleToLongBits(DoubleValue) != Double.doubleToLongBits(other.DoubleValue))
			return false;
		if (IntValue != other.IntValue)
			return false;
		return true;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Second [IntValue=" + IntValue + ", DoubleValue=" + DoubleValue + ", BooleanValue=" + BooleanValue + "]";
	}

}
