import org.junit.jupiter.api.Test

class OccupationsDataTest{
    private val occupation = importOccupations("Farmer", "classic")
    private val occupationWithMany = importOccupations("Lawyer", "modern")

    @Test
    fun `can generate occupation list`() {
        assert(generateOccupationList("classic").contains("Farmer"))
        assert(generateOccupationList("classic").contains("Random"))
    }

    @Test
    fun `can import occupations successfully`() {
        assert(occupation.displayName == "Farmer")
        assert(occupation.careerSkills.contains("sciences-Agriculture"))
    }

    @Test
    fun `copes with one of X skill requirements`() {
        assert(occupation.careerSkills.size==9)
    }

    @Test
    fun `copes with many of X skill requirements`() {
        assert(occupationWithMany.careerSkills.size==9)
    }

}