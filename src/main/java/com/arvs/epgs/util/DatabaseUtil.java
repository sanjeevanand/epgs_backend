package com.arvs.epgs.util;

import java.io.IOException;

import org.springframework.stereotype.Component;
@Component
public final class DatabaseUtil {
	
    public  boolean backup(String dbUsername, String dbPassword, String dbName, String outputFile)
            throws IOException, InterruptedException {
        String command = String.format("C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump -u%s -p%s --add-drop-table --databases %s -r %s",
                dbUsername, dbPassword, dbName, outputFile);
        System.out.println(command);
        Process process = Runtime.getRuntime().exec(command);
        int processComplete = process.waitFor();
        return processComplete == 0;
    }
    
    public  boolean restore(String dbUsername, String dbPassword, String dbName, String sourceFile)
            throws IOException, InterruptedException {
        String[] command = new String[]{
                "C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysql",
                "-u" + dbUsername,
                "-p" + dbPassword,
                "-e",
                " source " + sourceFile,
                dbName
        };
        System.out.println(command.toString());
        Process runtimeProcess = Runtime.getRuntime().exec(command);
        int processComplete = runtimeProcess.waitFor();
        return processComplete == 0;
    }
}