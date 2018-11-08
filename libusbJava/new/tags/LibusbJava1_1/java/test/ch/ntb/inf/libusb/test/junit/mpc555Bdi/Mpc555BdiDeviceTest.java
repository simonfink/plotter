package ch.ntb.inf.libusb.test.junit.mpc555Bdi;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.hamcrest.*;
import org.hamcrest.core.*;
import org.junit.rules.*;

import ch.ntb.inf.libusb.Context;
import ch.ntb.inf.libusb.Device;
import ch.ntb.inf.libusb.DeviceDescriptor;
import ch.ntb.inf.libusb.Speed;
import ch.ntb.inf.libusb.exceptions.AccessDeniedException;
import ch.ntb.inf.libusb.exceptions.LibusbException;
import ch.ntb.inf.libusb.exceptions.NotSupportedException;

public class Mpc555BdiDeviceTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
		
	@Test
	public void createDevice() throws Exception{
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("nativeDevice null");
		Device dev = new Device(null, null);	// context null would be valid, but nativeHandle null is not
		
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("nativeHandle null");
		dev.close();
	}
	
	@Test
	public void openDevice() throws Exception{
		Context useCtx = null;
		Device usbDev = null;
		
		useCtx = new Context();


		int nofDuplicates = 0;
		usbDev = Device.search(useCtx, 0x8235, 0x100);
		nofDuplicates = Device.getNofDuplicates();
		
		if(nofDuplicates >= 1){
			for(int i = 0; i < nofDuplicates; i++){
				//check which one of the composite device is the correct one
				try {
					usbDev = Device.getDuplicate(useCtx, 0x8235, 0x100, i);
					usbDev.open(1, 0, -1);
					usbDev.close();
					break;
				}
				catch(NotSupportedException e){
					// try next device
				}
			}

		}
	}
	
	@Test
	public void trySecondClose() throws Exception{
		Context useCtx = null;
		Device usbDev = null;
		
		useCtx = new Context();

		int nofDuplicates = 0;
		usbDev = Device.search(useCtx, 0x8235, 0x100);
		nofDuplicates = Device.getNofDuplicates();
		
		if(nofDuplicates >= 1){
			for(int i = 0; i < nofDuplicates; i++){
				//check which one of the composite device is the correct one
				try {
					usbDev = Device.getDuplicate(useCtx, 0x8235, 0x100, i);
					usbDev.open(1, 0, -1);
					usbDev.close();
					break;
				}
				catch(NotSupportedException e){
					// try next device
				}
			}
		}
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("nativeHandle null");
		usbDev.close();
		
	}
	
	@Test
	public void openDeviceInverted() throws Exception{
		Context useCtx = null;
		Device usbDev = null;
		
		useCtx = new Context();


		int nofDuplicates = 0;
		usbDev = Device.search(useCtx, 0x8235, 0x100);
		nofDuplicates = Device.getNofDuplicates();
		if(nofDuplicates >= 1){
			for(int i = nofDuplicates-1; i >= 0; i--){
				//check which one of the composite device is the correct one
				try {
					usbDev = Device.getDuplicate(useCtx, 0x8235, 0x100, i);
					usbDev.open(1, 0, -1);
					usbDev.close();
					break;
				}
				catch(NotSupportedException e){
					// try next device
				}
			}

		}
	}
	
	@Test
	public void testOpenFail() throws Exception{
		Device dev = openLibusbDevice();
		try{
			dev.open(1, 0, -1);
		}
		catch(Exception e){
			thrown.expect(AccessDeniedException.class);
			throw e;
		}
		finally{
			closeLibusbDevice(dev);
		}
	}
	
	public static Device openLibusbDevice() throws Exception{
		
		Context ctx = new Context();


		int nofDuplicates = 0;
		Device dev = Device.search(ctx, 0x8235, 0x100);
		nofDuplicates = Device.getNofDuplicates();
		
		if(nofDuplicates >= 1){
			for(int i = 0; i < nofDuplicates; i++){
				//check which one of the composite device is the correct one
				try {
					dev = Device.getDuplicate(ctx, 0x8235, 0x100, i);
					dev.open(1, 0, -1);
					dev.close();
					break;
				}
				catch(NotSupportedException e){
					// try next device
				}
			}

		}
		dev.open(1, 0, -1);
		return dev;
	}
	
	public static void closeLibusbDevice(Device dev) throws Exception{
		dev.close();		
	}
	
	@Test
	public void readDeviceDescriptorTest() throws Exception{
		DeviceDescriptor devDesc = null;
				
		Device dev = openLibusbDevice();
		
		devDesc = dev.getDeviceDescriptor();
		assertEquals("getVendorId failed", 0x8235, devDesc.getVendorId());
		assertEquals("getProductId failed", 0x100, devDesc.getProductId());
		
		closeLibusbDevice(dev);
	}
	
	@Test
	public void getBusPortNumberTest() throws Exception{
		Device dev = openLibusbDevice();
		assertNotNull(dev.getBusNumber());
		assertTrue(dev.getBusNumber() >= 0);
		assertTrue(dev.getBusNumber() < Integer.MAX_VALUE);
		
		assertNotNull(dev.getPortNumber());
		assertTrue(dev.getPortNumber() >= 0);
		assertTrue(dev.getPortNumber() < Integer.MAX_VALUE);
		
		closeLibusbDevice(dev);
	}
	
	@Test
	public void getBusNumberFail() throws Exception{
		Context ctx = new Context();
		Device dev = Device.open(ctx, 0x8235, 0x100);
		
		try{
			dev.getBusNumber();
		}
		catch(Exception e){
			thrown.expect(NullPointerException.class);
			thrown.expectMessage("nativeDevice null");
			throw e;
		}
		finally{		
			closeLibusbDevice(dev);
		}
	}
	
	@Test
	public void getPortNumberFail() throws Exception{
		Context ctx = new Context();
		Device dev = Device.open(ctx, 0x8235, 0x100);
		
		try{
			dev.getPortNumber();
		}
		catch(Exception e){
			thrown.expect(NullPointerException.class);
			thrown.expectMessage("nativeDevice null");
			throw e;
		}
		finally{		
			closeLibusbDevice(dev);
		}
	}
	
	@Test
	public void getPortNumbers() throws Exception{
		Device dev = openLibusbDevice();
		
		int MAX_PORT_DEPTH = 7;
		int portNumbers[] = new int[MAX_PORT_DEPTH];
		int len = dev.getPortNumbers(portNumbers);
		assertTrue(len >= 0);		// error on negative value
		for(int i = 0; i < len; i++){
			assertTrue(portNumbers[i] >= 0);
			assertTrue(portNumbers[i] < Integer.MAX_VALUE);
		}
		for(int i = MAX_PORT_DEPTH-1; i > len; i--){
			assertTrue(portNumbers[i] == 0);
		}
		
		closeLibusbDevice(dev);
	}
	
	@Test
	public void getPortNumbersFail() throws Exception{
		
		Context ctx = new Context();
		Device dev = Device.open(ctx, 0x8235, 0x100);
				
		int MAX_PORT_DEPTH = 7;
		int portNumbers[] = new int[MAX_PORT_DEPTH];
		
		try{
			int len = dev.getPortNumbers(portNumbers);
			if(len < 0){
				throw new LibusbException();	// only to make sure that int len = ... is not optimized and throw Exception, should not occur
			}
		}
		catch(Exception e){
			thrown.expect(NullPointerException.class);
			thrown.expectMessage("nativeDevice null");
			throw e;
		}
		finally{	
			closeLibusbDevice(dev);
		}
	}

	@Test
	public void getParentTest() throws Exception{
		Device dev = openLibusbDevice();
		
		try{
			Device parent = dev.getParent();
			parent.getDeviceAddress();
		}
		catch(Exception e){
			throw e;
		}
		finally{
			closeLibusbDevice(dev);
		}
	}
	
	@Test
	public void getParentTestFail() throws Exception{
		Context ctx = new Context();
		Device dev = Device.open(ctx, 0x8235, 0x100);
		
		try{
			Device parent = dev.getParent();
			parent.getDeviceAddress();
		}
		catch(Exception e){
			thrown.expect(NullPointerException.class);
			thrown.expectMessage("nativeDevice null");
			throw e;
		}
		finally{
			closeLibusbDevice(dev);
		}
	}
	
	@Test
	public void getDeviceSpeedTest() throws Exception{
		Device dev = openLibusbDevice();
		
		try{
			Speed spe = dev.getDeviceSpeed();
			assertNotNull(spe);
			assertEquals(spe, Speed.HIGH);
		}
		catch(Exception e){
			throw e;
		}
		finally{
			closeLibusbDevice(dev);
		}
	}
	
	@Test
	public void getDeviceSpeedFail() throws Exception{
		Context ctx = new Context();
		Device dev = Device.open(ctx, 0x8235, 0x100);
		
		try{
			Speed spe = dev.getDeviceSpeed();
			assertNull(spe);
		}
		catch(Exception e){
			thrown.expect(NullPointerException.class);
			thrown.expectMessage("nativeDevice null");
			throw e;
		}
		finally{
			closeLibusbDevice(dev);
		}
	}
	
	@Test
	public void getDeviceAddressTest() throws Exception{
		Device dev = openLibusbDevice();
		
		try{
			int address = dev.getDeviceAddress();
			assertNotNull(address);
			assertTrue(address >= 0);
			assertTrue(address < Integer.MAX_VALUE);
		}
		catch(Exception e){
			throw e;
		}
		finally{
			closeLibusbDevice(dev);
		}
	}
	
	@Test
	public void getDeviceAddressFail() throws Exception{
		Context ctx = new Context();
		Device dev = Device.open(ctx, 0x8235, 0x100);
		
		try{
			int address = dev.getDeviceAddress();
			assertNull(address);
		}
		catch(Exception e){
			thrown.expect(NullPointerException.class);
			thrown.expectMessage("nativeDevice null");
			throw e;
		}
		finally{
			closeLibusbDevice(dev);
		}
	}
}
