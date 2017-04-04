package wordCount.dsForStrings;

import wordCount.util.Logger;
import wordCount.visitors.DSProcessingVisitorI;

/**
 * BST: This is the Data Structure used.
 * 
 * @author Yash Divecha
 *
 */
public class BST {

	private Node root = null;

	// Constructor of Data Structure BST.
	public BST() {
		Logger.writeMessage("Constructor of BST: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
	}

	// Getter Method of Root.
	public Node getRoot() {
		return this.root;
	}

	// Setter Method of Root
	public void setRoot(Node root) {
		this.root = root;
	}

	// Visitor Pattern
	public void accept(DSProcessingVisitorI visitor) {
		Logger.writeMessage("BST Accept: " + this.getClass().getName(), Logger.DebugLevel.ACCEPT);
		visitor.visit(this);
	}
}
