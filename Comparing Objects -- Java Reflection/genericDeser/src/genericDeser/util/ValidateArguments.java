package genericDeser.util;

/**
 * ValidateArguments: This class is used to validate command line arguments.
 * 
 * @author Yash Divecha
 *
 */
public class ValidateArguments {
	/**
	 * This function helps validating command line argument from the user.
	 * 
	 * @param argsIn
	 *            String[] of arguments.
	 * @return post validating, on success it returns the arguments otherwise
	 *         it exits.
	 */
	public String[] validateInputArguments(String[] argsIn) {
		if (argsIn.length != 2) {
			System.out.println("Invalid number of arguments:");
			System.out.println("Usage: java Driver <inputFile> <DEBUG_VALUE>");
			System.exit(1);
		}
		return argsIn;
	}
}
