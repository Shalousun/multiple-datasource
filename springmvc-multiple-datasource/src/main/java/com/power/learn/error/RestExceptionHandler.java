package com.power.learn.error;

import com.boco.common.model.CommonResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;

/**
 * @see http://www.baeldung.com/global-error-handler-in-a-spring-rest-api
 */
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResult illegalParamsExceptionHandler(MethodArgumentNotValidException ex) {
        return new CommonResult(400, "request params invalid");
    }

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResult methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
        String error = String.format("The parameter '%s' should be of type '%s'", ex.getName(), ex.getRequiredType().getSimpleName());
        return new CommonResult(400, error);
    }

    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CommonResult noHandlerFoundException(Exception ex) {
        return new CommonResult(404, "Resource Not Found");
    }

    @ExceptionHandler(value ={HttpMediaTypeNotSupportedException.class})
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public CommonResult handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex){
        StringBuilder builder = new StringBuilder();
        builder.append(ex.getContentType());
        builder.append(" media type is not supported. Supported media types are ");
        List<MediaType> typeList = ex.getSupportedMediaTypes();
        for(MediaType type:typeList){
            builder.append(type + ", ");
        }
        return new CommonResult(415, builder.toString());
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResult unknownException(Exception ex) {
        return new CommonResult(500, ex.getMessage());
    }
}
