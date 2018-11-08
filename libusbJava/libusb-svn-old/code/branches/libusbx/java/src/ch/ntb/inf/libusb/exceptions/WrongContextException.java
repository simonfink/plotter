package ch.ntb.inf.libusb.exceptions;

public class WrongContextException extends LibusbException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4739162765665866800L;

	public WrongContextException(){
		super();
	}
	
	public WrongContextException(String message){
		super(message);
	}
	
	public WrongContextException(String message, Throwable cause){
		super(message, cause);
	}
	
	public WrongContextException(Throwable cause){
		super(cause);
	}
}
