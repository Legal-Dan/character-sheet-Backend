val occupations = mapOf<String, Occupations>(
    "Antiquarian" to Occupations(
        displayName = "Antiquarian",
        era = listOf<String>("classic"),
        careerSkills = listOf("creditRating", "appraise", "art", "history", "libraryUse", "languageOther", "spotHidden", "random",
            oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))),
        creditRatingLow = 30,
        creditRatingHigh = 70,
        occupationPoints = listOf("education", "education", "education", "education")))
private fun oneOf(options: List<String>): String {
    return options.random()
}

