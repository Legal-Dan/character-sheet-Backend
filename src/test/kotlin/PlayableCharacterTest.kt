import org.junit.jupiter.api.Test

class PlayableCharacterTest{

    @Test
    fun `can generate a set of standard stats`() {
        val statsGeneration = "standard"
        val highestValue = "none"
        var totalValue = 0
        val characteristics = PlayableCharacter(statsGeneration, highestValue).characteristics.assignedCharacteristic
        for (charac in characteristics) {
            totalValue += charac.value
        }
        totalValue -= characteristics[8].value
        assert(totalValue.equals(70+60+60+50+50+50+40+40))
    }

    @Test
    fun `can identify a characteristic to be the highest value in standard generation`() {
        val statsGeneration = "standard"
        val highestValue = "dexterity"
        val returnValue =
            PlayableCharacter(statsGeneration, highestValue).characteristics.assignedCharacteristic[0].value
        assert(returnValue.equals(70))
    }

    @Test
    fun `can generate a set of random stats`() {
        val statsGeneration = "roll"
        val highestValue = "none"
        var totalValue = 0
        val characteristics = PlayableCharacter(statsGeneration, highestValue).characteristics.assignedCharacteristic
        for (charac in characteristics) {
            totalValue += charac.value
        }
        totalValue -= characteristics[8].value
        assert(!totalValue.equals(70+60+60+50+50+50+40+40))
    }
}