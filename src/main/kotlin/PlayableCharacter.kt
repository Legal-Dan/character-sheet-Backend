class PlayableCharacter(name:String, era:String, occupation:String, age:Int, statsGeneration:String, highestValue: String) {
    val name = name
    val era = era
    val occupation = occupation
    val age = age
    val statsGeneration = statsGeneration
    val highestValue = highestValue

    val characteristics = Characteristics(statsGeneration, highestValue)
    val characterSkills = skillsByEra()
    val randomSkillsList = randomSkillListGenerator()

    private fun randomSkillListGenerator(): Any {
        val temp = mutableListOf<String>()
        for (skill in skills){
            if (skill.value.era.contains(era) && skill.value.rarity.equals("Very Common")){
                repeat(4) {
                    temp += skill.key
                }
            }else if (skill.value.era.contains(era) && skill.value.rarity.equals("Common")){
                repeat(2) {
                    temp += skill.key
                }
            }else if (skill.value.era.contains(era) && skill.value.rarity.equals("Uncommon")){
                temp += skill.key
            }
        }
        return temp
    }

    private fun skillsByEra(): MutableMap<String, Skills> {
        val temp = mutableMapOf<String, Skills>()
        for (skill in skills){
            if (skill.value.era.contains(era))
                temp += skill.key to skill.value
        }
        return temp
    }


//    val occupations = Occupations(characterSkills)
}
