/*
 * Java wrapper for libusb
 * 
 * Copyright (C) 2015-2016 NTB University of Applied Sciences in Technology
 * Buchs, Switzerland, http://www.ntb.ch/inf
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 * 
 */

package ch.ntb.inf.libusb;

import java.util.ArrayList;
import java.util.List;

import ch.ntb.inf.libusb.ConfigurationDescriptor;
import ch.ntb.inf.libusb.Descriptor;
import ch.ntb.inf.libusb.Device;
import ch.ntb.inf.libusb.Libusb;
import ch.ntb.inf.libusb.exceptions.*;

public class DeviceDescriptor extends Descriptor{

	private int nofConfigurations;
	private List<ConfigurationDescriptor> configDesc;
	
	protected Device device; 		//the corresponding device
		
	protected DeviceDescriptor(Device dev){
		this.device = dev;
	}
	
	/**
	 * get vendor id
	 * @return vendor id
	 */
	public int getVendorId(){
		return Libusb.getVendorId(device.getNativeDevice());
	}
	
	/**
	 * get product id
	 * @return product id
	 */
	public int getProductId(){
		return Libusb.getProductId(device.getNativeDevice());
	}
	
	/**
	 * get number of configurations
	 * @return number of configurations
	 */
	public int getNofConfigurations(){
		nofConfigurations = Libusb.getNofConfigurations(device.getNativeDevice()); 
		return nofConfigurations;
	}
	
	/**
	 * get all ConfigurationDescriptors of this DeviceDescriptor in a list
	 * @return list of ConfigurationDescriptors
	 * @throws LibusbException
	 */
	public List<ConfigurationDescriptor> getConfigDescriptors() throws LibusbException{
		if(configDesc == null){
			configDesc = new ArrayList<ConfigurationDescriptor>();
		}
		for(int i = 0; i < getNofConfigurations(); i++){
			if(configDesc.size()-1 < i ){
				configDesc.add(i,  new ConfigurationDescriptor(device, i));
				System.out.println("Config " + i + " added.");
			}
			else{
				configDesc.set(i, new ConfigurationDescriptor(device, i));
//				System.out.println("Config " + i + " updated.");
			}
		}
		return configDesc;
	}
	
	/**
	 * get ConfigurationDescriptor with specified configuration value
	 * @param configValue
	 * @return ConfigurationDescriptor
	 * @throws LibusbException
	 */
	public ConfigurationDescriptor getConfigDescriptor(int configValue) throws LibusbException{
		getConfigDescriptors();
		
		for(int i = 0; i < configDesc.size(); i++){
			if(configDesc.get(i).getConfigValue() == configValue){
				return configDesc.get(i);
			}
		}
		
		throw new InvalidParameterException(); 
	}
	
	/**
	 * get the currently active ConfigurationDescriptor
	 * @return active ConfigurationDescriptor
	 * @throws LibusbException
	 */
	public ConfigurationDescriptor getActiveConfigDescriptor() throws LibusbException{
		if(configDesc == null){
			configDesc = getConfigDescriptors();
		}
		int configValue = Libusb.getActiveConfigDescriptor(device.getNativeDevice());
		if(Context.dbg){
			System.out.println("ConfigValue ActiveConfigDesc: " + configValue);
		}
		for(int i = 0; i < configDesc.size(); i++){
			if(configValue == configDesc.get(i).getConfigValue()){
				if(Context.dbg){
					System.out.println("-----------ActiveConfigDesc---------------");
					System.out.println("Cfg found, pos: " + i + " value: " + configValue);
				}
				//TODO test it with Linux with more than one ConfigDescriptor
				return configDesc.get(i);
			}
		}
		throw new OtherException("No active Configuration Descriptor found.");
	}
	
	/**
	 * NOT SUPPORTED at the moment!!
	 * @param nofConfig
	 */
	public void setActiveConfigDescriptor(int nofConfig) throws LibusbException{ 
		throw new NotSupportedException();
		//TODO throws ConfigException!?
		//entspricht libusb_set_configuration
		//LIBUSB_ERROR_NOT_FOUND, LIBUSB_ERROR_BUSY, LIBUSB_ERROR_NO_DEVICE, another LIBUSB_ERROR code on other failure
	}
	
	/**
	 * get index to retrieve the serial number string
	 * @return serial number index
	 * @throws LibusbException
	 */
	public int getSerialNumberIndex() throws LibusbException{
		return Libusb.getSerialNumberIndex(device.getNativeDevice());
	}

	/**
	 * get index to retrieve the product descriptor string
	 * @return product descriptor index
	 * @throws LibusbException
	 */
	public int getProductDescIndex() throws LibusbException{
		return Libusb.getProductDescIndex(device.getNativeDevice());
	}


	/**
	 * get index to retrieve manufacturer descriptor string
	 * @return manufacturer descriptor index
	 * @throws LibusbException
	 */
	public int getManufacturerDescIndex() throws LibusbException{
		return Libusb.getManufacturerDescIndex(device.getNativeDevice());
	}
}
