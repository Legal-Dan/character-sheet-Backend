val skills = Skills(50)

class Occupations {
    object antiquarian {
        val displayName = "Antiquarian"
        val careerSkills = mutableListOf(
            Skills.appraise,
            Skills.art,
            Skills.history,
            Skills.libraryUse,
            Skills.languageOther,
            skills.oneOf("charm", "fastTalk", "intimidate", "persuade"),
            Skills.spotHidden,
        )
        val randomSkill: Any = skills.randomSkill(careerSkills)



    }



}
