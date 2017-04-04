package studentOrientation.util;

/**
 * OrientationWorkshop - This class is used to enforces the series of activities
 * that need to perform to complete the orientation checklist
 * 
 * @author Yash
 *
 */
public class OrientationWorkshop implements OrientationWorkshopI {

	public void construct(OrientationChecklistI orientationChecklist) {
		orientationChecklist.campusTour();
		orientationChecklist.buyBooks();
		orientationChecklist.selectDorm();
		orientationChecklist.registerCourses();
	}

}
