package me.seungwoo.controller;

import lombok.extern.slf4j.Slf4j;
import me.seungwoo.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import reactor.core.publisher.Mono;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Exception e) {
        log.info("===============handleException============");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Mono<String> handleNumberFormatlict(IllegalArgumentException e) {
        log.info("==============handleNumberFormatlict=============");
        return Mono.just("Exception" + e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Mono<String> handleNotFoundException(IllegalArgumentException e) {
        log.info("==============handleNotFoundException=============");
        return Mono.just("Exception" + e.getMessage());
    }
}
