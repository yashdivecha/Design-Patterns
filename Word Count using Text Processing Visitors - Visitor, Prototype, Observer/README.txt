Project: Word Count using Text Processing Visitors -- Visitor, Prototype, Observer 

Author(s): YASH DIVECHA

PURPOSE:
This project helps us to implement word count command (wc) with Visitor, Prototype, and Observer Patterns.


PERCENT COMPLETE:
I believe I have completed 100% of this project.


PARTS THAT ARE NOT COMPLETE:
Completed Successfully.


BUGS:
None.


FILES:
Driver.java : 	This class is the start of the program.

Data Structure 
BST.java: This is the data structure class (Binary Search Tree)
Node.java: This is the nodes used to create a Binary Serach Tree. 

Observer Pattern
ObserverI.java : This is he Observer interface.
SubjectI.java : This is the Subject Interface.
FilterI.java : This is used to check which updates Observer is registered for.
UpdateCountFilter: Implementation of the Filter Interface.


Visitor Pattern
DSProcessingVisitorI.java: This the visitor interface having visit method. 
PopulateVisitor.java : This visitor is used to populate or create the Binary Search Tree using the input.txt
WordCountVisitor.java : This visitor is used to perform the word count, char count, words and distinct words by traversing the tree 

Prototype and Observer Pattern.
CloneAndObserveVisitor.java: This visitor is used to clone the BST, node by node and sets up the observer pattern. 

InitiateBackUpVisitor.java:  This is used to trigget the initiate backup tree by incrementing the frequency of the nodes by 1.
PrintVisitor.java: This is used to print the tree to screen or write into file. 

input.txt: Simple file for testing.
README, the text file you are presently reading
build.xml : This is used to compile and run the Project


SAMPLE OUTPUT:
remote04:~/wordCount> ant -buildfile src/build.xml run -Darg0="input.txt" -Darg1="output.txt" -Darg2=100
Buildfile: /wordCount/src/build.xml

jar:
      [jar] Building jar: /wordCount/BUILD/jar/wordCount.jar

run:
     [java] Total Time taken: 7ms
     [java]
     [java] File "BST_1.txt" has been created.
     [java] File "BST_2.txt" has been created.

BUILD SUCCESSFUL
Total time: 1 second


TO COMPILE:
Compile using the build.xml
remote04:~/wordCount> ant -buildfile src/build.xml all
Buildfile: /wordCount/src/build.xml

prepare:
    [mkdir] Created dir: /wordCount/BUILD/classes

wordCount:
    [javac] /wordCount/src/build.xml:48: warning: 'includeantruntime' was not set, defaulting to build.sysclasspath=last; set to false for repeatable builds
    [javac] Compiling 16 source files to /wordCount/BUILD/classes

compile_all:

all:

BUILD SUCCESSFUL
Total time: 2 seconds


TO RUN:
remote05:~/wordCount> ant -buildfile src/build.xml run


DATA STRUCTURE USED: 
Used Binary Search Tree (BST).


TIME COMPLEXITY:
Since a binary search tree with n nodes has a minimum of O(log n) levels, it takes at least O(log n) comparisons to find a particular node.


SPACE COMPLEXITY:
O(h).  h is height of tree.


EXTRA CREDIT:
N/A


TEST_PATTERN: 
1. Post tree creation and counting the word, CloneAndObserveVisitor will clone the original BST to backup BST, node by node manner. 
2. InitiateBackUpVisitor will traverse the original tree and increase the frequency by one. Ideally as Observer pattern is set up, this will 
trigger the same and corresponding node will also get updated. 
3. To display the output, PrintVisitor will generate 2 files and prints inorder traversal (words, frequency and char_count),
BST_1.txt (Original BST) and BST_2 (Back Up BST) with the changed output. Comparison of both the files can be used to test the pattern.
4. You can print the same on screen by uncommeting the Driver printToScrren code. 


BIBLIOGRAPHY:
This serves as evidence that we are in no way intending Academic Dishonesty.
<YASH DIVECHA>


ACKNOWLEDGEMENT:
N/A