class PlayableCharacter(name:String, era:String, occupation:String, age:Int, statsGeneration:String, highestValue: String) {
    val name = name
    val era = era
    val occupation = occupation
    val age = age
    val statsGeneration = statsGeneration
    val highestValue = highestValue

    val characteristics = Characteristics(statsGeneration, highestValue)
    val characterSkills = skillsByEra()
    val characterOccupation = occupations[occupation]
    val careerSkills = assignCharacterSkills(characterOccupation!!.careerSkills)

    private fun assignCharacterSkills(tempSkills: List<String>): List<String> {
        val toReturn = mutableListOf<String>()
        for (skill in tempSkills){
            if (skill == "random"){
                toReturn += chooseRandom(randomSkillList())
            }
            else {
                toReturn += skill
            }
        }
        return toReturn
    }

    fun randomSkillList(): MutableList<String> {
        val temp = mutableListOf<String>()
        for (currentSkill in skills){
            if (currentSkill.value.era.contains(era) && currentSkill.value.rarity.equals("Very Common")){
                repeat(4) {
                    temp += currentSkill.key
                }
            }else if (currentSkill.value.era.contains(era) && currentSkill.value.rarity.equals("Common")){
                repeat(2) {
                    temp += currentSkill.key
                }
            }else if (currentSkill.value.era.contains(era) && currentSkill.value.rarity.equals("Uncommon")){
                temp += currentSkill.key
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

    private fun chooseRandom(randomSkillList: List<String>):String{
        var toReturn:String? = null
        while(toReturn == null){
            val temp = randomSkillList.random()
            if (!characterOccupation!!.careerSkills.contains(temp)) {
                toReturn = temp
            }
        }
        return toReturn
    }
}
