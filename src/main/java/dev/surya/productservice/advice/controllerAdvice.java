package dev.surya.productservice.advice;

import dev.surya.productservice.dtos.ErrorDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class controllerAdvice {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDto> handleNullPointerException(){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setError("please try again");
        return new ResponseEntity<>(errorDto, HttpStatusCode.valueOf(404));
    }
}
