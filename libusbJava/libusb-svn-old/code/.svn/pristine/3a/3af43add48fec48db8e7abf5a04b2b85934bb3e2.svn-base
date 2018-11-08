package ch.ntb.inf.libusb;

import ch.ntb.inf.libusb.Device;
import ch.ntb.inf.libusb.InterfaceDescriptor;
import ch.ntb.inf.libusb.Libusb;
import ch.ntb.inf.libusb.TransferType;
import ch.ntb.inf.libusb.exceptions.LibusbException;

public class EndpointDescriptor extends InterfaceDescriptor{

	protected int endpointIndex;
	
	protected EndpointDescriptor(Device device, int configIndex, int ifaceIndex, int altSetting, int endpointIndex){
		super(device, configIndex, ifaceIndex, altSetting);
		this.endpointIndex = endpointIndex;
	}
	
	public int getMaxPacketSize() throws LibusbException{
		return Libusb.getMaxPacketSize(device.getNativeDevice(), configIndex, ifaceIndex, altSetting, endpointIndex);
	}
	
	public int getMaxIsoPacketSize() throws LibusbException{
		//TODO, throws LIBUSB_ERROR_NOT_FOUND, LIBUSB_ERROR_OTHER
		return Libusb.getMaxIsoPacketSize(device.getNativeDevice(), configIndex, ifaceIndex, altSetting, endpointIndex);
	}
	
	public void clearHalt(){
		//TODO throws LIBUSB_ERROR_NOT_FOUND, LIBUSB_ERROR_NO_DEVICE, another LIBUSB_ERROR code on other failure
	}
	
	public int getEndpointAddress() throws LibusbException{
		return Libusb.getEndpointAddress(device.getNativeDevice(), configIndex, ifaceIndex, altSetting, endpointIndex);
	}
	
	/**
	 * 
	 * @return true if Endpoint-In (device-to-host), false if Endpoint-Out (host-to-device)
	 */
	public boolean getEndpointDirection() throws LibusbException{
		if((Libusb.getEndpointAddress(device.getNativeDevice(), configIndex, ifaceIndex, altSetting, endpointIndex) & 0x80) == 0x80){
			//endpoint In
			return true;
		}
		else{
			//endpoint Out
			return false;
		}
	}
	
	public TransferType getTransferType() throws LibusbException{
		return TransferType.valueOf(Libusb.getTransferType(device.getNativeDevice(), configIndex, ifaceIndex, altSetting, endpointIndex));
	}
}
