package ch.ntb.inf.libusb.exceptions;

public class ResourceBusyException extends LibusbException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7307496028686694179L;

	public ResourceBusyException(){
		super();
	}
	
	public ResourceBusyException(String message){
		super(message);
	}
	
	public ResourceBusyException(String message, Throwable cause){
		super(message, cause);
	}
	
	public ResourceBusyException(Throwable cause){
		super(cause);
	}
}