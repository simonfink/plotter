package ch.ntb.inf.libusb.exceptions;

public class DeviceListNotValidException extends LibusbException {

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 3745210342519785950L;

	public DeviceListNotValidException(){
		super();
	}
	
	public DeviceListNotValidException(String message){
		super(message);
	}
	
	public DeviceListNotValidException(String message, Throwable cause){
		super(message, cause);
	}
	
	public DeviceListNotValidException(Throwable cause){
		super(cause);
	}
}
