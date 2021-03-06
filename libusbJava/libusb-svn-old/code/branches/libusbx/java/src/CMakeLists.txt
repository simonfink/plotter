macro (add_libusbjava_sources)
    file (RELATIVE_PATH _relPath "${CMAKE_SOURCE_DIR}/java/src" "${CMAKE_CURRENT_SOURCE_DIR}")
    foreach (_src ${ARGN})
        if (_relPath)
            list (APPEND LIBUSBJAVA_SRCS "${_relPath}/${_src}")
        else()
            list (APPEND LIBUSBJAVA_SRCS "${_src}")
        endif()
    endforeach()
    if (_relPath)
        # propagate LIBUSBJAVA_SRCS to parent directory
        set (LIBUSBJAVA_SRCS ${LIBUSBJAVA_SRCS} PARENT_SCOPE)
    endif()
endmacro()

add_subdirectory(ch/ntb/inf/libusb/)

# compile .java files to class file and generate .jar
set(CMAKE_JAVA_COMPILE_FLAGS "-source" "1.7" "-target" "1.7")
add_jar(LibusbJava "${LIBUSBJAVA_SRCS}")
get_target_property(_jarFile LibusbJava JAR_FILE)
get_target_property(_classDir LibusbJava CLASSDIR)

message("JAR-File: ${_jarFile}")

