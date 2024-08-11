package com.vektorel.restful.exception;

import com.vektorel.restful.entity.Admin;
import com.vektorel.restful.exception.custom.AdminBulunamadiException;
import com.vektorel.restful.exception.custom.KullaniciBulunamadiException;
import com.vektorel.restful.exception.custom.MailException;
import com.vektorel.restful.exception.custom.TokenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// fırlatılacak istisnaları yakalayan sınıf
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MailException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> MailExceptionHandler(MailException mailException){

        ErrorMessage err= createErrorMessage(mailException.exc);

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TokenException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> TokenExceptionHandler(TokenException tokenException){

        ErrorMessage err= createErrorMessage(tokenException.exc);

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(AdminBulunamadiException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> AdminExceptionHandler(AdminBulunamadiException ex){

        return new ResponseEntity<>(
                createErrorMessage(ex.exc)
                ,HttpStatus.BAD_REQUEST);
    }

    public ErrorMessage createErrorMessage(AllException e){

        ErrorMessage errorMessage= new ErrorMessage();
        errorMessage.setMessage(e.getErrorMessage());
        errorMessage.setStatusCode(e.getStatusCode());

        return errorMessage;
    }
    // GRUP_1 EXCEPTION
    // en basit yöntem ile
    // KullaniciBulunamadiException burada yakalanıyor
    @ExceptionHandler(KullaniciBulunamadiException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> kullaniciBulunamadiEx(KullaniciBulunamadiException e){

        ErrorMessage errorMessage=new ErrorMessage();
        errorMessage.setStatusCode(1657);
        errorMessage.setMessage(e.getMessage());

        return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
    }



    // HTTPCode özelleştirilmeyecek ise
/*
    @ExceptionHandler(KullaniciBulunamadiException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> kullaniciBulunamadiEx(KullaniciBulunamadiException e){

        ErrorMessage errorMessage=new ErrorMessage();
        errorMessage.setStatusCode(1657);
        errorMessage.setMessage(e.getMessage());

        return ResponseEntity.ok(errorMessage);
    }
*/



    // özelleştirilmiş hata kodu dönülmeyecek ise

/*    @ExceptionHandler(KullaniciBulunamadiException.class)
    @ResponseBody
    public ResponseEntity<String> kullaniciBulunamadiEx(KullaniciBulunamadiException e){

        return ResponseEntity.ok(e.getMessage());
    }*/

    // özelleştirilmiş hata kodu yok
    // HTTP KODU ÖZELLEŞTİRİLMİ

/*    @ExceptionHandler(KullaniciBulunamadiException.class)
    @ResponseBody
    public ResponseEntity<String> kullaniciBulunamadiEx(KullaniciBulunamadiException e){

        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }*/





}
