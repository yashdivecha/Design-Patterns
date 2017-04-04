package wordCount.driver;

import wordCount.dsForStrings.BST;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;
import wordCount.util.ValidateArguments;
import wordCount.visitors.CloneAndObserveVisitor;
import wordCount.visitors.DSProcessingVisitorI;
import wordCount.visitors.InitiateBackUpVisitor;
import wordCount.visitors.PopulateVisitor;
import wordCount.visitors.PrintVisitor;
import wordCount.visitors.PrintVisitor.displayType;
import wordCount.visitors.WordCountVisitor;

/**
 * Driver : This is the start of the program. Validate the arguments and
 * visitors will perform their respective work.
 * 
 * @author Yash Divecha
 *
 */
public class Driver {

	public static void main(String[] args) {
		// Validation
		ValidateArguments check = new ValidateArguments();
		String inputArgs[] = check.validateInputArguments(args);

		// Sets the logger debug level.
		Logger.setDebugValue(DebugLevel.NOOUTPUT);

		// Sets the number of iterations.
		int NUM_ITERATIONS = Integer.parseInt(inputArgs[2]);

		// Declaring class objects.

		long startTime = System.currentTimeMillis();

		// Declare objects.
		BST bst = null;
		FileProcessor fileProc;
		DSProcessingVisitorI populateVistor;
		DSProcessingVisitorI wordCountVisitor;

		for (int i = 0; i < NUM_ITERATIONS; i++) {
			// Create instances.
			fileProc = new FileProcessor(inputArgs[0], inputArgs[1]);
			bst = new BST();

			populateVistor = new PopulateVisitor(fileProc);
			wordCountVisitor = new WordCountVisitor(fileProc);

			bst.accept(populateVistor);
			bst.accept(wordCountVisitor);

			fileProc.closeFile();
		}

		long finishTime = System.currentTimeMillis();
		long total_time = (finishTime - startTime) / NUM_ITERATIONS;
		System.out.println("Total Time taken: " + total_time + "ms\n");

		DSProcessingVisitorI cloneObserverVisitor = new CloneAndObserveVisitor();
		bst.accept(cloneObserverVisitor);

		BST cloneBST = ((CloneAndObserveVisitor) cloneObserverVisitor).getTree();

		DSProcessingVisitorI initiateBackUpVisitor = new InitiateBackUpVisitor();
		bst.accept(initiateBackUpVisitor);

		DSProcessingVisitorI printToFileVisitor = new PrintVisitor(displayType.FILE);
		bst.accept(printToFileVisitor);
		cloneBST.accept(printToFileVisitor);

//		DSProcessingVisitorI printToScreenVisitor = new PrintVisitor(displayType.SCREEN);
//		bst.accept(printToScreenVisitor);
//		cloneBST.accept(printToScreenVisitor);
	}
}
