import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.net.URL

var allCountries = listOf<Country>()

fun createCountriesList() {
    val resource: URL = Country::class.java.classLoader.getResource("static/assets/json/countries.json")
    allCountries = jacksonObjectMapper().readValue(
        resource,
        object : TypeReference<List<Country>>() {}
    )
}

fun importCountry(toFind: String): Country {
        return allCountries.filter { it.region == toFind }.first()
}

fun generateCountryList(eraToFind: String): Pair<List<String>,List<String>> {
    val countries = allCountries.filter { it.era.contains(eraToFind) }
    var languages:List<String> = countries.first().languages
    countries.map { it -> languages += it.languages }

    return Pair(countries.map { it -> it.region }, languages.distinct())
}

class Country(val region: String, private val male: List<String>, private val female: List<String>, private val surnames: List<String>,
              val languages: List<String>, val era: List<String>
) {
    fun randomName(gender:String):String{
        return when(region) {
            "Kent", "East Anglia", "Essex", "Mercia", "Northumbria", "Sussex", "Wessex" -> angloSaxonName(gender)
            "Britons", "Burgundy", "Franks", "German Empire" -> forenameOnly(gender)
            else -> forenameFirst(gender)
        }
    }

    private fun forenameOnly(gender: String): String {
        return when (gender){
            "male" -> male.random()
            "female" -> female.random()
            else -> listOf(male.random(), female.random()).random()
        }
    }

    private fun forenameFirst(gender: String): String {
        return when (gender){
            "male" -> "${male.random()} ${surnames.random()}"
            "female" -> "${female.random()} ${surnames.random()}"
            else -> listOf("${male.random()} ${surnames.random()}", "${female.random()} ${surnames.random()}").random()
        }
    }

    private fun angloSaxonName(gender: String): String {
        return when (gender){
            "male" -> "${surnames.random()}${male.random()}"
            "female" -> "${surnames.random()}${female.random()}"
            else -> listOf("${surnames.random()}${male.random()}", "${surnames.random()}${female.random()}").random()
        }
    }
}