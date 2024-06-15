package com.vennygo.study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;


@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberDaoJdbcTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //private MemberDao dao;

    @BeforeEach
    void setUp() {
        //dao = new MemberDao(jdbcTemplate);
    }

    @Test
    void findAll() {
        // ...
    }

    @Test
    @Timeout(3)
    void timeOut_seconds() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void timeOut_milliseconds() throws InterruptedException {
        Thread.sleep(100);
        assertThat(2).isEqualTo(4);
    }

}
