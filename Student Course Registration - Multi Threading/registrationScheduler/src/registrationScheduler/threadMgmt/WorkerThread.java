package registrationScheduler.threadMgmt;

import java.util.Arrays;

import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.store.Results;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.ObjectPool;

/**
 * WorkerThread - This implemented Runnable class run the Threads. It consists
 * of reading the line from the input file, executing allocation algorithm which
 * assign courses to the students and finally stores the results in the data
 * structure of the Results Class.
 * 
 * @author Yash
 */
public class WorkerThread implements Runnable {

	private FileProcessor fp;
	private Results res;
	private ObjectPool obj;

	// Constructor of the WorkerThread
	public WorkerThread(FileProcessor fpIn, ObjectPool objIn, FileDisplayInterface resIn) {
		Logger.writeMessage("Constructor of WorkerThread: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
		this.fp = fpIn;
		this.res = (Results) resIn;
		this.obj = objIn;
	}

	/**
	 * This function is used to print the input file data.
	 * 
	 * @param file
	 *            the inputFile has been taken into ConcurrentHashMap
	 * @return void
	 */
	public synchronized void display(ConcurrentHashMap<String, Vector<Integer>> file) {
		for (Map.Entry<String, Vector<Integer>> entry : file.entrySet())
			System.out.println(entry.getKey() + " " + entry.getValue());
	}

	/**
	 * This is the helper function which adds the student and the course.
	 * 
	 * @param student
	 *            name of the student
	 * @param course
	 *            name of the course
	 * @return void
	 */
	private synchronized void addElements(String student, char course) {
		Vector<Character> v = new Vector<Character>();
		if (res.getOutputMap().containsKey(student))
			v = res.getOutputMap().get(student);
		v.add(course);

		res.getOutputMap().put(student, v);
		res.setOutputMap(res.getOutputMap());
		if (Logger.getDebugValue() == Logger.DebugLevel.RESULT)
			Logger.writeMessage("Entry Added: " + res.getOutputMap()+"\n\n", Logger.DebugLevel.RESULT);
	}

	/**
	 * This is the allocation algorithm which does all the assignments of
	 * courses to all the students
	 * 
	 * @param file
	 *            Vector consisting of the input file.
	 * @return void
	 */
	public void allocationAlgo(Vector<String> file) {
		int counter = 0;
		int index = 0;

		while (true) {
			for (int i = 0; i < file.size(); i++) {
				String input[] = file.get(i).split("\\s+");
				if (res.getOutputMap().containsKey(input[0]) && res.getOutputMap().get(input[0]).size() == 5)
					break;
				switch (input[(index + 1) % 7]) {
				case "1":
					if (!Arrays.asList(res.getOutputMap().get(input[0])).contains('A')
							&& Arrays.asList(input).contains("1") && obj.checkAvailability('A')) {
						// addElements(input[0], 'A');
						addElements(input[0], obj.borrowObject('A'));
						// countA++;
						int temp = 0;
						if (res.getPreferenceCount().containsKey(input[0])) {
							temp = res.getPreferenceCount().get(input[0]);
							temp = temp + 1;
							res.getPreferenceCount().put(input[0], temp);
							res.setPreferenceCount(res.getPreferenceCount());
						}
						counter++;
						break;
					}
				case "2":
					if (!Arrays.asList(res.getOutputMap().get(input[0])).contains('B')
							&& Arrays.asList(input).contains("2") && obj.checkAvailability('B')) {
						// addElements(input[0], 'B');
						addElements(input[0], obj.borrowObject('B'));
						// countB++;
						int temp = 0;
						if (res.getPreferenceCount().containsKey(input[0])) {
							temp = res.getPreferenceCount().get(input[0]);
							temp = temp + 2;
							res.getPreferenceCount().put(input[0], temp);
							res.setPreferenceCount(res.getPreferenceCount());
						}
						counter++;
						break;
					}
				case "3":
					if (!Arrays.asList(res.getOutputMap().get(input[0])).contains('C')
							&& Arrays.asList(input).contains("3") && obj.checkAvailability('C')) {
						// addElements(input[0], 'C');
						addElements(input[0], obj.borrowObject('C'));
						// countC++;
						int temp = 0;
						if (res.getPreferenceCount().containsKey(input[0])) {
							temp = res.getPreferenceCount().get(input[0]);
							temp = temp + 3;
							res.getPreferenceCount().put(input[0], temp);
							res.setPreferenceCount(res.getPreferenceCount());
						}
						counter++;
						break;
					}
				case "4":
					if (!Arrays.asList(res.getOutputMap().get(input[0])).contains('D')
							&& Arrays.asList(input).contains("4") && obj.checkAvailability('D')) {
						// addElements(input[0], 'D');
						addElements(input[0], obj.borrowObject('D'));
						// countD++;
						int temp = 0;
						if (res.getPreferenceCount().containsKey(input[0])) {
							temp = res.getPreferenceCount().get(input[0]);
							temp = temp + 4;
							res.getPreferenceCount().put(input[0], temp);
							res.setPreferenceCount(res.getPreferenceCount());
						}
						counter++;
						break;
					}
				case "5":
					if (!Arrays.asList(res.getOutputMap().get(input[0])).contains('E')
							&& Arrays.asList(input).contains("5") && obj.checkAvailability('E')) {
						// addElements(input[0], 'E');
						addElements(input[0], obj.borrowObject('E'));
						// countE++;
						int temp = 0;
						if (res.getPreferenceCount().containsKey(input[0])) {
							temp = res.getPreferenceCount().get(input[0]);
							temp = temp + 5;
							res.getPreferenceCount().put(input[0], temp);
							res.setPreferenceCount(res.getPreferenceCount());
						}
						counter++;
						break;
					}
				case "6":
					if (!Arrays.asList(res.getOutputMap().get(input[0])).contains('F')
							&& Arrays.asList(input).contains("6") && obj.checkAvailability('F')) {
						// addElements(input[0], 'F');
						addElements(input[0], obj.borrowObject('F'));
						// countF++;
						int temp = 0;
						if (res.getPreferenceCount().containsKey(input[0])) {
							temp = res.getPreferenceCount().get(input[0]);
							temp = temp + 6;
							res.getPreferenceCount().put(input[0], temp);
							res.setPreferenceCount(res.getPreferenceCount());
						}
						counter++;
						break;
					}
				case "7":
					if (!Arrays.asList(res.getOutputMap().get(input[0])).contains('G')
							&& Arrays.asList(input).contains("7") && obj.checkAvailability('G')) {
						// addElements(input[0], 'G');
						addElements(input[0], obj.borrowObject('G'));
						// countG++;
						int temp = 0;
						if (res.getPreferenceCount().containsKey(input[0])) {
							temp = res.getPreferenceCount().get(input[0]);
							temp = temp + 7;
							res.getPreferenceCount().put(input[0], temp);
							res.setPreferenceCount(res.getPreferenceCount());
						}
						counter++;
						break;
					}
				}
			}
			index++;
			if (counter == 400 || index == 6)
				break;

		}
	}

	/**
	 * This function is called by the threads when it gets started.
	 */
	public void run() {
		try {
			Logger.writeMessage("Thread's run() method is called.", Logger.DebugLevel.RUN);
			String line = null;
			Vector<String> fileContents = new Vector<>();
			while ((line = fp.readNextLine()) != null) {
				String[] splitTerm = line.split("\\s+");
				Vector<Integer> test = new Vector<Integer>();
				for (int i = 0; i < splitTerm.length - 1; i++)
					test.add(Integer.parseInt(splitTerm[i + 1]));

				res.getPreferenceCount().put(splitTerm[0], 0);
				res.setPreferenceCount(res.getPreferenceCount());
				fileContents.add(line);
			}
			allocationAlgo(fileContents);
			if (Logger.getDebugValue() == Logger.DebugLevel.STOREOUTPUTMAP) {
				System.out.println(res.getOutputMap());
			}

			// System.out.println(obj.getObjectCount('A') + " " +
			// obj.getObjectCount('B') + " " + obj.getObjectCount('C')
			// + " " + obj.getObjectCount('D') + " " + obj.getObjectCount('E') +
			// " " + obj.getObjectCount('F')
			// + " " + obj.getObjectCount('G'));

		} catch (Exception e) {
			System.out.println("Exception occured.");
			e.printStackTrace();
			System.exit(1);
		}
	}
}
