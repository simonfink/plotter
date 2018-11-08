package ch.ntb.inf.libusb;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import ch.ntb.inf.libusb.ConfigurationDescriptor;
import ch.ntb.inf.libusb.Context;
import ch.ntb.inf.libusb.Device;
import ch.ntb.inf.libusb.DeviceDescriptor;
import ch.ntb.inf.libusb.Interface;
import ch.ntb.inf.libusb.InterfaceDescriptor;
import ch.ntb.inf.libusb.Libusb;
import ch.ntb.inf.libusb.Speed;
import ch.ntb.inf.libusb.exceptions.*;
import ch.ntb.inf.libusb.test.LibusbJavaListTest;

public class Device {

	private static final boolean dbg = true;
	private static final boolean testing = false;
	
	private DeviceDescriptor devDesc;
	private static int nofDevices = 0;
	private static List<Device> devList;
	private static boolean deviceListValid = false;
	
	private Context ctx;
	
	private ByteBuffer nativeDevice;
	private ByteBuffer nativeHandle;
	
	//parameters of last open
	private int cfgValue = -2;
	private int ifaceNum = -2; 
	private int altSetting = -2;
	
//	private Device parent;
	static{
		devList = new ArrayList<Device>();
	}
	
	public Device(Context ctx, ByteBuffer nativeDevice) { // TODO protected or not???
		this.ctx = ctx;
		this.nativeDevice = nativeDevice;
		nofDevices++;
	}
	
	public Device(Context ctx){
		this.ctx = ctx;
		nofDevices++;
	}
	
	//TODO this has limitations, if you have more than one device with the same vid, pid you get just the first in the list
	// probably extend, that you see how many devices with this vid, pid are available and choose one then
	public static Device search(Context ctx, int vid, int pid) throws LibusbException{
		getList(ctx);
		for(int i = 0; i < devList.size(); i++){
//			if(dbg){
//				System.out.println("Dev" + i + ":");
//				System.out.println("vid: " + devList.get(i).getDeviceDescriptor().getVendorId());
//			}
			if(vid == devList.get(i).getDeviceDescriptor().getVendorId()){
//				if(dbg){
//					System.out.println("pid: " + devList.get(i).getDeviceDescriptor().getProductId());
//				}
				if(pid == devList.get(i).getDeviceDescriptor().getProductId()){
					return devList.get(i);
				}
			}
		}
		throw new NoDeviceException();
	}
	
	public static Device get(Context ctx, int vid, int pid) {
		// TODO
		// protect this devices
		return null;
	}
	
	private static void getList(Context ctx) throws LibusbException {
		List<ByteBuffer> nativeList;
		if(testing){
			nativeList = LibusbJavaListTest.getDeviceList(ctx.getNativePointer());
		}
		else{
			nativeList = Libusb.getDeviceList(ctx.getNativePointer());
		}

//		System.out.println("size: " + nativeList.size());
		if(devList.size() > 0){ 	//refresh
			boolean devInList = false;
			
			//check if device already in the List or if one got cleared out
			for(int i = 0; i < devList.size(); i++){
				devInList = false;
				for(int j = 0; j < nativeList.size() && !devInList; j++){
					if(devList.get(i).getNativeDevice() == nativeList.get(j)){
						//device found
						devInList = true;
						if(i != j){
							//list changed
							devList.add(i+1, devList.get(i));
							devList.remove(i);
							devList.add(i, new Device(ctx, nativeList.get(i)));
						}
					}
				}
				if(!devInList){
					devList.remove(i);		//element at position i is not in native List anymore -> remove
					i--;					//make sure that new element i will be checked
				}
			}
			if(devList.size() < nativeList.size()){
				//add new devices at the end
				for(int i = devList.size(); i < nativeList.size(); i++){
					devList.add(i, new Device(ctx, nativeList.get(i)));
				}
			}
		}
		else{
			for(int i = 0; i < nativeList.size(); i++){
				devList.add(new Device(ctx, nativeList.get(i)));
			}
		}
		deviceListValid = true;
	}
	
