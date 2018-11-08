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

/**
 * Test with RS232-USB Converter on AT90USB1287
 */

package ch.ntb.inf.libusb.test;

import java.util.List;

import ch.ntb.inf.libusb.ConfigurationDescriptor;
import ch.ntb.inf.libusb.Context;
import ch.ntb.inf.libusb.Device;
import ch.ntb.inf.libusb.DeviceDescriptor;
import ch.ntb.inf.libusb.EndpointDescriptor;
import ch.ntb.inf.libusb.Interface;
import ch.ntb.inf.libusb.InterfaceDescriptor;
import ch.ntb.inf.libusb.exceptions.LibusbException;

public class AT90USB1287Test {

	private static final int MAX_PORT_DEPTH = 7;
	
	public static void main(String[] args){
		System.out.println("start at90usb1287test");
		Context useCtx = null;
		Device usbDev = null;
		DeviceDescriptor devDesc = null;
		List<ConfigurationDescriptor> configDescriptors;
		ConfigurationDescriptor activeCfgDesc;
		List<Interface> ifaceDev;
		List<InterfaceDescriptor> ifaceDescDev;
		List<EndpointDescriptor> epDescDev;
		System.out.println("UseTests started:");
		try {
			useCtx = new Context();
		} catch (LibusbException e) {
			System.out.println("Init failed:");
			e.printStackTrace();
		}
		System.out.println("search Device:");
		try {
			usbDev = Device.search(useCtx, 0x8235, 0x0100);		// 0xAFFE, 0x6001
			devDesc = usbDev.getDeviceDescriptor();
			System.out.println("Device found with vid 0x" + Integer.toHexString(devDesc.getVendorId()) 
					+ ", pid 0x" + Integer.toHexString(devDesc.getProductId()));
			System.out.println("Bus: " + usbDev.getBusNumber() + " Port: " + usbDev.getPortNumber());
			
		} catch (LibusbException e) {
			System.out.println("Error occured: search");
			e.printStackTrace();
		}
		if(usbDev == null) return;
		System.out.println("finished.");
		int nofPorts = 0;
		int[] portNumbers = new int [MAX_PORT_DEPTH];
		try{
			nofPorts = usbDev.getPortNumbers(portNumbers);
			System.out.print("Port Numbers to root: ");
			for(int i = 0; i < nofPorts; i++){
				System.out.print(portNumbers[i] + " ");
			}
			System.out.println();
			System.out.println("Device Address: 0x" + Integer.toHexString(usbDev.getDeviceAddress()));
			System.out.println("Device Speed: " + usbDev.getDeviceSpeed().toString());
			System.out.println("--Parent Device--");
			Device parentDev = usbDev.getParent();
			if(parentDev != null){
				System.out.println("Parent Device: vid: 0x" + Integer.toHexString(parentDev.getDeviceDescriptor().getVendorId()) 
						+ ", pid: 0x" + Integer.toHexString(parentDev.getDeviceDescriptor().getProductId()));
				System.out.println("Bus: " + parentDev.getBusNumber() + " Port: " + parentDev.getPortNumber());
				System.out.print("Port Numbers to root: ");
				nofPorts = parentDev.getPortNumbers(portNumbers);
				for(int i = 0; i < nofPorts; i++){
					System.out.print(portNumbers[i] + " ");
				}
				System.out.println();
				System.out.println("-----------------");
			}
			else{
				System.out.println("No Parent Device.");
			}			
			
			//ConfigDescriptor

			devDesc = usbDev.getDeviceDescriptor();
			DeviceDescriptor devDescParent = parentDev.getDeviceDescriptor();
			System.out.println("Config Descriptors:\nnofConfigs: " + devDesc.getNofConfigurations());
			
			configDescriptors = devDesc.getConfigDescriptors();
			if(configDescriptors == null){
				System.out.println("configDesc == null");
			}
			for(int i = 0; i < configDescriptors.size(); i++){
				System.out.println("Config " + i + ": configValue: " + configDescriptors.get(i).getConfigValue());
			}
			
			System.out.println("Active Descriptor of devDesc: ");
			activeCfgDesc = devDesc.getActiveConfigDescriptor();
			
			//System.out.println("Active Descriptor of devDescParent:");
			//ConfigurationDescriptor cfgDescParent = devDescParent.getActiveConfigDescriptor();
			
//			System.out.println("--------Interfaces---------");
//			System.out.println("NofInterfaces device: " + activeCfgDesc.getNofInterfaces());
//			System.out.println("NofInterfaces parent: " + cfgDescParent.getNofInterfaces());
			
			ifaceDev = activeCfgDesc.getAllInterfaces();
//			List<Interface> ifaceParent = cfgDescParent.getAllInterfaces();
			//read number of alternate settings
			System.out.println("device:");
			System.out.println("------------");
			for(int i = 0; i < ifaceDev.size(); i++){
				System.out.println("Interface " + i + " nofAltSettings: " + ifaceDev.get(i).getNumberOfAlternateSettings());
				//Interface Number:
				ifaceDescDev = ifaceDev.get(i).getAlternateSettings();
				for(int j = 0; j < ifaceDescDev.size(); j++){
					System.out.println("Interface Number dev:" + ifaceDescDev.get(j).getInterfaceNumber());
					//Alternate Setting (used to select)
					System.out.println("Alternate Setting:" + ifaceDescDev.get(j).getAlternateSetting());
					//Number of endpoints:
					System.out.println("Number of Endpoints: " + ifaceDescDev.get(j).getNumberOfEndpoints());
					epDescDev = ifaceDescDev.get(j).getEndpointDescriptors();
					System.out.println("---Endpoints---");
					for(int k = 0; k < epDescDev.size(); k++){
						//Endpoint address
						System.out.println("Endpoint " + k + ":");
						System.out.println("Address: " + epDescDev.get(k).getEndpointAddress());
						//Endpoint direction
						if(epDescDev.get(k).getEndpointDirection()){
							System.out.println("Direction: Endpoint-IN");
						}
						else{
							System.out.println("Direction: Endpoint-OUT");
						}
						//MaxPacketSize:
						System.out.println("MaxPacketSize: " + epDescDev.get(k).getMaxPacketSize());
						//MaxIsoPacketSize:
						System.out.println("MaxIsoPacketSize: " + epDescDev.get(k).getMaxIsoPacketSize());
						//TransferType:
						System.out.println("TransferType of Endpoint: " + epDescDev.get(k).getTransferType().toString());
					}
				}
			}
			//read number of alternate settings for parent
			System.out.println("parent:");
			System.out.println("------------");
			/*for(int i = 0; i < ifaceParent.size(); i++){
				System.out.println("Interface " + i + " nofAltSettings: " + ifaceParent.get(i).getNumberOfAlternateSettings());
				//Interface Number:
				List<InterfaceDescriptor> ifaceDescParent = ifaceParent.get(i).getAlternateSettings();
				for(int j = 0; j < ifaceDescParent.size(); j++){
					System.out.println("Interface Number parentDev:" + ifaceDescParent.get(j).getInterfaceNumber());
					//Alternate Setting (used to select)
					System.out.println("Alternate Setting:" + ifaceDescParent.get(j).getAlternateSetting());
					//Number of endpoints:
					System.out.println("Number of Endpoints: " + ifaceDescParent.get(j).getNumberOfEndpoints());
					List<EndpointDescriptor> epDescParent = ifaceDescParent.get(j).getEndpointDescriptors();
					System.out.println("---Endpoints---");
					for(int k = 0; k < epDescParent.size(); k++){
						//Endpoint address
						System.out.println("Endpoint " + k + ":");
						System.out.println("Address: " + epDescParent.get(k).getEndpointAddress());
						//Endpoint direction
						if(epDescParent.get(k).getEndpointDirection()){
							System.out.println("Direction: Endpoint-IN");
						}
						else{
							System.out.println("Direction: Endpoint-OUT");
						}
						//MaxPacketSize:
						System.out.println("MaxPacketSize: " + epDescParent.get(k).getMaxPacketSize());
						//MaxIsoPacketSize:
						System.out.println("MaxIsoPacketSize: " + epDescParent.get(k).getMaxIsoPacketSize());
						//TransferType:
						System.out.println("TransferType of Endpoint: " + epDescParent.get(k).getTransferType().toString());
					}
				}
			}*/
		}
		catch(LibusbException e){
			System.out.println("Error occured: get device properties");
			e.printStackTrace();
		}
		try {
			usbDev.open(1, 0, 0);			//1,0,-1
			System.out.println("Device open");
			byte[] data = {(byte)0x41, (byte)0x42, (byte)0x43, (byte)0x30};
			System.out.println("Data length 1: " + data.length);
			int res = usbDev.bulkTransfer(2, data, data.length, 0);
			if(res == data.length){
				System.out.println("Bulk tranfer 1 successful.");
			}
			else{
				System.out.println("Bulk transfer 1 failed.");
			}
			usbDev.reset();
			res = 0;
			data[0] = (byte)0x65;
			data[1] = (byte)0x66;
			data[2] = (byte)0x67;
			data[3] = (byte)0x68;
			System.out.println("Data length 2: " + data.length);
			res = usbDev.bulkTransfer(2, data, data.length, 0);
			if(res == data.length){
				System.out.println("Bulk tranfer 2 successful.");
			}
			else{
				System.out.println("Bulk transfer 2 failed.");
			}
			System.out.println("Enter some chars: ");
			res = 0;
			byte[] readData = new byte[25];
			int sum = 0;
			while(sum <= 10){
				res = usbDev.readBulk(1, readData, readData.length, 0);
				sum += res;
				if(res != 0){
					for(int i = 0; i < res; i++){
						System.out.print((char)readData[i]);
					}
				}
			}
			System.out.println();

			// string descriptor
			int serialNumIdx = devDesc.getSerialNumberIndex();
			System.out.println("Serial number index: " + serialNumIdx);
			System.out.println("String descriptor serial number: " + usbDev.getStringDescriptorAscii(serialNumIdx));
			int prodIdx = devDesc.getProductDescIndex();
			int manufacturerIdx = devDesc.getManufacturerDescIndex();
			System.out.println("Product descriptor: " + usbDev.getStringDescriptorAscii(prodIdx));
			System.out.println("Manufacturer descriptor: " + usbDev.getStringDescriptorAscii(manufacturerIdx));
//			System.out.println("String descriptor: " + usbDev.getStringDescriptor(serialNumIdx, 0x0409));
			usbDev.releaseInterface(0);
			usbDev.close();
			System.out.println("Device closed.");
		} catch (LibusbException e) {
			System.out.println("Error occured: transfer");
			e.printStackTrace();
		}
				
		try{
			Device usbDevice = Device.open(useCtx, 0xAFFE, 0x6001);		//0xAFFE, 0x6001
			System.out.println("Device open with vid, pid successful.");
			usbDevice.claimInterface(0);
			byte[] dataOut = {(byte)0x30, (byte)0x31, (byte)0x32, (byte)0x33};
			System.out.println("Data length 3: " + dataOut.length);
			int res = usbDevice.bulkTransfer(2, dataOut, dataOut.length, 0);
			if(res == dataOut.length){
				System.out.println("Bulk tranfer 3 successful.");
			}
			else{
				System.out.println("Bulk transfer 3 failed.");
			}
			usbDevice.releaseInterface(0);
			usbDevice.close();
			System.out.println("Device closed.");
			
		}
		catch(LibusbException e){
			System.out.println("Error occured at vid, pid block.");
			e.printStackTrace();
		}
		
	}

}
