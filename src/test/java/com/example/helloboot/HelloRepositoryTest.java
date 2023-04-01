package com.example.helloboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.*;

@HelloBootTest
public class HelloRepositoryTest {
    @Autowired
    HellopRepository hellopRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

    @Test
    void findHelloFailed() {
        assertThat(hellopRepository.findHello("Park")).isNull();
    }

    @Test
    void increaseCount() {
        assertThat(hellopRepository.countOf("Park")).isEqualTo(0);

        hellopRepository.increaseCount("Park");
        assertThat(hellopRepository.countOf("Park")).isEqualTo(1);

        hellopRepository.increaseCount("Park");
        assertThat(hellopRepository.countOf("Park")).isEqualTo(2);
    }


}
