package me.seungwoo;

import me.seungwoo.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class WebClientTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void personSelectAll() {
        webTestClient.get().uri("/persons")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBodyList(Person.class).hasSize(4).consumeWith(persons -> {
            {
                Person person = persons.getResponseBody().get(0);
                assertThat(person.getId()).isEqualTo(1);
                assertThat(person.getName()).isEqualTo("rei");
                assertThat(person.getAge()).isEqualTo(10);
                assertThat(person.getCountry()).isEqualTo("US");
            }
            {
                Person person = persons.getResponseBody().get(1);
                assertThat(person.getId()).isEqualTo(2);
                assertThat(person.getName()).isEqualTo("東京");
                assertThat(person.getAge()).isEqualTo(20);
                assertThat(person.getCountry()).isEqualTo("JP");
            }
        });
    }

    @Test
    public void personSelect() {
        webTestClient.get().uri("/person/1")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBody(Person.class).consumeWith(per -> {
            {
                Person person = per.getResponseBody();
                assertThat(person.getId()).isEqualTo(1);
                assertThat(person.getName()).isEqualTo("rei");
                assertThat(person.getAge()).isEqualTo(10);
                assertThat(person.getCountry()).isEqualTo("US");
            }
        });
    }
}
