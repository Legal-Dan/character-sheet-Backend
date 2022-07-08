package main

import Names
import Occupations
import OccupationsList
import PlayableCharacter
import com.beust.klaxon.Klaxon
import importCountry
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.CrossOrigin

val countryList = listOf("Albania", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bangladesh", "Belgium", "Bosnia and Herzegovina", "Brazil", "Bulgaria", "Canada", "China", "Colombia", "Costa Rica", "Croatia", "Czech Republic", "Denmark", "Egypt", "England", "Estonia", "Finland", "France", "Georgia", "Germany", "Greece", "Hungary", "India", "Indonesia", "Iran", "Ireland", "Israel", "Italy", "Japan", "Korea", "Kyrgyz Republic", "Mexico", "Morocco", "Nepal", "Netherlands", "New Zealand", "Nigeria", "Norway", "Pakistan", "Poland", "Portugal", "Romania", "Russia", "Saudi Arabia", "Scotland", "Slovakia", "Slovenia", "Spain", "Sweden", "Switzerland", "Tunisia", "Turkey", "Ukraine", "United States", "Vietnam", "Wales")
val languageList = listOf("Albanian", "Spanish", "Armenian", "English", "German", "Azerbaijani", "Bengali", "Dutch", "French", "Bosnian", "Croatian", "Serbian", "Portuguese", "Bulgarian", "Mandarin", "Czech", "Slovak", "Danish", "Arabic", "Estonian", "Finnish", "Georgian", "Greek", "Hungarian", "Hindi", "Tamil", "Malayalam", "Telugu", "Kannada", "Marathi", "Punjabi", "Assamese", "Odiya", "Gujarathi", "Indonesian", "Persian", "Hebrew", "Italian", "Japanese", "Korean", "Kyrgyz", "Russian", "Tamazight", "Nepali", "Norwegian", "Urdu", "Polish", "Romanian", "Slovene", "Swedish", "Turkish", "Ukrainian", "Vietnamese", "Welsh")

@SpringBootApplication
class CharacterSheet
var occupationList = listOf<String>()

object names: org.jetbrains.exposed.sql.Table(){
    val region = varchar("region", 100)
    val male = varchar("male", 5000)
    val female = varchar("female", 5000)
    val surnames = varchar("surnames", 5000)
    val languages = varchar("languages", 100)
    val periods = varchar("periods", 100)
}

fun main(args: Array<String>) {
    runApplication<CharacterSheet>(*args)
}

@RestController
class MessageResource() {
    @CrossOrigin(origins = arrayOf("http://localhost:8080", "http://localhost:3000"))
    @PostMapping("/getOccupations")
    fun get(@RequestBody title: String): List<String> {
        val era = title.subSequence(10, title.length-2).toString()
        occupationList = filterByEra(OccupationsList().occupations, era)
        return occupationList;
    }

    private fun filterByEra(occupations: Map<String, Occupations>, era: String): List<String> {
        var toReturn = listOf("Random")
        for (occupation in occupations){
            if (occupation.value.era.contains(era)){
                toReturn = toReturn + occupation.key
            }
        }
        return toReturn
    }

    @CrossOrigin(origins = arrayOf("http://localhost:8080", "http://localhost:3000"))
    @PostMapping("/getUsers")
    fun post(@RequestBody message: String): String {
        data class Character(
            val charName: String,
            val era: String,
            val occupation: String,
            val age: String,
            val statsGeneration: String,
            val highestValue: String
        )

        val result = Klaxon()
            .parse<Character>(message) ?: throw error("No details found!")
        val generatedCountry = importCountry(countryList.random())
        val generatedCharacter = PlayableCharacter(
            nameGenerator(result.charName, generatedCountry),
            result.era,
            parseOccupation(result.occupation),
            ageGenerator(result.age),
            result.statsGeneration,
            result.highestValue
        )
        val returnName = generatedCharacter.name
        val returnAge = generatedCharacter.age
        val returnOccupation = generatedCharacter.occupation
        val flatStats = generatedCharacter.characteristics.assignedCharacteristic
        var returnStats = ""
        var returnSkills = ""
        for (stat in flatStats){
            returnStats += ", " + stat.value.name + ": " + stat.value.value
        }

        for (skill in generatedCharacter.characterSkills.assignedCharacterSkills){
            returnSkills += ", " + skill.value.displayName + ": " + skill.value.value
        }

        val toReturn =
            "$returnName is a $returnAge year old $returnOccupation with base characteristics of$returnStats. Current skills are set to$returnSkills."

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

    private fun nameGenerator(charName: String, generatedCountry: Names, sex: String = "Random"): String {
        return if (charName == "") {
            generatedCountry?.randomName(sex) ?: String.toString()
        } else {
            return charName
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
