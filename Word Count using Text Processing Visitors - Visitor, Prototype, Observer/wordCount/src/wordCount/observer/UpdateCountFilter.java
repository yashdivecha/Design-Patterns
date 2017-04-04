package wordCount.observer;

/**
 * UpdateCountFilter : Implementation of the Filter Interface.
 * 
 * @author Yash Divecha
 *
 */
public class UpdateCountFilter implements FilterI {
	private Updates update;

	@Override // Checks what type of update observer needs.
	public boolean checkUpdate(Updates update) {
		if (update.equals(Updates.UPDATE_COUNT))
			return true;
		return false;
	}

	@Override // Getter method of the Filter.
	public Updates getFilterValue() {
		return this.update;

	}

	@Override // Setter method of the Filter.
	public void setFilterValue(Updates updateIn) {
		this.update = updateIn;

	}

}
