
package registrationScheduler.threadMgmt;

import java.util.ArrayList;
import java.util.List;

import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.store.Results;
import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.ObjectPool;

/**
 * CreateWorker - This class creates the number of threads requested by the user
 * and starts and joins it.
 * 
 * @author Yash
 */
public class CreateWorkers {

	private FileProcessor fp;
	private Results res;
	private ObjectPool obj;

	// Constructor of CreateWorkers
	public CreateWorkers(FileProcessor fpIn, ObjectPool objIn, FileDisplayInterface resIn) {
		Logger.writeMessage("Constructor of CreateWorkers: "+this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
		this.fp = fpIn;
		this.res = (Results) resIn;
		this.obj = objIn;
	}

	/**
	 * This function creates the number of threads indicated by the user and
	 * start's them.
	 * 
	 * @param noOfThreads
	 *            how many threads user wants is indicated by the user.
	 * @return void
	 */
	// this class has the method startWokers(...)
	public void startWokers(int noOfThreads) {
		WorkerThread worker = new WorkerThread(fp, obj, res);
		List<Thread> threadList = new ArrayList<Thread>();

		for (int i = 0; i < noOfThreads; i++) {
			Thread t = new Thread(worker);
			threadList.add(t);
			t.start();
		}
		try {
			for (Thread t : threadList)
				t.join();
		} catch (InterruptedException e) {
			System.out.println("Interrupted Exception");
			e.printStackTrace();
			System.exit(1);
		} finally {

		}

	}

}