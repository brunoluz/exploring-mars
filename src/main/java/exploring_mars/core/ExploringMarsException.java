package exploring_mars.core;

public class ExploringMarsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	// this exception must be used for business errors
	public ExploringMarsException(String message) {
		super(message);
	}

}
