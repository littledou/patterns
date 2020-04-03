cmake_minimum_required(VERSION 3.4.1)

add_library(
        readface
        SHARED
        src/main/cpp/main.cpp)

find_library(
        log-lib
        log)

target_link_libraries(
        readface
        log
        android)
