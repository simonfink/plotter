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

# Utility rule file for LibusbJavaTest.

# Include the progress variables for this target.
include java/test/CMakeFiles/LibusbJavaTest.dir/progress.make

java/test/CMakeFiles/LibusbJavaTest: java/test/LibusbJavaTest.jar

java/test/LibusbJavaTest.jar: java/test/CMakeFiles/LibusbJavaTest.dir/java_class_filelist
	$(CMAKE_COMMAND) -E cmake_progress_report C:\Users\libusb\libusbdev\libusbx\build64\CMakeFiles $(CMAKE_PROGRESS_1)
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold "Creating Java archive LibusbJavaTest.jar"
	cd /d C:\Users\libusb\libusbdev\libusbx\build64\java\test\CMakeFiles\LibusbJavaTest.dir && "C:\Program Files\Java\jdk1.7.0_67\bin\jar.exe" -cf C:/Users/libusb/libusbdev/libusbx/build64/java/test/LibusbJavaTest.jar @java_class_filelist
	cd /d C:\Users\libusb\libusbdev\libusbx\build64\java\test\CMakeFiles\LibusbJavaTest.dir && "C:\Program Files (x86)\CMake\bin\cmake.exe" -D_JAVA_TARGET_DIR=C:/Users/libusb/libusbdev/libusbx/build64/java/test -D_JAVA_TARGET_OUTPUT_NAME=LibusbJavaTest.jar -D_JAVA_TARGET_OUTPUT_LINK= -P "C:/Program Files (x86)/CMake/share/cmake-3.0/Modules/UseJavaSymlinks.cmake"

LibusbJavaTest: java/test/CMakeFiles/LibusbJavaTest
LibusbJavaTest: java/test/LibusbJavaTest.jar
LibusbJavaTest: java/test/CMakeFiles/LibusbJavaTest.dir/build.make
.PHONY : LibusbJavaTest

# Rule to build all files generated by this target.
java/test/CMakeFiles/LibusbJavaTest.dir/build: LibusbJavaTest
.PHONY : java/test/CMakeFiles/LibusbJavaTest.dir/build

java/test/CMakeFiles/LibusbJavaTest.dir/clean:
	cd /d C:\Users\libusb\libusbdev\libusbx\build64\java\test && $(CMAKE_COMMAND) -P CMakeFiles\LibusbJavaTest.dir\cmake_clean.cmake
.PHONY : java/test/CMakeFiles/LibusbJavaTest.dir/clean

java/test/CMakeFiles/LibusbJavaTest.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" C:\Users\libusb\libusbdev\libusbx C:\Users\libusb\libusbdev\libusbx\java\test C:\Users\libusb\libusbdev\libusbx\build64 C:\Users\libusb\libusbdev\libusbx\build64\java\test C:\Users\libusb\libusbdev\libusbx\build64\java\test\CMakeFiles\LibusbJavaTest.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : java/test/CMakeFiles/LibusbJavaTest.dir/depend

