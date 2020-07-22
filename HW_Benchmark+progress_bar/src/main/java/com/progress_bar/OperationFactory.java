package com.progress_bar;

public class OperationFactory {

    public static AbstractOperation choose(OperationSelector selector)
    {

        switch (selector)
        {
            case ZIP:
                return new Zip();
            case UNZIP:
                return new Unzip();
            case COPY:
                return new Copy();
            default:
                return null;
        }
    }
}
