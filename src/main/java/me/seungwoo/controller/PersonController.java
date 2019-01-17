package me.seungwoo.controller;

import com.github.underscore.lodash.U;
import lombok.RequiredArgsConstructor;
import me.seungwoo.domain.Person;
import me.seungwoo.service.PersonService;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

import java.util.concurrent.Callable;

/**
 * webflux 기존방식
 */
@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;


    @GetMapping("/person/{id}")
    public Mono<Person> getPerson(@PathVariable int id) {
        return Mono.just(personService.select(id));
    }

    @GetMapping("/persons")
    public Flux<Person> getPersons() {
        return Flux.defer(() -> Flux.fromIterable(personService.selectAll()));
    }

    @PostMapping("/person")
    public Mono<ResponseEntity<Person>> createPerson(@RequestBody Person person) {
        return personService.saveTest(person)
                .map(m -> new ResponseEntity<>(m, HttpStatus.OK));

    }

    /*@PutMapping("/person")
    public Mono<Person> updatePerson(@RequestBody Person person) {
        return personService.update(person);
    }

    @DeleteMapping("/person")
    public Mono<Boolean> deletePerson(@RequestBody Person person) {
        return personService.delete(person);
    }*/

    @GetMapping(value = "/data/json", produces = "application/json;")
    public Mono<String> getJson() {
        String xmlString = "<XML_SELECT><AirLineCode AirLineCode=\"5J\"></AirLineCode><AirLineCode AirLineCode=\"5J\"></AirLineCode><AirLineCode AirLineCode=\"5J\"></AirLineCode><AirLineName AirLineName=\"Cebu Pacific\"></AirLineName><AirLineName AirLineName=\"Cebu Pacific\"></AirLineName><AirLineName AirLineName=\"Cebu Pacific\"></AirLineName></XML_SELECT>";
        JSONObject jsonObject = XML.toJSONObject(xmlString);
        return Mono.just(jsonObject.toString());
    }

    @GetMapping(value = "/data/xml", produces = "application/xml;")
    public Mono<String> getXml() {
        String json = "{\"cityCode\":\"DEFHI\",\"countryCode\":\"DE\",\"stateCode\":null,\"cityFileName\":\"Flonheim_DE\",\"cityNameEn\":\"Flonheim\",\"cityNameKo\":\"Flonheim\",\"cityNameJa\":null,\"cityNameZh\":null,\"cityNameFr\":null,\"cityNameEs\":null,\"cityNameDe\":null}";
        String xml = U.jsonToXml(json);
        return Mono.just(xml);
    }

}
