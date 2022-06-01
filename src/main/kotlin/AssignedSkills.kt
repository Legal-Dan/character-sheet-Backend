class AssignedSkills(
    characterSkills: MutableMap<String, Skills>,
    occupation:Occupations,
    era:String,
    characteristics: MutableMap<String, Characteristic>
) {
    val occupation = occupation
    val era = era
    val characteristics = characteristics
    val careerSkills = assignCharacterSkills(occupation.careerSkills)
    val characterSkills = characterSkills
    val assignedCharacterSkills = assign(careerSkills)

    private fun updateCharacteristicSkills(characterSkills: MutableMap<String, Skills>): MutableMap<String, Skills> {
        characterSkills["dodge"]!!.value = characteristics["dexterity"]!!.value/2
        characterSkills["languageOwn"]!!.displayName = "Language: English"
        characterSkills["languageOwn"]!!.value = characteristics["education"]!!.value
        return characterSkills
    }

    private fun assign(careerSkills: List<String>): MutableMap<String, Skills> {
        updateCharacteristicSkills(characterSkills)
        val standardArray = mutableListOf(70, 60, 60, 50, 50, 50, 40, 40, 40)
        for (skill in careerSkills){
            if (skill == "creditRating"){
                var creditValue = 0
                while (creditValue > occupation.creditRatingHigh || creditValue < occupation.creditRatingLow){
                    creditValue = standardArray.random()
                }
                assignValue("creditRating", creditValue, "replace")
                standardArray.remove(creditValue)
            }
            else{
                assignValue(skill, standardArray.random(), "replace")
                standardArray.remove(characterSkills[skill]!!.value)
            }
        }
        assignInterests()
        return characterSkills
    }

    private fun assignInterests() {
        var interestPoints = (characteristics["intelligence"]!!.value)*2
        while (interestPoints > 0){
            val tempPoints = (1..6).random()*5
            if(tempPoints <= interestPoints){
                assignValue(randomSkillList().random(), tempPoints, "addition")
                interestPoints -= tempPoints
            }
        }
    }

    private fun assignValue(skill:String, skillValue:Int, function:String): Skills? {
        if(function == "replace"){
            val skillObject = characterSkills[skill]
            skillObject!!.value = skillValue
            return skillObject
        }
        else{
            val skillObject = characterSkills[skill]
            skillObject!!.value += skillValue
            return skillObject
        }
    }

    private fun assignCharacterSkills(tempSkills: List<String>): List<String> {
        val toReturn = mutableListOf<String>()
        for (skill in tempSkills){
            if (skill == "random"){
                toReturn += chooseRandom()
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

    private fun chooseRandom():String{
        var toReturn:String? = null
        while(toReturn == null){
            val temp = randomSkillList().random()
            if (!occupation.careerSkills.contains(temp)) {
                toReturn = temp
            }
        }
        return toReturn
    }
}