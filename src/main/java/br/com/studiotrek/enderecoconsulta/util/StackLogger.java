package br.com.studiotrek.enderecoconsulta.util;

public class StackLogger {
    private StackLogger() {

    }

    public static String getMessage(Exception exception) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Error: %s", exception.getMessage()) + '\n');
        sb.append(String.format("Cause: %s", exception.getCause()) + '\n');

        for (StackTraceElement stack : exception.getStackTrace()) {
            sb.append(String.format("Class: %s", stack.getClassName()) + '\n');
            sb.append(String.format("Method: %s", stack.getMethodName()) + '\n');
            sb.append(String.format("File: %s", stack.getFileName()) + '\n');
            sb.append(String.format("Line Error: %d", stack.getLineNumber()) + '\n');
        }

        return sb.toString();
    }
}
