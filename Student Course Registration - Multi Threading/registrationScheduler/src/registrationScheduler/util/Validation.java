package registrationScheduler.util;

/**
 * Validation - This class is used to validate command line arguments
 * 
 * @author Yash
 *
 */
public class Validation {

	/**
	 * This function helps validating command line argument from the user.
	 * 
	 * @param argsIn
	 *            String[] of arguements.
	 * @return post validating, on success it returns the arguements otherwise
	 *         it exits.
	 */
	public String[] validateArguments(String[] argsIn) {
		if (argsIn.length != 4) {
			System.out.println("Invalid number of arguments:");
			System.out.println("Usage: java Driver <inputFile> <outputFile> <NUM_THREADS> <debugLevel>");
			System.exit(1);
		} else if ((Integer.parseInt(argsIn[2]) < 1) || ((Integer.parseInt(argsIn[2]) > 3))) {
			System.out.println("Number of Threads should be between 1 and 3");
			System.exit(1);
		} else if ((Integer.parseInt(argsIn[3]) < 0 || (Integer.parseInt(argsIn[3]) > 4))) {
			System.out.println("Debug Level should be between 0 and 4");
			System.out.println("0 - No Output");
			System.out.println("1 - Store Data Structure");
			System.out.println("2 - Result");
			System.out.println("3 - Run");
			System.out.println("4 - Constructor");
			System.exit(1);
		}
		return argsIn;
	}
}
