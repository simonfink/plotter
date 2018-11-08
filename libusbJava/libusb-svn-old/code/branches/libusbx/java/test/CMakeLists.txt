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

add_subdirectory(ch/ntb/inf/libusb/ctest)

add_jar(LibusbJavaTestList "{$LIBUSBJAVA_TEST_SRCS}")
