import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object OccupationsData: org.jetbrains.exposed.sql.Table(){
    val displayName = varchar("displayName", 100)
    val era = varchar("era", 1000)
    val careerSkills = varchar("careerSkills", 5000)
    val creditRatingLow = varchar("creditRatingLow", 100)
    val creditRatingHigh = varchar("creditRatingHigh", 100)
    val occupationPoints = varchar("occupationPoints", 1000)
}

fun importOccupations(toFind: String, eraToFind: String): Occupations {
    val data = mutableListOf<String>()
    transaction(
        Database.connect(url = "jdbc:mysql://localhost:3306/mysql",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "rootroot")) {
        SchemaUtils.create(CountriesData)

        OccupationsData.selectAll().forEach {
            if (it[OccupationsData.displayName] == toFind && eraToFind in it[OccupationsData.era]) {
                data += mutableListOf(
                    it[OccupationsData.displayName],
                    it[OccupationsData.era],
                    it[OccupationsData.careerSkills],
                    it[OccupationsData.creditRatingLow],
                    it[OccupationsData.creditRatingHigh],
                    it[OccupationsData.occupationPoints]
                )
            }
        }
    }
    val delim = ","
    return Occupations(data[0], data[1].split(delim), splitSkills(data[2]), data[3].toInt(), data[4].toInt(), data[5].split(delim))
}

fun splitSkills(skillString: String): List<String> {
    val skillList = skillString.split(",")
    val toReturn = mutableListOf<String>()
    for (skill in skillList){
        when {
            skill.contains("multipleOf") -> multipleOf(skill)
            skill.contains("oneOf") -> oneOf(skill)
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
    val remainingOptions = splitList[0].split("/").toMutableList()

    val toReturn = mutableListOf<String>()
    while(toReturn.size < number){
        toReturn += remainingOptions.random()
        remainingOptions.remove(toReturn.last())
    }
    return toReturn
}

fun generateOccupationList(eraToFind: String): List<String> {
    val data = mutableListOf("Random")
    transaction(
        Database.connect(url = "jdbc:mysql://localhost:3306/mysql",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "rootroot")) {
        SchemaUtils.create(OccupationsData)

        OccupationsData.selectAll().forEach {
            if (it[OccupationsData.era].contains(eraToFind)) {
                data += it[OccupationsData.displayName]
            }
        }
    }
    return data
}