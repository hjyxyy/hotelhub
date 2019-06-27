package com.harrywork.hotelhub.config;

import com.harrywork.hotelhub.dto.BaseResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

/**
 * Usage: <b> Handle any exception from Controllers, rethrow annotated ones to framework </b>
 *
 * @author Harry
 * @date 19-6-26
 * Time: 16:35
 * Desc: ControllerDefaultExceptionHandler
 */
@ApiIgnore
@Slf4j
@ControllerAdvice
public class ControllerDefaultExceptionHandler {

    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BaseResponseDTO requestConvertException(HttpServletRequest req, HttpMessageNotReadableException e) {
        log.error("request convert for url " + req.getRequestURL() + " failed.", e);
        return BaseResponseDTO.FAILED(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public BaseResponseDTO defaultExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        log.error("request url " + req.getRequestURL() + " failed.", e);
        return BaseResponseDTO.FAILED;
    }
}
