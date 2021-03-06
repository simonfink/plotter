/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class ch_ntb_inf_libusbJava_LibusbJava1 */

#ifndef _Included_ch_ntb_inf_libusbJava_LibusbJava1
#define _Included_ch_ntb_inf_libusbJava_LibusbJava1
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_set_debug
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1set_1debug
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_init
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1init
  (JNIEnv *, jclass);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_exit
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1exit
  (JNIEnv *, jclass, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_get_device_list
 * Signature: (J)Lch/ntb/inf/libusbJava/Usb_Device;
 */
JNIEXPORT jobject JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1get_1device_1list
  (JNIEnv *, jclass, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_get_bus_number
 * Signature: (Lch/ntb/inf/libusbJava/Usb_Device;)S
 */
JNIEXPORT jshort JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1get_1bus_1number
  (JNIEnv *, jclass, jobject);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_get_max_iso_packet_size
 * Signature: (Lch/ntb/inf/libusbJava/Usb_Device;S)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1get_1max_1iso_1packet_1size
  (JNIEnv *, jclass, jobject, jshort);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_ref_device
 * Signature: (Lch/ntb/inf/libusbJava/Usb_Device;)Lch/ntb/inf/libusbJava/Usb_Device;
 */
JNIEXPORT jobject JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1ref_1device
  (JNIEnv *, jclass, jobject);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_unref_device
 * Signature: (Lch/ntb/inf/libusbJava/Usb_Device;)V
 */
JNIEXPORT void JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1unref_1device
  (JNIEnv *, jclass, jobject);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_open
 * Signature: (Lch/ntb/inf/libusbJava/Usb_Device;)J
 */
JNIEXPORT jlong JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1open
  (JNIEnv *, jclass, jobject);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_open_device_with_vid_pid
 * Signature: (JII)J
 */
JNIEXPORT jlong JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1open_1device_1with_1vid_1pid
  (JNIEnv *, jclass, jlong, jint, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_close
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1close
  (JNIEnv *, jclass, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_get_device
 * Signature: (J)Lch/ntb/inf/libusbJava/Usb_Device;
 */
JNIEXPORT jobject JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1get_1device
  (JNIEnv *, jclass, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_get_configuration
 * Signature: (J)B
 */
JNIEXPORT jbyte JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1get_1configuration
  (JNIEnv *, jclass, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_set_configuration
 * Signature: (JI)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1set_1configuration
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_claim_interface
 * Signature: (JI)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1claim_1interface
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_release_interface
 * Signature: (JI)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1release_1interface
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_set_interface_alt_setting
 * Signature: (JII)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1set_1interface_1alt_1setting
  (JNIEnv *, jclass, jlong, jint, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_clear_halt
 * Signature: (JS)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1clear_1halt
  (JNIEnv *, jclass, jlong, jshort);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_reset_device
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1reset_1device
  (JNIEnv *, jclass, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_kernel_driver_active
 * Signature: (JI)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1kernel_1driver_1active
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_detach_kernel_driver
 * Signature: (JI)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1detach_1kernel_1driver
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_attach_kernel_driver
 * Signature: (JI)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1attach_1kernel_1driver
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_get_active_config_descriptor
 * Signature: (Lch/ntb/inf/libusbJava/Usb_Device;)Lch/ntb/inf/libusbJava/Usb_Config_Descriptor;
 */
JNIEXPORT jobject JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1get_1active_1config_1descriptor
  (JNIEnv *, jclass, jobject);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_get_string_descriptor_ascii
 * Signature: (JSI)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1get_1string_1descriptor_1ascii
  (JNIEnv *, jclass, jlong, jshort, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_get_descriptor
 * Signature: (JISI)[B
 */
JNIEXPORT jbyteArray JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1get_1descriptor
  (JNIEnv *, jclass, jlong, jint, jshort, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_get_string_descriptor
 * Signature: (JSII)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1get_1string_1descriptor
  (JNIEnv *, jclass, jlong, jshort, jint, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_alloc_transfer
 * Signature: (I)J
 */
JNIEXPORT jlong JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1alloc_1transfer
  (JNIEnv *, jclass, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_free_transfer
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1free_1transfer
  (JNIEnv *, jclass, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_submit_transfer
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1submit_1transfer
  (JNIEnv *, jclass, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_cancel_transfer
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1cancel_1transfer
  (JNIEnv *, jclass, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_control_transfer_get_data
 * Signature: (J)[B
 */
JNIEXPORT jbyteArray JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1control_1transfer_1get_1data
  (JNIEnv *, jclass, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_control_transfer_get_setup
 * Signature: (J)[B
 */
JNIEXPORT jbyteArray JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1control_1transfer_1get_1setup
  (JNIEnv *, jclass, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_fill_control_setup
 * Signature: (IIIII)[B
 */
JNIEXPORT jbyteArray JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1fill_1control_1setup
  (JNIEnv *, jclass, jint, jint, jint, jint, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_fill_control_transfer
 * Signature: (JJ[BI)V
 */
JNIEXPORT void JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1fill_1control_1transfer
  (JNIEnv *, jclass, jlong, jlong, jbyteArray, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_fill_bulk_transfer
 * Signature: (JJB[BII)V
 */
JNIEXPORT void JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1fill_1bulk_1transfer
  (JNIEnv *, jclass, jlong, jlong, jbyte, jbyteArray, jint, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_fill_interrupt_transfer
 * Signature: (JJB[BII)V
 */
JNIEXPORT void JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1fill_1interrupt_1transfer
  (JNIEnv *, jclass, jlong, jlong, jbyte, jbyteArray, jint, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_fill_iso_transfer
 * Signature: (JJB[BIII)V
 */
JNIEXPORT void JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1fill_1iso_1transfer
  (JNIEnv *, jclass, jlong, jlong, jbyte, jbyteArray, jint, jint, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_set_iso_packet_lengths
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1set_1iso_1packet_1lengths
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_get_iso_packet_buffer
 * Signature: (JI)[B
 */
JNIEXPORT jbyteArray JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1get_1iso_1packet_1buffer
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_get_iso_packet_buffer_simple
 * Signature: (JI)[B
 */
JNIEXPORT jbyteArray JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1get_1iso_1packet_1buffer_1simple
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_try_lock_events
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1try_1lock_1events
  (JNIEnv *, jclass, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_lock_events
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1lock_1events
  (JNIEnv *, jclass, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_unlock_events
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1unlock_1events
  (JNIEnv *, jclass, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_event_handling_ok
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1event_1handling_1ok
  (JNIEnv *, jclass, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_event_handler_active
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1event_1handler_1active
  (JNIEnv *, jclass, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_lock_event_waiters
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1lock_1event_1waiters
  (JNIEnv *, jclass, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_unlock_event_waiters
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1unlock_1event_1waiters
  (JNIEnv *, jclass, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_wait_for_event
 * Signature: (JJ)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1wait_1for_1event
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_handle_events_timeout
 * Signature: (JJ)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1handle_1events_1timeout
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_handle_events
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1handle_1events
  (JNIEnv *, jclass, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_handle_events_locked
 * Signature: (JJ)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1handle_1events_1locked
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_pollfds_handle_timeouts
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1pollfds_1handle_1timeouts
  (JNIEnv *, jclass, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_get_next_timeout
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1get_1next_1timeout
  (JNIEnv *, jclass, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_set_pollfd_notifiers
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1set_1pollfd_1notifiers
  (JNIEnv *, jclass, jlong, jboolean);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_get_pollfds
 * Signature: (J)[Lch/ntb/inf/libusbJava/Libusb_pollfd;
 */
JNIEXPORT jobjectArray JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1get_1pollfds
  (JNIEnv *, jclass, jlong);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_control_transfer
 * Signature: (JIIII[BII)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1control_1transfer
  (JNIEnv *, jclass, jlong, jint, jint, jint, jint, jbyteArray, jint, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_bulk_transfer
 * Signature: (JB[BII)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1bulk_1transfer
  (JNIEnv *, jclass, jlong, jbyte, jbyteArray, jint, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_interrupt_transfer
 * Signature: (JB[BII)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1interrupt_1transfer
  (JNIEnv *, jclass, jlong, jbyte, jbyteArray, jint, jint);

/*
 * Class:     ch_ntb_inf_libusbJava_LibusbJava1
 * Method:    libusb_strerror
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_ch_ntb_inf_libusbJava_LibusbJava1_libusb_1strerror
  (JNIEnv *, jclass);

#ifdef __cplusplus
}
#endif
#endif
