package studentOrientation.util;

/**
 * Registration - This is an Activity class. This class checks the ENUM and
 * performregisterCourses depending on the values of enum.
 * SUBMIT_FORMS_WITH_PAYCHECK cost is 3% cheaper than
 * ACCESS_REGISTRATION_SYSTEM.
 * 
 * @author Yash
 *
 */
public class Registration implements OrientationActivitiesI, RegistrationI {

	private RegisterEnum userCourseChoice;
	private double standardPrice;
	private final double submitFormCheaper = 3;
	private Cost cost;
	private Duration duration;
	private CarbonFootprint cfp;
	private Efforts efforts;

	// Used Enum because it is Type-Safe.
	public enum RegisterEnum {
		SUBMIT_FORMS_WITH_PAYCHECK, ACCESS_REGISTRATION_SYSTEM
	};

	/**
	 * Constructor which sets the user preference and creates summary(cost,
	 * duration, carbon foot prints and efforts) objects.
	 * 
	 * @param RegisterEnum:
	 *            User selects method for registration using Enum.
	 */
	public Registration(RegisterEnum userCourseChoiceIn) {
		userCourseChoice = userCourseChoiceIn;
		cost = new Cost();
		duration = new Duration();
		cfp = new CarbonFootprint();
		efforts = new Efforts();
		standardPrice = 13000;
	}

	/**
	 * This method is used to set the summary parameters depending upon user
	 * preferences.
	 * 
	 * @param :
	 *            void
	 * @return : void
	 */
	public void performRegisterCourses() {
		if (userCourseChoice.equals(RegisterEnum.ACCESS_REGISTRATION_SYSTEM)) {
			cost.setCost(cost.calculateCost(standardPrice));
			duration.setDuration(duration.calculateDuration(30));
			cfp.setCarbonFootprint(cfp.calculateCarbonFootPrint(2));
			efforts.setEfforts(efforts.calculateEfforts(100));

		} else if (userCourseChoice.equals(RegisterEnum.SUBMIT_FORMS_WITH_PAYCHECK)) {
			// 1 for percent increment and 0 for percent decrement
			cost.setCost(cost.calculateCost(standardPrice, submitFormCheaper, 0));
			duration.setDuration(duration.calculateDuration(60));
			cfp.setCarbonFootprint(cfp.calculateCarbonFootPrint(10));
			efforts.setEfforts(efforts.calculateEfforts(600));
		}

	}

	/**
	 * This method returns the Register summary (Cost) object.
	 * 
	 * @param void
	 * @return : Cost object which has cost field to get the Register cost.
	 */
	@Override
	public Cost getCostObj() {
		return cost;
	}

	/**
	 * This method returns the Register summary (Duration) object.
	 * 
	 * @param void
	 * @return : Duration object which has duration field to get the Register
	 *         duration.
	 */
	@Override
	public Duration getDurationObj() {
		return duration;
	}

	/**
	 * This method returns the Register summary (Carbon Foot Print) object.
	 * 
	 * @param void
	 * @return : Carbon Foot Print object which has carbonFootPrint field to get
	 *         the Register carbon foot print.
	 */
	@Override
	public CarbonFootprint getCarbonFootPrintObj() {
		return cfp;
	}

	/**
	 * This method returns the Register summary (Effort) object.
	 * 
	 * @param void
	 * @return : Effort object which has efforts field to get the Register
	 *         efforts.
	 */
	@Override
	public Efforts getEffortsObj() {
		return efforts;
	}

}
