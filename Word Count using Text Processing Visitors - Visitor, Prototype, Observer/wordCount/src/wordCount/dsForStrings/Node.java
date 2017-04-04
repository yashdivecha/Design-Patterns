package wordCount.dsForStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import wordCount.observer.FilterI;
import wordCount.observer.ObserverI;
import wordCount.observer.SubjectI;
import wordCount.observer.FilterI.Updates;
import wordCount.util.Logger;

/**
 * Node : This class is used to for the BST and acts as Observer and Subject.
 * 
 * @author Yash Divecha
 *
 */
public class Node implements Cloneable, SubjectI, ObserverI {
	private String word = "";
	private Node right = null;
	private Node left = null;
	private long frequency = 1;
	private long charCount;
	private HashMap<FilterI.Updates, List<Node>> observerList;
	private FilterI filter;

	public Node() {
		Logger.writeMessage("Constructor of Node: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
	}

	// Constructor of Node
	public Node(String wordIn) {
		Logger.writeMessage("Constructor of Node: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
		this.word = wordIn;
		observerList = new HashMap<>();
	}

	// This method is overridden from Cloneable interface
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Unable to Clone.");
			e.printStackTrace();
			System.exit(1);
		} finally {
		}
		return this;

	}

	// This method is used to initiate the back up cloning and sets up the
	// observer pattern and notify the dependent nodes.
	public void setNewFrequency(long frequencyIn) {
		this.frequency = frequencyIn;
		notifyNodes(frequencyIn);
	}

	public String getWord() {
		return word;
	}

	public void setWord(String wordIn) {
		this.word = wordIn;
	}

	// Getter method of Frequency
	public long getFrequency() {
		return frequency;
	}

	// Setter method of Frequency
	public void setFrequency(long frequencyIn) {
		this.frequency = frequencyIn;

	}

	// Getter method of Char Count
	public long getCharCount() {
		return charCount;
	}

	// Setter method of Char Count.
	public void setCharCount(long charCountIn) {
		this.charCount = charCountIn;
	}

	// Getter method of Right Child
	public Node getRight() {
		return right;
	}

	// Setter method of Right Child
	public void setRight(Node rightIn) {
		this.right = rightIn;
	}

	// Getter method of Left Child
	public Node getLeft() {
		return left;
	}

	// Setter method of Left Child
	public void setLeft(Node left) {
		this.left = left;
	}

	@Override // Observer Pattern
	public void registerNode(Node node, FilterI filterIn) {
		if (observerList.get(filterIn) == null) {
			this.filter = filterIn;
			ArrayList<Node> list = new ArrayList<>();
			list.add(node);
			observerList.put(filterIn.getFilterValue(), list);
		}

	}

	@Override // Observer Pattern
	public void removeNode(ObserverI obs) {
		if (!observerList.isEmpty())
			observerList.remove(obs);
	}

	@Override // Observer Pattern
	public void notifyNodes(long updateValue) {
		if (filter.checkUpdate(Updates.UPDATE_COUNT)) {
			if (observerList.get(Updates.UPDATE_COUNT) != null)
				for (ObserverI n : observerList.get(FilterI.Updates.UPDATE_COUNT))
					n.updateNode(updateValue);
		}
	}

	@Override // Observer Pattern
	public void updateNode(long updateValue) {
		this.frequency = updateValue;
	}
}
