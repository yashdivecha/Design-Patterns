Project: Comparing Objects using Java Reflection 

Author(s): YASH DIVECHA

PURPOSE:
JAVA REFLECTION
This project helps us to compare Objects in Java, locating the classes using String and creating class objects of the same class and thereby 
invoking the methods. [Reflection.]


PERCENT COMPLETE:
I believe I have completed 100% of this project.


PARTS THAT ARE NOT COMPLETE:
Completed Successfully.


BUGS:
None.


FILES:
Driver.java : 			This class is the start of the program.
First.java:				Simple Class having getter and setter methods for data members, hashCode and equals methods for comparing objects.
Second.java:			Simple Class having getter and setter methods for data members, hashCode and equals methods for comparing objects.
PopulateObjects.java:	Parse the file, creates the objects using Reflection, stores the objects in HashMap, displays the unique and total
						objects to the screen. 
Result.java: 			This class has unique and total number of objects created and stored in HashMap.
Logger.java: 			Used for debugging purpose.
FileProcessor.java: 	Used to read line from the file, close the file and do file related activities.
ValidateArguments.java: Validates the command line arguments. 
input.txt: Simple file for testing.
README, the text file you are presently reading
build.xml : This is used to compile and run the Project


SAMPLE OUTPUT:
     [java] Number of unique First objects: 4952
     [java] Total Number of First objects: 4952
     [java] Number of unique Second objects: 5018
     [java] Total Number of Second objects: 5048
	 
	 
TO COMPILE:
Compile using the build.xml
remote03:~/genericDeser> ant -buildfile src/build.xml all
Buildfile: /genericDeser/src/build.xml

prepare:
    [mkdir] Created dir: /genericDeser/BUILD
    [mkdir] Created dir: /genericDeser/BUILD/classes

genericDeser:
    [javac] /genericDeser/src/build.xml:48: warning: 'includeantruntime' was not set, defaulting to build.sysclasspath=last; set to false for repeatable builds
    [javac] Compiling 8 source files to /genericDeser/BUILD/classes

compile_all:

all:

BUILD SUCCESSFUL
Total time: 4 seconds


RUN: 
remote03:~/genericDeser> ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=0
Buildfile: /genericDeser/src/build.xml

jar:

run:
     [java] Number of unique First objects: 4952
     [java] Total Number of First objects: 4952
     [java] Number of unique Second objects: 5018
     [java] Total Number of Second objects: 5048

BUILD SUCCESSFUL
Total time: 1 second


DATA STRUCTURE USED: 
Used LinkedHashMap because it preserves the insertion order in the HashMap, almost constant time O(1) for retrieving the storing objects. 


TIME COMPLEXITY:
get() or put(..) containsKey(..) is constant time O(1). 


SPACE COMPLEXITY:
Depending upon the input data size, LinkedHashMap size will increase. 
It is directly proportional to the number of records in the input file.


EXTRA CREDIT:
N/A


BIBLIOGRAPHY:
This serves as evidence that we are in no way intending Academic Dishonesty.
<YASH DIVECHA>


ACKNOWLEDGEMENT:
N/A