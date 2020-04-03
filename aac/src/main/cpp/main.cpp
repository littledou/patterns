//
// Created by loki on 2020/4/1.
//



#include <jni.h>

long mtrr(){
    return 2;
}

extern "C" JNIEXPORT long JNICALL Java_cn_readsense_serial_SerialPort_close
        (JNIEnv *env, jstring key) {

    return mtrr();
}