package wordCount.visitors;

import wordCount.dsForStrings.BST;
import wordCount.dsForStrings.Node;
import wordCount.util.Logger;

/**
 * InitiateBackUpVisitor: This visitor is used to trigger the back up by
 * Traversing the tree and incrementing the frequency by 1
 * 
 * @author Yash Divecha
 *
 */
public class InitiateBackUpVisitor implements DSProcessingVisitorI {

	// Visitor Pattern
	@Override
	public void visit(BST bst) {
		Logger.writeMessage("Initiate Visitor Visit Method: " + this.getClass().getName(), Logger.DebugLevel.VISIT);
		incrementFrequency(bst.getRoot());
	}

	/**
	 * This function traverse the tree and increments the frequency by 1.
	 * 
	 * @param node
	 *            Root of the tree and recursively travel the tree.
	 */
	private void incrementFrequency(Node node) {
		if (node != null) {
			incrementFrequency(node.getLeft());
			// setNewFrequency will use Observer Pattern and notify the
			// corresponding node to update their own frequency.
			node.setNewFrequency(node.getFrequency() + 1);
			incrementFrequency(node.getRight());
		}
	}
}
