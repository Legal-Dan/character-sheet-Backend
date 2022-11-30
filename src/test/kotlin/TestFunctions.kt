class TestFunctions {
    fun characterSkills(era: String): MutableMap<String, Skills> {
        return mutableMapOf(
        "dodge" to Skills("dodge", "Dodge", listOf(era), 0, "Common", null),
        "languageAOwn" to Skills("languageAOwn", "languageaown", listOf(era), 0, "Common", null),
        "creditRating" to Skills("creditRating", "Credit Rating", listOf(era), 0, "Common", null),
        "sciences" to Skills("sciences", "Sciences", listOf(era), 0, "Common", mutableMapOf("Agriculture" to 0)),
        "driveAuto" to Skills("driveAuto", "Drive Auto", listOf(era), 0, "Common", null),
        "mechRepair" to Skills("mechRepair", "Mechanical Repair", listOf(era), 0, "Common", null),
        "naturalWorld" to Skills("naturalWorld", "Natural World", listOf(era), 0, "Common", null),
        "operateHeavyMachinery" to Skills("operateHeavyMachinery", "Operate Heavy Machinery", listOf(era), 0, "Common", null),
        "track" to Skills("track", "Track", listOf(era), 0, "Common", null),
        "charm" to Skills("charm", "Charm", listOf(era), 0, "Common", null),
        "fastTalk" to Skills("fastTalk", "Fast Talk", listOf(era), 0, "Common", null),
        "intimidate" to Skills("intimidate", "Intimidate", listOf(era), 0, "Common", null),
        "persuade" to Skills("persuade", "Persuade", listOf(era), 0, "Common", null)
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