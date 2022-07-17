import main.countryList
import main.languageList
import java.util.*

class AssignedSkills(
    private val characterSkills: MutableMap<String, Skills>,
    private val occupation: Occupations,
    private val era: String,
    private val characteristics: MutableMap<String, Characteristic>,
    private val country: Country
) {
    private val careerSkills = assignCharacterSkills(occupation.careerSkills)
    val assignedCharacterSkills = assign(careerSkills)

    private fun updateCharacteristicSkills(characterSkills: MutableMap<String, Skills>): MutableMap<String, Skills> {
        characterSkills["dodge"]!!.initialValue = characteristics["dexterity"]!!.value/2
        val assignLanguage = country.languages.random()
        characterSkills["languageOwn"]!!.displayName = "Language: $assignLanguage"
        characterSkills["languageOwn"]!!.initialValue = characteristics["education"]!!.value
        for (language in languageList){
            if (language != assignLanguage){
                characterSkills["languageOther"]!!.variety?.plusAssign(language to 1)
            }
        }
        if(era == "darkAge"){
            for (kingdom in countryList){
                if (kingdom != country.region){
                    characterSkills["otherKingdom"]!!.variety?.plusAssign(kingdom to 20)
                }
            }
        }
        return characterSkills
    }

    private fun assign(careerSkills: List<String>): MutableMap<String, Skills> {
        updateCharacteristicSkills(characterSkills)
        val standardArray = mutableListOf(70, 60, 60, 50, 50, 50, 40, 40, 40)
        for (skill in careerSkills){
            if (skill == "creditRating"){
                var creditValue = 0
                if (occupation.creditRatingLow >= 70){
                    creditValue = 70
                }
                else if (occupation.creditRatingHigh <= 40){
                    creditValue = 40
                }
                else{
                    while (creditValue > occupation.creditRatingHigh || creditValue < occupation.creditRatingLow){
                        creditValue = standardArray.random()
                    }
                }
                assignValue("creditRating", creditValue, "replace")
                standardArray.remove(creditValue)
            }
            else{
                val temp = standardArray.random()
                assignValue(skill, temp, "replace")
                standardArray.remove(temp)
            }
        }
        assignInterests()
        return characterSkills
    }

    private fun assignInterests() {
        var interestPoints = characteristics["intelligence"]!!.value*2
        while (interestPoints > 0){
            val tempPoints = (1..6).random()*5
            when{
                interestPoints >= tempPoints -> {
                    assignValue(randomSkillList().random(), tempPoints, "addition")
                    interestPoints -= tempPoints
                }
                interestPoints in 1..4 -> interestPoints = 5
            }
        }
    }

    private fun assignValue(skill:String, skillValue:Int, function:String): Skills {
        val skillObject = characterSkills[skillParser(skill)] ?: throw error("assignValue says that $skill is not a skill!")
        return if(function == "replace"){
            skillObject.initialValue = skillValue
            skillObject
        } else{
            skillObject.initialValue += skillValue
            skillObject
        }
    }

    private fun skillParser(skill: String): String {
        if (skill.contains("-")){
            val skillPair = skill.split("-")
            return skillConstructor(skillPair)
        }
        val skillObject = characterSkills[skill] ?: throw error("skillParser says that $skill is not a skill!")
        return if (skillObject.variety.isNullOrEmpty()){
            skill
        } else {
            val map = skillObject.variety
            val skillPair = listOf(skill, map?.entries?.elementAt(Random().nextInt(map.size))!!.key)
            skillConstructor(skillPair)
        }
    }

    private fun skillConstructor(skillPair: List<String>): String {
        val skill = skillPair[0]
        val variety = skillPair[1]
        val newSkill = "$skill: $variety"
        val skillObject = characterSkills[skill] ?: throw error("skillConstructor says that $skill is not a skill!")
        val skillObjectVarietyList = skillObject.variety ?: throw error("skillConstructor says that $skill does not have a variety!")
        val skillObjectVariety = skillObjectVarietyList[variety] ?: throw error("skillConstructor says that $variety is not in the $skill list!")
        val displayNameAltered = removeOther(skillObject.displayName)
        characterSkills += newSkill to Skills(
            displayName = "$displayNameAltered: $variety",
            era = skillObject.era,
            initialValue = skillObjectVariety,
            rarity = skillObject.rarity,
            variety = null
        )
        characterSkills[skill]?.variety?.remove(variety)
        return newSkill
    }

    private fun removeOther(displayName: String): String {
        return if (displayName.contains(": Other")){
            displayName.replace(": Other", "")
        } else displayName
    }

    private fun assignCharacterSkills(tempSkills: List<String>): List<String> {
        val toReturn = mutableListOf<String>()
        val randomsAssigned = mutableListOf<String>()
        for (skill in tempSkills){
            if (skill == "random"){
                val temp = chooseRandom(randomsAssigned)
                toReturn += temp
                randomsAssigned += temp
            }
            else {
                toReturn += skill
            }
        }
        return toReturn
    }

    private fun randomSkillList(): MutableList<String> {
        val temp = mutableListOf<String>()
        for (currentSkill in characterSkills){
            when (currentSkill.value.rarity) {
                "Very Common" -> { repeat(4) { temp += currentSkill.key } }
                "Common" -> { repeat(2) { temp += currentSkill.key } }
                "Uncommon" -> { temp += currentSkill.key }
            }
        }
        return temp
    }

    private fun chooseRandom(alreadyAssigned: MutableList<String>):String{
        var toReturn:String? = null
        while(toReturn == null){
            val temp = randomSkillList().random()
            if (!occupation.careerSkills.contains(temp) && !alreadyAssigned.contains(temp)) {
                toReturn = temp
            }
        }
        return toReturn
    }
}