/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class ch_ntb_usb_LibusbJava */

#ifndef _Included_ch_ntb_usb_LibusbJava
#define _Included_ch_ntb_usb_LibusbJava
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_set_debug
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_ch_ntb_usb_LibusbJava_usb_1set_1debug
  (JNIEnv *, jclass, jint);

/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_init
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_ch_ntb_usb_LibusbJava_usb_1init
  (JNIEnv *, jclass);

/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_find_busses
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_usb_LibusbJava_usb_1find_1busses
  (JNIEnv *, jclass);

/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_find_devices
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_usb_LibusbJava_usb_1find_1devices
  (JNIEnv *, jclass);

/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_get_busses
 * Signature: ()Lch/ntb/usb/Usb_Bus;
 */
JNIEXPORT jobject JNICALL Java_ch_ntb_usb_LibusbJava_usb_1get_1busses
  (JNIEnv *, jclass);

/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_open
 * Signature: (Lch/ntb/usb/Usb_Device;)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_usb_LibusbJava_usb_1open
  (JNIEnv *, jclass, jobject);

/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_close
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_usb_LibusbJava_usb_1close
  (JNIEnv *, jclass, jint);

/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_set_configuration
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_usb_LibusbJava_usb_1set_1configuration
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_set_altinterface
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_usb_LibusbJava_usb_1set_1altinterface
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_clear_halt
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_usb_LibusbJava_usb_1clear_1halt
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_reset
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_usb_LibusbJava_usb_1reset
  (JNIEnv *, jclass, jint);

/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_claim_interface
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_usb_LibusbJava_usb_1claim_1interface
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_release_interface
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_usb_LibusbJava_usb_1release_1interface
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_control_msg
 * Signature: (IIIII[BII)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_usb_LibusbJava_usb_1control_1msg
  (JNIEnv *, jclass, jint, jint, jint, jint, jint, jbyteArray, jint, jint);

/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_get_string
 * Signature: (III)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_ch_ntb_usb_LibusbJava_usb_1get_1string
  (JNIEnv *, jclass, jint, jint, jint);

/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_get_string_simple
 * Signature: (II)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_ch_ntb_usb_LibusbJava_usb_1get_1string_1simple
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_get_descriptor
 * Signature: (IBBI)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_ch_ntb_usb_LibusbJava_usb_1get_1descriptor
  (JNIEnv *, jclass, jint, jbyte, jbyte, jint);

/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_get_descriptor_by_endpoint
 * Signature: (IIBBI)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_ch_ntb_usb_LibusbJava_usb_1get_1descriptor_1by_1endpoint
  (JNIEnv *, jclass, jint, jint, jbyte, jbyte, jint);

/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_bulk_write
 * Signature: (II[BII)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_usb_LibusbJava_usb_1bulk_1write
  (JNIEnv *, jclass, jint, jint, jbyteArray, jint, jint);

/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_bulk_read
 * Signature: (II[BII)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_usb_LibusbJava_usb_1bulk_1read
  (JNIEnv *, jclass, jint, jint, jbyteArray, jint, jint);

/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_interrupt_write
 * Signature: (II[BII)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_usb_LibusbJava_usb_1interrupt_1write
  (JNIEnv *, jclass, jint, jint, jbyteArray, jint, jint);

/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_interrupt_read
 * Signature: (II[BII)I
 */
JNIEXPORT jint JNICALL Java_ch_ntb_usb_LibusbJava_usb_1interrupt_1read
  (JNIEnv *, jclass, jint, jint, jbyteArray, jint, jint);

/*
 * Class:     ch_ntb_usb_LibusbJava
 * Method:    usb_strerror
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_ch_ntb_usb_LibusbJava_usb_1strerror
  (JNIEnv *, jclass);

#ifdef __cplusplus
}
#endif
#endif
