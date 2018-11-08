cmake_minimum_required (VERSION 2.8)

project (LibusbJavaWrapper)

find_package(Java REQUIRED)
find_package(JNI REQUIRED)
include(UseJava)

enable_testing()

add_subdirectory(java)

# generate Libusb.h stub
set (_LIBUSBJAVA_CPP_LOCATION "${PROJECT_SOURCE_DIR}/LibusbJava")
set (_javaClassDir "${CMAKE_CURRENT_BINARY_DIR}/java/src")
message("JavaClassDirectory: ${_javaClassDir}")

add_subdirectory(LibusbJava)

# tests for LibusbJava
# test for Device List -> in Class Device set testing to true for test!
#add_test(ListTest ${Java_JAVA_EXECUTABLE} "-Djava.library.path=${PROJECT_BINARY_DIR}/LibusbJava/Debug" -cp "${PROJECT_BINARY_DIR}/java/src/LibusbJava.jar" "ch.ntb.inf.libusbJava.test.LibusbJavaListTest")
add_test(UseTestMPC555BDI ${Java_JAVA_EXECUTABLE} "-Djava.library.path=${PROJECT_BINARY_DIR}/LibusbJava/Debug" -cp "${PROJECT_BINARY_DIR}/java/src/LibusbJava.jar" "ch.ntb.inf.libusb.test.UseTestLibusbJava") 
