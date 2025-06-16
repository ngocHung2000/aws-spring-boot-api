package com.vn.awsspringbootapi;

import com.vn.awsspringbootapi.controllers.HelloWorldController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AwsSpringBootApiApplicationTests {

    @Autowired
    private HelloWorldController helloWorldController;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    void contextLoads() throws Exception {
        assertThat(helloWorldController).isNotNull();
    }

    @Test
    void greetingShouldReturnDefaultMessageForHelloRestAPI() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/hello",
                String.class)).contains("Hello World!");
    }
}
