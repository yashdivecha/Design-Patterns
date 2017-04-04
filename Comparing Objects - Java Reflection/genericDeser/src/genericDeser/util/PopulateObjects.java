package genericDeser.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import genericDeser.fileOperations.FileProcessor;

/**
 * PopulateObjects - This class parses the File, using reflection creates the
 * objects and stores into Data Structure. Finally it displays how many class
 * objects are created. (Total and Unique)
 * 
 * @author Yash
 *
 */
public class PopulateObjects {
	private FileProcessor fp;
	private Result result;
	private Map<Object, Integer> objMap;
	private Map<String, Class<?>> dataTypeCheckMap;
	private String clsName;
	private Class<?> cls;
	private Object obj;
	private Class<?>[] signature;

	public enum ClassNames {
		First, Second
	};

	// Public Constructor
	public PopulateObjects(FileProcessor fpIn) {
		Logger.writeMessage("Constructor of Populate Objects: " + this.getClass().getName(),
				Logger.DebugLevel.CONSTRUCTOR);
		this.fp = fpIn;
		result = new Result();
		clsName = null;
		objMap = new HashMap<Object, Integer>();
		dataTypeCheckMap = new HashMap<String, Class<?>>();
		initialiseTypeCheckMap(dataTypeCheckMap);

	}

	/**
	 * This function initials the dataTypeCheckMap to map to the corresponding
	 * Class Type.
	 * 
	 * @param typeCheckMap
	 *            HashMap used to store the data type and class type.
	 * @return void
	 */
	private void initialiseTypeCheckMap(Map<String, Class<?>> typeCheckMap) {
		typeCheckMap.put("int", Integer.TYPE);
		typeCheckMap.put("double", Double.TYPE);
		typeCheckMap.put("float", Float.TYPE);
		typeCheckMap.put("String", String.class);
		typeCheckMap.put("boolean", Boolean.TYPE);
		typeCheckMap.put("short", Short.TYPE);
	}

