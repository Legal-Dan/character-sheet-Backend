class OccupationsList{
val occupations = mapOf(
    "Adventurer" to Occupations(
        displayName = "Adventurer",
        era = listOf("gaslight"),
        careerSkills = listOf("creditRating", "sleightOfHand", "fastTalk", "languageOther", "charm", "psychology", "art") +
            multipleOf(listOf("disguise", "firstAid", "locksmith", "ride" ), 2),
        creditRatingLow = 5,
        creditRatingHigh = 25,
        occupationPoints = listOf("education", "education", "appearance", "appearance")
    ),
    "Antiquarian" to Occupations(
        displayName = "Antiquarian",
        era = listOf("gaslight", "classic", "modern"),
        careerSkills = listOf("creditRating", "appraise", "art", "history", "libraryUse", "languageOther", "spotHidden", "random",
            oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))),
        creditRatingLow = 30,
        creditRatingHigh = 70,
        occupationPoints = listOf("education", "education", "education", "education")
    ),
    "Archaeologist" to Occupations(
        displayName = "Archaeologist",
        era = listOf("gaslight", "classic", "modern"),
        careerSkills = listOf("creditRating", "anthropology", "archaeology", "history", "libraryUse", "languageOther", "spotHidden", "navigate",
            oneOf(listOf("climb", "demolitions", "firstAid", "naturalWorld", "occult", "survival"))),
        creditRatingLow = 30,
        creditRatingHigh = 70,
        occupationPoints = listOf("education", "education", "strength/intelligence", "strength/intelligence")
    ),
    "Aristocrat" to Occupations(
        displayName = "Aristocrat",
        era = listOf("gaslight"),
        careerSkills = listOf("creditRating", "history", "languageOther-Latin", "law", "persuade", "languageOther", "ride", "firearmsRifle", "random"),
        creditRatingLow = 65,
        creditRatingHigh = 99,
        occupationPoints = listOf("education", "education", "education", "education")
    ),
    "Artist" to Occupations(
        displayName = "Artist",
        era = listOf("gaslight", "classic", "modern"),
        careerSkills = listOf("creditRating", "art", "languageOther", "psychology", "spotHidden", "random", "random",
            oneOf(listOf("naturalWorld", "history")),oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))),
        creditRatingLow = 9,
        creditRatingHigh = 50,
        occupationPoints = listOf("education", "education", "power/dexterity", "power/dexterity")
    ),
    "Athlete" to Occupations(
        displayName = "Athlete",
        era = listOf("classic", "modern"),
        careerSkills = listOf("creditRating", "climb", "jump", "fightingBrawl", "ride", "swim", "throwSkill", "random",
            oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))),
        creditRatingLow = 9,
        creditRatingHigh = 70,
        occupationPoints = listOf("education", "education", "dexterity/strength", "dexterity/strength")
    ),
    "Author" to Occupations(
        displayName = "Author",
        era = listOf("gaslight", "classic", "modern"),
        careerSkills = listOf("creditRating", "art-Writing", "history", "libraryUse", "languageOther", "languageOwn", "psychology", "random",
            oneOf(listOf("naturalWorld", "occult"))),
        creditRatingLow = 9,
        creditRatingHigh = 30,
        occupationPoints = listOf("education", "education", "education", "education")
    ),
    "Clergy" to Occupations(
        displayName = "Member of the Clergy",
        era = listOf("gaslight", "classic", "modern"),
        careerSkills = listOf("creditRating", "psychology", "spotHidden", "stealth",
            oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))),
        creditRatingLow = 9,
        creditRatingHigh = 60,
        occupationPoints = listOf("education", "education", "education", "education")
    ),
    "Cleric" to Occupations(
        displayName = "Cleric",
        era = listOf("darkAge"),
        careerSkills = listOf("status", "charm", "libraryUseDarkAge", "persuadeDarkAge", "languageOtherDarkAge-Latin", "ownKingdom", "religion", "random",
            oneOf(listOf("readAndWrite-Latin", "readAndWrite-Own"))),
        creditRatingLow = 9,
        creditRatingHigh = 99,
        occupationPoints = listOf("education", "education", "power/appearance", "power/appearance")
    ),
    "Craftsperson" to Occupations(
        displayName = "Craftsperson",
        era = listOf("darkAge"),
        careerSkills = listOf("status", "accountingDarkAge", "charm", "artDarkAge", "fastTalk", "insight", "naturalWorldDarkAge", "ownKingdom", "random"),
        creditRatingLow = 9,
        creditRatingHigh = 60,
        occupationPoints = listOf("education", "education", "strength/dexterity", "strength/dexterity")
    ),
    "Criminal" to Occupations(
        displayName = "Criminal",
        era = listOf("classic", "modern"),
        careerSkills = listOf("creditRating", "psychology", "spotHidden", "stealth",
                oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))) +
                multipleOf(listOf("appraise", "disguise", "fightingBrawl", "fightingOther", "firearmsHandgun", "firearmsRifle", "firearmsOther-Machine Gun", "locksmith", "mechRepair", "sleightOfHand" ), 4),
        creditRatingLow = 5,
        creditRatingHigh = 65,
        occupationPoints = listOf("education", "education", "dexterity/strength", "dexterity/strength")
    ),
    "Criminal Gaslight" to Occupations(
        displayName = "Criminal",
        era = listOf("gaslight"),
        careerSkills = listOf("creditRating", "psychology", "spotHidden", "stealth",
                oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))) +
                multipleOf(listOf("appraise", "disguise", "fightingBrawl", "fightingOther", "firearmsHandgun", "firearmsRifle", "locksmith", "mechRepair", "sleightOfHand" ), 4),
        creditRatingLow = 5,
        creditRatingHigh = 65,
        occupationPoints = listOf("education", "education", "dexterity/strength", "dexterity/strength")
    ),
    "Dilettante" to Occupations(
    displayName = "Dilettante",
    era = listOf("classic", "modern"),
    careerSkills = listOf("creditRating", "art", "languageOther", "ride", "random", "random", "random",
        oneOf(listOf("firearmsHandgun", "firearmsRifle")),
        oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))),
    creditRatingLow = 50,
    creditRatingHigh = 99,
    occupationPoints = listOf("education", "education", "appearance", "appearance")
    ),
    "Doctor of Medicine" to Occupations(
    displayName = "Doctor of Medicine",
    era = listOf("classic", "modern"),
    careerSkills = listOf("creditRating", "firstAid", "languageOther-Latin", "medicine", "psychology", "sciences-Biology", "sciences-Pharmacology", "random", "random"),
    creditRatingLow = 30,
    creditRatingHigh = 80,
    occupationPoints = listOf("education", "education", "education", "education")
    ),
    "Drifter" to Occupations(
    displayName = "Drifter",
    era = listOf("classic", "modern"),
    careerSkills = listOf("creditRating", "climb", "jump", "listen", "navigate", "stealth", "random", "random",
        oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))),
    creditRatingLow = 0,
    creditRatingHigh = 5,
    occupationPoints = listOf("education", "education", "appearance/dexterity/strength", "appearance/dexterity/strength")
    ),
    "Engineer" to Occupations(
    displayName = "Engineer",
    era = listOf("classic", "modern"),
    careerSkills = listOf("creditRating", "art-TechnicalDrawing", "elecRepair", "libraryUse", "mechRepair", "operateHeavyMachinery", "sciences-Mathematics", "sciences-Physics", "random"),
    creditRatingLow = 30,
    creditRatingHigh = 60,
    occupationPoints = listOf("education", "education", "education", "education")
    ),
    "Entertainer" to Occupations(
    displayName = "Entertainer",
    era = listOf("classic", "modern"),
    careerSkills = listOf("creditRating", "art-Acting", "disguise", "listen", "psychology", "random", "random") +
        multipleOf(listOf("charm", "fastTalk", "intimidate", "persuade"), 2),
    creditRatingLow = 9,
    creditRatingHigh = 70,
    occupationPoints = listOf("education", "education", "appearance", "appearance")
    ),
    "Farmer" to Occupations(
    displayName = "Farmer",
    era = listOf("classic", "modern"),
    careerSkills = listOf("creditRating", "sciences-Agriculture", "driveAuto", "mechRepair", "naturalWorld", "operateHeavyMachinery", "track", "random",
        oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))),
    creditRatingLow = 9,
    creditRatingHigh = 30,
    occupationPoints = listOf("education", "education", "dexterity/strength", "dexterity/strength")
    ),
    "FarmerGaslight" to Occupations(
    displayName = "Farmer",
    era = listOf("gaslight"),
    careerSkills = listOf("creditRating", "sciences-Agriculture", "driveCarriage", "mechRepair", "naturalWorld", "operateHeavyMachinery", "track", "random",
        oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))),
    creditRatingLow = 9,
    creditRatingHigh = 30,
    occupationPoints = listOf("education", "education", "dexterity/strength", "dexterity/strength")
    ),
    "Hacker" to Occupations(
    displayName = "Hacker",
    era = listOf("modern"),
    careerSkills = listOf("creditRating", "computerUse", "elecRepair", "electronics", "libraryUse", "spotHidden", "random", "random",
                oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))),
    creditRatingLow = 10,
    creditRatingHigh = 70,
    occupationPoints = listOf("education", "education", "education", "education")
    ),
    "Journalist" to Occupations(
    displayName = "Journalist",
    era = listOf("classic", "modern"),
    careerSkills = listOf("creditRating", "art-Photography", "history", "libraryUse", "languageOwn", "psychology", "random", "random",
            oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))),
    creditRatingLow = 9,
    creditRatingHigh = 30,
    occupationPoints = listOf("education", "education", "education", "education")
    ),
    "Lawyer" to Occupations(
    displayName = "Lawyer",
    era = listOf("classic", "modern"),
    careerSkills = listOf("creditRating", "accounting", "law", "libraryUse", "psychology", "random", "random") +
        multipleOf(listOf("charm", "fastTalk", "intimidate", "persuade"), 2),
    creditRatingLow = 30,
    creditRatingHigh = 80,
    occupationPoints = listOf("education", "education", "education", "education")
    ),
    "Librarian" to Occupations(
    displayName = "Librarian",
    era = listOf("classic", "modern"),
    careerSkills = listOf("creditRating", "accounting", "libraryUse", "languageOther", "languageOwn", "random", "random", "random", "random"),
    creditRatingLow = 9,
    creditRatingHigh = 35,
    occupationPoints = listOf("education", "education", "education", "education")
    ),
    "Military Officer" to Occupations(
    displayName = "Military Officer",
    era = listOf("classic", "modern"),
    careerSkills = listOf("creditRating", "accounting", "navigate", "psychology", "survival", "random",
            oneOf(listOf("firearmsHandgun", "firearmsRifle"))) +
        multipleOf(listOf("charm", "fastTalk", "intimidate", "persuade"), 2),
    creditRatingLow = 20,
    creditRatingHigh = 70,
    occupationPoints = listOf("education", "education", "dexterity/strength", "dexterity/strength")
    ),
    "Missionary" to Occupations(
    displayName = "Missionary",
    era = listOf("classic"),
    careerSkills = listOf("creditRating", "art", "firstAid", "mechRepair", "medicine", "naturalWorld", "random", "random",
        oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))),
    creditRatingLow = 0,
    creditRatingHigh = 30,
    occupationPoints = listOf("education", "education", "education", "education")
    ),
    "Musician" to Occupations(
    displayName = "Musician",
    era = listOf("classic", "modern"),
    careerSkills = listOf("creditRating", "art-Musician", "listen", "psychology", "random", "random", "random", "random",
                oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))),
    creditRatingLow = 9,
    creditRatingHigh = 30,
    occupationPoints = listOf("education", "education", "dexterity/power", "dexterity/power")
    ),
    "Parapsychologist" to Occupations(
    displayName = "Parapsychologist",
    era = listOf("classic", "modern"),
    careerSkills = listOf("creditRating", "anthropology", "art-Photography", "history", "libraryUse", "occult", "languageOther", "psychology", "random"),
    creditRatingLow = 9,
    creditRatingHigh = 30,
    occupationPoints = listOf("education", "education", "education", "education")
    ),
    "Pilot" to Occupations(
    displayName = "Pilot",
    era = listOf("classic", "modern"),
    careerSkills = listOf("creditRating", "elecRepair", "mechRepair", "navigate", "operateHeavyMachinery", "pilot-Aircraft", "sciences-Astronomy", "random", "random"),
    creditRatingLow = 20,
    creditRatingHigh = 70,
    occupationPoints = listOf("education", "education", "dexterity", "dexterity")
    ),
    "Police Detective" to Occupations(
    displayName = "Police Detective",
    era = listOf("classic", "modern"),
    careerSkills = listOf("creditRating", "firearmsHandgun", "law", "listen", "psychology", "spotHidden", "random",
        oneOf(listOf("art-Acting", "disguise")),
        oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))),
    creditRatingLow = 20,
    creditRatingHigh = 50,
    occupationPoints = listOf("education", "education", "dexterity/strength", "dexterity/strength")
    ),
    "Police Officer" to Occupations(
    displayName = "Police Officer",
    era = listOf("classic", "modern"),
    careerSkills = listOf("creditRating", "fightingBrawl", "firearmsHandgun", "firstAid", "law", "psychology", "spotHidden",
        oneOf(listOf("driveAuto", "ride")),
        oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))),
    creditRatingLow = 9,
    creditRatingHigh = 30,
    occupationPoints = listOf("education", "education", "dexterity/strength", "dexterity/strength")
    ),
    "Private Investigator" to Occupations(
    displayName = "Private Investigator",
    era = listOf("classic"),
    careerSkills = listOf("creditRating", "art-Photography", "disguise", "law", "libraryUse", "psychology", "spotHidden",
        oneOf(listOf("locksmith", "firearmsHandgun")),
        oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))),
    creditRatingLow = 9,
    creditRatingHigh = 30,
    occupationPoints = listOf("education", "education", "dexterity/strength", "dexterity/strength"),
    ),
    "Private InvestigatorModern" to Occupations(
    displayName = "Private Investigator",
    era = listOf("modern"),
    careerSkills = listOf("creditRating", "art-Photography", "disguise", "law", "libraryUse", "psychology", "spotHidden",
        oneOf(listOf("computerUse", "locksmith", "firearmsHandgun")),
        oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))),
    creditRatingLow = 9,
    creditRatingHigh = 30,
    occupationPoints = listOf("education", "education", "dexterity/strength", "dexterity/strength"),
    ),
    "Professor" to Occupations(
    displayName = "Professor",
    era = listOf("classic", "modern"),
    careerSkills = listOf("creditRating", "libraryUse", "languageOther", "languageOwn", "psychology", "random", "random", "random", "random"),
    creditRatingLow = 20,
    creditRatingHigh = 70,
    occupationPoints = listOf("education", "education", "education", "education")
    ),
    "Soldier" to Occupations(
    displayName = "Soldier",
    era = listOf("classic", "modern"),
    careerSkills = listOf("creditRating", "dodge", "fightingBrawl", "firearmsRifle", "stealth", "survival",
    oneOf(listOf("climb", "swim"))) +
            multipleOf(listOf("firstAid", "mechRepair", "languageOther"), 2),
    creditRatingLow = 9,
    creditRatingHigh = 30,
    occupationPoints = listOf("education", "education", "dexterity/strength", "dexterity/strength"),
    ),
    "Tribe Member" to Occupations(
    displayName = "Tribe Member",
    era = listOf("classic", "modern"),
    careerSkills = listOf("creditRating", "climb", "naturalWorld", "listen", "occult", "spotHidden", "swim", "survival",
        oneOf(listOf("fightingBrawl", "throwSkill"))),
    creditRatingLow = 0,
    creditRatingHigh = 15,
    occupationPoints = listOf("education", "education", "dexterity/strength", "dexterity/strength"),
    ),
    "Zealot" to Occupations(
    displayName = "Zealot",
    era = listOf("classic", "modern"),
    careerSkills = listOf("creditRating", "history", "psychology", "stealth", "random", "random", "random") +
        multipleOf(listOf("charm", "fastTalk", "intimidate", "persuade"), 2),
    creditRatingLow = 0,
    creditRatingHigh = 30,
    occupationPoints = listOf("education", "education", "appearance/power", "appearance/power")
    ),
)

private fun oneOf(options: List<String>): String {
    return options.random()
}

private fun multipleOf(options: List<String>, number:Int): MutableList<String> {
    val remainingOptions = options.toMutableList()
    val toReturn = mutableListOf<String>()
    while(toReturn.size < number){
        toReturn += remainingOptions.random()
        remainingOptions.remove(toReturn.last())
    }
    return toReturn
}}