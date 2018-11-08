package ch.ntb.inf.libusb.exceptions;

public class NoMemoryException extends LibusbException{

	/**
	 * TODO
	 */
	private static final long serialVersionUID = -7749440703300870005L;

	public NoMemoryException(){
		super();
	}
	
	public NoMemoryException(String message){
		super(message);
	}
	
	public NoMemoryException(String message, Throwable cause){
		super(message, cause);
	}
	
	public NoMemoryException(Throwable cause){
		super(cause);
	}
}
