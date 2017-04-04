package wordCount.observer;

import wordCount.dsForStrings.Node;

/**
 * SubjectI: This interface is used to register, remove and notify the observer
 * depending upon the filter.
 * 
 * @author Yash Divecha
 *
 */
public interface SubjectI {
	public void registerNode(Node observer, FilterI f);

	public void removeNode(ObserverI observer);

	public void notifyNodes(long udpateValue);
}
