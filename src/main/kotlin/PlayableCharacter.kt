class PlayableCharacter(
    name: String,
    era: String,
    occupation: String,
    age: Int,
    statsGeneration: String,
    highestValue: String,
) {
    val name = name
    val era = era
    val occupation = occupation
    val age = age
    val skills = SkillsList().skills
    val statsGeneration = statsGeneration
    val highestValue = highestValue
    val characteristics = Characteristics(statsGeneration, highestValue)
    val eraSkills = skillsByEra()
    val occupations = OccupationsList().occupations
    val characterOccupation = occupations[occupation]
    val characterSkills = AssignedSkills(eraSkills, characterOccupation!!, era, characteristics.assignedCharacteristic)

    private fun skillsByEra(): MutableMap<String, Skills> {
        val temp = mutableMapOf<String, Skills>()
        for (skill in skills){
            if (skill.value.era.contains(era))
                temp += skill.key to skill.value
        }
        return temp
    }
}
