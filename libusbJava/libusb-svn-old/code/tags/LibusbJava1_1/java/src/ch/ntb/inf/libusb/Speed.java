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

import ch.ntb.inf.libusb.Speed;

/**
 * enum for USB speed reported by libusb
 *
 */
public enum Speed {
	UNKNOWN(0),		// The OS doesn't report or know the device speed. 
	LOW(1),			// The device is operating at low speed (1.5MBit/s).
	FULL(2),		// The device is operating at full speed (12MBit/s).
	HIGH(3),		// The device is operating at high speed (480MBit/s).
	SUPER(4);		// The device is operating at super speed (5000MBit/s).
	
	private int code;
	
	private static Map<Integer, Speed> map = new HashMap<Integer, Speed>();
	
	static{
		for(Speed speedEnum: Speed.values()){
			map.put(speedEnum.code, speedEnum);
		}
	}
	
	private Speed(final int code){
		this.code = code;
	}
	
	public static Speed valueOf(int code){
		return map.get(code);
	}
}
