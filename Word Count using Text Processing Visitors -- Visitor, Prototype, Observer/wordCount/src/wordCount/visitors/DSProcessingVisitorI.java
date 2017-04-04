package wordCount.visitors;

import wordCount.dsForStrings.BST;

/**
 * DSProcessingVisitorI: This interface is used in Visitor Pattern
 * 
 * @author Yash Divecha
 *
 */
public interface DSProcessingVisitorI {
	public void visit(BST bst);
}
