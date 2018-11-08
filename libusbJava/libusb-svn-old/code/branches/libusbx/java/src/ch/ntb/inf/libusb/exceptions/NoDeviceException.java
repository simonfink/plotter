package ch.ntb.inf.libusb.exceptions;

public class NoDeviceException extends LibusbException{

	/**
	 * TODO
	 */
	private static final long serialVersionUID = -6272050122143339200L;

	public NoDeviceException(){
		super();
	}
	
	public NoDeviceException(String message){
		super(message);
	}
	
	public NoDeviceException(String message, Throwable cause){
		super(message, cause);
	}
	
	public NoDeviceException(Throwable cause){
		super(cause);
	}	
}
