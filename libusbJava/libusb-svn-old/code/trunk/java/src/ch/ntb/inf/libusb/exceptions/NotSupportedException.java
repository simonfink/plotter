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

package ch.ntb.inf.libusb.exceptions;

public class NotSupportedException extends LibusbException{

	/**
	 * TODO
	 */
	private static final long serialVersionUID = -3014810607594566275L;

	public NotSupportedException(){
		super();
	}
	
	public NotSupportedException(String message){
		super(message);
	}
	
	public NotSupportedException(String message, Throwable cause){
		super(message, cause);
	}
	
	public NotSupportedException(Throwable cause){
		super(cause);
	}
}
