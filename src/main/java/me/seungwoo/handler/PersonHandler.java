package me.seungwoo.handler;

import lombok.RequiredArgsConstructor;
import me.seungwoo.domain.Person;
import me.seungwoo.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


/**
 * webflux 함수형 모델
 */
@Component
@RequiredArgsConstructor
public class PersonHandler {

    private final PersonService personService;

    /*public Mono<ServerResponse> findById(ServerRequest request) {
        return
    }*/
}
