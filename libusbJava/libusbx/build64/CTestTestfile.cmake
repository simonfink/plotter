# CMake generated Testfile for 
# Source directory: C:/Users/libusb/libusbdev/libusbx
# Build directory: C:/Users/libusb/libusbdev/libusbx/build64
# 
# This file includes the relevant testing commands required for 
# testing this directory and lists subdirectories to be tested as well.
add_test(UseTestMPC555BDI "C:/Program Files/Java/jdk1.7.0_67/bin/java.exe" "-Djava.library.path=C:/Users/libusb/libusbdev/libusbx/build64/LibusbJava/" "-cp" "C:/Users/libusb/libusbdev/libusbx/build64/java/src/LibusbJava.jar" "ch.ntb.inf.libusb.test.UseTestLibusbJava")
subdirs(java)
subdirs(LibusbJava)
