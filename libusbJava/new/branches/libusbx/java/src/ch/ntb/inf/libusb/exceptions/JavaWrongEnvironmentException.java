package ch.ntb.inf.libusb.exceptions;

public class JavaWrongEnvironmentException extends LibusbException{

	/**
	 * TODO
	 */
	private static final long serialVersionUID = -6969170327767175697L;

	public JavaWrongEnvironmentException(){
		super();
	}
	
	public JavaWrongEnvironmentException(String message){
		super(message);
	}
	
	public JavaWrongEnvironmentException(String message, Throwable cause){
		super(message, cause);
	}
	
	public JavaWrongEnvironmentException(Throwable cause){
		super(cause);
	}
}
