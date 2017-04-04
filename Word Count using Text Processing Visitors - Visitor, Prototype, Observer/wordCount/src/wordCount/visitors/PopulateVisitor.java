package wordCount.visitors;

import wordCount.dsForStrings.BST;
import wordCount.dsForStrings.Node;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;

/**
 * PopulateVisitor - Visitor class that reads words from a file and populates a
 * data structure
 * 
 * @author Yash Divecha
 *
 */
public class PopulateVisitor implements DSProcessingVisitorI {

	private FileProcessor fp;

	public PopulateVisitor(FileProcessor fpIn) {
		Logger.writeMessage("Constructor of Populate Visitor: " + this.getClass().getName(),
				Logger.DebugLevel.CONSTRUCTOR);
		this.fp = fpIn;
	}

	/**
	 * This is used to build the BST comparing Hash Value of the string.
	 * 
	 * @param root
	 *            root the BST
	 * @param node
	 *            Node that needs to be inserted.
	 * @return void
	 */
	public void insert(Node root, Node node) {
		int compareCheck = root.getWord().compareTo(node.getWord());
		if (compareCheck < 0) {
			if (root.getLeft() != null)
				insert(root.getLeft(), node);
			else
				root.setLeft(node);
		} else if (compareCheck > 0) {
			if (root.getRight() != null)
				insert(root.getRight(), node);
			else
				root.setRight(node);
		} else if (compareCheck == 0) {
			root.setFrequency(root.getFrequency() + 1);
		}
	}

	/**
	 * This function is used to parse the line, split the words and call the
	 * insert function
	 * 
	 * @param rootIn
	 *            First word of the first line consider as root.
	 * @param words
	 *            Line is split into different words.
	 * @param isRootLine
	 *            Check whether is this the first line of the file or not.
	 */
	private void parseLine(Node rootIn, String[] words, boolean isRootLine) {
		Node node = null;
		if (isRootLine) {
			for (int i = 1; i < words.length; i++) {
				node = new Node(words[i]);
				insert(rootIn, node);
			}
		} else {
			for (int i = 0; i < words.length; i++) {
				node = new Node(words[i]);
				insert(rootIn, node);
			}
		}
	}

	// Visitor Pattern
	@Override
	public void visit(BST bst) {
		Logger.writeMessage("Populate Visitor Visit Method: " + this.getClass().getName(), Logger.DebugLevel.VISIT);
		String temp = null;
		boolean isRootLine = true;
		String[] words;
		Node rootIn = null;

		// Reads the line, split into words and parse the line(creates BST)
		while ((temp = fp.readNextLine()) != null) {
			if (isRootLine) {
				words = temp.split("\\s+");
				rootIn = new Node(words[0]);
				bst.setRoot(rootIn);
				parseLine(rootIn, words, isRootLine);
				isRootLine = false;
			} else {
				words = temp.split("\\s+");
				parseLine(rootIn, words, isRootLine);
			}
		}
	}
}
