package studentOrientation.util;

/**
 * This interface helps to retrieve summary Objects (Cost, Duration, Carbon
 * FootPrint, Efforts)
 * 
 * @author Yash
 *
 */
public interface OrientationActivitiesI {

	public Cost getCostObj();

	public Duration getDurationObj();

	public CarbonFootprint getCarbonFootPrintObj();

	public Efforts getEffortsObj();
}
