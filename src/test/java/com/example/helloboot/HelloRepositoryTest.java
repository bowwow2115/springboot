package com.example.helloboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
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
