package registrationScheduler.store;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Period;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import registrationScheduler.util.Logger;

/**
 * Results - This Singleton class stores the allocated the courses and students
 * into ConcurrentHashMap.
 * 
 * @author Yash
 *
 */
public class Results implements StdoutDisplayInterface, FileDisplayInterface {

	// Data Structure which stores the output
	private ConcurrentHashMap<String, Vector<Character>> mapOutput;
	// Data Structure which stores the preference count of individual students
	private ConcurrentHashMap<String, Integer> preferenceCount;
	private static volatile Results uniqueRes = null;

	/**
	 * Singleton Pattern is implemented hence used double checked locking to
	 * return an object of this class.
	 *
	 * @return Newly created object of the Results class
	 */
	public static Results getInstance() {
		if (uniqueRes == null) {
			synchronized (Results.class) {
				if (uniqueRes == null) {
					uniqueRes = new Results();
				}
			}
		}
		return uniqueRes;
	}

	// Initialization of the data structures using private Constructor
	private Results() {
		Logger.writeMessage("Constructor of Results: "+this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
		mapOutput = new ConcurrentHashMap<String, Vector<Character>>();
		preferenceCount = new ConcurrentHashMap<String, Integer>();
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	// Getter and Setter methods.
	public ConcurrentHashMap<String, Vector<Character>> getOutputMap() {
		return mapOutput;
	}

	public void setOutputMap(ConcurrentHashMap<String, Vector<Character>> matOutputIn) {
		this.mapOutput = matOutputIn;
	}

	public ConcurrentHashMap<String, Integer> getPreferenceCount() {
		return preferenceCount;
	}

	public void setPreferenceCount(ConcurrentHashMap<String, Integer> preferenceCountIn) {
		this.preferenceCount = preferenceCountIn;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * It is used to write the Student course allocation output to File along
	 * with the average preference score
	 * 
	 * @param outputFile
	 *            the file to which data is to be written
	 * @return void
	 * 
	 */
	@Override
	public synchronized void writeSchedulesToFile(String outputFile) {
		BufferedWriter bw = null;
		try {
			int noOfRows = 0, total = 0;
			bw = new BufferedWriter(new FileWriter(outputFile));
			for (Map.Entry<String, Vector<Character>> entry : mapOutput.entrySet()) {
				// System.out.print(entry.getKey() + " ");
				noOfRows++;
				bw.write(entry.getKey() + " ");
				total += preferenceCount.get(entry.getKey());
				for (int i = 0; i < entry.getValue().size(); i++)
					bw.write(entry.getValue().get(i) + " ");
				// System.out.print(entry.getValue().get(i) + " ");
				// bw.write(this.preferenceCount.get(entry.getKey()) + "\n");
				bw.write("\n");
				// System.out.println();
			}
			bw.write("Average preference_score is: " + (double) total / noOfRows);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				System.out.println("Buffered Write cannot be closed.");
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	/**
	 * It is used to display the Student course allocation output on Screen
	 * along with the average preference score
	 * 
	 * @param void
	 * @return void
	 * 
	 */
	@Override
	public synchronized void writeSchedulesToScreen() {
		int noOfRows = 0, total = 0;
		for (Map.Entry<String, Vector<Character>> entry : mapOutput.entrySet()) {
			noOfRows++;
			System.out.print(entry.getKey() + " ");
			total += preferenceCount.get(entry.getKey());
			for (int i = 0; i < entry.getValue().size(); i++)
				System.out.print(entry.getValue().get(i) + " ");
			System.out.println();
			// System.out.println("\t
			// "+this.preferenceCount.get(entry.getKey()));
		}
		System.out.println("Average preference_score is: " + (double) total / noOfRows);
	}

	// This is used for debugging purpose.
	@Override
	public String toString() {
		return "Contents of the Data Structure: \n" + getOutputMap();
	}

}
