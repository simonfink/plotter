macro (add_libusbjava_cpp_sources)
    file (RELATIVE_PATH _relPath "${CMAKE_SOURCE_DIR}/LibusbJava" "${CMAKE_CURRENT_SOURCE_DIR}")
    foreach (_src ${ARGN})
        if (_relPath)
            list (APPEND LIBUSBJAVA_CPP_SRCS "${_relPath}/${_src}")
        else()
            list (APPEND LIBUSBJAVA_CPP_SRCS "${_src}")
        endif()
    endforeach()
    if (_relPath)
        # propagate LIBUSBJAVA_CPP_SRCS to parent directory
        set (LIBUSBJAVA_CPP_SRCS ${LIBUSBJAVA_CPP_SRCS} PARENT_SCOPE)
    endif()
endmacro()

include_directories("${JAVA_INCLUDE_PATH}" "${JAVA_INCLUDE_PATH2}" "${_LIBUSBJAVA_CPP_LOCATION}/libusb/include" "${_LIBUSBJAVA_CPP_LOCATION}")

add_libusbjava_cpp_sources(LibusbJava.cpp)

link_directories("${_LIBUSBJAVA_CPP_LOCATION}")
link_directories("${JNI_LIBRARIES}")
link_directories("${_LIBUSBJAVA_CPP_LOCATION}/libusb/x64/dll/libusb-1.0.lib")

add_custom_command(
    OUTPUT jni_header
    COMMAND ${Java_JAVAH_EXECUTABLE} -verbose
        -classpath "${_javaClassDir}/LibusbJava.jar"
        -d ${_LIBUSBJAVA_CPP_LOCATION}
        -jni "ch.ntb.inf.libusb.Libusb"
    )

add_library(LibusbJava-1_1 MODULE jni_header "${LIBUSBJAVA_CPP_SRCS}")

message("JNI Libraries: ${JNI_LIBRARIES}")
message("LibusbJavaCpp: ${_LIBUSBJAVA_CPP_LOCATION}/libusb/Win32/dll/libusb-1.0.dll")
	
set_target_properties(LibusbJava-1_1 PROPERTIES CXX_STANDARD 11)
set_target_properties(LibusbJava-1_1 PROPERTIES SUFFIX ".dll")
#target_link_libraries(LibusbJava-1_1 "${JNI_LIBRARIES}" "${_LIBUSBJAVA_CPP_LOCATION}/libusb/Win32/dll/libusb-1.0.dll")

target_link_libraries(LibusbJava-1_1 "${JNI_LIBRARIES}" "${_LIBUSBJAVA_CPP_LOCATION}/libusb/x64/dll/libusb-1.0.dll")


