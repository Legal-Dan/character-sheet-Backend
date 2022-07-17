import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object CountriesData: org.jetbrains.exposed.sql.Table(){
    val region = varchar("region", 100)
    val male = varchar("male", 5000)
    val female = varchar("female", 5000)
    val surnames = varchar("surnames", 5000)
    val languages = varchar("languages", 100)
    val periods = varchar("periods", 100)
}

fun importCountry(toFind: String): Country {
    val data = mutableListOf<String>()
    transaction(
        Database.connect(url = "jdbc:mysql://localhost:3306/mysql",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "rootroot")) {
        SchemaUtils.create(CountriesData)

        CountriesData.selectAll().forEach {
            if (it[CountriesData.region] == (toFind)) {
                data += mutableListOf(
                    it[CountriesData.region],
                    it[CountriesData.male],
                    it[CountriesData.female],
                    it[CountriesData.surnames],
                    it[CountriesData.languages]
                )
            }
        }
    }
    val delim = ","
    return Country(data[0], data[1].split(delim), data[2].split(delim), data[3].split(delim), data[4].split(delim))
}

fun generateCountryList(eraToFind: String): List<MutableList<String>> {
    val data = listOf(mutableListOf(), mutableListOf<String>())
    transaction(
        Database.connect(url = "jdbc:mysql://localhost:3306/mysql",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "rootroot")) {
        SchemaUtils.create(CountriesData)

        CountriesData.selectAll().forEach {
            if (it[CountriesData.periods].contains(eraToFind)) {
                data[0] += it[CountriesData.region]
                for (language in it[CountriesData.languages].split(",")){
                    if (!data[1].contains(language)) data[1] += language
                }
            }
        }
    }
    return data
}