class PlayableCharacter(
    val name: String,
    private val era: String,
    country: Country,
    val occupation: String,
    val age: Int,
    statsGeneration: String,
    highestValue: String,
) {
    private val skills = SkillsList().skills
    val characteristics = Characteristics(statsGeneration, highestValue, age).updatedCharacteristic
    val eraSkills = skillsByEra()
    private val occupations = OccupationsList().occupations
    private val characterOccupation = occupations[occupation]
    val characterSkills = AssignedSkills(eraSkills, characterOccupation!!, era, characteristics, country)

    private fun skillsByEra(): MutableMap<String, Skills> {
        val temp = mutableMapOf<String, Skills>()
        for (skill in skills){
            if (skill.value.era.contains(era))
                temp += skill.key to skill.value
        }
        return temp
    }
}
