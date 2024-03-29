package com.dan.legal

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Klaxon
import createCountriesList
import createOccupationList
import createSkillsList
import generateCountryList
import generateOccupationList
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

var countryList = listOf<String>()
var languageList = listOf<String>()
var occupationList = listOf<String>()

@SpringBootApplication
class CharacterSheet

fun main(args: Array<String>) {
    runApplication<CharacterSheet>(*args)
    createOccupationList()
    createSkillsList()
    createCountriesList()
}

class getEraRequest (
    val title: String
)

@RestController
class MessageResource {
//    @CrossOrigin(origins = ["http://localhost:8080", "http://localhost:3000"])
@CrossOrigin(origins = ["https://legal-dan.github.io", "https://legal-dan.github.io"])
    @PostMapping("/getOccupations")
    fun get(@RequestBody request: getEraRequest): List<String> {
        val era = request.title
        occupationList = generateOccupationList(era)
        return occupationList
    }

    //@CrossOrigin(origins = ["http://localhost:8080", "http://localhost:3000"])
@CrossOrigin(origins = ["https://legal-dan.github.io", "https://legal-dan.github.io"])
    @PostMapping("/getRegions")
    fun getRegions(@RequestBody request: getEraRequest): List<String> {
        val data = generateCountryList(request.title)
        countryList = data.first
        languageList = data.second
        return listOf("Random") + countryList
    }

//    @CrossOrigin(origins = ["http://localhost:8080", "http://localhost:3000"])
@CrossOrigin(origins = ["https://legal-dan.github.io", "https://legal-dan.github.io"])
    @PostMapping("/getUsers")
    fun post(@RequestBody message: String): String {
        data class Character(
            val charName: String,
            val era: String,
            val gender: String,
            val region: String,
            val occupation: String,
            val age: String,
            val statsGeneration: String,
            val highestValue: String
        )

        val generators = Generators()
        val result = Klaxon()
            .parse<Character>(message) ?: throw error("No details found!")
        val generatedCountry = generators.countryGenerator(result.region)
        val generatedCharacter = PlayableCharacter(
            generators.nameGenerator(result.charName, result.gender, generatedCountry),
            result.era,
            generatedCountry,
            generators.parseOccupation(result.occupation),
            generators.ageGenerator(result.age),
            result.statsGeneration,
            result.highestValue
        )
        val toReturn =
            "${generatedCharacter.name}|" +
                    "${generatedCharacter.age}|" +
                    "${generatedCharacter.occupation}|" +
                    "${generatedCountry.region}|" +
                    "${sortStats(generatedCharacter)}|" +
                    "${sortSkills(generatedCharacter)}|" +
                    generatedCharacter.characteristics["build"]?.let { generators.dbGenerator(it.value) }

        class ReturnString(val text: String)

        val toReturnJson = ReturnString(toReturn)
        return Klaxon().toJsonString(toReturnJson)
    }

    private fun sortSkills(generatedCharacter: PlayableCharacter): String {
        var returnSkills = ""
        val sortedList = generatedCharacter.characterSkills.assignedCharacterSkills.toSortedMap()
        for (skill in sortedList) {
            if (skill.value.rarity != "Uncommon" ||
                generatedCharacter.characterSkills.careerSkills.contains(skill.key) ||
                generatedCharacter.characterSkills.assignedInterestSkills.contains(skill.key)
            ) {
                returnSkills += ", " + skill.value.displayName + ">" + skill.value.initialValue
            }
        }
        return returnSkills
    }

    private fun sortStats(generatedCharacter: PlayableCharacter): String {
        val flatStats = generatedCharacter.characteristics
        var returnStats = ""
        for (stat in flatStats){
            returnStats += ", " + stat.value.name + ">" + stat.value.value
        }
        return returnStats
    }
}
