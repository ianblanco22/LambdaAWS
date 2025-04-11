package co.com.semillero.exception;

import co.com.semillero.util.Util;

// Clase personalizada para manejar excepciones
public class ErrorResponse extends Throwable {
    private String message;
    private String stackTrace;

    public ErrorResponse(Exception e) {
        this.message = e.getMessage();
        this.stackTrace = Util.getStackTraceAsString(e); // Método para convertir el stack trace a String
    }

    // Getters y setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }
}