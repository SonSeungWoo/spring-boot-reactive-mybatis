package me.seungwoo.controller;

import lombok.extern.slf4j.Slf4j;
import me.seungwoo.ExResponse;
import me.seungwoo.MessageCode;
import me.seungwoo.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Exception e) {
        log.info("===============handleException============");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Mono<ResponseEntity<ExResponse>> handleNumberFormatlict(NumberFormatException e) {
        log.info("==============handleNumberFormatlict=============");
        return Mono.just(ResponseEntity.ok(
                new ExResponse
                        .Builder<>(e.getMessage())
                        .message(MessageCode.ERROR)
                        .build()));
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Mono<ResponseEntity<ExResponse>> handleNotFoundException(NotFoundException e) {
        log.info("==============handleNotFoundException=============");
        return Mono.just(ResponseEntity.ok(
                new ExResponse
                        .Builder<>(e.getMessage())
                        .message(MessageCode.ERROR)
                        .build()));
    }

    @ExceptionHandler(NullPointerException.class)
    public Mono<ResponseEntity<ExResponse>> handleNullPointerException(NullPointerException e) {
        log.info("==============handleNullPointerException=============");
        return Mono.just(ResponseEntity.ok(
                new ExResponse
                        .Builder<>(e.getMessage())
                        .message(MessageCode.ERROR)
                        .build()));
    }
}
