
package registrationScheduler.util;

/**
 * Logger - This class is used for debugging purpose. Depending upon the Debug
 * Level it prints on the screen.
 * 
 * @author Yash
 */
public class Logger {

	public static enum DebugLevel {
		NOOUTPUT, STOREOUTPUTMAP, RESULT, RUN, CONSTRUCTOR
	};

	private static DebugLevel debugLevel;

	public static DebugLevel getDebugValue() {
		return debugLevel;
	}

	/**
	 * Sets the debug value provided the user as an argument.
	 * 
	 * @param levelIn
	 *            debug value to set the enumerator value
	 * @return void
	 */
	public static void setDebugValue(int levelIn) {
		switch (levelIn) {
		case 0:
			debugLevel = DebugLevel.NOOUTPUT;
			break;
		case 1:
			debugLevel = DebugLevel.STOREOUTPUTMAP;
			break;
		case 2:
			debugLevel = DebugLevel.RESULT;
			break;
		case 3:
			debugLevel = DebugLevel.RUN;
			break;
		case 4:
			debugLevel = DebugLevel.CONSTRUCTOR;
			break;
		}
	}

	/**
	 * Sets the debug level by the providing Debug Level.
	 * 
	 * @param levelIn
	 *            - Debug Level which you want to set.
	 */
	public static void setDebugValue(DebugLevel levelIn) {
		debugLevel = levelIn;
	}

	/**
	 * Displays output on screen depending upon the DebugLevel
	 * 
	 * @param message
	 *            to display on screen
	 * @param levelIn
	 *            debug level.
	 */
	public static void writeMessage(String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
			System.out.println(message);
	}

	@Override
	public String toString() {
		return "Debug Level is " + debugLevel;
	}
}
