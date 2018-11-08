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
	
	/**
	 * get all endpoint descriptors of this interface
	 * @return List of endpoint descriptors
	 * @throws LibusbException
	 */
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
	
	/**
	 * get endpoint descriptor with specified endpoint address
	 * @param endpointAddress
	 * @return desired EndpointDescriptor
	 * @throws LibusbException
	 */
	public EndpointDescriptor getEndpointDescriptor(int endpointAddress) throws LibusbException{
		getEndpointDescriptors();
		
		for(int i = 0; i < endpointDesc.size(); i++){
			if(endpointDesc.get(i).getEndpointAddress() == endpointAddress){
				return endpointDesc.get(i);
			}
		}
		
		throw new InvalidParameterException();
	}
	
	/**
	 * get number of endpoints this interface has
	 * @return number of endpoints
	 * @throws LibusbException
	 */
	public int getNumberOfEndpoints() throws LibusbException{
		return Libusb.getNofEndpoints(device.getNativeDevice(), configIndex, ifaceIndex, altSetting);
	}
	
	/**
	 * get interface number of this interface
	 * @return interface number
	 * @throws LibusbException
	 */
	public int getInterfaceNumber() throws LibusbException{
		return Libusb.getInterfaceNumber(device.getNativeDevice(), configIndex, ifaceIndex, altSetting);		
	}
	
	/**
	 * get alternate setting of this interface
	 * @return interface number of alternate setting
	 * @throws LibusbException
	 */
	public int getAlternateSetting() throws LibusbException{
		return Libusb.getAlternateSetting(device.getNativeDevice(), configIndex, ifaceIndex, altSetting);
	}
}
