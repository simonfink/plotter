package ch.ntb.inf.libusb.exceptions;

public class OverflowException extends LibusbException{

	/**
	 * TODO
	 */
	private static final long serialVersionUID = -5922916856144324472L;
	
	public OverflowException(){
		super();
	}
	
	public OverflowException(String message){
		super(message);
	}
	
	public OverflowException(String message, Throwable cause){
		super(message, cause);
	}
	
	public OverflowException(Throwable cause){
		super(cause);
	}
}