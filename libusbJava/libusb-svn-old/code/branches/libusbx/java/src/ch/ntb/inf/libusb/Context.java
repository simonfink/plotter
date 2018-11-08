package ch.ntb.inf.libusb;

import java.nio.ByteBuffer;

import ch.ntb.inf.libusb.Libusb;
import ch.ntb.inf.libusb.exceptions.LibusbException;

public class Context {

	private ByteBuffer context;
	private static int nofContext = 0;
	
	static{
		
		System.loadLibrary("LibusbJava-1_1");
	}
	
	public Context() throws LibusbException {
		context = Libusb.init();
		nofContext++;
	}
	
	ByteBuffer getNativePointer(){
		return context;
	}
	
	public void finalize() throws Throwable{
		try{
			nofContext--;
			if(nofContext <= 0){
				Libusb.exit(context);
			}
		}
		finally{
			super.finalize();
		}
	}
}
