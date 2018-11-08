package ch.ntb.inf.libusb.exceptions;

import java.io.IOException;

public class LibusbException extends IOException{
	/**
	 * TODO autoGenerated, probably think to add one which is related to libusbJava-Version 
	 */
	private static final long serialVersionUID = 8778526783315850689L;
	
	/**
	 * libusb error codes
	 */
	public static final int ERROR_NONE = 0;
	public static final int ERROR_IO = -1;
	public static final int ERROR_INVALID_PARAM = -2;
	public static final int ERROR_ACCESS = -3;
	public static final int ERROR_NO_DEVICE = -4;
	public static final int ERROR_NOT_FOUND = -5;
	public static final int ERROR_BUSY = -6;
	public static final int ERROR_TIMEOUT = -7;
	public static final int ERROR_OVERFLOW = -8;
	public static final int ERROR_PIPE = -9;
	public static final int ERROR_INTERRUPTED = -10;
	public static final int ERROR_NO_MEM = -11;
	public static final int ERROR_NOT_SUPPORTED = -12;
	public static final int ERROR_OTHER = -99;
	public static final int ERROR_JAVA_REFERENCES_NOT_LOADED = -100;
	public static final int ERROR_JAVA_WRONG_ENVIRONMENT = -101;
	public static final int ERROR_JAVA_ILLEGAL_DEVICE_HANDLE = -102;
	
	public LibusbException(){
		super();
	}
	
	public LibusbException(String message){
		super(message);
	}
	
	public LibusbException(String message, Throwable cause){
		super(message, cause);
	}
	
	public LibusbException(Throwable cause){
		super(cause);
	}

	public LibusbException(int code) throws LibusbException {
		switch(code){
			case ERROR_IO:
				throw new LibusbIOException();
			case ERROR_INVALID_PARAM:
				throw new InvalidParameterException();
			case ERROR_ACCESS:
				throw new AccessDeniedException();
			case ERROR_NO_DEVICE:
				throw new NoDeviceException();
			case ERROR_NOT_FOUND:
				throw new EntityNotFoundException();
			case ERROR_BUSY:
				throw new ResourceBusyException();	
			case ERROR_TIMEOUT:
				throw new TimeoutException();	
			case ERROR_OVERFLOW:
				throw new OverflowException();
			case ERROR_PIPE:
				throw new PipeException();
			case ERROR_INTERRUPTED:
				throw new SysCallInterruptedException();
			case ERROR_NO_MEM:
				throw new NoMemoryException();	
			case ERROR_NOT_SUPPORTED:
				throw new NotSupportedException();
			case ERROR_OTHER:
				throw new OtherException();			
			case ERROR_JAVA_REFERENCES_NOT_LOADED:
				throw new JavaReferencesNotLoadedException();			
			case ERROR_JAVA_WRONG_ENVIRONMENT:
				throw new JavaWrongEnvironmentException();		
			case ERROR_JAVA_ILLEGAL_DEVICE_HANDLE:
				throw new JavaIllegalDeviceHandleException();		
			default:
				throw new OtherException("Unknown: (" + code + ")");
		}
	}
}