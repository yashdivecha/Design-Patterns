package registrationScheduler.util;

/**
 * This interface creates and manages Objects (Courses).
 * 
 * @author Yash
 */
public interface ObjectPool {

	public char borrowObject(char object);

	public void addObject(char object);

	public int getObjectCount(char object);

	public boolean checkAvailability(char object);

	public void clear();

	public void invalidate(char object);
}
