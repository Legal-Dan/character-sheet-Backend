import com.dan.legal.Country
import com.dan.legal.PlayableCharacter
import org.junit.jupiter.api.Test

class PlayableCharacterTest{
    private val testCountry = Country("CountryName", listOf("MaleName"), listOf("FemaleName"), listOf("Surname"), listOf("Language"))


    @Test
    fun `can generate a set of standard stats`() {
        var totalValue = 0
        val characteristics = PlayableCharacter(
            "test",
            "classic",
            testCountry,
            "Archaeologist",
            20,
            "standard",
            ""
        ).characteristics
        for (charac in characteristics) totalValue += charac.value.value

        val map = mapOf("Key1" to "Value1", "Key2" to "Value2", "Key3" to "Value3")
        map.forEach { entry ->
            print("${entry.key} : ${entry.value}")
        }
    }

    @Test
    fun `can identify a characteristic to be the highest value in standard generation`() {
        val returnValue =
            PlayableCharacter(
                "test",
                "classic",
                testCountry,
                "Archaeologist",
                20,
                "standard",
                "dexterity"
            ).characteristics["dexterity"]!!.value
        assert(returnValue == 70)
    }

    @Test
    fun `can generate a set of random stats`() {
        var totalValue = 0
        val characteristics = PlayableCharacter(
            "test",
            "classic",
            testCountry,
            "Archaeologist",
            20,
            "roll",
            ""
        ).characteristics
        for (charac in characteristics) {
            totalValue += charac.value.value
        }
        totalValue -= characteristics["luck"]!!.value
        assert(totalValue != 70+60+60+50+50+50+40+40)
    }

    @Test
    fun `can generate a set of period appropriate skills`() {
        val eraSkills = PlayableCharacter(
            "test",
            "classic",
            testCountry,
            "Archaeologist",
            20,
            "roll",
            ""
        ).eraSkills
        for (skill in eraSkills) {
            assert(skill.value.era.contains("classic"))
        }
    }
}