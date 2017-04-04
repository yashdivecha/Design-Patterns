package studentOrientation.util;

import studentOrientation.util.BookStore.BookStoreEnum;
import studentOrientation.util.CampusTour.CampusTourEnum;
import studentOrientation.util.Registration.RegisterEnum;
import studentOrientation.util.Dorms.DormsEnum;

/**
 * OrientationChecklist - This class is used to build orientation object. Client
 * visible class.
 * 
 * @author Yash
 *
 */
public class OrientationChecklist implements OrientationChecklistI {

	private CampusTour campusTour;
	private BookStore bookStore;
	private Dorms dorms;
	private Registration courses;
	private CurrencyCost currency;

	/**
	 * This constructor creates classes for each activities using user defined
	 * preferences.
	 * 
	 * @param ctIn
	 *            User defined preference for Campus Tour
	 * @param bookStoreIn
	 *            User defined preference for Book Store
	 * @param dormsIn
	 *            User defined preference for Dorms
	 * @param coursesIn
	 *            User defined preference for Registration
	 */
	public OrientationChecklist(CampusTourEnum ctIn, BookStoreEnum bookStoreIn, DormsEnum dormsIn,
			RegisterEnum coursesIn) {
		this.campusTour = new CampusTour(ctIn);
		this.bookStore = new BookStore(bookStoreIn);
		this.dorms = new Dorms(dormsIn);
		this.courses = new Registration(coursesIn);
		this.currency=CurrencyCost.DOLLARS;
	}
	public OrientationChecklist(CampusTourEnum ctIn, BookStoreEnum bookStoreIn, DormsEnum dormsIn,
			RegisterEnum coursesIn,CurrencyCost currencyIn) {
		this.campusTour = new CampusTour(ctIn);
		this.bookStore = new BookStore(bookStoreIn);
		this.dorms = new Dorms(dormsIn);
		this.courses = new Registration(coursesIn);
		this.currency=currencyIn;
	}

	/**
	 * This method calls the performsCampusTour for the orientation object.
	 * 
	 * @return void
	 */
	public void campusTour() {
		campusTour.performCampusTour();
	}

	/**
	 * This method calls the performsBuyBooks for the orientation object.
	 * 
	 * @return void
	 */
	public void buyBooks() {
		bookStore.performBuyBooks();
	}

	/**
	 * This method calls the performsSelectDorm for the orientation object.
	 * 
	 * @return void
	 */
	public void selectDorm() {
		dorms.performSelectDorms();
	}

	/**
	 * This method calls the performsRegiserCourses for the orientation object.
	 * 
	 * @return void
	 */
	public void registerCourses() {
		courses.performRegisterCourses();
	}

	/**
	 * This method returns the Campus Tour object
	 * 
	 * @param void
	 * @return CampusTour It returns the campus tour object.
	 */
	public CampusTour getCampusTourObj() {
		return campusTour;
	}

	/**
	 * This method returns the book Store object
	 * 
	 * @param void
	 * @return BookStore It returns the book store object.
	 */
	public BookStore getBookStoreObj() {
		return bookStore;
	}

	/**
	 * This method returns the Dorms object
	 * 
	 * @param void
	 * @return Dorms It returns the Dorm object.
	 */
	public Dorms getDormObj() {
		return dorms;
	}

	/**
	 * This method returns the Registration object
	 * 
	 * @param void
	 * @return Registation It returns the Registration object.
	 */
	public Registration getCourseObj() {
		return courses;
	}

	/**
	 * This method helps to fetch the summary of the activities.
	 * 
	 * @param void
	 * @return : String which represent the total cost, duration, carbon foot
	 *         prints, efforts.
	 */
	@Override
	public String toString() {
		double totalCost = campusTour.getCostObj().getCost() + getBookStoreObj().getCostObj().getCost()
				+ getDormObj().getCostObj().getCost() + getCourseObj().getCostObj().getCost();
		String totalConvertedCost=Cost.getCost(currency, totalCost);
		double totalDuration = campusTour.getDurationObj().getDuration()
				+ getBookStoreObj().getDurationObj().getDuration() + getDormObj().getDurationObj().getDuration()
				+ getCourseObj().getDurationObj().getDuration();
		double totalCarbonFootprints = campusTour.getCarbonFootPrintObj().getCarbonFootprint()
				+ getBookStoreObj().getCarbonFootPrintObj().getCarbonFootprint()
				+ getDormObj().getCarbonFootPrintObj().getCarbonFootprint()
				+ getCourseObj().getCarbonFootPrintObj().getCarbonFootprint();
		double totalEfforts = campusTour.getEffortsObj().getEfforts() + getBookStoreObj().getEffortsObj().getEfforts()
				+ getDormObj().getEffortsObj().getEfforts() + getCourseObj().getEffortsObj().getEfforts();
		String output = "Total Cost: " + totalConvertedCost + "\nTotal Duration: "
				+ String.format("%.2f mins", totalDuration) + "\nTotal Carbon Foot Prints: "
				+ String.format("%.2f CO2", totalCarbonFootprints) + "\nTotal Efforts: "
				+ String.format("%.2f calories", totalEfforts);
		return output;
	}
}
