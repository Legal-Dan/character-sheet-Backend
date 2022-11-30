class TestFunctions {
    fun characterSkills(era: String): MutableMap<String, Skills> {
        return mutableMapOf(
        "dodge" to Skills("Dodge", listOf(era), 0, "Common", null),
        "languageAOwn" to Skills("languageaown", listOf(era), 0, "Common", null),
        "creditRating" to Skills("Credit Rating", listOf(era), 0, "Common", null),
        "sciences" to Skills("Sciences", listOf(era), 0, "Common", mutableMapOf("Agriculture" to 0)),
        "driveAuto" to Skills("Drive Auto", listOf(era), 0, "Common", null),
        "mechRepair" to Skills("Mechanical Repair", listOf(era), 0, "Common", null),
        "naturalWorld" to Skills("Natural World", listOf(era), 0, "Common", null),
        "operateHeavyMachinery" to Skills("Operate Heavy Machinery", listOf(era), 0, "Common", null),
        "track" to Skills("Track", listOf(era), 0, "Common", null),
        "charm" to Skills("Charm", listOf(era), 0, "Common", null),
        "fastTalk" to Skills("Fast Talk", listOf(era), 0, "Common", null),
        "intimidate" to Skills("Intimidate", listOf(era), 0, "Common", null),
        "persuade" to Skills("Persuade", listOf(era), 0, "Common", null)
    )}

//    fun assignedSkills(era:String): AssignedSkills {
//        return AssignedSkills(
//            characterSkills(era),
//            importOccupations("Farmer", "classic"),
//            "classic",
//            mutableMapOf(
//                "dexterity" to Characteristic("dexterity", 100),
//                "education" to Characteristic("education", 500),
//                "intelligence" to Characteristic("intelligence", 75)
//            ),
//            Country("CountryName", listOf("MaleName"), listOf("FemaleName"), listOf("Surname"), listOf("MyLanguage"))
//        )
//    }
}