package ch.ntb.inf.libusb.exceptions;

public class JavaIllegalDeviceHandleException extends LibusbException{

	/**
	 * TODO
	 */
	private static final long serialVersionUID = -8851659702782268583L;

	public JavaIllegalDeviceHandleException(){
		super();
	}
	
	public JavaIllegalDeviceHandleException(String message){
		super(message);
	}
	
	public JavaIllegalDeviceHandleException(String message, Throwable cause){
		super(message, cause);
	}
	
	public JavaIllegalDeviceHandleException(Throwable cause){
		super(cause);
	}
}