	public static void freeList(Context ctx, boolean unrefDev) throws LibusbException {
		if(deviceListValid){
			if(ctx.getNativePointer() == devList.get(0).getContext().getNativePointer()){
				Libusb.freeDeviceList(unrefDev);
				deviceListValid = false;
				if(dbg) System.out.println("Device List freed.");				
			}
			else{
				throw new WrongContextException();
			}
		}
		else{
			throw new DeviceListNotValidException();
		}
	}
		
	//gives bus number where device is attached
	public int getBusNumber(){
		return Libusb.getBusNumber(nativeDevice);
	}
	
	//gives port number where device is attached
	public int getPortNumber(){
		return Libusb.getPortNumber(nativeDevice);
	}
	
	//gives all port numbers from device to root
	public int getPortNumbers(int[] portNumbers) throws LibusbException {
		return Libusb.getPortNumbers(ctx.getNativePointer(), nativeDevice, portNumbers);
	}
	
	public Device getParent() throws LibusbException{
		// only valid as long as device_list is not freed in native code with libusb_free_device_list
		if(!deviceListValid){
			throw new DeviceListNotValidException();
		}
		ByteBuffer nativeParent = Libusb.getParent(nativeDevice);
		if(nativeParent == null){
			return null;			//no parent available
		}
		for(int i = 0; i < devList.size(); i++){
			if(nativeParent == devList.get(i).nativeDevice){
				return devList.get(i);
			}
		}
		return new Device(ctx, nativeParent);
	}
	
	public int getDeviceAddress(){
		return Libusb.getDeviceAddress(nativeDevice);
	}
	
	public Speed getDeviceSpeed(){
		return Speed.valueOf(Libusb.getDeviceSpeed(nativeDevice));
	}
	
//	public void refDevice(){
//		//TODO increment the reference count of a device
//	}
//	
//	public void unrefDevice(){
//		//TODO decrement the reference count of a device, if the decrement operation causes the reference count to reach zero, the device shall be destroyed.
//	}
	
	public void open() throws LibusbException{
		nativeHandle = Libusb.open(nativeDevice);
		//TODO think about freeing: is a bit delicate because, if using Java Objects with dev Pointer in it, could go wrong if using underlaying infos, so don't free it automatically
		if(nativeHandle != null){ 	//error occured during open, so we probably need Device List again
			freeList(ctx, true);	//otherwise: clean up Device List
		}
	}
	
	public static Device open(Context ctx, int vid, int pid) throws LibusbException{
		ByteBuffer handle = Libusb.openVidPid(ctx.getNativePointer(), vid, pid);
		if(handle != null){					// Exception already thrown in JNI if went wrong
			devList.add(new Device(ctx));
			devList.get(devList.size()-1).setNativeHandle(handle);
			deviceListValid = true;
			return devList.get(devList.size()-1);
		}
		return null;
	}
	
	public void open(ConfigurationDescriptor cfgDesc, Interface iface, InterfaceDescriptor altSetting) throws LibusbException{
		throw new NotSupportedException();
		//TODO
	}
	
	public void open(int cfgValue, int ifaceNum, int altSetting) throws LibusbException{
		if(cfgValue < -1 && ifaceNum < -1 && altSetting < -1){	//TODO think about init-values and how to handle exception
			throw new InvalidParameterException();
		}
		//open device
		nativeHandle = Libusb.open(nativeDevice);
		//claim interface
		try{
			Libusb.claimInterface(nativeHandle, ifaceNum);	//Exception already thrown from JNI if something went wrong
			this.cfgValue = cfgValue;
			this.ifaceNum = ifaceNum;
			this.altSetting = altSetting;
		}	
		catch(LibusbException e){
			throw e;
		}
		if(altSetting > 0){		//use non-standard alt-setting
			Libusb.setInterfaceAltSetting(nativeDevice, ifaceNum, altSetting);
		}
		
	}
	
	public void close() throws LibusbException{
//		releaseInterface(ifaceNum);
		Libusb.close(nativeHandle);
		nativeHandle = null; 		//destroy handle in Java too
	}
	
	public boolean isOpen(){
		if(nativeHandle == null){
			return false;
		}
		return true;
	}
	
