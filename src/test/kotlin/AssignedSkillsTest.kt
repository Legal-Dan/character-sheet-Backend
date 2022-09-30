import org.junit.jupiter.api.Test

class AssignedSkillsTest{


    @Test
    fun `updates dodge to match half dexterity`() {
        assert(TestFunctions().assignedSkills("classic").assignedCharacterSkills["dodge"]!!.initialValue == 50)
    }

    @Test
    fun `updates language display name to match country's language`() {
        assert(TestFunctions().assignedSkills("classic").assignedCharacterSkills["languageAOwn"]!!.displayName == "Language: MyLanguage")
    }

    @Test
    fun `updates language value to match education`() {
        assert(TestFunctions().assignedSkills("classic").assignedCharacterSkills["languageAOwn"]!!.initialValue >= 500)
    }

    @Test
    fun `total points equal to standard array`() {
        var total = 0
        for (skill in TestFunctions().assignedSkills("classic").assignedCharacterSkills) {
            total += skill.value.initialValue
        }
        assert(total == 70 + 60 + 60 + 50 + 50 + 50 + 40 + 40 + 40 + (75 * 2) + 500 + (100 / 2))
    }


}