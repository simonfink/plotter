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

# Utility rule file for LibusbJavaTestList.

# Include the progress variables for this target.
include java/test/CMakeFiles/LibusbJavaTestList.dir/progress.make

java/test/CMakeFiles/LibusbJavaTestList: java/test/LibusbJavaTestList.jar

java/test/LibusbJavaTestList.jar: java/test/CMakeFiles/LibusbJavaTestList.dir/java_class_filelist
	$(CMAKE_COMMAND) -E cmake_progress_report C:\Users\libusb\libusbdev\libusbx\build64\CMakeFiles $(CMAKE_PROGRESS_1)
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold "Creating Java archive LibusbJavaTestList.jar"
	cd /d C:\Users\libusb\libusbdev\libusbx\build64\java\test\CMakeFiles\LibusbJavaTestList.dir && "C:\Program Files\Java\jdk1.7.0_67\bin\jar.exe" -cf C:/Users/libusb/libusbdev/libusbx/build64/java/test/LibusbJavaTestList.jar @java_class_filelist
	cd /d C:\Users\libusb\libusbdev\libusbx\build64\java\test\CMakeFiles\LibusbJavaTestList.dir && "C:\Program Files (x86)\CMake\bin\cmake.exe" -D_JAVA_TARGET_DIR=C:/Users/libusb/libusbdev/libusbx/build64/java/test -D_JAVA_TARGET_OUTPUT_NAME=LibusbJavaTestList.jar -D_JAVA_TARGET_OUTPUT_LINK= -P "C:/Program Files (x86)/CMake/share/cmake-3.0/Modules/UseJavaSymlinks.cmake"

LibusbJavaTestList: java/test/CMakeFiles/LibusbJavaTestList
LibusbJavaTestList: java/test/LibusbJavaTestList.jar
LibusbJavaTestList: java/test/CMakeFiles/LibusbJavaTestList.dir/build.make
.PHONY : LibusbJavaTestList

# Rule to build all files generated by this target.
java/test/CMakeFiles/LibusbJavaTestList.dir/build: LibusbJavaTestList
.PHONY : java/test/CMakeFiles/LibusbJavaTestList.dir/build

java/test/CMakeFiles/LibusbJavaTestList.dir/clean:
	cd /d C:\Users\libusb\libusbdev\libusbx\build64\java\test && $(CMAKE_COMMAND) -P CMakeFiles\LibusbJavaTestList.dir\cmake_clean.cmake
.PHONY : java/test/CMakeFiles/LibusbJavaTestList.dir/clean

java/test/CMakeFiles/LibusbJavaTestList.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" C:\Users\libusb\libusbdev\libusbx C:\Users\libusb\libusbdev\libusbx\java\test C:\Users\libusb\libusbdev\libusbx\build64 C:\Users\libusb\libusbdev\libusbx\build64\java\test C:\Users\libusb\libusbdev\libusbx\build64\java\test\CMakeFiles\LibusbJavaTestList.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : java/test/CMakeFiles/LibusbJavaTestList.dir/depend
