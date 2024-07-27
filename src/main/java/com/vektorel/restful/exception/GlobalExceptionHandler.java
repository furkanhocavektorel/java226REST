package com.vektorel.restful.exception;

import com.vektorel.restful.exception.custom.AdminBulunamadiException;
import com.vektorel.restful.exception.custom.MailException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MailException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> MailExceptionHandler(MailException mailException){


        return new ResponseEntity<>(createMessage(AllException.ADMIN_ZATEN_KAYITLI), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AdminBulunamadiException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> AdminExceptionHandler(AdminBulunamadiException ex){

        return new ResponseEntity<>(
                createMessage(AllException.ADMIN_BULUNAMADI)
                ,HttpStatus.ALREADY_REPORTED);
    }

    public ErrorMessage createMessage(AllException enm){
        return ErrorMessage.builder()
                .message(enm.getErrorMessage())
                .statusCode(enm.getStatusCode())
                .build();
    }

}
