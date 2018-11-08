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

add_subdirectory(src)

add_subdirectory(test)
