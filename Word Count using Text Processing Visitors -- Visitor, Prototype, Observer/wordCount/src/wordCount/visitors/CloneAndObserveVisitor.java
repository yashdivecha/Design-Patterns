package wordCount.visitors;

import wordCount.dsForStrings.BST;
import wordCount.dsForStrings.Node;
import wordCount.observer.FilterI;
import wordCount.observer.UpdateCountFilter;
import wordCount.observer.FilterI.Updates;
import wordCount.util.Logger;

/**
 * Clone and Observer : This class is used to clone the BST tree in the Node by
 * node manner and sets up Observer Pattern.
 * 
 * @author Yash Divecha
 *
 */
public class CloneAndObserveVisitor implements DSProcessingVisitorI {
	private BST backupBST;

	// Visitor Pattern
	@Override
	public void visit(BST bst) {
		Logger.writeMessage("Clone And Observe Visitor Visit Method: " + this.getClass().getName(),
				Logger.DebugLevel.VISIT);
		backupBST = new BST();
		Node backupRoot = backUpCloning(bst.getRoot());
		backupBST.setRoot(backupRoot);
	}

	public BST getTree() {
		return this.backupBST;
	}

	/**
	 * This function recursively clone the nodes of the BST and returns the new
	 * root of the backup BST.
	 * 
	 * @param node
	 * @return node root of the backup Tree.
	 * 
	 */
	public Node backUpCloning(Node node) {
		if (node == null)
			return node;
		Node temp = (Node) node.clone();

		// Observer Pattern
		FilterI filter = new UpdateCountFilter();
		filter.setFilterValue(Updates.UPDATE_COUNT);

		temp.setLeft(backUpCloning(node.getLeft()));
		temp.setRight(backUpCloning(node.getRight()));

		node.registerNode(temp, filter);
		return temp;
	}
}
