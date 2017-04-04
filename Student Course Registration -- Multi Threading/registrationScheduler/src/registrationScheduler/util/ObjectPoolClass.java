package registrationScheduler.util;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ObjectPoolClass - This Singleton class creates object of 7 courses and
 * provides functionality of borrowing, adding objects (course), checking the
 * availability.
 * 
 * @author Yash
 */
public class ObjectPoolClass implements ObjectPool {

	// Data structure contains 7 courses and their corresponding course count.
	private ConcurrentHashMap<Character, Integer> courseMap;
	private static volatile ObjectPoolClass uniqueObj;

	/**
	 * Singleton Pattern is implemented hence used double checked locking to
	 * return an object of this class.
	 * 
	 * @return Newly created ObjectPoolClass object
	 */
	public static ObjectPoolClass getInstance() {
		if (uniqueObj == null) {
			synchronized (ObjectPoolClass.class) {
				if (uniqueObj == null) {
					uniqueObj = new ObjectPoolClass();
				}
			}
		}
		return uniqueObj;
	}

	// Private Constructor
	private ObjectPoolClass() {
		Logger.writeMessage("Constructor of Object Pool: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
		courseMap = new ConcurrentHashMap<>();
		courseMap.put('A', 0);
		courseMap.put('B', 0);
		courseMap.put('C', 0);
		courseMap.put('D', 0);
		courseMap.put('E', 0);
		courseMap.put('F', 0);
		courseMap.put('G', 0);
	}

	/**
	 * This function returns course name and increments the counter.
	 * 
	 * @param course
	 *            name
	 * @char returns the course name
	 */
	@Override
	public synchronized char borrowObject(char courseName) {
		int count = 0;
		if (courseMap.containsKey(courseName)) {
			count = courseMap.get(courseName);
			count++;
			courseMap.put(courseName, count);
		}
		return courseName;
	}

	// Getter method of CourseMap data Structure
	public ConcurrentHashMap<Character, Integer> getCourseMap() {
		return courseMap;
	}

	/**
	 * This function adds the new object (course) in this class.
	 * 
	 * @param course
	 *            name
	 * @return void
	 */
	@Override
	public void addObject(char courseName) {
		if (!courseMap.containsKey(courseName))
			courseMap.put(courseName, 0);
	}

	/**
	 * This function returns the count of the course
	 * 
	 * @param course
	 *            name
	 * @return int count of the given coursename.
	 */
	@Override
	public synchronized int getObjectCount(char courseName) {
		if (courseMap.containsKey(courseName))
			return courseMap.get(courseName);
		return -1;
	}

	/**
	 * This function checks whether course if full or not.
	 * 
	 * @param course
	 *            name
	 * @return boolean variable which indicates whether course is full or not.
	 */
	@Override
	public boolean checkAvailability(char courseName) {
		if (courseMap.containsKey(courseName))
			return (courseMap.get(courseName) < 60);
		return false;
	}

	/**
	 * This function clears all the objects in the object pool
	 */
	@Override
	public void clear() {
		courseMap.clear();
	}

	/**
	 * This function invalidates (sets the counter to 0) the course
	 * 
	 * @param coursename
	 */
	@Override
	public void invalidate(char courseName) {
		if (courseMap.containsKey(courseName))
			courseMap.put(courseName, 0);
	}

	// This is used for debugging purpose.
	@Override
	public String toString() {
		return "Object Pool Contents: \n" + getCourseMap();
	}

}// end of ObjectPoolClass
