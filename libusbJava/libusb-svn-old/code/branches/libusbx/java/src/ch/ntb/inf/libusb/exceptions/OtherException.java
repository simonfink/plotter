package ch.ntb.inf.libusb.exceptions;

public class OtherException extends LibusbException{

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 4435872410369564807L;

	public OtherException(){
		super();
	}
	
	public OtherException(String message){
		super(message);
	}
	
	public OtherException(String message, Throwable cause){
		super(message, cause);
	}
	
	public OtherException(Throwable cause){
		super(cause);
	}
	
}
