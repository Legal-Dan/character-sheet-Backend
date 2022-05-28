package main

import PlayableCharacter
import com.beust.klaxon.Klaxon
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.annotation.Id
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
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
    @GetMapping("/getUsers")
    fun index() : List<Message> {
        val sampleList = listOf(
            Message("1", "Hello!"),
            Message("2", "Bonjour!"),
            Message("3", "Privet!")
        )
        return sampleList;
    }

    @CrossOrigin(origins = arrayOf("http://localhost:8080", "http://localhost:3000"))
    @PostMapping("/getUsers")
    fun post(@RequestBody message: String): String {
        data class Character(val charName: String, val occupation: String, val age: String, val statsGeneration: String, val highestValue:String)

        val result = Klaxon()
            .parse<Character>(message)
        if (result != null) {
            val generatedCharacter = PlayableCharacter(result.charName, result.occupation, result.age.toInt(), result.statsGeneration, result.highestValue)
            val returnName = generatedCharacter.name
            val returnAge = generatedCharacter.age
            val returnOccupation = generatedCharacter.occupation
            val flatStats = generatedCharacter.characteristics.assignedCharacteristic
            var returnStats = ""
            for (stat in flatStats){
                returnStats += ", " + stat.value.name + ": " + stat.value.value
            }
            val toReturn = "$returnName is a $returnAge year old $returnOccupation with base characteristics of$returnStats"

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

