# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.0

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list

# Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "C:\Program Files (x86)\CMake\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Program Files (x86)\CMake\bin\cmake.exe" -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = C:\Users\libusb\libusbdev\libusbx

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = C:\Users\libusb\libusbdev\libusbx\build64

# Utility rule file for LibusbJava.

# Include the progress variables for this target.
include java/src/CMakeFiles/LibusbJava.dir/progress.make

java/src/CMakeFiles/LibusbJava: java/src/LibusbJava.jar

java/src/LibusbJava.jar: java/src/CMakeFiles/LibusbJava.dir/java_class_filelist
	$(CMAKE_COMMAND) -E cmake_progress_report C:\Users\libusb\libusbdev\libusbx\build64\CMakeFiles $(CMAKE_PROGRESS_1)
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold "Creating Java archive LibusbJava.jar"
	cd /d C:\Users\libusb\libusbdev\libusbx\build64\java\src\CMakeFiles\LibusbJava.dir && "C:\Program Files\Java\jdk1.7.0_67\bin\jar.exe" -cf C:/Users/libusb/libusbdev/libusbx/build64/java/src/LibusbJava.jar @java_class_filelist
	cd /d C:\Users\libusb\libusbdev\libusbx\build64\java\src\CMakeFiles\LibusbJava.dir && "C:\Program Files (x86)\CMake\bin\cmake.exe" -D_JAVA_TARGET_DIR=C:/Users/libusb/libusbdev/libusbx/build64/java/src -D_JAVA_TARGET_OUTPUT_NAME=LibusbJava.jar -D_JAVA_TARGET_OUTPUT_LINK= -P "C:/Program Files (x86)/CMake/share/cmake-3.0/Modules/UseJavaSymlinks.cmake"

java/src/CMakeFiles/LibusbJava.dir/java_class_filelist: java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava
	$(CMAKE_COMMAND) -E cmake_progress_report C:\Users\libusb\libusbdev\libusbx\build64\CMakeFiles $(CMAKE_PROGRESS_2)
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold "Generating CMakeFiles/LibusbJava.dir/java_class_filelist"
	cd /d C:\Users\libusb\libusbdev\libusbx\java\src && "C:\Program Files (x86)\CMake\bin\cmake.exe" -DCMAKE_JAVA_CLASS_OUTPUT_PATH=C:/Users/libusb/libusbdev/libusbx/build64/java/src/CMakeFiles/LibusbJava.dir -DCMAKE_JAR_CLASSES_PREFIX="" -P "C:/Program Files (x86)/CMake/share/cmake-3.0/Modules/UseJavaClassFilelist.cmake"

java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/exceptions/AccessDeniedException.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/exceptions/DeviceListNotValidException.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/exceptions/EntityNotFoundException.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/exceptions/InvalidParameterException.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/exceptions/JavaIllegalDeviceHandleException.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/exceptions/JavaReferencesNotLoadedException.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/exceptions/JavaWrongEnvironmentException.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/exceptions/LibusbException.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/exceptions/LibusbIOException.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/exceptions/NoDeviceException.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/exceptions/NoMemoryException.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/exceptions/NotSupportedException.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/exceptions/OtherException.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/exceptions/OverflowException.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/exceptions/PipeException.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/exceptions/ResourceBusyException.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/exceptions/SysCallInterruptedException.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/exceptions/TimeoutException.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/exceptions/WrongContextException.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/test/UseTestLibusbJava.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/test/LibusbJavaTest.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/test/LibusbJavaListTest.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/test/ByteBufferTest.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/test/AT90USB1287Test.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/ConfigurationDescriptor.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/Context.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/Descriptor.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/DescriptorType.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/Device.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/DeviceDescriptor.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/EndpointDescriptor.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/Interface.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/InterfaceDescriptor.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/Libusb.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/LibusbJava.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/Speed.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/StandardRequest.java
java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava: ../java/src/ch/ntb/inf/libusb/TransferType.java
	$(CMAKE_COMMAND) -E cmake_progress_report C:\Users\libusb\libusbdev\libusbx\build64\CMakeFiles $(CMAKE_PROGRESS_3)
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold "Building Java objects for LibusbJava.jar"
	cd /d C:\Users\libusb\libusbdev\libusbx\java\src && "C:\Program Files\Java\jdk1.7.0_67\bin\javac.exe" -source 1.7 -target 1.7 -classpath ;C:/Users/libusb/libusbdev/libusbx/java/src;C:/Users/libusb/libusbdev/libusbx/build64/java/src -d C:/Users/libusb/libusbdev/libusbx/build64/java/src/CMakeFiles/LibusbJava.dir @C:/Users/libusb/libusbdev/libusbx/build64/java/src/CMakeFiles/LibusbJava.dir/java_sources
	cd /d C:\Users\libusb\libusbdev\libusbx\java\src && "C:\Program Files (x86)\CMake\bin\cmake.exe" -E touch C:/Users/libusb/libusbdev/libusbx/build64/java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava

LibusbJava: java/src/CMakeFiles/LibusbJava
LibusbJava: java/src/LibusbJava.jar
LibusbJava: java/src/CMakeFiles/LibusbJava.dir/java_class_filelist
LibusbJava: java/src/CMakeFiles/LibusbJava.dir/java_compiled_LibusbJava
LibusbJava: java/src/CMakeFiles/LibusbJava.dir/build.make
.PHONY : LibusbJava

# Rule to build all files generated by this target.
java/src/CMakeFiles/LibusbJava.dir/build: LibusbJava
.PHONY : java/src/CMakeFiles/LibusbJava.dir/build

java/src/CMakeFiles/LibusbJava.dir/clean:
	cd /d C:\Users\libusb\libusbdev\libusbx\build64\java\src && $(CMAKE_COMMAND) -P CMakeFiles\LibusbJava.dir\cmake_clean.cmake
.PHONY : java/src/CMakeFiles/LibusbJava.dir/clean

java/src/CMakeFiles/LibusbJava.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" C:\Users\libusb\libusbdev\libusbx C:\Users\libusb\libusbdev\libusbx\java\src C:\Users\libusb\libusbdev\libusbx\build64 C:\Users\libusb\libusbdev\libusbx\build64\java\src C:\Users\libusb\libusbdev\libusbx\build64\java\src\CMakeFiles\LibusbJava.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : java/src/CMakeFiles/LibusbJava.dir/depend
