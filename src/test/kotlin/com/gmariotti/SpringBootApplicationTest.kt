package com.gmariotti

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootApplicationTest {
    @Autowired lateinit var client: WebTestClient

    @ParameterizedTest
    @ValueSource(strings = ["/health/liveness", "/health/readiness", "/prometheus"])
    fun `verify default endpoints are available`(endpoint: String) {
        client
            .get()
            .uri("/actuator/$endpoint")
            .exchange()
            .expectStatus().is2xxSuccessful
    }
}
