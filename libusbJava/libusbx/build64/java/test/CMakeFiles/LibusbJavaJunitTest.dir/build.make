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

# Utility rule file for LibusbJavaJunitTest.

# Include the progress variables for this target.
include java/test/CMakeFiles/LibusbJavaJunitTest.dir/progress.make

java/test/CMakeFiles/LibusbJavaJunitTest: java/test/LibusbJavaJunitTest.jar

java/test/LibusbJavaJunitTest.jar: java/test/CMakeFiles/LibusbJavaJunitTest.dir/java_class_filelist
	$(CMAKE_COMMAND) -E cmake_progress_report C:\Users\libusb\libusbdev\libusbx\build64\CMakeFiles $(CMAKE_PROGRESS_1)
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold "Creating Java archive LibusbJavaJunitTest.jar"
	cd /d C:\Users\libusb\libusbdev\libusbx\build64\java\test\CMakeFiles\LibusbJavaJunitTest.dir && "C:\Program Files\Java\jdk1.7.0_67\bin\jar.exe" -cf C:/Users/libusb/libusbdev/libusbx/build64/java/test/LibusbJavaJunitTest.jar @java_class_filelist
	cd /d C:\Users\libusb\libusbdev\libusbx\build64\java\test\CMakeFiles\LibusbJavaJunitTest.dir && "C:\Program Files (x86)\CMake\bin\cmake.exe" -D_JAVA_TARGET_DIR=C:/Users/libusb/libusbdev/libusbx/build64/java/test -D_JAVA_TARGET_OUTPUT_NAME=LibusbJavaJunitTest.jar -D_JAVA_TARGET_OUTPUT_LINK= -P "C:/Program Files (x86)/CMake/share/cmake-3.0/Modules/UseJavaSymlinks.cmake"

java/test/CMakeFiles/LibusbJavaJunitTest.dir/java_class_filelist: java/test/CMakeFiles/LibusbJavaJunitTest.dir/java_compiled_LibusbJavaJunitTest
	$(CMAKE_COMMAND) -E cmake_progress_report C:\Users\libusb\libusbdev\libusbx\build64\CMakeFiles $(CMAKE_PROGRESS_2)
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold "Generating CMakeFiles/LibusbJavaJunitTest.dir/java_class_filelist"
	cd /d C:\Users\libusb\libusbdev\libusbx\java\test && "C:\Program Files (x86)\CMake\bin\cmake.exe" -DCMAKE_JAVA_CLASS_OUTPUT_PATH=C:/Users/libusb/libusbdev/libusbx/build64/java/test/CMakeFiles/LibusbJavaJunitTest.dir -DCMAKE_JAR_CLASSES_PREFIX="" -P "C:/Program Files (x86)/CMake/share/cmake-3.0/Modules/UseJavaClassFilelist.cmake"

java/test/CMakeFiles/LibusbJavaJunitTest.dir/java_compiled_LibusbJavaJunitTest: ../java/test/ch/ntb/inf/libusb/test/junit/mpc555Bdi/Mpc555BdiDeviceTest.java
java/test/CMakeFiles/LibusbJavaJunitTest.dir/java_compiled_LibusbJavaJunitTest: ../java/test/ch/ntb/inf/libusb/test/junit/mpc555Bdi/DescriptorTest.java
java/test/CMakeFiles/LibusbJavaJunitTest.dir/java_compiled_LibusbJavaJunitTest: ../java/test/ch/ntb/inf/libusb/test/junit/mpc555Bdi/AllMpc555BdiTests.java
	$(CMAKE_COMMAND) -E cmake_progress_report C:\Users\libusb\libusbdev\libusbx\build64\CMakeFiles $(CMAKE_PROGRESS_3)
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold "Building Java objects for LibusbJavaJunitTest.jar"
	cd /d C:\Users\libusb\libusbdev\libusbx\java\test && "C:\Program Files\Java\jdk1.7.0_67\bin\javac.exe" -source 1.7 -target 1.7 -classpath ";C:/Program Files/Java/junit4/junit-4.12.jar;C:/Program Files/Java/junit4/hamcrest-core-1.3.jar;C:/Users/libusb/libusbdev/libusbx/build64/java/src/LibusbJava.jar;C:/Users/libusb/libusbdev/libusbx/java/test;C:/Users/libusb/libusbdev/libusbx/build64/java/test" -d C:/Users/libusb/libusbdev/libusbx/build64/java/test/CMakeFiles/LibusbJavaJunitTest.dir @C:/Users/libusb/libusbdev/libusbx/build64/java/test/CMakeFiles/LibusbJavaJunitTest.dir/java_sources
	cd /d C:\Users\libusb\libusbdev\libusbx\java\test && "C:\Program Files (x86)\CMake\bin\cmake.exe" -E touch C:/Users/libusb/libusbdev/libusbx/build64/java/test/CMakeFiles/LibusbJavaJunitTest.dir/java_compiled_LibusbJavaJunitTest

LibusbJavaJunitTest: java/test/CMakeFiles/LibusbJavaJunitTest
LibusbJavaJunitTest: java/test/LibusbJavaJunitTest.jar
LibusbJavaJunitTest: java/test/CMakeFiles/LibusbJavaJunitTest.dir/java_class_filelist
LibusbJavaJunitTest: java/test/CMakeFiles/LibusbJavaJunitTest.dir/java_compiled_LibusbJavaJunitTest
LibusbJavaJunitTest: java/test/CMakeFiles/LibusbJavaJunitTest.dir/build.make
.PHONY : LibusbJavaJunitTest

# Rule to build all files generated by this target.
java/test/CMakeFiles/LibusbJavaJunitTest.dir/build: LibusbJavaJunitTest
.PHONY : java/test/CMakeFiles/LibusbJavaJunitTest.dir/build

java/test/CMakeFiles/LibusbJavaJunitTest.dir/clean:
	cd /d C:\Users\libusb\libusbdev\libusbx\build64\java\test && $(CMAKE_COMMAND) -P CMakeFiles\LibusbJavaJunitTest.dir\cmake_clean.cmake
.PHONY : java/test/CMakeFiles/LibusbJavaJunitTest.dir/clean

java/test/CMakeFiles/LibusbJavaJunitTest.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" C:\Users\libusb\libusbdev\libusbx C:\Users\libusb\libusbdev\libusbx\java\test C:\Users\libusb\libusbdev\libusbx\build64 C:\Users\libusb\libusbdev\libusbx\build64\java\test C:\Users\libusb\libusbdev\libusbx\build64\java\test\CMakeFiles\LibusbJavaJunitTest.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : java/test/CMakeFiles/LibusbJavaJunitTest.dir/depend

