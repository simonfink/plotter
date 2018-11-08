package ch.ntb.inf.libusb;

import java.util.ArrayList;
import java.util.List;

import ch.ntb.inf.libusb.Device;
import ch.ntb.inf.libusb.DeviceDescriptor;
import ch.ntb.inf.libusb.Interface;
import ch.ntb.inf.libusb.Libusb;
import ch.ntb.inf.libusb.exceptions.InvalidParameterException;
import ch.ntb.inf.libusb.exceptions.LibusbException;

public class ConfigurationDescriptor extends DeviceDescriptor{
	
	//evtl. Collection libusb_interface zuerst darüber legen und dort drin altsettings
	//numberOfAltSettings entspricht iface.size()
	private List<Interface> iface;
	private int nofInterfaces;
	
	protected int configIndex;
			
	protected ConfigurationDescriptor(Device dev){
		super(dev);
	}
	
	protected ConfigurationDescriptor(Device dev, int configIndex){
		super(dev);
		this.configIndex = configIndex;
	}
	
	public int getNofInterfaces(){
		nofInterfaces = Libusb.getNofInterfaces(device.getNativeDevice(), configIndex);
		return nofInterfaces;
	}
	
	public Interface getInterface(int number) throws LibusbException{
		if(number > getNofInterfaces()){
			throw new InvalidParameterException();
		}
		getAllInterfaces();
		return iface.get(number);
	}
	
	public List<Interface> getAllInterfaces(){
		if(iface == null){
			iface = new ArrayList<Interface>();
		}
		for(int i = 0; i < getNofInterfaces(); i++){			
			if(iface.size()-1 < i ){
				iface.add(i, new Interface(device, configIndex, i));
			}
			else{
				iface.set(i, new Interface(device, configIndex, i));
			}
			
		}
		return iface;
	}
	
	public int getConfigValue(){
		return Libusb.getConfigValue(device.getNativeDevice(), configIndex);
	}
}
