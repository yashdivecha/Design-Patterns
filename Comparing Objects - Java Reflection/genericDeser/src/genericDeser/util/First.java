package genericDeser.util;

/**
 * First - This class has data members, getter and setter methods and hashCode,
 * equals methods and toString methods have been overridden.
 * 
 * @author Yash Divecha
 *
 */
public class First {

	// Data Members
	private int IntValue;
	private float FloatValue;
	private short ShortValue;
	private String StringValue;

	// Public Constructor.
	public First() {
		Logger.writeMessage("Constructor of First: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
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
	 * @return the floatValue
	 */
	public float getFloatValue() {
		return FloatValue;
	}

	/**
	 * @param floatValue
	 *            the floatValue to set
	 */
	public void setFloatValue(float floatValueIn) {
		FloatValue = floatValueIn;
	}

	/**
	 * @return the shortValue
	 */
	public short getShortValue() {
		return ShortValue;
	}

	/**
	 * @param shortValue
	 *            the shortValue to set
	 */
	public void setShortValue(short shortValueIn) {
		ShortValue = shortValueIn;
	}

	/**
	 * @return the stringValue
	 */
	public String getStringValue() {
		return StringValue;
	}

	/**
	 * @param stringValue
	 *            the stringValue to set
	 */
	public void setStringValue(String stringValueIn) {
		StringValue = stringValueIn;
	}

	/*
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(FloatValue);
		result = prime * result + IntValue;
		result = prime * result + ShortValue;
		result = prime * result + ((StringValue == null) ? 0 : StringValue.hashCode());
		return result;
	}	

	/*
	 * (non-Javadoc)
	 * 
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
		First other = (First) obj;
		if (Float.floatToIntBits(FloatValue) != Float.floatToIntBits(other.FloatValue))
			return false;
		if (IntValue != other.IntValue)
			return false;
		if (ShortValue != other.ShortValue)
			return false;
		if (StringValue == null) {
			if (other.StringValue != null)
				return false;
		} else if (!StringValue.equals(other.StringValue))
			return false;
		return true;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "First [IntValue=" + IntValue + ", FloatValue=" + FloatValue + ", ShortValue=" + ShortValue
				+ ", StringValue=" + StringValue + "]";
	}

}
