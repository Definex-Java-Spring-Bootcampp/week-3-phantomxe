package com.phantomxe.orderservice.exceptions;
  
import com.phantomxe.orderservice.dto.KafkaLog;
import com.phantomxe.orderservice.exceptions.dto.ExceptionResponse;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
 
    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate; 


    @ExceptionHandler(Exception.class)
    public ResponseEntity<com.phantomxe.orderservice.exceptions.dto.ExceptionResponse> handleAllException(Exception exception) {
        log.error("exception occurred. {0}", exception.getCause()); 

        kafkaTemplate.send("patika.logs", new KafkaLog("exception-order-service", ExceptionUtils.getFullStackTrace(exception) ));
        log.info("Exception sent to Kafka");

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(prepareExceptionResponse(exception, HttpStatus.BAD_REQUEST));
    }

    private ExceptionResponse prepareExceptionResponse(Exception exception, HttpStatus httpStatus) {
        return ExceptionResponse.builder()
                .message(exception.getMessage())
                .httpStatus(httpStatus)
                .build();
    }

}
