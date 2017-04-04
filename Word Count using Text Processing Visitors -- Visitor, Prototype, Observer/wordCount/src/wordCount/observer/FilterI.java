package wordCount.observer;

/**
 * This FilterI is used check which updates Observer is registered for.
 * 
 * @author Yash Divecha
 *
 */
public interface FilterI {
	public enum Updates {
		UPDATE_COUNT, UPDATE_WORD
	};

	public boolean checkUpdate(Updates update);

	public Updates getFilterValue();

	public void setFilterValue(Updates updateIn);
}
