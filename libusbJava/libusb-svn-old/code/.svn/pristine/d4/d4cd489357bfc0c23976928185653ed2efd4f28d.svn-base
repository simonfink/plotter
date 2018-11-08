package ch.ntb.inf.libusb.test.junit.mpc555Bdi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ch.ntb.inf.libusb.ConfigurationDescriptor;
import ch.ntb.inf.libusb.Device;
import ch.ntb.inf.libusb.DeviceDescriptor;
import ch.ntb.inf.libusb.test.junit.mpc555Bdi.Mpc555BdiDeviceTest;

public class DescriptorTest {

	
	
	@Test
	public void configDesc() throws Exception{
		Device dev = Mpc555BdiDeviceTest.openLibusbDevice();
		DeviceDescriptor devDesc = null;
		devDesc = dev.getDeviceDescriptor();
		
		assertNotNull(devDesc.getConfigDescriptors());
		
		Mpc555BdiDeviceTest.closeLibusbDevice(dev);
	}
	
	@Test
	public void activeConfigDesc() throws Exception{
		Device dev = Mpc555BdiDeviceTest.openLibusbDevice();
		DeviceDescriptor devDesc = dev.getDeviceDescriptor();
		
		ConfigurationDescriptor activeCfgDesc = null;
		activeCfgDesc = devDesc.getActiveConfigDescriptor();
		
		assertEquals(3, activeCfgDesc.getNofInterfaces());
		
		Mpc555BdiDeviceTest.closeLibusbDevice(dev);
	}
}
