class Skills(dexterity: Int) {

    val dexterity = dexterity

    fun oneOf(vararg options: String): String {
        return options.random()}

    fun randomSkill(vararg exclude: MutableList<Any>): Any {
        return skills
    }

    object accounting {
        val displayName = "Accounting"
        val starting = 5
        val rarity = "Common"
        val variety = false
    }
    object animalHandling {
        val displayName = "Animal Handling"
        val starting = 5
        val rarity = "Uncommon"
        val variety = false
    }
    object anthropology {
        val displayName = "Anthropology"
        val starting = 1
        val rarity = "Common"
        val variety = false
    }
    object appraise {
        val displayName = "Appraise"
        val starting = 5
        val rarity = "Common"
        val variety = false
    }
    object archaeology {
        val displayName = "Archaeology"
        val starting = 1
        val rarity = "Common"
        val variety = false
    }
    object art {
        val displayName = "Art and Craft: "
        val starting = 5
        val rarity = "Common"
        val variety = mutableMapOf("Acting" to 5, "Carpentry" to 5, "Dancing" to 5, "Fine Art" to 5, "Forgery" to 5, "Writing" to 5, "Singing" to 5, "Photography" to 5, "Pottery" to 5)
    }
    object artillery {
        val displayName = "Artillery"
        val starting = 1
        val rarity = "Uncommon"
        val variety = false
    }
    object charm {
        val displayName = "Charm"
        val starting = 15
        val rarity = "Common"
        val variety = false
    }
    object climb {
        val displayName = "Climb"
        val starting = 20
        val rarity = "Common"
        val variety = false
    }
    object demolitions {
        val displayName = "Demolitions"
        val starting = 1
        val rarity = "Uncommon"
        val variety = false
    }
    object disguise {
        val displayName = "Disguise"
        val starting = 5
        val rarity = "Common"
        val variety = false
    }
    object diving {
        val displayName = "Diving"
        val starting = 1
        val rarity = "Uncommon"
        val variety = false
    }
    object dodge {
        val displayName = "Dodge"
        val starting = skills.dexterity
        val rarity = "Common"
        val variety = false
    }
    object driveAuto {
        val displayName = "Drive Auto"
        val starting = 20
        val rarity = "Common"
        val variety = false
    }
    object elecRepair {
        val displayName = "Electrical Repair"
        val starting = 10
        val rarity = "Common"
        val variety = false
    }
    object fastTalk {
        val displayName = "Fast Talk"
        val starting = 5
        val rarity = "Common"
        val variety = false
    }
    object fightingBrawl {
        val displayName = "Fighting: Brawl"
        val starting = 25
        val rarity = "Common"
        val variety = false
    }
    object fightingOther {
        val displayName = "Fighting: "
        val starting = 15
        val rarity = "Uncommon"
        val variety = mutableMapOf("Axe" to 15, "Garrote" to 15, "Sword" to 20, "Whip" to 5)
    }
    object firearmsHandgun {
        val displayName = "Firearms: Handgun"
        val starting = 20
        val rarity = "Common"
        val variety = false
    }
    object firearmsRifle {
        val displayName = "Firearms: Rifle/Shotgun"
        val starting = 25
        val rarity = "Common"
        val variety = false
    }
    object firearmsOther {
        val displayName = "Firearms: "
        val starting = 15
        val rarity = "Uncommon"
        val variety = mutableMapOf("Bow" to 15, "Flamethrower" to 10, "Machine Gun" to 10)
    }
    object firstAid {
        val displayName = "First Aid"
        val starting = 30
        val rarity = "Common"
        val variety = false
    }
    object history {
        val displayName = "History"
        val starting = 5
        val rarity = "Common"
        val variety = false
    }
    object hypnosis {
        val displayName = "Hypnosis"
        val starting = 1
        val rarity = "Uncommon"
        val variety = false
    }
    object intimidate {
        val displayName = "Intimidate"
        val starting = 15
        val rarity = "Common"
        val variety = false
    }
    object jump {
        val displayName = "Jump"
        val starting = 20
        val rarity = "Common"
        val variety = false
    }
    object languageOther {
        val displayName = "Language: "
        val starting = 1
        val rarity = "Common"
        val variety = mutableMapOf("Latin" to 1, "Spanish" to 1, "French" to 1, "German" to 1)
    }
    object law {
        val displayName = "Law"
        val starting = 5
        val rarity = "Common"
        val variety = false
    }
    object libraryUse {
        val displayName = "Library Use"
        val starting = 20
        val rarity = "Very Common"
        val variety = false
    }
    object listen {
        val displayName = "Listen"
        val starting = 20
        val rarity = "Very Common"
        val variety = false
    }
    object locksmith {
        val displayName = "Locksmith"
        val starting = 1
        val rarity = "Common"
        val variety = false
    }
    object mechRepair {
        val displayName = "Mechanical Repair"
        val starting = 10
        val rarity = "Common"
        val variety = false
    }
    object medicine {
        val displayName = "Medicine"
        val starting = 1
        val rarity = "Common"
        val variety = false
    }
    object naturalWorld {
        val displayName = "Natural World"
        val starting = 10
        val rarity = "Common"
        val variety = false
    }
    object navigate {
        val displayName = "Navigate"
        val starting = 10
        val rarity = "Common"
        val variety = false
    }
    object occult {
        val displayName = "Occult"
        val starting = 5
        val rarity = "Common"
        val variety = false
    }
    object operateHeavyMachinery {
        val displayName = "Operate Heavy Machinery"
        val starting = 1
        val rarity = "Common"
        val variety = false
    }
    object persuade {
        val displayName = "Persuade"
        val starting = 10
        val rarity = "Common"
        val variety = false
    }
    object pilot {
        val displayName = "Pilot: "
        val starting = 1
        val rarity = "Common"
        val variety = mutableMapOf("Aircraft" to 1, "Boat" to 1)
    }
    object psychoanalysis {
        val displayName = "Psychoanalysis"
        val starting = 1
        val rarity = "Common"
        val variety = false
    }
    object psychology {
        val displayName = "Psychology"
        val starting = 10
        val rarity = "Common"
        val variety = false
    }
    object readLips {
        val displayName = "Read Lips"
        val starting = 1
        val rarity = "Uncommon"
        val variety = false
    }
    object ride {
        val displayName = "Ride"
        val starting = 5
        val rarity = "Common"
        val variety = false
    }
    object sciences {
        val displayName = "Science: "
        val starting = 1
        val rarity = "Common"
        val variety = mutableMapOf("Astronomy" to 1, "Biology" to 1, "Chemistry" to 1, "Geology" to 1, "Mathematics" to 1, "Pharmacology" to 1, "Physics" to 1)
    }
    object sleightOfHand {
        val displayName = "Sleight of Hand"
        val starting = 10
        val rarity = "Common"
        val variety = false
    }
    object spotHidden {
        val displayName = "Spot Hidden"
        val starting = 25
        val rarity = "Very Common"
        val variety = false
    }
    object stealth {
        val displayName = "Stealth"
        val starting = 20
        val rarity = "Common"
        val variety = false
    }
    object survival {
        val displayName = "Survival: "
        val starting = 10
        val rarity = "Common"
        val variety = mutableMapOf("Desert" to 10, "Sea" to 10, "Arctic" to 10)
    }
    object swim {
        val displayName = "Swim"
        val starting = 20
        val rarity = "Common"
        val variety = false
    }
    object throwSkill {
        val displayName = "Throw"
        val starting = 20
        val rarity = "Common"
        val variety = false
    }
    object track {
        val displayName = "Track"
        val starting = 10
        val rarity = "Common"
        val variety = false
    }
}
