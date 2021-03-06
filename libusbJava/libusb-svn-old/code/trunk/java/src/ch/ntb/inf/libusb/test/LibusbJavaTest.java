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

package ch.ntb.inf.libusb.test;

import java.nio.ByteBuffer;

import ch.ntb.inf.libusb.exceptions.LibusbException;

public class LibusbJavaTest {

	/**
	 * This method does not need to be tested. This test only exists to document
	 * the fact that this function has not been forgotten. 
	 */
	public void testSetDebug(){
		
	}
	
	public void testInit(){
		System.out.println("testInit:");
		//Test for ByteBuffer
//		try{
//			ByteBuffer handle = Libusb.init();
//			System.out.println("got handle: " + handle.toString());
//			Libusb.exit(handle);
//		}
//		catch(LibusbException e){
//			System.out.println("Initialization failed: " + e.toString());
//		}
	}
	
	public static void main(String[] args){
		LibusbJavaTest libtest = new LibusbJavaTest();
		libtest.testInit();
		libtest.testSetDebug();
	}
	
	static{
		System.loadLibrary("LibusbJava");
	}
}
