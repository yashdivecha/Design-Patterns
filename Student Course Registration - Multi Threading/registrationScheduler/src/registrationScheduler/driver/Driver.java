
package registrationScheduler.driver;

import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.store.Results;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.ObjectPool;
import registrationScheduler.util.ObjectPoolClass;
import registrationScheduler.util.Validation;

/**
 * Driver - This class validated the command line arguments and calls the
 * startWorker function and captures the result on screen and file.
 * 
 * @author Yash
 *
 */
public class Driver {

	/**
	 * This is the start of the program and proceeds.
	 * 
	 * @param args
	 *            A string array containing the command line arguments
	 * @return No return value
	 */
	public static void main(String args[]) {

		// Validation
		Validation check = new Validation();
		String inputArgs[] = check.validateArguments(args);

		// Sets the logger debug level.
		Logger.setDebugValue(Integer.parseInt(inputArgs[3]));

		// Creates an instance.
		FileProcessor fileProc = FileProcessor.getInstance(inputArgs[0]);

		// Will be used for capturing the output
		FileDisplayInterface res = Results.getInstance();

		// Creates an instance.
		ObjectPool obj = ObjectPoolClass.getInstance();

		// Calls create workers to create the number of threads and start them.
		CreateWorkers cw = new CreateWorkers(fileProc, obj, res);
		cw.startWokers(Integer.parseInt(inputArgs[2]));

		// Prints the result on to the screen and in the file.
		((Results) res).writeSchedulesToScreen();
		res.writeSchedulesToFile(inputArgs[1]);
	} // end main(...)

} // end public class Driver
