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

import ch.ntb.inf.libusb.TransferType;

/**
 * enum for TransferType reported by USB
 * @author libusb
 *
 */
public enum TransferType {

	CONTROL(0),				// Control endpoint
	ISOCHRONOUS(1),			// Isochronous endpoint
	BULK(2),				// Bulk endpoint
	INTERRUPT(3),			// Interrupt endpoint
	STREAM(4);				// Stream endpoint (USB 3.0)
	
	private int code;
	
	private static Map<Integer, TransferType> map = new HashMap<Integer, TransferType>();
	
	static{
		for(TransferType transferTypeEnum: TransferType.values()){
			map.put(transferTypeEnum.code, transferTypeEnum);
		}
	}
	
	private TransferType(final int code){
		this.code = code;
	}
	
	public static TransferType valueOf(int code){
		return map.get(code);
	}
}
