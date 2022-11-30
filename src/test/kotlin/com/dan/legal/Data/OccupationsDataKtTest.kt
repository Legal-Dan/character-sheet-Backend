package com.dan.legal.Data

import Occupations
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test
import java.net.URL

internal class OccupationsDataKtTest{



    @Test
    fun aaaaaa(){
        val resource: URL = Occupations::class.java.classLoader.getResource("static/assets/json/occupations.json")
        val list:List<Occupations> = jacksonObjectMapper().readValue(
            resource,
            object : TypeReference<List<Occupations>>() {}
            //OccupationsData2::class.java
        )

        assert(list.size>0)

        list.filter { it.era.contains("classic") }.forEach { println(it) }

    }
}