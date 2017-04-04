Project: Student Orientation Program -- Builder Pattern

Author(s): YASH DIVECHA

PURPOSE:
This project helps us to implement Builder Pattern


PERCENT COMPLETE:
I believe I have completed 100% of this project.


PARTS THAT ARE NOT COMPLETE:
Completed Successfully.


BUGS:
None.


FILES:
Driver.java : 	This class is the start of the program.

Activity Classes and Interface: 
BookStore.java:
CampusTour.java:
Registration.java:
Dorms.java:
BookStoreI.java:
CampusTourI.java:
RegistrationI.java:
DormsI.java:

Summary Classes and Interface
Cost.java
CarbonFootprint.java:
Efforts.java:
Duration.java:
CostI.java:
CarbonFootprintI.java:
EffortsI.java:
DurationI.java:

Builder Classes and Interfaces
CurrencyCost.java: Enum used to select currency 
OrientationActivitiesI.java: 
OrientationChecklist.java
OrientationChecklistI.java
OrientationWorkshop.java
OrientationWorkshopI.java

README, the text file you are presently reading
build.xml : This is used to compile and run the Project


SAMPLE OUTPUT:
remote05:~/studentOrientation> ant -buildfile src/build.xml run
Buildfile: /studentOrientation/src/build.xml

jar:
      [jar] Building jar: /studentOrientation/BUILD/jar/studentOrientation.jar

run:
     [java] Total Cost: 13712.00 dollars
     [java] Total Duration: 255.00 mins
     [java] Total Carbon Foot Prints: 30.00 CO2
     [java] Total Efforts: 2000.00 calories

BUILD SUCCESSFUL
Total time: 1 second


TO COMPILE:
Compile using the build.xml
remote05:~/studentOrientation> ant -buildfile src/build.xml all
Buildfile: /studentOrientation/src/build.xml

prepare:
    [mkdir] Created dir: /studentOrientation/BUILD
    [mkdir] Created dir: /studentOrientation/BUILD/classes

studentOrientation:
    [javac] /studentOrientation/src/build.xml:48: warning: 'includeantruntime' was not set, defaulting to build.sysclasspath=last; set to false for repeatable builds
    [javac] Compiling 23 source files to /studentOrientation/BUILD/classes

compile_all:

all:

BUILD SUCCESSFUL
Total time: 1 second


TO RUN:
remote05:~/studentOrientation> ant -buildfile src/build.xml run


DATA STRUCTURE USED: 
Implemented Builder Pattern as studied in class. 
If user wants to choose the Currency he can do it using the below code. 
Currently we have 3 currency incooperated in our code. {DOLLARS, POUNDS, RUPEES}
OrientationChecklistI orientation = new OrientationChecklist(CampusTourEnum.BUS_RIDE,
			BookStoreEnum.UNIVERSITY_BOOK_STORE, DormsEnum.LONG_QUEUE, RegisterEnum.SUBMIT_FORMS_WITH_PAYCHECK, CurrencyCost.RUPEES);

TIME COMPLEXITY:
N/A

SPACE COMPLEXITY:
N/A

EXTRA CREDIT:
N/A


BIBLIOGRAPHY:
This serves as evidence that we are in no way intending Academic Dishonesty.
<YASH DIVECHA>


ACKNOWLEDGEMENT:
N/A