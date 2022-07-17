package main

import Country
import PlayableCharacter
import com.beust.klaxon.Klaxon
import generateCountryList
import generateOccupationList
import importCountry
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

        val result = Klaxon()
            .parse<Character>(message) ?: throw error("No details found!")
        val generatedCountry = countryGenerator(result.region)
        val generatedCharacter = PlayableCharacter(
            nameGenerator(result.charName, result.gender, generatedCountry),
            result.era,
            generatedCountry,
            parseOccupation(result.occupation),
            ageGenerator(result.age),
            result.statsGeneration,
            result.highestValue
        )
        val returnName = generatedCharacter.name
        val returnAge = generatedCharacter.age
        val returnOccupation = generatedCharacter.occupation
        val returnRegion = generatedCountry.region
        val flatStats = generatedCharacter.characteristics
        var returnStats = ""
        var returnSkills = ""
        for (stat in flatStats){
            returnStats += ", " + stat.value.name + ": " + stat.value.value
        }

        for (skill in generatedCharacter.characterSkills.assignedCharacterSkills){
            returnSkills += ", " + skill.value.displayName + ": " + skill.value.value
        }

        val toReturn =
            "$returnName is a $returnAge year old $returnOccupation from $returnRegion with base characteristics of$returnStats. Current skills are set to$returnSkills."

        class ReturnString(val text: String)

        val toReturnJson = ReturnString(toReturn)
        return Klaxon().toJsonString(toReturnJson)
    }

    private fun ageGenerator(charAge: String): Int {
        return if (charAge == "") {
            (18..80).random()
        } else {
            charAge.toInt()
        }
    }

    private fun nameGenerator(charName: String, gender: String, generatedCountry: Country): String {
        return if (charName == "") {
            var updatedGender = gender
            if (gender == "Random") updatedGender = listOf("male", "female").random()
            generatedCountry.randomName(updatedGender)
        } else {
            return charName
        }
    }

    private fun countryGenerator(country: String):Country{
        return if(country == "Random" || country == "") {
            importCountry(countryList.random())
        } else {
            return importCountry(country)
        }

    }

    private fun parseOccupation(occupation: String): String {
        return if (occupationList.contains(occupation)) {
            occupation
        } else {
            occupationList[(1 until occupationList.size).random()]
        }
    }
}
