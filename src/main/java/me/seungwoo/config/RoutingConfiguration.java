package me.seungwoo.config;

import me.seungwoo.handler.PersonHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-01-17
 * Time: 17:14
 */
@Configuration
public class RoutingConfiguration {

    /*@Bean
    public RouterFunction<?> routes(PersonHandler personHandler) {
        return route(GET("/book").and(accept(APPLICATION_JSON)), personHandler::findById)
                .andNest(path("/data"),
                        route(GET("/json").and(accept(APPLICATION_JSON)), personHandler::getJson)
                );
    }*/
}
