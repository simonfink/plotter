package ch.ntb.inf.libusb.ctest;

import static org.junit.Assert.fail;

import java.nio.ByteBuffer;

import org.junit.Test;

import ch.ntb.inf.libusb.exceptions.LibusbException;

public class LibusbJavaTest {

	/**
	 * This method does not need to be tested. This test only exists to document
	 * the fact that this function has not been forgotten. 
	 */
	@Test
	public void testSetDebug(){
		
	}
	
	@Test
	public void testInit(){
		//Test ByteBuffer
//		try{
//			ByteBuffer handle = Libusb.init();
//			Libusb.exit(handle);
//		}
//		catch(LibusbException e){
//			fail("Initialization failed, Code: " + e.toString());
//		}
	}
}
