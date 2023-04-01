package com.example.helloboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.*;

@HelloBootTest
public class HelloRepositoryTest {
    @Autowired
    HelloRepository helloRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Test
    void findHelloFailed() {
        assertThat(helloRepository.findHello("Park")).isNull();
    }

    @Test
    void increaseCount() {
        assertThat(helloRepository.countOf("Park")).isEqualTo(0);

        helloRepository.increaseCount("Park");
        assertThat(helloRepository.countOf("Park")).isEqualTo(1);

        helloRepository.increaseCount("Park");
        assertThat(helloRepository.countOf("Park")).isEqualTo(2);
    }


}
