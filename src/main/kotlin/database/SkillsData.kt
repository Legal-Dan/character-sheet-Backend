import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object SkillsData: org.jetbrains.exposed.sql.Table(){
    val shortName = varchar("shortName", 100)
    val displayName = varchar("displayName", 100)
    val era = varchar("era", 5000)
    val initialValue = integer("initialValue")
    val rarity = varchar("rarity", 100)
    val variety = varchar("variety", 5000)
}

fun importSkills(eraToFind: String): Map<String, Skills> {
    val data = mutableMapOf<String, Skills>()
    val delim = ","
    transaction(
        Database.connect(url = "jdbc:mysql://localhost:3306/mysql",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "rootroot")) {
        SchemaUtils.create(SkillsData)

        SkillsData.selectAll().forEach {
            if ((eraToFind) in it[SkillsData.era]) data += mapOf(
                it[SkillsData.shortName] to Skills(
                    it[SkillsData.displayName],
                    it[SkillsData.era].split(delim),
                    it[SkillsData.initialValue],
                    it[SkillsData.rarity],
                    assignVariety(it[SkillsData.variety])
                )
            )
        }
    }

    return data

}

fun assignVariety(varietyString: String): MutableMap<String, Int>? {
    if (varietyString.isBlank()) return null
    val varietyList = varietyString.split(",")
    val toReturn = mutableMapOf<String, Int>()
    for (variety in varietyList){
        val pair = variety.split(" to ")
        toReturn += mapOf(pair[0] to pair[1].toInt())
    }
    return toReturn
}