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

/**
 * Enum for Request Type in USB Setup Packet
 * 
 * @author Andreas Kalberer
 *
 */
public enum RequestType {
	HOST_TO_DEVICE(0 << 7),	
	DEVICE_TO_HOST(1 << 7),
	
	STANDARD(0 << 5),
	CLASS(1 << 5),
	VENDOR(2 << 5),
	
	DEVICE(0),
	INTERFACE(1),
	ENDPOINT(2),
	OTHER(3);

	private int code;

	private static Map<Integer, RequestType> map = new HashMap<Integer, RequestType>();

	static{
		for(RequestType requestTypeEnum: RequestType.values()){
			map.put(requestTypeEnum.code, requestTypeEnum);
		}
	}
	
	private RequestType(final int code){
		this.code = code;
	}

	public static RequestType valueOf(int code){
		return map.get(code);
	}
	
	public int getCode(){
		return code;
	}	
	
	public static byte getBitPattern(RequestType... reqType){
		byte pattern = 0;
		for(int i = 0; i < reqType.length; i++){
			pattern |= reqType[i].getCode();
		}
		return pattern;
	}
}
