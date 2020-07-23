package com;

import com.enums.EIntention;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileLogger {
    private Bank bank;

    public FileLogger() {}

    public FileLogger(Bank bank) {
        this.bank = bank;
    }

    public String createLog(String destination)
    {
        final String fileType = ".txt";
        StringBuilder strBuilder = new StringBuilder();

        String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        strBuilder.append(System.lineSeparator());
        strBuilder.append("--------------------------------------------------------------------------------\n");
        strBuilder.append("| ").append("Bank log. Create time: ").append(time);
        strBuilder.append("--------------------------------------------------------------------------------\n");

        try {
            Files.write(Paths.get(destination).getParent().resolve("BankLog_" + time + fileType),
                    strBuilder.toString().getBytes(),
                    StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "BankLog_" + time + fileType;
    }

    public void logUpdate(String fileToLog, String destination, EIntention intention, int sum)
    {
        StringBuilder strBuilder = new StringBuilder();

        String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        int sumByType = 0;

        for (Client client : intention == EIntention.DEPOSIT ? bank.getClientsWithDeposits() : bank.getClientsWithLoans()) {
            sumByType += client.getIntent().getSum().get();
        }

        strBuilder.append(System.lineSeparator());
        strBuilder.append("Time:      ");
        strBuilder.append(time);
        strBuilder.append("Type:    ");
        strBuilder.append(intention.toString());
        strBuilder.append("Sum:  ");
        strBuilder.append(sum);
        strBuilder.append("Procent:  ");
        strBuilder.append(intention == EIntention.DEPOSIT ? bank.getDEPOSIT_INTEREST() : bank.getLOAN_INTEREST());
        strBuilder.append("Bank capital:  ");
        strBuilder.append(bank.getBalance());
        strBuilder.append("Sum by type:  ");
        strBuilder.append(sumByType);
        strBuilder.append("\n");
        strBuilder.append("=================");
        strBuilder.append(System.lineSeparator());

        try {
            Files.write(Paths.get(destination).getParent().resolve(fileToLog),
                    strBuilder.toString().getBytes(),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
