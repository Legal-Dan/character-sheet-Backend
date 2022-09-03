package main

import AssignedSkills
import Generators
import OccupationsData.careerSkills
import PlayableCharacter
import com.beust.klaxon.Klaxon
import generateCountryList
import generateOccupationList
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.CrossOrigin

var countryList = listOf<String>()
var languageList = listOf<String>()
var occupationList = listOf<String>()

@SpringBootApplication
class CharacterSheet

fun main(args: Array<String>) {
    runApplication<CharacterSheet>(*args)
}

@RestController
class MessageResource {
    @CrossOrigin(origins = ["http://localhost:8080", "http://localhost:3000"])
    @PostMapping("/getOccupations")
    fun get(@RequestBody title: String): List<String> {
        val era = title.subSequence(10, title.length-2).toString()
        occupationList = generateOccupationList(era)
        return occupationList
    }

    @CrossOrigin(origins = ["http://localhost:8080", "http://localhost:3000"])
    @PostMapping("/getRegions")
    fun getRegions(@RequestBody title: String): List<String> {
        val era = title.subSequence(10, title.length-2).toString()
        val data = generateCountryList(era)
        countryList = data[0]
        languageList = data[1]
        return listOf("Random") + countryList
    }

    @CrossOrigin(origins = ["http://localhost:8080", "http://localhost:3000"])
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
        val flatStats = generatedCharacter.characteristics
        var returnStats = ""
        var returnSkills = ""
        for (stat in flatStats){
            returnStats += ", " + stat.value.name + ">" + stat.value.value
        }

        for (skill in generatedCharacter.characterSkills.assignedCharacterSkills){
            if (skill.value.rarity != "Uncommon" ||
                generatedCharacter.characterSkills.careerSkills.contains(skill.key) ||
                generatedCharacter.characterSkills.assignedInterestSkills.contains(skill.key)){
            returnSkills += ", " + skill.value.displayName + ">" + skill.value.initialValue
            }
        }

        val toReturn =
            "${generatedCharacter.name}|${generatedCharacter.age}|${generatedCharacter.occupation}|${generatedCountry.region}|$returnStats|$returnSkills"

        class ReturnString(val text: String)

        val toReturnJson = ReturnString(toReturn)
        return Klaxon().toJsonString(toReturnJson)
    }
}
