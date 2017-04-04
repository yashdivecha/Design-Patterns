package wordCount.visitors;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import wordCount.dsForStrings.BST;
import wordCount.dsForStrings.Node;
import wordCount.util.Logger;

/**
 * PrintVisitor: This visitor prints the BST in order(Word, Frequency,
 * Char_Count) to screen or writes to the file, depending on Enum Value.
 * 
 * @author Yash Divecha
 *
 */
public class PrintVisitor implements DSProcessingVisitorI {

	private BufferedWriter bw = null;
	private int fileNameIndex = 0;
	private displayType type;

	public enum displayType {
		FILE, SCREEN
	};

	public PrintVisitor(displayType typeIn) {
		this.type = typeIn;
	}

	@Override
	public void visit(BST bst) {
		Logger.writeMessage("Print To File Visitor Visit Method: " + this.getClass().getName(),
				Logger.DebugLevel.VISIT);
		if (type.equals(displayType.FILE)) {
			fileNameIndex++;
			String fileName = "BST_" + fileNameIndex + ".txt";
			System.out.println("File " + "\"" + fileName + "\"" + " has been created. ");
			writeBSTToFile(bst, fileName);
		} else if (type.equals(displayType.SCREEN))
			writeBSTToScreen(bst);
	}

	/**
	 * This function traverse the tree the prints the inorder traversal (word,
	 * frequency, char count)to File.
	 * 
	 * @param bst
	 *            Data Structure Binary Search Tree.
	 * @param outputBSTFileName
	 *            File to which output should be written.
	 * 
	 */
	public void writeBSTToFile(BST bst, String outputBSTFileName) {

		try {
			bw = new BufferedWriter(new FileWriter(outputBSTFileName));
			bw.write(String.format("%-20s %-20s %-20s \r\n", "Nodes", "Frequency", "Character_Count"));
			printTree(bst.getRoot(), type);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				System.out.println("Buffered Write cannot be closed.");
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	/**
	 * This function traverse the tree the prints the inorder traversal (word,
	 * frequency, char count)to Screen.
	 * 
	 * @param bst
	 *            Data Structure Binary Search Tree.
	 * @param outputBSTFileName
	 *            File to which output should be written.
	 * 
	 */
	public void writeBSTToScreen(BST bst) {
		System.out.println("*******************************************************************");
		System.out.format("%-20s %-20s %-20s \r\n", "Nodes", "Frequency", "Character_Count");
		System.out.println("*******************************************************************");
		printTree(bst.getRoot(), type);
		System.out.println("*******************************************************************");
		System.out.println();
	}

	/**
	 * This function is used to recursively travel and print to screen or writes
	 * in the file.
	 * 
	 * @param node
	 *            Initially it's the root and recursively travel the tree node
	 *            by node.
	 * @param type
	 *            FILE or SCREEN
	 */
	private void printTree(Node node, displayType type) {
		if (type.equals(displayType.FILE)) {
			if (node != null) {
				try {
					printTree(node.getLeft(), type);
					bw.write(String.format("%-20s %-20d %-20d \r\n", node.getWord(), node.getFrequency(),
							node.getCharCount()));
					printTree(node.getRight(), type);
				} catch (IOException e) {
					System.out.println("Unable to Write to FILE.");
					e.printStackTrace();
					System.exit(1);
				} finally {

				}
			}
		} else if (type.equals(displayType.SCREEN)) {
			if (node != null) {
				printTree(node.getLeft(), type);
				System.out.format("%-20s %-20d %-20d \r\n", node.getWord(), node.getFrequency(), node.getCharCount());
				printTree(node.getRight(), type);
			}
		}

	}

}
