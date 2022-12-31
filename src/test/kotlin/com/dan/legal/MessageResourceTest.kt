package com.dan.legal

import createCountriesList
import createOccupationList
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class MessageResourceTest @Autowired constructor (
    private val restTemplate: TestRestTemplate
){

    @LocalServerPort
    private var port: Int = 0


    @BeforeAll
    fun beforeAll() {
        createCountriesList()
        createOccupationList()
    }

    @Test
    fun getRegions() {
        val requestObject = getEraRequest("darkAge")

        val response = restTemplate.postForEntity(
            "http://localhost:$port/getRegions", requestObject,
            String::class.java)

        assertEquals(response.statusCodeValue, 200)

    }

    @Test
    fun getOccupations() {
        val requestObject = getEraRequest("darkAge")

        val response = restTemplate.postForEntity(
            "http://localhost:$port/getOccupations", requestObject,
            String::class.java)

        assertEquals(response.statusCodeValue, 200)

    }
}


