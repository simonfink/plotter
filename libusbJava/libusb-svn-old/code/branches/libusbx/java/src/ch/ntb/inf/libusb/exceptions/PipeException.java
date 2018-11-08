package ch.ntb.inf.libusb.exceptions;

public class PipeException extends LibusbException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5754048803153512646L;

	public PipeException(){
		super();
	}
	
	public PipeException(String message){
		super(message);
	}
	
	public PipeException(String message, Throwable cause){
		super(message, cause);
	}
	
	public PipeException(Throwable cause){
		super(cause);
	}
}
