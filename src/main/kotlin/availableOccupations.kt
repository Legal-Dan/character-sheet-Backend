val occupations = mapOf<String, Occupations>(
    "Adventurer" to Occupations(
        displayName = "Adventurer",
        era = listOf<String>("gaslight"),
        careerSkills = listOf("creditRating", "sleightOfHand", "fastTalk", "languageOther", "charm", "psychology", "art",
            multipleOf(mutableListOf("disguise", "firstAid", "locksmith", "ride" ), 2)) as List<String>,
        creditRatingLow = 5,
        creditRatingHigh = 25,
        occupationPoints = listOf("education", "education", "appearance", "appearance")
    ),
    "Antiquarian" to Occupations(
        displayName = "Antiquarian",
        era = listOf<String>("gaslight", "classic", "modern"),
        careerSkills = listOf("creditRating", "appraise", "art", "history", "libraryUse", "languageOther", "spotHidden", "random",
            oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))),
        creditRatingLow = 30,
        creditRatingHigh = 70,
        occupationPoints = listOf("education", "education", "education", "education")
    ),
    "Archaeologist" to Occupations(
        displayName = "Archaeologist",
        era = listOf<String>("gaslight", "classic", "modern"),
        careerSkills = listOf("creditRating", "anthropology", "archaeology", "history", "libraryUse", "languageOther", "spotHidden", "navigate",
            oneOf(listOf("climb", "demolitions", "firstAid", "naturalWorld", "occult", "survival"))),
        creditRatingLow = 30,
        creditRatingHigh = 70,
        occupationPoints = listOf("education", "education", "strength/intelligence", "strength/intelligence")
    ),
    "Aristocrat" to Occupations(
        displayName = "Aristocrat",
        era = listOf<String>("gaslight"),
        careerSkills = listOf("creditRating", "history", "languageOther-Latin", "law", "persuade", "languageOther", "ride", "firearmsRifle", "random"),
        creditRatingLow = 65,
        creditRatingHigh = 99,
        occupationPoints = listOf("education", "education", "education", "education")
    ),
    "Artist" to Occupations(
        displayName = "Artist",
        era = listOf<String>("gaslight", "classic", "modern"),
        careerSkills = listOf("creditRating", "art", "languageOther", "psychology", "spotHidden", "random", "random",
            oneOf(listOf("naturalWorld", "history")),oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))),
        creditRatingLow = 9,
        creditRatingHigh = 50,
        occupationPoints = listOf("education", "education", "power/dexterity", "power/dexterity")
    ),
    "Athlete" to Occupations(
        displayName = "Athlete",
        era = listOf<String>("classic", "modern"),
        careerSkills = listOf("creditRating", "climb", "jump", "fightingBrawl", "ride", "swim", "throw", "random",
            oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))),
        creditRatingLow = 9,
        creditRatingHigh = 70,
        occupationPoints = listOf("education", "education", "dexterity/strength", "dexterity/strength")
    ),
    "Author" to Occupations(
        displayName = "Author",
        era = listOf<String>("gaslight", "classic", "modern"),
        careerSkills = listOf("creditRating", "art-literature", "history", "libraryUse", "languageOther", "languageOwn", "psychology", "random",
            oneOf(listOf("naturalWorld", "occult"))),
        creditRatingLow = 9,
        creditRatingHigh = 30,
        occupationPoints = listOf("education", "education", "education", "education")
    ),
    "Clergy" to Occupations(
        displayName = "Member of the Clergy",
        era = listOf<String>("gaslight", "classic", "modern"),
        careerSkills = listOf("creditRating", "psychology", "spotHidden", "stealth",
            oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))),
        creditRatingLow = 9,
        creditRatingHigh = 60,
        occupationPoints = listOf("education", "education", "education", "education")
    ),
    "Cleric" to Occupations(
        displayName = "Cleric",
        era = listOf<String>("darkAge"),
        careerSkills = listOf("status", "charm", "libraryUseDarkAge", "persuadeDarkAge", "languageOtherDarkAge-Latin", "ownKingdom", "religion", "random",
            oneOf(listOf("readAndWrite-Latin", "readAndWrite-Own"))),
        creditRatingLow = 9,
        creditRatingHigh = 99,
        occupationPoints = listOf("education", "education", "power/appearance", "power/appearance")
    ),
    "Craftsperson" to Occupations(
        displayName = "Craftsperson",
        era = listOf<String>("darkAge"),
        careerSkills = listOf("status", "accountingDarkAge", "charm", "artDarkAge", "fastTalk", "insight", "naturalWorldDarkAge", "ownKingdom", "random"),
        creditRatingLow = 9,
        creditRatingHigh = 60,
        occupationPoints = listOf("education", "education", "strength/dexterity", "strength/dexterity")
    ),
    "Criminal" to Occupations(
        displayName = "Criminal",
        era = listOf<String>("gaslight", "classic", "modern"),
        careerSkills = listOf("creditRating", "appraise", "art", "history", "libraryUse", "languageOther", "spotHidden", "random",
            multipleOf(mutableListOf("appraise", "disguise", "fightingBrawl", "fightingOther", "firearmsHandgun", "firearmsRifle", "firearmsOther", "locksmith", "mechRepair", "sleightOfHand" ), 4)) as List<String>,
        creditRatingLow = 5,
        creditRatingHigh = 65,
        occupationPoints = listOf("education", "education", "dexterity/strength", "dexterity/strength")
    ),
)

private fun oneOf(options: List<String>): String {
    return options.random()
}

private fun multipleOf(options: MutableList<String>, number:Int): MutableList<String> {
    val remainingOptions = options
    val toReturn = mutableListOf<String>()
    while(toReturn.size < number){
        toReturn += remainingOptions.random()
        remainingOptions.remove(toReturn.last())
    }
    return toReturn
}

