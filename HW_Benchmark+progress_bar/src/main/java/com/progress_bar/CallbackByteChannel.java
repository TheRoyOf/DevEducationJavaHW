package com.progress_bar;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

class CallbackByteChannel implements ReadableByteChannel
{
    private ProgressCallback delegate;
    private long size;
    private ReadableByteChannel rbc;
    private long sizeRead;

    CallbackByteChannel(ReadableByteChannel rbc, long expectedSize, ProgressCallback delegate)
    {
        this.delegate = delegate;
        this.size = expectedSize;
        this.rbc = rbc;
    }

    public void close() throws IOException
    {
        rbc.close();
    }

    public long getReadSoFar() {
        return sizeRead;
    }

    public long getSize() {
        return size;
    }

    public boolean isOpen() {
        return rbc.isOpen();
    }

    @Override
    public int read(ByteBuffer bb) throws IOException
    {
        int n;
        double progress;
        if ((n = rbc.read(bb)) > 0)
        {
            sizeRead += n;
            progress = size > 0 ? (double) sizeRead / (double) size * 100.0 : -1.0;
            delegate.callback(this, progress);
        }
        return n;
    }
}
