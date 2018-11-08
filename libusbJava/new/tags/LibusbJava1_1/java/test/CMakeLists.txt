macro (add_libusbjava_test_sources)
    file (RELATIVE_PATH _relPath "${CMAKE_SOURCE_DIR}/java/test" "${CMAKE_CURRENT_SOURCE_DIR}")
    foreach (_src ${ARGN})
        if (_relPath)
            list (APPEND LIBUSBJAVA_TEST_SRCS "${_relPath}/${_src}")
        else()
            list (APPEND LIBUSBJAVA_TEST_SRCS "${_src}")
        endif()
    endforeach()
    if (_relPath)
        # propagate LIBUSBJAVA_TEST_SRCS to parent directory
        set (LIBUSBJAVA_TEST_SRCS ${LIBUSBJAVA_TEST_SRCS} PARENT_SCOPE)
    endif()
endmacro()

#add_subdirectory(ch/ntb/inf/libusb/ctest)
add_subdirectory(ch/ntb/inf/libusb/test/junit)
add_subdirectory(ch/ntb/inf/libusb/test/junit/mpc555Bdi)

# compile .java files to class file and generate .jar
set(CMAKE_JAVA_COMPILE_FLAGS "-source" "1.7" "-target" "1.7") 
set(CMAKE_JAVA_INCLUDE_PATH "C:/Program Files/Java/junit4/junit-4.12.jar" "C:/Program Files/Java/junit4/hamcrest-core-1.3.jar" "${PROJECT_BINARY_DIR}/java/src/LibusbJava.jar")
add_jar(LibusbJavaJunitTest "${LIBUSBJAVA_TEST_SRCS}")
