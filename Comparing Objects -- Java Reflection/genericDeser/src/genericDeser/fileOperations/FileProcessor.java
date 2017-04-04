package genericDeser.fileOperations;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import genericDeser.util.Logger;

/**
 * FileProcessor: This class is used for file operations.
 * 
 * @author Yash Divecha
 *
 */
public class FileProcessor {
	private BufferedReader br;
	private FileInputStream fIn;

	// Public Constructor
	public FileProcessor(String fileInputName) {
		try {
			Logger.writeMessage("Constructor of File Processor: " + this.getClass().getName(),
					Logger.DebugLevel.CONSTRUCTOR);
			fIn = new FileInputStream(fileInputName);
			br = new BufferedReader(new InputStreamReader(fIn));

		} catch (FileNotFoundException e) {
			System.out.println("File " + fileInputName + " not found");
			e.printStackTrace();
			System.exit(1);
		} finally {
		}
	}

	/**
	 * This function reads the single line and returns it.
	 * 
	 * @return String next Line is returned
	 */
	public String readNextLine() {
		try {
			String line;
			if ((line = br.readLine()) != null)
				return line;
		} catch (IOException e) {
			System.out.println("Unable to read line");
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
		return null;
	}
	/**
	 * This function is used to close the Buffered Reader. 
	 */

	public void closeFile() {
		try {
			br.close();
		} catch (IOException e) {
			System.out.println("Unable to close the file due to IOException");
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
	}

	/**
	 * This function sets the pointer to the start of the file
	 */
	public void resetPointer() {
		try {
			fIn.getChannel().position(0);
		} catch (IOException e) {
			System.out.println("Couln't point to the start of the file.");
			e.printStackTrace();
			System.exit(1);
		} finally {
		}
	}

}
