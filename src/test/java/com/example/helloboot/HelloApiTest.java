package com.example.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloApiTest {
    @Test
    void helloApi() {
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String> response =
                restTemplate.getForEntity("http://localhost:9090/app/hello?name={name}", String.class, "Park");

        // status code 200
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        // header(content-type) text/plain
        assertThat(response.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        // body Hello Spring
        assertThat(response.getBody()).isEqualTo("Hello Park");
    }

    @Test
    void failsHelloApi() {
        TestRestTemplate restTemplate = new TestRestTemplate();

        ResponseEntity<String> response =
                restTemplate.getForEntity("http://localhost:9090/app/hello?name=", String.class);

        // status code 500
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
