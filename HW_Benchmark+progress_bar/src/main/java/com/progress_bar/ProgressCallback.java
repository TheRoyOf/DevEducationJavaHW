package com.progress_bar;

@FunctionalInterface
interface ProgressCallback {

    void callback(CallbackByteChannel rbc, double progress);
}
