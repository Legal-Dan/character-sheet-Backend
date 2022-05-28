import org.junit.jupiter.api.Test

class PlayableCharacterTest{

    @Test
    fun `can generate a set of standard stats`() {
        val statsGeneration = "standard"
        val highestValue = "none"
        var totalValue = 0
        val characteristics = PlayableCharacter("test", "Archaeologist", 20, statsGeneration, highestValue).characteristics.assignedCharacteristic
        for (charac in characteristics) {
            totalValue += charac.value.value
        }

        val map = mapOf("Key1" to "Value1", "Key2" to "Value2", "Key3" to "Value3")
        map.forEach { entry ->
            print("${entry.key} : ${entry.value}")
        }
    }

    @Test
    fun `can identify a characteristic to be the highest value in standard generation`() {
        val statsGeneration = "standard"
        val highestValue = "dexterity"
        val returnValue =
            PlayableCharacter("test", "Archaeologist", 20, statsGeneration, highestValue).characteristics.assignedCharacteristic[highestValue]!!.value
        assert(returnValue == 70)
    }

    @Test
    fun `can generate a set of random stats`() {
        val statsGeneration = "roll"
        val highestValue = "none"
        var totalValue = 0
        val characteristics = PlayableCharacter("test", "Archaeologist", 20, statsGeneration, highestValue).characteristics.assignedCharacteristic
        for (charac in characteristics) {
            totalValue += charac.value.value
        }
        totalValue -= characteristics["luck"]!!.value
        assert(totalValue != 70+60+60+50+50+50+40+40)
    }
}