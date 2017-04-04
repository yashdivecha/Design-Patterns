package wordCount.visitors;

import java.util.HashMap;
import java.util.Map;

import wordCount.dsForStrings.BST;
import wordCount.dsForStrings.Node;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;

/**
 * WordCountVisitor - Visitor that determines the total number of words, total
 * number of unique words, and characters in the data structure
 * 
 * @author Yash Divecha
 *
 */
public class WordCountVisitor implements DSProcessingVisitorI {

	private FileProcessor fileProc;

	// Used if there are more than one frequently used words, having same count.
	private Map<String, Long> mostFreqWordMap = new HashMap<String, Long>();

	long maxFrequency = 0;
	private long wordCount;
	private long charCount;

	// Constructor
	public WordCountVisitor(FileProcessor fileProcIn) {
		Logger.writeMessage("Constructor of Word Count: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
		this.fileProc = fileProcIn;
	}

	/**
	 * To determine the total words, max frequency and max word
	 * 
	 * @param nodes
	 *            Recursively this function is called, current node.
	 * @return void
	 */
	private void calculateWordCount(Node node) {
		charCount += (node.getWord().length() * node.getFrequency());
		wordCount += node.getFrequency();
		node.setCharCount(node.getWord().length());

		if (node.getFrequency() > maxFrequency) {
			maxFrequency = node.getFrequency();
			mostFreqWordMap.clear();
			mostFreqWordMap.put(node.getWord(), node.getFrequency());
		} else if (node.getFrequency() == maxFrequency) {
			mostFreqWordMap.put(node.getWord(), node.getFrequency());
		}
	}

	// Visitor Pattern
	@Override
	public void visit(BST bst) {
		Logger.writeMessage("WordCount Visitor Visit Method: " + this.getClass().getName(), Logger.DebugLevel.VISIT);
		traverseDataStructure(bst.getRoot());
		writeToFile(bst);
	}

	/**
	 * This function traverse the tree In-Order and perform computations like
	 * most frequent occurring word and frequency, .
	 * 
	 * @param Node
	 * @return void
	 */
	public void traverseDataStructure(Node node) {
		if (node != null) {
			traverseDataStructure(node.getLeft());
			calculateWordCount(node); // Gets the necessary details from the
										// tree.
			traverseDataStructure(node.getRight());
		}
	}

	/**
	 * This function calculates the distinct word in the data structure.
	 * 
	 * @param node
	 *            Initially we send the root and recursively it finds the
	 *            distinct words
	 * @return long total number of distinct words.
	 */
	private long findDistinctWords(Node node) {
		if (node == null)
			return 0;
		else if (node.getLeft() == null && node.getRight() == null)
			return 1;
		return (1 + findDistinctWords(node.getLeft()) + findDistinctWords(node.getRight()));
	}

	/**
	 * This function writes the necessary word count details into a file.
	 * 
	 * @param bst
	 *            fully formed tree.
	 * @return void
	 */
	public void writeToFile(BST bst) {
		for (String word : mostFreqWordMap.keySet()) {
			fileProc.writeLine(
					"Most Frequent Word: \"" + word + "\"\t	Frequency: " + mostFreqWordMap.get(word) + "\n");
		}
		fileProc.writeLine("Total number of words: " + wordCount + "\n");
		fileProc.writeLine("Total number of Distinct words: " + findDistinctWords(bst.getRoot()) + "\n");
		fileProc.writeLine("Total number of characters stored by the data structure: " + charCount + "\n");		
	}
}
