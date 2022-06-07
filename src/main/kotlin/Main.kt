package main

import Occupations
import PlayableCharacter
import com.beust.klaxon.Klaxon
import occupations
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.annotation.Id
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.CrossOrigin

@SpringBootApplication
class CharacterSheet

fun main(args: Array<String>) {
    runApplication<CharacterSheet>(*args)
}

@RestController
class MessageResource(val service: MessageService)  {

    @CrossOrigin(origins = arrayOf("http://localhost:8080", "http://localhost:3000"))
    @PostMapping("/getOccupations")
    fun get(@RequestBody title: String): List<String> {
        val era = title.subSequence(10, title.length-2).toString()
        return filterByEra(occupations, era);
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
        data class Character(val charName: String, val era: String, val occupation: String, val age: String, val statsGeneration: String, val highestValue:String)

        val result = Klaxon()
            .parse<Character>(message)
        if (result != null) {
            val generatedCharacter = PlayableCharacter(result.charName, result.era, result.occupation, result.age.toInt(), result.statsGeneration, result.highestValue)
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

            val toReturn = "$returnName is a $returnAge year old $returnOccupation with base characteristics of$returnStats. Current skills are set to$returnSkills."

            class ReturnString(val text: String)
            val toReturnJson = ReturnString(toReturn)
            return Klaxon().toJsonString(toReturnJson)
        }
        return Klaxon().toJsonString("TODO")
        }
    }

@Table("messages")
data class Message(@Id val id: String?, val text: String)

interface MessageRepository : CrudRepository<Message, String> {
    @Query("select * from messages")
    fun findMessages(): List<Message>
}

@Service
class MessageService(val db: MessageRepository) {
    fun findMessages(): List<Message> = db.findMessages()
    fun post(message: Message){
        db.save(message)
    }
}

