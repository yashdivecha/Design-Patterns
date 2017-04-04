package studentOrientation.util;

/**
 * CampusTour- This is an Activity class. This class checks the ENUM and
 * performCampusTour depending on the values of enum. BUS_RIDE cost is 2.00$ and
 * ON_FOOT cost is 0.10$.
 * 
 * @author Yash
 *
 */
public class CampusTour implements OrientationActivitiesI, CampusTourI {

	private CampusTourEnum userCampusTourChoice;
	private Cost cost;
	private Duration duration;
	private CarbonFootprint cfp;
	private Efforts efforts;

	// Used Enum because it is Type-Safe.
	public enum CampusTourEnum {
		BUS_RIDE, ON_FOOT
	};

	/**
	 * Constructor which sets the user preference and creates summary(cost,
	 * duration, carbon foot prints and efforts) objects.
	 * 
	 * @param CampusTourEnum:
	 *            User selects how they want to do campus tour using Enum.
	 */
	public CampusTour(CampusTourEnum userCampusTourChoiceIn) {
		userCampusTourChoice = userCampusTourChoiceIn;
		cost = new Cost();
		duration = new Duration();
		cfp = new CarbonFootprint();
		efforts = new Efforts();
	}

	/**
	 * This method is used to set the summary parameters depending upon user
	 * preferences.
	 * 
	 * @param :
	 *            void
	 * @return : void
	 */
	public void performCampusTour() {
		if (userCampusTourChoice.equals(CampusTourEnum.BUS_RIDE)) {
			cost.setCost(cost.calculateCost(2.00));
			duration.setDuration(duration.calculateDuration(45));
			cfp.setCarbonFootprint(cfp.calculateCarbonFootPrint(4));
			efforts.setEfforts(efforts.calculateEfforts(250));
		} else if (userCampusTourChoice.equals(CampusTourEnum.ON_FOOT)) {
			cost.setCost(cost.calculateCost(0.10));
			duration.setDuration(duration.calculateDuration(180));
			cfp.setCarbonFootprint(cfp.calculateCarbonFootPrint(40));
			efforts.setEfforts(efforts.calculateEfforts(1500));
		}

	}

	/**
	 * This method returns the Campus Tour summary (Cost) object.
	 * 
	 * @param void
	 * @return : Cost object which has cost field to get the Campus Tour cost.
	 */
	@Override
	public Cost getCostObj() {
		return cost;
	}

	/**
	 * This method returns the Campus Tour summary (Duration) object.
	 * 
	 * @param void
	 * @return : Duration object which has duration field to get the Campus Tour
	 *         duration.
	 */
	@Override
	public Duration getDurationObj() {
		return duration;
	}

	/**
	 * This method returns the Campus Tour summary (Carbon Foot Print) object.
	 * 
	 * @param void
	 * @return : Carbon Foot Print object which has carbonFootPrint field to get
	 *         the Campus Tour carbon foot print.
	 */
	@Override
	public CarbonFootprint getCarbonFootPrintObj() {
		return cfp;
	}

	/**
	 * This method returns the Campus Tour summary (Effort) object.
	 * 
	 * @param void
	 * @return : Effort object which has efforts field to get the Campus Tour
	 *         efforts.
	 */
	@Override
	public Efforts getEffortsObj() {
		return efforts;
	}
}
