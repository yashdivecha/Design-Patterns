package registrationScheduler.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileProcessor {
	private static volatile FileProcessor uniqueFileProcessor = null;
	private BufferedReader br;
	private FileInputStream fIn;

	/**
	 * Singleton Pattern is implemented hence used double checked locking to
	 * return an instance of this class
	 * 
	 * @param fileName
	 *            Name of the input file
	 * @return Newly created object of the File Processor class
	 */
	public static FileProcessor getInstance(String fileName) {
		if (uniqueFileProcessor == null) {
			synchronized (FileProcessor.class) {
				if (uniqueFileProcessor == null) {
					uniqueFileProcessor = new FileProcessor(fileName);
				}
			}
		}
		return uniqueFileProcessor;
	}

	// Private Constructor
	private FileProcessor(String fileName) {
		try {
			Logger.writeMessage("Constructor of File Processor: "+this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
			fIn = new FileInputStream(fileName);
			br = new BufferedReader(new InputStreamReader(fIn));
		} catch (FileNotFoundException e) {
			System.out.println("File " + fileName + " not found");
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
	public synchronized String readNextLine() {
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
	 * This function sets the pointer to the start of the file
	 */
	public synchronized void resetPointer() {
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
