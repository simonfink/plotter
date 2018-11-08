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

import ch.ntb.inf.libusb.Context;
import ch.ntb.inf.libusb.Libusb;

public class LibusbJava {
	/**
	 * Set log message verbosity.
	 * The default level is LIBUSB_LOG_LEVEL_NONE, which means no messages are ever printed. If you
	 *  choose to increase the message verbosity level, ensure that your application does not close 
	 *  the stdout/stderr file descriptors.<br>
	 * You are advised to use level LIBUSB_LOG_LEVEL_WARNING. libusb is conservative with its message 
	 * logging and most of the time, will only log messages that explain error conditions and other 
	 * oddities. This will help you debug your software.<br>
	 * If the LIBUSB_DEBUG environment variable was set when libusb was initialized, this function 
	 * does nothing: the message verbosity is fixed to the value in the environment variable.<br>
	 * If libusb was compiled without any message logging, this function does nothing: you'll never
	 * get any messages.<br>
	 * If libusb was compiled with verbose debug message logging, this function does nothing: you'll 
	 * always get messages from all levels.<br>
	 *
	 * @param ctx	
	 * 			the context to operate on, or NULL for the default context
	 * @param level	
	 * 			debug level to set 
	 */
	public static void setDebug(Context ctx, int level){
		//TODO Auswirkungen auf LibusbJava -> wirft Exceptions bei bestimmtem Level, sonst nur Error-Log etc. inkl. Beschreibung Javadoc
		Libusb.setDebug(ctx.getNativePointer(), level);		
	}
	
}
