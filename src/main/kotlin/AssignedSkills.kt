class AssignedSkills(careerSkills: List<String>, characterSkills: MutableMap<String, Skills>, creditRatingLow: Int, creditRatingHigh: Int) {
    val characterSkills = characterSkills
    val creditRatingLow = creditRatingLow
    val creditRatingHigh = creditRatingHigh
    val assignedCharacterSkills = assign(careerSkills)

    private fun assign(careerSkills: List<String>): MutableMap<String, Skills> {
        var standardArray = mutableListOf(70, 60, 60, 50, 50, 50, 40, 40, 40)
        for (skill in careerSkills){
            if (skill == "creditRating"){
                var creditValue = 0
                while (creditValue > creditRatingHigh || creditValue < creditRatingLow){
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
        return characterSkills
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
}