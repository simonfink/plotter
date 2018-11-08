package ch.ntb.inf.libusb;

import java.util.HashMap;
import java.util.Map;

import ch.ntb.inf.libusb.Speed;

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
