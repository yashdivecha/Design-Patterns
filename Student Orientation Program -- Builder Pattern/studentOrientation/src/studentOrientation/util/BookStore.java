package studentOrientation.util;

/**
 * BookStore - This is an Activity class. This class checks the ENUM and
 * performBuyBook depending on the values of enum. UNIVERSITY_BOOK_STORE is 5
 * percent cheaper than MANDO_BOOK_STORE
 * 
 * @author Yash
 *
 */
public class BookStore implements OrientationActivitiesI, BookStoreI {

	private BookStoreEnum userBookStoreChoice;
	private double standardPrice;
	private final double mandoPriceDifference = 5;
	private Cost cost;
	private Duration duration;
	private CarbonFootprint cfp;
	private Efforts efforts;

	// Used Enum because it is Type-Safe.
	public enum BookStoreEnum {
		UNIVERSITY_BOOK_STORE, MANDO_BOOK_STORE
	};

	/**
	 * Constructor which sets the user preference and creates summary(cost,
	 * duration, carbon foot prints and efforts) objects.
	 * 
	 * @param BookStoreEnum:
	 *            User selects which Book Store using Enum
	 */
	public BookStore(BookStoreEnum userBookStoreChoiceIn) {
		userBookStoreChoice = userBookStoreChoiceIn;
		cost = new Cost();
		duration = new Duration();
		cfp = new CarbonFootprint();
		efforts = new Efforts();
		standardPrice = 100;
	}

	/**
	 * This method is used to set the summary parameters depending upon user
	 * preferences.
	 * 
	 * @param :
	 *            void
	 * @return : void
	 */
	public void performBuyBooks() {
		if (userBookStoreChoice.equals(BookStoreEnum.UNIVERSITY_BOOK_STORE)) {
			cost.setCost(cost.calculateCost(standardPrice));
			duration.setDuration(duration.calculateDuration(30));
			cfp.setCarbonFootprint(cfp.calculateCarbonFootPrint(6));
			efforts.setEfforts(efforts.calculateEfforts(250));

		} else if (userBookStoreChoice.equals(BookStoreEnum.MANDO_BOOK_STORE)) {
			// 1 for percent increment and 0 for percent decrement
			cost.setCost(cost.calculateCost(standardPrice, mandoPriceDifference, 1));
			duration.setDuration(duration.calculateDuration(180));
			cfp.setCarbonFootprint(cfp.calculateCarbonFootPrint(16));
			efforts.setEfforts(efforts.calculateEfforts(500));
		}
	}

	/**
	 * This method returns the Book Store summary (Cost) object.
	 * 
	 * @param void
	 * @return : Cost object which has cost field to get the Book Store cost.
	 */
	@Override
	public Cost getCostObj() {
		return cost;
	}

	/**
	 * This method returns the Book Store summary (Duration) object.
	 * 
	 * @param void
	 * @return : Duration object which has duration field to get the Book Store
	 *         duration.
	 */
	@Override
	public Duration getDurationObj() {
		return duration;
	}

	/**
	 * This method returns the Book Store summary (Carbon Foot Print) object.
	 * 
	 * @param void
	 * @return : Carbon Foot Print object which has carbonFootPrint field to get
	 *         the Book Store carbon foot print.
	 */
	@Override
	public CarbonFootprint getCarbonFootPrintObj() {
		return cfp;
	}

	/**
	 * This method returns the Book Store summary (Effort) object.
	 * 
	 * @param void
	 * @return : Effort object which has efforts field to get the Book Store
	 *         efforts.
	 */
	@Override
	public Efforts getEffortsObj() {
		return efforts;
	}
}
