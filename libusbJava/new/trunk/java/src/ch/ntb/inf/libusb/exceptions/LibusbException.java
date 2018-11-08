/*
 * Java wrapper for libusb
 * 
 * Copyright 2015 - 2018 NTB University of Applied Sciences in Technology
 * Buchs, Switzerland, http://www.ntb.ch/inf
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

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
