package ch.ntb.inf.libusb;

import java.util.HashMap;
import java.util.Map;

import ch.ntb.inf.libusb.TransferType;

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
