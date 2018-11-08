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

import java.util.HashMap;
import java.util.Map;

import ch.ntb.inf.libusb.DescriptorType;

public enum DescriptorType{
	DEVICE(0x01),
	CONFIG(0x02),
	STRING(0x03),
	IFACE(0x04),
	ENDPOINT(0x05),
	BOS(0x0f),
	DEVICE_CAPABILITY(0x10),
	HID(0x21),
	REPORT(0x22),
	PHYSICAL(0x23),
	HUB(0x29),
	SUPERSPEED_HUB(0x2a),
	SS_ENDPOINT_COMPANION(0x30);
	
	private int code;
	
	private static Map<Integer, DescriptorType> map = new HashMap<Integer, DescriptorType>();
	
	static{
		for(DescriptorType descriptorTypeEnum: DescriptorType.values()){
			map.put(descriptorTypeEnum.code, descriptorTypeEnum);
		}
	}
	
	private DescriptorType(final int code){
		this.code = code;
	}
	
	public static DescriptorType valueOf(int code){
		return map.get(code);
	}
}
