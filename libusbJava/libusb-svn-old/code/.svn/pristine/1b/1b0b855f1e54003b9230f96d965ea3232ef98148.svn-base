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

import ch.ntb.inf.libusb.Device;
import ch.ntb.inf.libusb.DeviceDescriptor;
import ch.ntb.inf.libusb.Interface;
import ch.ntb.inf.libusb.Libusb;
import ch.ntb.inf.libusb.exceptions.InvalidParameterException;
import ch.ntb.inf.libusb.exceptions.LibusbException;

public class ConfigurationDescriptor extends DeviceDescriptor{
	
	//evtl. Collection libusb_interface zuerst darueber legen und dort drin altsettings
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
	
	/**
	 * get the number of interfaces supported by this configruation
	 * @return number of interfaces
	 */
	public int getNofInterfaces(){
		nofInterfaces = Libusb.getNofInterfaces(device.getNativeDevice(), configIndex);
		return nofInterfaces;
	}
	
	/**
	 * get the specified interface
	 * @param number of desired interface
	 * @return specified interface
	 * @throws LibusbException
	 */
	public Interface getInterface(int number) throws LibusbException{
		if(number > getNofInterfaces()){
			throw new InvalidParameterException();
		}
		getAllInterfaces();
		return iface.get(number);
	}
	
	/**
	 * get a List of all interfaces supported by this configuration
	 * @return List of interfaces
	 */
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
	
	/**
	 * get the configuration value of the current configuration
	 * @return configuration value
	 */
	public int getConfigValue(){
		return Libusb.getConfigValue(device.getNativeDevice(), configIndex);
	}
}
