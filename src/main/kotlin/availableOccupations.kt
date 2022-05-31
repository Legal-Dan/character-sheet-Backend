val occupations = mapOf<String, Occupations>(
    "Antiquarian" to Occupations(
        displayName = "Antiquarian",
        era = listOf<String>("classic"),
        careerSkills = listOf("appraise", "art", "history", "libraryUse", "languageOther", "spotHidden", "random",
            oneOf(listOf("charm", "fastTalk", "intimidate", "persuade"))
)))
private fun oneOf(options: List<String>): String {
    return options.random()
}

