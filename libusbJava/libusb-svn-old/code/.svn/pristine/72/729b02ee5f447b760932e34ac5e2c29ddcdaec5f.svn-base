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
	
	/**
	 * get maximum packet size for endpoint
	 * @return maximum packet size
	 * @throws LibusbException
	 */
	public int getMaxPacketSize() throws LibusbException{
		return Libusb.getMaxPacketSize(device.getNativeDevice(), configIndex, ifaceIndex, altSetting, endpointIndex);
	}
	
	/**
	 * get maximum isochronous packet size
	 * @return maximum isochronous packet size
	 * @throws LibusbException
	 */
	public int getMaxIsoPacketSize() throws LibusbException{
		//TODO, throws LIBUSB_ERROR_NOT_FOUND, LIBUSB_ERROR_OTHER
		return Libusb.getMaxIsoPacketSize(device.getNativeDevice(), configIndex, ifaceIndex, altSetting, endpointIndex);
	}
	
	/**
	 * NOT SUPPORTED at the moment
	 */
	public void clearHalt(){
		//TODO throws LIBUSB_ERROR_NOT_FOUND, LIBUSB_ERROR_NO_DEVICE, another LIBUSB_ERROR code on other failure
	}
	
	/**
	 * get address of desired endpoint
	 * @return endpoint address
	 * @throws LibusbException
	 */
	public int getEndpointAddress() throws LibusbException{
		return Libusb.getEndpointAddress(device.getNativeDevice(), configIndex, ifaceIndex, altSetting, endpointIndex);
	}
	
	/**
	 * get endpoint direction
	 * @return true if Endpoint-In (device-to-host), false if Endpoint-Out (host-to-device)
	 * @throws LibusbException
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
	
	/**
	 * get type of transfer
	 * @return TransferType
	 * @throws LibusbException
	 */
	public TransferType getTransferType() throws LibusbException{
		return TransferType.valueOf(Libusb.getTransferType(device.getNativeDevice(), configIndex, ifaceIndex, altSetting, endpointIndex));
	}
}
