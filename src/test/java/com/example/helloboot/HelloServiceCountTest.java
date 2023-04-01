package com.example.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

@HelloBootTest
public class HelloServiceCountTest {
    @Autowired HelloService helloService;
    @Autowired HelloRepository helloRepository;

    @Test
    void sayHelloIncraseCount() {
        IntStream.rangeClosed(1,10).forEach(count -> {
            helloService.sayHello("Park");
            assertThat(helloRepository.countOf("Park")).isEqualTo(count);
        });
    }

}
