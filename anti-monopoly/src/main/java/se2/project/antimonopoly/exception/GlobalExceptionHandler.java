package se2.project.antimonopoly.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {
        // Logge die Ausnahme, sende eine benutzerdefinierte Fehlerantwort usw.
        return new ResponseEntity<>("Ein Fehler ist aufgetreten: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
