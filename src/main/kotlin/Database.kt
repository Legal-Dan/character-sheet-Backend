import main.names
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun importCountry(toFind: String): Names {
    val data = mutableListOf<String>()
    transaction(
        Database.connect(url = "jdbc:mysql://localhost:3306/mysql",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "rootroot")) {
        SchemaUtils.create(names)

        names.selectAll().forEach {
            if (it[names.region] == (toFind)) {
                data += mutableListOf(
                    it[names.region],
                    it[names.male],
                    it[names.female],
                    it[names.surnames],
                    it[names.languages]
                )
            }
        }
    }
    val delim = ","
    return Names(data[0], data[1].split(delim), data[2].split(delim), data[3].split(delim), data[4].split(delim))
}

fun generateCountryList(eraToFind: String): List<MutableList<String>> {
    val data = listOf(mutableListOf<String>(), mutableListOf<String>())
    transaction(
        Database.connect(url = "jdbc:mysql://localhost:3306/mysql",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "rootroot")) {
        SchemaUtils.create(names)

        names.selectAll().forEach {
            if (it[names.periods].contains(eraToFind)) {
                data[0] += it[names.region]
                for (language in it[names.languages].split(",")){
                    if (!data[1].contains(language)) data[1] += language
                }
            }
        }
    }
    return data
}