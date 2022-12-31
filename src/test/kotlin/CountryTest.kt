//import org.junit.jupiter.api.Test
//
//class CountryTest{
//    private val testCountry = Country("CountryName", listOf("MaleName"), listOf("FemaleName"), listOf("Surname"), listOf("Language"), listOf("Era"))
//    private val saxonCountry = Country("Kent", listOf("MaleName"), listOf("FemaleName"), listOf("Surname"), listOf("Language"), listOf("Era"))
//    private val forenameCountry = Country("Franks", listOf("MaleName"), listOf("FemaleName"), listOf("Surname"), listOf("Language"), listOf("Era"))
//
//    @Test
//    fun `can generate a random name, forename first`() {
//        assert(testCountry.randomName("male") == "MaleName Surname")
//    }
//
//    @Test
//    fun `can generate a random other name, forename first`() {
//        assert(listOf("MaleName Surname","FemaleName Surname").contains(testCountry.randomName("other")))
//    }
//
//    @Test
//    fun `can generate a random saxon name`() {
//        assert(saxonCountry.randomName("male") == "SurnameMaleName")
//    }
//
//    @Test
//    fun `can generate a random other saxon name`() {
//        assert(listOf("SurnameMaleName","SurnameFemaleName").contains(saxonCountry.randomName("other")))
//    }
//
//    @Test
//    fun `can generate a random name, forename only`() {
//        assert(forenameCountry.randomName("male") == "MaleName")
//    }
//
//    @Test
//    fun `can generate a random other name, forename only`() {
//        assert(listOf("MaleName","FemaleName").contains(forenameCountry.randomName("other")))
//    }
//
//
//
//}