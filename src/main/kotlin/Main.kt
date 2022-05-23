package main

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

    @PostMapping
    fun post(@RequestBody message: String) {
        println(message)
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

