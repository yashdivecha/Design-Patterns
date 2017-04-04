package wordCount.util;

/**
 * ValidateArguments: This class is used to validate command line arguments.s
 * 
 * @author Yash Divecha
 *
 */
public class ValidateArguments {
	/**
	 * This function helps validating command line argument from the user.
	 * 
	 * @param argsIn
	 *            String[] of arguements.
	 * @return post validating, on success it returns the arguements otherwise
	 *         it exits.
	 */
	public String[] validateInputArguments(String[] argsIn) {
		if (argsIn.length != 3) {
			System.out.println("Invalid number of arguments:");
			System.out.println("Usage: java Driver <inputFile> <outputFile> <NUM_ITERATIONS>");
			System.exit(1);
		}
		return argsIn;
	}
}
