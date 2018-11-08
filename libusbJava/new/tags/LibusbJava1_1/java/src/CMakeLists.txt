add_subdirectory(ch/ntb/inf/libusb/)

# compile .java files to class file and generate .jar
set(CMAKE_JAVA_COMPILE_FLAGS "-source" "1.7" "-target" "1.7")
add_jar(LibusbJava "${LIBUSBJAVA_SRCS}")
get_target_property(_jarFile LibusbJava JAR_FILE)
get_target_property(_classDir LibusbJava CLASSDIR)

message("JAR-File: ${_jarFile}")

