/*
 * Java wrapper for libusb
 * 
 * Copyright 2015 - 2018 NTB University of Applied Sciences in Technology
 * Buchs, Switzerland, http://www.ntb.ch/inf
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package ch.ntb.inf.libusb;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

import ch.ntb.inf.libusb.Libusb;
import ch.ntb.inf.libusb.exceptions.LibusbException;

public class Context {

	public static final boolean dbg = false;
	
	private ByteBuffer context;
	private static int nofContext = 0;
	
	static{
		if (System.getProperty("os.name").equals("Linux")) {
			System.setProperty( "java.library.path", "/usr/lib" );
		} else {
			System.setProperty( "java.library.path", "C:/Windows/System32/" );
		}
		 
		
		Field fieldSysPath;
		try {
			fieldSysPath = ClassLoader.class.getDeclaredField( "sys_paths" );
			fieldSysPath.setAccessible( true );
			fieldSysPath.set( null, null );
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		System.loadLibrary("LibusbJava-1_2");
	}
	
	/**
	 * create a new LibusbJava context, this is the entry point for the use of LibusbJava (initializes libusb)
	 * @throws LibusbException
	 */
	public Context() throws LibusbException {
		context = Libusb.init();
		nofContext++;
	}
	
	ByteBuffer getNativePointer(){
		return context;
	}
	
	/**
	 * exit libusb
	 */
	public void finalize() throws Throwable{
		try{
			nofContext--;
			if(nofContext <= 0){
				Libusb.exit(context);
			}
		}
		finally{
			super.finalize();
		}
	}
}
