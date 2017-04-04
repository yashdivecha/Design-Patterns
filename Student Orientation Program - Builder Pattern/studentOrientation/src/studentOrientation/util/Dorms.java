package studentOrientation.util;

/**
 * Dorms - This is an Activity class. This class checks the ENUM and
 * performSelectDorm depending on the values of enum. ONLINE_GAMING_CONTEST has
 * 2% surcharge.
 * 
 * @author Yash
 *
 */
public class Dorms implements OrientationActivitiesI, DormsI {

	private DormsEnum userDormChoice;
	private double standardPrice;
	private final double gameContestSurcharge = 2;
	private Cost cost;
	private Duration duration;
	private CarbonFootprint cfp;
	private Efforts efforts;

	// Used Enum because it is Type-Safe.
	public enum DormsEnum {
		LONG_QUEUE, ONLINE_GAMING_CONTEST
	};

	/**
	 * Constructor which sets the user preference and creates summary(cost,
	 * duration, carbon foot prints and efforts) objects.
	 * 
	 * @param DormsEnum:
	 *            User selects which method to use for selecting Dorm.
	 */
	public Dorms(DormsEnum userDormChoiceIn) {
		userDormChoice = userDormChoiceIn;
		cost = new Cost();
		duration = new Duration();
		cfp = new CarbonFootprint();
		efforts = new Efforts();
		standardPrice = 1000;
	}

	/**
	 * This method is used to set the summary parameters depending upon user
	 * preferences.
	 * 
	 * @param :
	 *            void
	 * @return : void
	 */
	public void performSelectDorms() {
		if (userDormChoice.equals(DormsEnum.LONG_QUEUE)) {
			cost.setCost(cost.calculateCost(standardPrice));
			duration.setDuration(duration.calculateDuration(120));
			cfp.setCarbonFootprint(cfp.calculateCarbonFootPrint(10));
			efforts.setEfforts(efforts.calculateEfforts(900));

		} else if (userDormChoice.equals(DormsEnum.ONLINE_GAMING_CONTEST)) {
			// 1 for percent increment and 0 for percent decrement 
			cost.setCost(cost.calculateCost(standardPrice, gameContestSurcharge, 1));
			duration.setDuration(duration.calculateDuration(30));
			cfp.setCarbonFootprint(cfp.calculateCarbonFootPrint(2));
			efforts.setEfforts(efforts.calculateEfforts(100));
		}
	}

	/**
	 * This method returns the Dorm summary (Cost) object.
	 * 
	 * @param void
	 * @return : Cost object which has cost field to get the Dorm cost.
	 */
	@Override
	public Cost getCostObj() {
		return cost;
	}

	/**
	 * This method returns the Dorm summary (Duration) object.
	 * 
	 * @param void
	 * @return : Duration object which has duration field to get the Dorm
	 *         duration.
	 */
	@Override
	public Duration getDurationObj() {
		return duration;
	}

	/**
	 * This method returns the Dorm summary (Carbon Foot Print) object.
	 * 
	 * @param void
	 * @return : Carbon Foot Print object which has carbonFootPrint field to get
	 *         the Dorm carbon foot print.
	 */
	@Override
	public CarbonFootprint getCarbonFootPrintObj() {
		return cfp;
	}

	/**
	 * This method returns the Dorm summary (Effort) object.
	 * 
	 * @param void
	 * @return : Effort object which has efforts field to get the Dorm efforts.
	 */
	@Override
	public Efforts getEffortsObj() {
		return efforts;
	}

}