	/**
	 * This function parses the file line by line, use Reflection to create
	 * Objects from String and invoke a method using Class Object.
	 * 
	 * @param void
	 * @return void
	 */
	public void deserObjects() {
		String line = null;
		// long uniqueFirst;
		// long uniqueSecond;
		// long totalFirst;
		// long totalSecond;

		// Pattern pattern = Pattern.compile("\\w+=(\\w+), [\\w ]+=(\\w+), [\\w
		// ]+=(\\d+(\\.\\d+)?)");
		// for value = 12 or value = 12.6
		Pattern pattern = Pattern.compile("\\w+=(\\w+), [\\w ]+=(\\w+), [\\w ]+=(.*)");
		String parsedString[] = null;
		Object prev = null;
		// File Parsing
		while ((line = fp.readNextLine()) != null) {
			if (line.contains(":")) {
				try {
					if (prev != null) {
						addToHashMap(prev);
						prev = null;
					}
					parsedString = line.split("\\:");
					clsName = parsedString[1]; // Capturing the String.
					cls = Class.forName(clsName); // Check the class
					obj = cls.newInstance(); // Creating Object of the class.

				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
					System.out.println("Cannot find the mentioned class.");
					e.printStackTrace();
					System.exit(1);
				} finally {
				}

			} else {
				Matcher m = pattern.matcher(line);
				if (m.find()) {
					/*
					 * if (m.group(1).equals("int"))
					 * setMethodValue(Integer.TYPE, m.group(2), m.group(3));
					 * else if (m.group(1).equals("float"))
					 * setMethodValue(Float.TYPE, m.group(2), m.group(3)); else
					 * if (m.group(1).equals("short"))
					 * setMethodValue(Short.TYPE, m.group(2), m.group(3)); else
					 * if (m.group(1).equals("String"))
					 * setMethodValue(String.class, m.group(2), m.group(3));
					 * else if (m.group(1).equals("boolean"))
					 * setMethodValue(Boolean.TYPE, m.group(2), m.group(3));
					 * else if (m.group(1).equals("double"))
					 * setMethodValue(Double.TYPE, m.group(2), m.group(3));
					 */

					// Check which data type and invoke a method of the class.
					if (dataTypeCheckMap.containsKey(m.group(1)))
						setMethodValue(dataTypeCheckMap.get(m.group(1)), m.group(2), m.group(3));
				} else {
					System.out.println("Please enter the value in the correct format.");
					System.out.println("type=<typeName>, var=<variableName>, value=<value>");
					System.exit(1);
				}
				prev = obj;
			}
		}
		// This is used last object to the data structure after comparing.
		if (prev != null) {
			addToHashMap(prev);
			prev = null;
		}

		if (Logger.getDebugValue() == Logger.DebugLevel.POPULATE_OBJECT) {
			printMap(objMap); // This prints out the data structure.
			System.out.println();
		}

		// This call sets the Result class data members which we need to display
		// on the screen.
		setResultClassObjectCount(objMap, ClassNames.First, ClassNames.Second);

		if (Logger.getDebugValue() == Logger.DebugLevel.RESULT) {
			System.out.println(result); // This prints out the data structure.
			System.out.println();
		}

		// Prints the output to the screen.
		printOutput(result);

		// uniqueFirst = getUniqueObject(objMap, ClassNames.First);
		// uniqueSecond = getUniqueObject(objMap, ClassNames.Second);
		// totalFirst = getTotalObject(objMap, ClassNames.First);
		// totalSecond = getTotalObject(objMap, ClassNames.Second);
		// printOutput(uniqueFirst, totalFirst, uniqueSecond, totalSecond);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////
	// private long getTotalObject(Map<Object, Integer> objMap, ClassNames
	/////////////////////////////////////////////////////////////////////////////////////////////////////// className)
	// {
	// long temp = 0;
	// for (Object keys : objMap.keySet())
	// if (keys.toString().contains(className.toString()))
	// temp += objMap.get(keys);
	// return temp;
	// }
	//
	// private long getUniqueObject(Map<Object, Integer> objMap, ClassNames
	/////////////////////////////////////////////////////////////////////////////////////////////////////// className)
	// {
	// long temp = 0;
	// for (Object keys : objMap.keySet())
	// if (keys.toString().contains(className.toString()))
	// temp++;
	// return temp;
	// }
	//
	// private void printOutput(long uniqueFirst, long totalFirst, long
	/////////////////////////////////////////////////////////////////////////////////////////////////////// uniqueSecond,
	/////////////////////////////////////////////////////////////////////////////////////////////////////// long
	/////////////////////////////////////////////////////////////////////////////////////////////////////// totalSecond)
	// {
	// System.out.println("Number of unique First objects: " + uniqueFirst);
	// System.out.println("Total Number of First objects: " + totalFirst);
	// System.out.println("Number of unique Second objects: " + uniqueSecond);
	// System.out.println("Total Number of Second objects: " + totalSecond);
	// }
	/////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * This function checks how many unique and total objects of First and
	 * Second are created.
	 * 
	 * @param objMap2
	 *            Data Structure having objects and count.
	 * @param clsFirst
	 *            First Class.
	 * @param clsSecond
	 *            Second Class.
	 * @return void
	 */
	private void setResultClassObjectCount(Map<Object, Integer> objMap2, ClassNames clsFirst, ClassNames clsSecond) {
		long uniqueFirst = 0;
		long uniqueSecond = 0;
		long totalFirst = 0;
		long totalSecond = 0;
		for (Object keys : objMap.keySet()) {
			if (keys.toString().contains(clsFirst.toString())) {
				uniqueFirst++;
				totalFirst += objMap.get(keys);
			} else if (keys.toString().contains(clsSecond.toString())) {
				uniqueSecond++;
				totalSecond += objMap.get(keys);
			}
		}
		result.setUniqueFirst(uniqueFirst);
		result.setTotalFirst(totalFirst);
		result.setUniqueSecond(uniqueSecond);
		result.setTotalSecond(totalSecond);
	}

	/**
	 * This function displays the unique and total number of objects on screen.
	 * 
	 * @param result
	 *            This has all the information count of the object created.
	 * @return void
	 */
	private void printOutput(Result result) {
		System.out.println("Number of unique First objects: " + result.getUniqueFirst());
		System.out.println("Total Number of First objects: " + result.getTotalFirst());
		System.out.println("Number of unique Second objects: " + result.getUniqueSecond());
		System.out.println("Total Number of Second objects: " + result.getTotalSecond());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * This method is used to invoke the class method .
	 * 
	 * @param type
	 *            which data type
	 * @param variableName
	 *            data member name of the class
	 * @param variableValue
	 *            data member value to be set of the class.
	 * @return void
	 */
	private void setMethodValue(Class<?> type, String variableName, String variableValue) {
		try {
			Object[] params = new Object[1];
			signature = new Class[1];
			if (type.equals(Integer.TYPE)) {
				signature[0] = Integer.TYPE;
				params[0] = new Integer(variableValue);
			} else if (type.equals(Float.TYPE)) {
				signature[0] = Float.TYPE;
				params[0] = new Float(variableValue);
			} else if (type.equals(Short.TYPE)) {
				signature[0] = Short.TYPE;
				params[0] = new Short(variableValue);
			} else if (type.equals(String.class)) {
				signature[0] = String.class;
				params[0] = new String(variableValue);
			} else if (type.equals(Double.TYPE)) {
				signature[0] = Double.TYPE;
				params[0] = new Double(variableValue);
			} else if (type.equals(Boolean.TYPE)) {
				signature[0] = Boolean.TYPE;
				params[0] = new Boolean(variableValue);
			}

			String methodName = "set" + variableName;
			Method meth = cls.getMethod(methodName, signature);
			// Object result =
			meth.invoke(obj, params);

			// Object result1 = cls.getMethod("get" + variableName).invoke(obj);
			// System.out.println(result1);

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			System.out.println("Exception Occured:\n" + e.getClass() + ": " + e.getMessage());
			// e.printStackTrace();
			System.exit(1);
		} finally {
		}

	}

	/**
	 * This function is used to add the Object to the data structure after
	 * comparing it existence in the Map.
	 * 
	 * @param newInstanceObj
	 *            Object that needs to be added to the data structure.
	 * @return void
	 */
	private void addToHashMap(Object newInstanceObj) {
		if (!(objMap.containsKey(newInstanceObj))) {
			objMap.put(newInstanceObj, 0);
		}
		objMap.put(newInstanceObj, objMap.get(newInstanceObj) + 1);
	}

	/**
	 * This method is used to print the data structure. Used for debugging
	 * purpose.
	 * 
	 * @param objMap
	 *            Map having First and Second Objects
	 * @return void
	 */
	private void printMap(Map<Object, Integer> objMap) {
		for (Map.Entry<Object, Integer> entry : objMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
