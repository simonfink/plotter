package ch.ntb.inf.libusb.exceptions;

public class LibusbIOException extends LibusbException{

	/**
	 * TODO autoGenerated, probably think to add one which is related to libusbJava-Version
	 */
	private static final long serialVersionUID = -2715836651838704720L;

	public LibusbIOException(){
		super();
	}
	
	public LibusbIOException(String message){
		super(message);
	}
	
	public LibusbIOException(String message, Throwable cause){
		super(message, cause);
	}
	
	public LibusbIOException(Throwable cause){
		super(cause);
	}
}