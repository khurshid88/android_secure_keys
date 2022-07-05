#include <jni.h>
JNIEXPORT jstring JNICALL
Java_com_pdp_securekey_activity_MainActivity_getPublicKey(JNIEnv *env, jobject instance) {
    return (*env)->  NewStringUTF(env, "long_public_key");
}
JNIEXPORT jstring JNICALL
Java_com_pdp_securekey_activity_MainActivity_getPrivateKey(JNIEnv *env, jobject instance) {
    return (*env)->NewStringUTF(env, "long_private_key");
}