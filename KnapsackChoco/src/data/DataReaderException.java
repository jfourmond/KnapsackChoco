package data;

public class DataReaderException extends Exception {
	private static final long serialVersionUID = 1517324557999134595L;

	public DataReaderException(String message) {
		super(message);
	}
	
	public DataReaderException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DataReaderException(Throwable cause) {
		super(cause);
	}
}
