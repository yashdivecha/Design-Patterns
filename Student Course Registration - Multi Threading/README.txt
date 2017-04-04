Project: Student Course Registration - Multi-Threading

Author(s): YASH DIVECHA

PURPOSE:
This project helps us to get familiar with Multi Threaded Programming in JAVA. 


PERCENT COMPLETE:
I believe I have completed 100% of this project.


PARTS THAT ARE NOT COMPLETE:
Completed Successfully.


BUGS:
None.


FILES:
Driver.java : 	This class take the command line argruments, create instances and 
				prints the output to the screen and writes on the file.

FileDisplayInterface.java:	This interface is used to diplay the output in the file.

Results.java: 	This Singleton class Stores the output in ConcurrentHashMap data structure implements 
				write to screen and write to file functions. 
				
StdoutDisplayInterface.java: This interface is used to diplay the output on screen.

CreateWorkers.java: This class creates the number of threads specified by the user and starts it.

WorkerThread.java: 	This class runs the thread. It captures the line and calls allocateAlgo to allocate courses. 

FileProcessor.java:	This Singleton class returns the next line. 

Logger.java: 	This class is used for different level of debugging. 

ObjectPool.java:	This interface is used to create Objects in the ObjectPool

ObjectPoolClass.java: This class implements ObjectPool, creates and manage objects.

Validation.java: This class is used for validating input argruments.

README, the text file you are presently reading

build.xml : This is used to compile and run the Project


SAMPLE OUTPUT:
remote04:~/registrationScheduler> ant -buildfile src/build.xml all
Buildfile: ~/registrationScheduler/src/build.xml

prepare:

registrationScheduler:
    [javac] /import/linux/home/ydivech1/DP/Assignment2/yash_divecha/registrationScheduler/src/build.xml:48: warning: 'includeantruntime' was not set, defaulting to build.sysclasspath=last; set to false for repeatable builds

compile_all:

all:

BUILD SUCCESSFUL
Total time: 0 seconds

remote04:~/DP/Assignment2/yash_divecha/registrationScheduler> ant -buildfile src/build.xml run 
-Darg0=/registrationScheduler/Assign2Input1_A.txt 
-Darg1=/registrationScheduler/output.txt -Darg2=1 -Darg3=0

output.txt
Student_15 E C D B A 
Student_59 C F E B A 
Student_16 F G A D E 
Student_17 F E B A C 
Student_18 G B D C A 
Student_19 F C A E G 
Student_51 A G C D F 
Student_52 C A F B D 
Student_53 E C F A B 
Student_10 A F C B D 
Student_54 A D F E C 
Student_11 D A B F C 
Student_55 G A F D B 
Student_12 E F C D B 
Student_56 F B C A E 
Student_13 E F C G D 
Student_57 D C A B E 
Student_14 C G B D E 
Student_58 E C F B D 
Student_60 A G D E C 
Student_61 D B E A G 
Student_26 G F A C E 
Student_27 B A C D E 
Student_28 A E C F B 
Student_29 C F D A E 
Student_62 D A F G C 
Student_63 F E B G A 
Student_20 D E G A B 
Student_64 A B G E C 
Student_21 G F E C B 
Student_65 C G A B F 
Student_22 B E A F D 
Student_66 D C E G F 
Student_23 F B C G E 
Student_67 B G D A C 
Student_24 D E G A B 
Student_68 A E F B G 
Student_25 D C E F B 
Student_69 B D F E C 
Student_70 C G F E D 
Student_71 B A F C E 
Student_72 G E F D C 
Student_37 C G E F B 
Student_38 F D A B G 
Student_39 D G E C F 
Student_5 C E A G F 
Student_73 A C B G F 
Student_4 D E G C F 
Student_30 D F B A E 
Student_74 E G A D F 
Student_7 F E A G D 
Student_31 B D C A G 
Student_75 A G D F B 
Student_6 F C E B A 
Student_32 B A C G E 
Student_76 E D G C B 
Student_9 A G D E F 
Student_33 A D F E G 
Student_77 C D E F A 
Student_8 B G D E C 
Student_34 B D G C A 
Student_78 E F B A G 
Student_35 F A E G D 
Student_79 D G B C E 
Student_36 F C A B G 
Student_1 C D E B F 
Student_80 E C F D A 
Student_3 E F D G A 
Student_2 A F G B D 
Student_48 A E B C D 
Student_49 G C A F D 
Student_40 B F G A D 
Student_41 B D E F A 
Student_42 C B F G D 
Student_43 F B G D C 
Student_44 E C D B G 
Student_45 F E G A D 
Student_46 B C F D A 
Student_47 C G F A B 
Student_50 D C A E G 
Average preference_score is: 19.925


TO COMPILE:
Compile using the build.xml
remote04:~/registrationScheduler> ant -buildfile src/build.xml all
Buildfile: /registrationScheduler/src/build.xml

prepare:

registrationScheduler:
    [javac] /registrationScheduler/src/build.xml:48: 
	warning: 'includeantruntime' was not set, defaulting to build.sysclasspath=last; set to false for repeatable builds

compile_all:

all:

BUILD SUCCESSFUL
Total time: 0 seconds


TO RUN:
Please run as: remote04:~/registrationScheduler> ant -buildfile src/build.xml run 
-Darg0=/registrationScheduler/Assign2Input1_A.txt 
-Darg1=/registrationScheduler/output.txt -Darg2=1 -Darg3=0

DATA STRUCTURE USED: 
ConcurrentHashMap: Thread Safe

TIME COMPLEXITY:
Used ConcurrentHashMap because it's time complexity of get() or put(..) containsKey(..) is constant time O(1). 

SPACE COMPLEXITY:
Depending upon the input data size, ConcurrentHashMap size will increase. 
It is directly proportional to the number of records in the input file.

EXTRA CREDIT:
N/A


BIBLIOGRAPHY:
This serves as evidence that we are in no way intending Academic Dishonesty.
<YASH DIVECHA>


ACKNOWLEDGEMENT:
N/A