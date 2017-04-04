package genericDeser.driver;

import genericDeser.fileOperations.FileProcessor;
import genericDeser.util.Logger;
import genericDeser.util.PopulateObjects;
import genericDeser.util.ValidateArguments;

public class Driver {

	public static void main(String[] args) {
		ValidateArguments check = new ValidateArguments();
		String inputArgs[] = check.validateInputArguments(args);

		// Sets the logger debug level.
		Logger.setDebugValue(Integer.parseInt(inputArgs[1]));

		FileProcessor fileProc = new FileProcessor(inputArgs[0]);
		PopulateObjects populateObjs = new PopulateObjects(fileProc);
		populateObjs.deserObjects();

	}
}
