import main.countryList
import main.occupationList

class Generators {

    fun ageGenerator(charAge: String): Int {
        return if (charAge == "") {
            (18..80).random()
        } else {
            charAge.toInt()
        }
    }

    fun nameGenerator(charName: String, gender: String, generatedCountry: Country): String {
        return if (charName == "") {
            var updatedGender = gender
            if (gender == "Random") updatedGender = listOf("male", "female").random()
            generatedCountry.randomName(updatedGender)
        } else {
            return charName
        }
    }

    fun countryGenerator(country: String): Country {
        return if (country == "Random" || country == "") {
            importCountry(countryList.random())
        } else {
            return importCountry(country)
        }

    }

    fun parseOccupation(occupation: String): String {
        return if (occupationList.contains(occupation)) {
            occupation
        } else {
            occupationList[(1 until occupationList.size).random()]
        }
    }
}