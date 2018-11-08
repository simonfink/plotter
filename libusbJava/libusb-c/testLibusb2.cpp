#include <iostream>
#include <libusb-1.0/libusb.h>

using namespace std;

void isoCallback(libusb_transfer* transfer);

int main() {
	libusb_device **devs; //pointer to pointer of device, used to retrieve a list of devices
	libusb_device_handle *dev_handle; //a device handle
	libusb_context *ctx = NULL; //a libusb session
	int r; //for return values
	ssize_t cnt; //holding number of devices in list
	r = libusb_init(&ctx); //initialize the library for the session we just declared
	if(r < 0) {
		cout<<"Init Error "<<r<<endl; //there was an error
		return 1;
	}
	libusb_set_debug(ctx, 3); //set verbosity level to 3, as suggested in the documentation

	cnt = libusb_get_device_list(ctx, &devs); //get the list of devices
	if(cnt < 0) {
		cout<<"Get Device Error"<<endl; //there was an error
		return 1;
	}
	cout<<cnt<<" Devices in list."<<endl;

	dev_handle = libusb_open_device_with_vid_pid(ctx, 0x03eb, 0x2ffb); //these are vendorID and productID I found for my usb device
	if(dev_handle == NULL)
		cout<<"Cannot open device"<<endl;
	else
		cout<<"Device Opened"<<endl;
	libusb_free_device_list(devs, 1); //free the list, unref the devices in it

	unsigned char *data = new unsigned char[4]; //data to write
	data[0]='a';data[1]='b';data[2]='c';data[3]='d'; //some dummy values

	int actual; //used to find out how many bytes were written
	if(libusb_kernel_driver_active(dev_handle, 0) == 1) { //find out if kernel driver is attached
		cout<<"Kernel Driver Active"<<endl;
		if(libusb_detach_kernel_driver(dev_handle, 0) == 0) //detach it
			cout<<"Kernel Driver Detached!"<<endl;
	}
	r = libusb_claim_interface(dev_handle, 0); //claim interface 0 (the first) of device (mine had jsut 1)
	if(r < 0) {
		cout<<"Cannot Claim Interface"<<endl;
		return 1;
	}
	cout<<"Claimed Interface"<<endl;

	cout<<"Data->"<<data<<"<-"<<endl; //just to see the data we want to write : abcd
	cout<<"Writing Data..."<<endl;

	libusb_transfer *transfer = libusb_alloc_transfer(8);


	unsigned char *buffer = 0;
	void* userdata;
	libusb_fill_iso_transfer(transfer, dev_handle, (4|LIBUSB_ENDPOINT_OUT), buffer, 4, 4, isoCallback, userdata , 100);

	//libusb_submit_transfer(transfer);

	for(int i = 0; i < 8; i++){
	//libusb_fill_iso_transfer()
	}

	r = libusb_bulk_transfer(dev_handle, (3 | LIBUSB_ENDPOINT_OUT), data, 4, &actual, 0); //my device's out endpoint was 2, found with trial- the device had 2 endpoints: 2 and 129
	if(r == 0 && actual == 4) //we wrote the 4 bytes successfully
		cout<<"Writing Successful!"<<endl;
	else
		cout<<"Write Error"<<endl;

	r = libusb_release_interface(dev_handle, 0); //release the claimed interface
	if(r!=0) {
		cout<<"Cannot Release Interface"<<endl;
		return 1;
	}
	cout<<"Released Interface"<<endl;

	libusb_close(dev_handle); //close the device we opened
	libusb_exit(ctx); //needs to be called to end the

	delete[] data; //delete the allocated memory for data
	return 0;
}

void LIBUSB_CALL isoCallback(struct libusb_transfer* transfer){
	switch(transfer->status){
	case LIBUSB_TRANSFER_COMPLETED:
		cout << "transfer completed" << endl;
		break;
	case LIBUSB_TRANSFER_ERROR:
		cout << "transfer error" << endl;
		break;
	case LIBUSB_TRANSFER_TIMED_OUT:
		cout << "transfer timed out" << endl;
		break;
	case LIBUSB_TRANSFER_CANCELLED:
		cout << "transfer cancelled" << endl;
		break;
	case LIBUSB_TRANSFER_STALL:
		cout << "transfer stall" << endl;
		break;
	case LIBUSB_TRANSFER_NO_DEVICE:
		cout << "transfer -> no device" << endl;
		break;

	case LIBUSB_TRANSFER_OVERFLOW:
		cout << "transfer overflow" << endl;
		break;
	}
}

