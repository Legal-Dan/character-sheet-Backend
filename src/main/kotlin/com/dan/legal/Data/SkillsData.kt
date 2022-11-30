import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.net.URL

var allSkills = listOf<Skills>()

class Skills(var shortName: String,
             var displayName: String,
             var era: List<String>,
             var initialValue: Int,
             val rarity: String,
             var variety: MutableMap<String, Int>?)

fun createSkillsList() {
    val resource: URL = Skills::class.java.classLoader.getResource("static/assets/json/skills.json")
    allSkills = jacksonObjectMapper().readValue(
        resource,
        object : TypeReference<List<Skills>>() {}
    )
}

fun importSkills(eraToFind: String): Map<String, Skills> {
    return allSkills
        .filter { it.era.contains(eraToFind) }
        .map { it.shortName to it}.toMap()
}