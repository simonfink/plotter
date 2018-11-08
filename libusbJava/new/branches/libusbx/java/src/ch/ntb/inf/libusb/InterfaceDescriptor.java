package ch.ntb.inf.libusb;

import java.util.ArrayList;
import java.util.List;

import ch.ntb.inf.libusb.Device;
import ch.ntb.inf.libusb.EndpointDescriptor;
import ch.ntb.inf.libusb.Interface;
import ch.ntb.inf.libusb.Libusb;
import ch.ntb.inf.libusb.exceptions.*;

public class InterfaceDescriptor extends Interface{

	private List<EndpointDescriptor> endpointDesc;
	
	protected int altSetting;
	
	protected InterfaceDescriptor(Device device, int configIndex, int ifaceIndex, int altSetting){
		super(device, configIndex, ifaceIndex);
		this.altSetting = altSetting;
	}
	
	public List<EndpointDescriptor> getEndpointDescriptors() throws LibusbException{
		if(endpointDesc == null){
			endpointDesc = new ArrayList<EndpointDescriptor>();
		}
		for(int i = 0; i < getNumberOfEndpoints(); i++){
			if(endpointDesc.size() - 1 < i){
				endpointDesc.add(i, new EndpointDescriptor(device, configIndex, ifaceIndex, altSetting, i));
			}
			else{
				endpointDesc.set(i, new EndpointDescriptor(device, configIndex, ifaceIndex, altSetting, i));
			}
		}
		
		return endpointDesc;
	}
	
	public EndpointDescriptor getEndpointDescriptor(int endpointAddress) throws LibusbException{
		getEndpointDescriptors();
		
		for(int i = 0; i < endpointDesc.size(); i++){
			if(endpointDesc.get(i).getEndpointAddress() == endpointAddress){
				return endpointDesc.get(i);
			}
		}
		
		throw new InvalidParameterException();
	}
	
	public int getNumberOfEndpoints() throws LibusbException{
		return Libusb.getNofEndpoints(device.getNativeDevice(), configIndex, ifaceIndex, altSetting);
	}
	
	public int getInterfaceNumber() throws LibusbException{
		return Libusb.getInterfaceNumber(device.getNativeDevice(), configIndex, ifaceIndex, altSetting);		
	}
	
	public int getAlternateSetting() throws LibusbException{
		return Libusb.getAlternateSetting(device.getNativeDevice(), configIndex, ifaceIndex, altSetting);
	}
}
