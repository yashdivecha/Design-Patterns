package genericDeser.util;

/**
 * Result - This class stores the unique and total number of instances created
 * after reading the file.
 * 
 * @author Yash Divecha
 *
 */
public class Result {

	private long uniqueFirst;
	private long uniqueSecond;
	private long totalFirst;
	private long totalSecond;

	// Public constructor.
	public Result() {
		Logger.writeMessage("Constructor of Result: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
		uniqueFirst = 0;
		totalFirst = 0;
		uniqueSecond = 0;
		totalSecond = 0;
	}

	// Getter and Setter method of the data members.
	/**
	 * @return the uniqueFirst
	 */
	public long getUniqueFirst() {
		return uniqueFirst;
	}

	/**
	 * @param uniqueFirst
	 *            the uniqueFirst to set
	 */
	public void setUniqueFirst(long uniqueFirst) {
		this.uniqueFirst = uniqueFirst;
	}

	/**
	 * @return the uniqueSecond
	 */
	public long getUniqueSecond() {
		return uniqueSecond;
	}

	/**
	 * @param uniqueSecond
	 *            the uniqueSecond to set
	 */
	public void setUniqueSecond(long uniqueSecond) {
		this.uniqueSecond = uniqueSecond;
	}

	/**
	 * @return the totalFirst
	 */
	public long getTotalFirst() {
		return totalFirst;
	}

	/**
	 * @param totalFirst
	 *            the totalFirst to set
	 */
	public void setTotalFirst(long totalFirst) {
		this.totalFirst = totalFirst;
	}

	/**
	 * @return the totalSecond
	 */
	public long getTotalSecond() {
		return totalSecond;
	}

	/**
	 * @param totalSecond
	 *            the totalSecond to set
	 */
	public void setTotalSecond(long totalSecond) {
		this.totalSecond = totalSecond;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Result [uniqueFirst=" + uniqueFirst + ", uniqueSecond=" + uniqueSecond + ", totalFirst=" + totalFirst
				+ ", totalSecond=" + totalSecond + "]";
	}

}
