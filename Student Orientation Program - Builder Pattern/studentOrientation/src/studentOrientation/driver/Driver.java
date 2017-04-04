package studentOrientation.driver;

import studentOrientation.util.OrientationChecklist;
import studentOrientation.util.OrientationChecklistI;
import studentOrientation.util.OrientationWorkshop;
import studentOrientation.util.OrientationWorkshopI;

import java.util.Currency;

import studentOrientation.util.BookStore.BookStoreEnum;
import studentOrientation.util.CampusTour.CampusTourEnum;
import studentOrientation.util.CurrencyCost;
import studentOrientation.util.Registration.RegisterEnum;
import studentOrientation.util.Dorms.DormsEnum;

/**
 * Driver - Start of the Program. This class initializes the Checklist
 * constructor and calls the construct method using OrientationWorkshop object
 * to build the orientation object.
 * 
 * @author Yash
 *
 */
public class Driver {

	public static void main(String[] args) {

		OrientationChecklistI orientation = new OrientationChecklist(CampusTourEnum.BUS_RIDE,
				BookStoreEnum.UNIVERSITY_BOOK_STORE, DormsEnum.LONG_QUEUE, RegisterEnum.SUBMIT_FORMS_WITH_PAYCHECK);
		
//		This constructor is more flexible to the user, he can choose currency between DOLLARS, POUNDS, RUPEES
//		OrientationChecklistI orientation = new OrientationChecklist(CampusTourEnum.BUS_RIDE,
//				BookStoreEnum.UNIVERSITY_BOOK_STORE, DormsEnum.LONG_QUEUE, RegisterEnum.SUBMIT_FORMS_WITH_PAYCHECK, CurrencyCost.RUPEES);
		OrientationWorkshopI shop = new OrientationWorkshop();
		shop.construct(orientation);
		System.out.println(orientation);		
	}

}
