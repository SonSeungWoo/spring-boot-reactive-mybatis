package me.seungwoo.controller;

import com.github.underscore.lodash.U;
import lombok.RequiredArgsConstructor;
import me.seungwoo.ExResponse;
import me.seungwoo.MessageCode;
import me.seungwoo.domain.Person;
import me.seungwoo.service.PersonService;
import org.json.JSONObject;
import org.json.XML;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * webflux 기존방식
 */
@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;


    @GetMapping("/person/{id}")
    public Mono<Person> getPerson(@PathVariable int id) {
        return Mono.fromCallable(() -> personService.select(id));
    }

    @GetMapping("/persons")
    public Flux<Person> getPersons() {
        return Flux.defer(() -> Flux.fromIterable(personService.selectAll()));
    }

    @PostMapping("/person")
    public Mono<Void> createPerson(@RequestBody Person person) {
        return Mono.fromRunnable(() -> personService.insert(person));
    }

    @PutMapping("/person")
    public void updatePerson(@RequestBody Person person) {
        personService.update(person);
    }

    @DeleteMapping("/person")
    public void deletePerson(@RequestBody Person person) {
        personService.delete(person);
    }

    @GetMapping(value = "/data/json", produces = "application/json;")
    public Mono<ResponseEntity<ExResponse>> getJson() throws ParseException {
        String xmlString = "<XML_SELECT><AirLineCode AirLineCode=\"5J\"></AirLineCode><AirLineCode AirLineCode=\"5J\"></AirLineCode><AirLineCode AirLineCode=\"5J\"></AirLineCode><AirLineName AirLineName=\"Cebu Pacific\"></AirLineName><AirLineName AirLineName=\"Cebu Pacific\"></AirLineName><AirLineName AirLineName=\"Cebu Pacific\"></AirLineName></XML_SELECT>";
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = XML.toJSONObject(xmlString);
        Object json = jsonParser.parse(jsonObject.toString());
        return Mono.just(ResponseEntity.ok(
                new ExResponse
                        .Builder<>(json)
                        .message(MessageCode.SUCCESS)
                        .build()));
    }

    @GetMapping(value = "/data/xml", produces = "application/xml;")
    public Mono<String> getXml() {
        String json = "{\"cityCode\":\"DEFHI\",\"countryCode\":\"DE\",\"stateCode\":null,\"cityFileName\":\"Flonheim_DE\",\"cityNameEn\":\"Flonheim\",\"cityNameKo\":\"Flonheim\",\"cityNameJa\":null,\"cityNameZh\":null,\"cityNameFr\":null,\"cityNameEs\":null,\"cityNameDe\":null}";
        String xml = U.jsonToXml(json);
        return Mono.just(xml);
    }
}
