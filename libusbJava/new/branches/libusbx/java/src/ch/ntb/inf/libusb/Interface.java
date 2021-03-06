package ch.ntb.inf.libusb;

import java.util.ArrayList;
import java.util.List;

import ch.ntb.inf.libusb.ConfigurationDescriptor;
import ch.ntb.inf.libusb.Device;
import ch.ntb.inf.libusb.InterfaceDescriptor;
import ch.ntb.inf.libusb.Libusb;
import ch.ntb.inf.libusb.exceptions.*;

public class Interface extends ConfigurationDescriptor{
	//contains one Interface with alternate settings
	private List<InterfaceDescriptor> altSettings;
	private int nofAltSettings;
	
	protected int ifaceIndex;
	
	protected Interface(Device dev, int configIndex, int ifaceIndex){
		super(dev, configIndex);
		this.ifaceIndex = ifaceIndex;
	}
	
	public List<InterfaceDescriptor> getAlternateSettings() throws LibusbException{
		if(altSettings == null){
			altSettings = new ArrayList<InterfaceDescriptor>();
		}
		for(int i = 0; i < getNumberOfAlternateSettings(); i++){
			if(altSettings.size() - 1 < i){
				altSettings.add(i, new InterfaceDescriptor(device, configIndex, ifaceIndex, i));
			}
			else{
				altSettings.set(i, new InterfaceDescriptor(device, configIndex, ifaceIndex, i));
			}			
		}
		return altSettings;
	}
	
	public int getNumberOfAlternateSettings() throws LibusbException{
		nofAltSettings = Libusb.getNofAltSettings(device.getNativeDevice(), configIndex);
		return nofAltSettings;
	}
	
	public InterfaceDescriptor getAlternateSetting(int ifaceNum) throws LibusbException{
		getAlternateSettings();
		
		for(int i = 0; i < altSettings.size(); i++){
			if( altSettings.get(i).getInterfaceNumber() == ifaceNum ){
				return altSettings.get(i);
			}
		}
		throw new InvalidParameterException();
	}
	
	public boolean kernelDriverActive(int interfaceNumber){
		return false; //TODO throws error, true if kernelDriverActive, false else 
		//LIBUSB_ERROR_NO_DEVICE, LIBUSB_ERROR_NOT_SUPPORTED, another LIBUSB_ERROR on other failure
	}
	
	public void detachKernelDriver(int interfaceNumber){
		//TODO throws LIBUSB_ERROR_NOT_FOUND, LIBUSB_ERROR_INVALID_PARAM, LIBUSB_ERROR_NO_DEVICE, LIBUSB_ERROR_NOT_SUPPORTED, another LIBUSB_ERROR code
	}
	
	public void attachKernelDriver(int interfaceNumber){
		//TODO throws LIBUSB_ERROR_NOT_FOUND, LIBUSB_ERROR_INVALID_PARAM, LIBUSB_ERROR_NO_DEVICE, LIBUSB_ERROR_NOT_SUPPORTED, LIBUSB_ERROR_BUSY, another LIBUSB_ERROR on other fail
	}
	
	public void setAutoDetachKernelDriver(boolean enable){
		//TODO
		// throws LIBUSB_ERROR_NOT_SUPPORTED on platforms without this functionality, LIBUSB_SUCCESS on success
	}
	
	public void setAltSetting(int interfaceNumber, int alternateSetting){
		//TODO throws if fail
		//LIBUSB_ERROR_NOT_FOUND, LIBUSB_ERROR_NO_DEVICE, another LIBUSB_ERROR code on other failure
	}
}
