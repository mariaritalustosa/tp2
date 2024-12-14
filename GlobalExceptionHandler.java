import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collector;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>>handlerValidationExceptions(MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult().getFieldErrors()
        .stream()
        .map(error -> "Campo: " + error.getField()+ error.getDefaultMessage())
        .collect(Collector.toList());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