	public DeviceDescriptor getDeviceDescriptor() throws LibusbException{
		devDesc = new DeviceDescriptor(this);
		return devDesc;
	}
	
	public void reset() throws LibusbException{
		if(nativeHandle == null){
			throw new JavaIllegalDeviceHandleException();
		}
		int retVal = Libusb.resetDevice(nativeHandle);
		if(retVal < 0){				//exception already thrown in JNI
			nativeHandle = null;
		}
	}
	
	public int controlTransfer(){
		//TODO throw LIBUSB_ERROR_TIMEOUT, LIBUSB_ERROR_PIPE, LIBUSB_ERROR_NO_DEVICE, another LIBUSB_ERROR
		return 0;
	}
		
	/**
	 * 
	 * @param endpoint
	 * @param data
	 * @param length
	 * @param timeout
	 * @return	number of transfered bytes
	 * @throws LibusbException
	 */
	public int bulkTransfer(int endpoint, byte[] data, int length, int timeout) throws LibusbException{
		if(length > data.length){
			throw new InvalidParameterException(); 
		}
		int retVal = Libusb.bulkTransfer(nativeHandle, endpoint, data, length, timeout); //exceptions will be thrown in JNI
		return retVal;	//think about if Error Handling sufficient
	}
	
	public int readBulk(int endpoint, byte[] data, int length, int timeout) throws LibusbException{
		return bulkTransfer( (endpoint|0x80), data, length, timeout);
	}
	
	public int readBulk(int endpoint, byte[] data, int length, int timeout, boolean reOpenOnTimeout) throws LibusbException{
		int cnt = 0;
		try{
			cnt = bulkTransfer( (endpoint|0x80), data, length, timeout);
		}
		catch(TimeoutException e){
			if(reOpenOnTimeout){
				reset();
				open(cfgValue, ifaceNum, altSetting);
				return readBulk(endpoint, data, length, timeout, false);
			}
			throw e;
		}
		return cnt;
	}
	
	public int writeBulk(int endpoint, byte[] data, int length, int timeout) throws LibusbException{
		return bulkTransfer( (endpoint&(~0x80)), data, length, timeout);
	}
	
	public int writeBulk(int endpoint, byte[] data, int length, int timeout, boolean reOpenOnTimeout) throws LibusbException{
		int cnt = 0;
		try{
			cnt = bulkTransfer( (endpoint&(~0x80)), data, length, timeout);
		}
		catch(TimeoutException e){
			if(reOpenOnTimeout){
				reset();
				open(cfgValue, ifaceNum, altSetting);
				return writeBulk(endpoint, data, length, timeout, false);
			}
			throw e;
		}
		return cnt;		
	}
	
	public void interruptTransfer(){
		//TODO throw LIBUSB_ERROR_TIMEOUT, LIBUSB_ERROR_PIPE, LIBUSB_ERROR_OVERFLOW, LIBUSB_ERROR_NO_DEVICE, another LIBUSB_ERROR
	}
	
	protected void finalize(){
		Libusb.unrefDevice(nativeDevice);
		nofDevices--;
	}
	
	public static int getNofDevices(){
		return nofDevices;
	}
	
	public Context getContext(){
		return ctx;
	}
	
	public ByteBuffer getNativeDevice(){
		return nativeDevice;
	}
	
	private void setNativeHandle(ByteBuffer nativeHandle){
		this.nativeHandle = nativeHandle;
	}
	
	public void claimInterface(int interfaceNumber) throws LibusbException{
		Libusb.claimInterface(nativeHandle, interfaceNumber);
		this.ifaceNum = interfaceNumber;
	}
	
	public void releaseInterface(int interfaceNumber) throws LibusbException{
		Libusb.relaseInterface(nativeHandle, interfaceNumber);
	}
	
	public String getStringDescriptor(int descriptorIndex, int langId) throws LibusbException{
		return Libusb.getStringDescriptor(nativeHandle, descriptorIndex, langId);
	}

	public String getStringDescriptorAscii(int descriptorIndex) throws LibusbException{
		return Libusb.getStringDescriptorAscii(nativeHandle, descriptorIndex);
	}
}
