package ch.ntb.inf.libusb.exceptions;

public class TimeoutException extends LibusbException{

	/**
	 * TODO
	 */
	private static final long serialVersionUID = -6926978720043438963L;

	public TimeoutException(){
		super();
	}
	
	public TimeoutException(String message){
		super(message);
	}
	
	public TimeoutException(String message, Throwable cause){
		super(message, cause);
	}
	
	public TimeoutException(Throwable cause){
		super(cause);
	}
}
