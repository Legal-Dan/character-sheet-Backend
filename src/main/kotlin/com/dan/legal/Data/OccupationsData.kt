import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.net.URL

var allOccupations = listOf<Occupations>()

data class Occupations (
val displayName: String,
val era: List<String>,
val careerSkills: List<String>,
val creditRatingLow: Int,
val creditRatingHigh: Int,
val occupationPoints: List<String>
)

fun createOccupationList() {
    val resource: URL = Occupations::class.java.classLoader.getResource("static/assets/json/occupations.json")
    allOccupations = jacksonObjectMapper().readValue(
        resource,
        object : TypeReference<List<Occupations>>() {}
    )
}

fun importOccupations(toFind: String, eraToFind: String): Occupations {
    val rawData:Occupations = allOccupations
        .filter { it.era.contains(eraToFind) }.first { it.displayName.contains(toFind) }

    val data = Occupations(
        displayName = rawData.displayName,
        era = rawData.era,
        careerSkills = splitSkills(rawData.careerSkills),
        creditRatingLow = rawData.creditRatingLow,
        creditRatingHigh = rawData.creditRatingHigh,
        occupationPoints = rawData.occupationPoints
    )

    return data
}

fun splitSkills(skillList: List<String>): List<String> {
    val toReturn = mutableListOf<String>()
    for (skill in skillList){
        when {
            skill.contains("multipleOf") -> toReturn += multipleOf(skill)
            skill.contains("oneOf") -> toReturn += oneOf(skill)
            else -> toReturn += skill
        }
    }
    return toReturn
}

fun oneOf(skillList: String): String {
    return skillList.replace("oneOf", "").split("/").random()
}

fun multipleOf(skillList: String): MutableList<String> {
    val splitList = skillList.split(":")
    val number = splitList[1].toInt()
    val remainingOptions = splitList[0].replace("multipleOf", "").split("/").toMutableList()

    val toReturn = mutableListOf<String>()
    while(toReturn.size < number){
        toReturn += remainingOptions.random()
        remainingOptions.remove(toReturn.last())
    }
    return toReturn
}

fun generateOccupationList(eraToFind: String): List<String> {
    val data = ((allOccupations.filter { it.era.contains(eraToFind) }).map { occupation -> occupation.displayName })
    return listOf("Random") + data
}
