data class Occupations(val skills: Map<String, Skills>) {

    class Antiquarian(skills: Map<String, Skills>) {
        val displayName = "Antiquarian"
        private val interpersonalSkill:Skills? = oneOf(skills["charm"], skills["fastTalk"], skills["intimidate"], skills["persuade"])
        private val basicSkills = listOf(
            skills["appraise"],
            skills["art"],
            skills["history"],
            skills["libraryUse"],
            skills["languageOther"],
            skills["spotHidden"],
            interpersonalSkill
        )
        private val randomSkill = randomSkill(skills, basicSkills)
        val careerSkills = mutableListOf(basicSkills, randomSkill)
    }
}

private fun oneOf(vararg options: Skills?): Skills? {
    return options.random()
}

private fun randomSkill(allSkills:Map<String, Skills>, vararg exclude: List<Skills?>): Skills? {
    val availableSkills: MutableList<Skills>
        for (skill in allSkills) {
//            if ( !exclude.contains(allSkills){
//
//                TODO()
//            }

        }
    return exclude[0][0]
}
