package com.progress_bar;

public class Main {
    static String unzip = "C:/Users/Vlad/Desktop/test/testUnzip.zip";
    static String copy = "C:/Users/Vlad/Desktop/test/testCopy.zip";
    static String targetZip = "C:/Users/Vlad/Desktop/test/target.zip";
    static String targetFolder = "C:/Users/Vlad/Desktop/test";

    public static void main(String[] args)
    {
        AbstractOperation abstractOperation = OperationFactory.choose(OperationSelector.COPY);
        assert abstractOperation != null;
        abstractOperation.operation(copy, targetFolder);
    }
}
