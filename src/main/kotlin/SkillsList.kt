class SkillsList{

val skills = mapOf<String, Skills>(
    "accounting" to Skills(
        displayName = "Accounting",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 5,
        rarity = "Common",
        variety = null
    ),
    "accountingDarkAge" to Skills(
        displayName = "Accounting",
        era = listOf<String>("darkAge"),
        value = 10,
        rarity = "Common",
        variety = null
    ),
    "animalHandling" to Skills(
        displayName = "Animal Handling",
        era = listOf<String>("classic", "modern"),
        value = 5,
        rarity = "Uncommon",
        variety = null
    ),
    "animalHandlingDarkAge" to Skills(
        displayName = "Animal Handling",
        era = listOf<String>("darkAge"),
        value = 15,
        rarity = "Common",
        variety = null
    ),
    "animalHandlingGaslight" to Skills(
        displayName = "Animal Handling",
        era = listOf<String>("gaslight"),
        value = 5,
        rarity = "Common",
        variety = null
    ),
    "anthropology" to Skills(
        displayName = "Anthropology",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 1,
        rarity = "Common",
        variety = null
    ),
    "appraise" to Skills(
        displayName = "Appraise",
        era = listOf<String>("darkAge", "gaslight", "classic", "modern"),
        value = 5,
        rarity = "Common",
        variety = null
    ),
    "archaeology" to Skills(
        displayName = "Archaeology",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 1,
        rarity = "Common",
        variety = null
    ),
    "art" to Skills(
        displayName = "Art and Craft",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 5,
        rarity = "Common",
        variety = mutableMapOf("Acting" to 5, "Carpentry" to 5, "Dancing" to 5, "Fine Art" to 5, "Forgery" to 5, "Writing" to 5, "Singing" to 5, "Photography" to 5, "Pottery" to 5, "Musician" to 5, "TechnicalDrawing" to 5)
    ),
    "artDarkAge" to Skills(
        displayName = "Art and Craft",
        era = listOf<String>("darkAge"),
        value = 5,
        rarity = "Common",
        variety = mutableMapOf("Carpentry" to 5, "Musician" to 5, "Jeweler" to 5, "Metal Working" to 5, "Leather Working" to 5, "Potions" to 5, "Singing" to 5, "Oratory" to 5, "Pottery" to 5)
    ),
    "artillery" to Skills(
        displayName = "Artillery",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 1,
        rarity = "Uncommon",
        variety = null
    ),
    "charm" to Skills(
        displayName = "Charm",
        era = listOf<String>("darkAge", "gaslight", "classic", "modern"),
        value = 15,
        rarity = "Common",
        variety = null
    ),
    "climb" to Skills(
        displayName = "Climb",
        era = listOf<String>("darkAge", "gaslight", "classic", "modern"),
        value = 20,
        rarity = "Common",
        variety = null
    ),
    "computerUse" to Skills(
        displayName = "Computer Use",
        era = listOf<String>("modern"),
        value = 5,
        rarity = "Very Common",
        variety = null
    ),
    "creditRating" to Skills(
        displayName = "Credit Rating",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 0,
        rarity = "Uncommon",
        variety = null
    ),
    "cthulhuMythos" to Skills(
        displayName = "Cthulhu Mythos",
        era = listOf<String>("darkAge", "gaslight", "classic", "modern"),
        value = 0,
        rarity = "Uncommon",
        variety = null
    ),
    "demolitions" to Skills(
        displayName = "Demolitions",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 1,
        rarity = "Uncommon",
        variety = null
    ),
    "disguise" to Skills(
        displayName = "Disguise",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 5,
        rarity = "Common",
        variety = null
    ),
    "diving" to Skills(
        displayName = "Diving",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 1,
        rarity = "Uncommon",
        variety = null
    ),
    "dodge" to Skills(
        displayName = "Dodge",
        era = listOf<String>("darkAge", "gaslight", "classic", "modern"),
        value = 0,
        rarity = "Common",
        variety = null
    ),
    "driveAuto" to Skills(
        displayName = "Drive Auto",
        era = listOf<String>("classic", "modern"),
        value = 20,
        rarity = "Common",
        variety = null
    ),
    "driveCarriage" to Skills(
        displayName = "Drive Carriage",
        era = listOf<String>("gaslight"),
        value = 20,
        rarity = "Common",
        variety = null
    ),
    "driveHorse" to Skills(
        displayName = "Drive Horses/Oxen",
        era = listOf<String>("darkAge"),
        value = 20,
        rarity = "Common",
        variety = null
    ),
    "elecRepair" to Skills(
        displayName = "Electrical Repair",
        era = listOf<String>("classic", "modern"),
        value = 10,
        rarity = "Common",
        variety = null
    ),
    "elecRepairGaslight" to Skills(
        displayName = "Electrical Repair",
        era = listOf<String>("gaslight"),
        value = 1,
        rarity = "Uncommon",
        variety = null
    ),
    "electronics" to Skills(
        displayName = "Electronics",
        era = listOf<String>("modern"),
        value = 1,
        rarity = "Common",
        variety = null
    ),
    "fastTalk" to Skills(
        displayName = "Fast Talk",
        era = listOf<String>("darkAge", "gaslight", "classic", "modern"),
        value = 5,
        rarity = "Common",
        variety = null
    ),
    "fightingBrawl" to Skills(
        displayName = "Fighting: Brawl",
        era = listOf<String>("darkAge", "gaslight", "classic", "modern"),
        value = 25,
        rarity = "Common",
        variety = null
    ),
    "fightingOther" to Skills(
        displayName = "Fighting: Other",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 5,
        rarity = "Uncommon",
        variety = mutableMapOf("Axe" to 15, "Garrote" to 15, "Sword" to 20, "Whip" to 5)
    ),
    "fightingOtherDarkAge" to Skills(
        displayName = "Fighting: Other",
        era = listOf<String>("darkAge"),
        value = 5,
        rarity = "Common",
        variety = mutableMapOf("Axe" to 15, "Flail" to 10, "Garrote" to 15, "Lance" to 15, "Mace" to 25, "Shield" to 15, "Spear" to 15, "Staff" to 15, "Sword" to 20)
    ),
    "firearmsHandgun" to Skills(
        displayName = "Firearms: Handgun",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 20,
        rarity = "Common",
        variety = null
    ),
    "firearmsRifle" to Skills(
        displayName = "Firearms: Rifle/Shotgun",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 25,
        rarity = "Common",
        variety = null
    ),
    "firearmsOther" to Skills(
        displayName = "Firearms: Other",
        era = listOf<String>("classic", "modern"),
        value = 10,
        rarity = "Uncommon",
        variety = mutableMapOf("Bow" to 15, "Flamethrower" to 10, "Machine Gun" to 10)
    ),
    "firstAid" to Skills(
        displayName = "First Aid",
        era = listOf<String>("darkAge", "gaslight", "classic", "modern"),
        value = 30,
        rarity = "Common",
        variety = null
    ),
    "insight" to Skills(
        displayName = "Insight",
        era = listOf<String>("darkAge"),
        value = 5,
        rarity = "Common",
        variety = null
    ),
    "history" to Skills(
        displayName = "History",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 5,
        rarity = "Common",
        variety = null
    ),
    "hypnosis" to Skills(
        displayName = "Hypnosis",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 1,
        rarity = "Uncommon",
        variety = null
    ),
    "intimidate" to Skills(
        displayName = "Intimidate",
        era = listOf<String>("darkAge", "gaslight", "classic", "modern"),
        value = 15,
        rarity = "Common",
        variety = null
    ),
    "jump" to Skills(
        displayName = "Jump",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 20,
        rarity = "Common",
        variety = null
    ),
    "jumpDarkAge" to Skills(
        displayName = "Jump",
        era = listOf<String>("darkAge"),
        value = 25,
        rarity = "Common",
        variety = null
    ),
    "languageOwn" to Skills(
        displayName = "Language: Own",
        era = listOf<String>("darkAge", "gaslight", "classic", "modern"),
        value = 0,
        rarity = "Uncommon",
        variety = null
    ),
    "languageOther" to Skills(
        displayName = "Language: Other",
        era = listOf<String>("darkAge","gaslight", "classic", "modern"),
        value = 1,
        rarity = "Common",
        variety = mutableMapOf<String,Int>("Latin" to 1)
    ),
    "law" to Skills(
        displayName = "Law",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 5,
        rarity = "Common",
        variety = null
    ),
    "libraryUse" to Skills(
        displayName = "Library Use",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 20,
        rarity = "Very Common",
        variety = null
    ),
    "libraryUseDarkAge" to Skills(
        displayName = "Library Use",
        era = listOf<String>("darkAge"),
        value = 5,
        rarity = "Common",
        variety = null
    ),
    "listen" to Skills(
        displayName = "Listen",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 20,
        rarity = "Very Common",
        variety = null
    ),
    "listenDarkAge" to Skills(
        displayName = "Listen",
        era = listOf<String>("darkAge"),
        value = 25,
        rarity = "Very Common",
        variety = null
    ),
    "locksmith" to Skills(
        displayName = "Locksmith",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 1,
        rarity = "Common",
        variety = null
    ),
    "mechRepair" to Skills(
        displayName = "Mechanical Repair",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 10,
        rarity = "Common",
        variety = null
    ),
    "medicine" to Skills(
        displayName = "Medicine",
        era = listOf<String>("darkAge", "gaslight", "classic", "modern"),
        value = 1,
        rarity = "Common",
        variety = null
    ),
    "naturalWorld" to Skills(
        displayName = "Natural World",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 10,
        rarity = "Common",
        variety = null
    ),
    "naturalWorldDarkAge" to Skills(
        displayName = "Natural World",
        era = listOf<String>("darkAge"),
        value = 20,
        rarity = "Common",
        variety = mutableMapOf("Forest" to 20, "Sea" to 20, "Desert" to 20)
    ),
    "navigate" to Skills(
        displayName = "Navigate",
        era = listOf<String>("darkAge", "gaslight", "classic", "modern"),
        value = 10,
        rarity = "Common",
        variety = null
    ),
    "occult" to Skills(
        displayName = "Occult",
        era = listOf<String>("darkAge", "gaslight", "classic", "modern"),
        value = 5,
        rarity = "Common",
        variety = null
    ),
    "operateHeavyMachinery" to Skills(
        displayName = "Operate Heavy Machinery",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 1,
        rarity = "Common",
        variety = null
    ),
    "otherKingdom" to Skills(
        displayName = "Other Kingdom",
        era = listOf<String>("darkAge"),
        value = 20,
        rarity = "Common",
        variety = mutableMapOf()
    ),
    "ownKingdom" to Skills(
        displayName = "Own Kingdom",
        era = listOf<String>("darkAge"),
        value = 20,
        rarity = "Common",
        variety = null
    ),
    "persuade" to Skills(
        displayName = "Persuade",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 10,
        rarity = "Common",
        variety = null
    ),
    "persuadeDarkAge" to Skills(
        displayName = "Persuade",
        era = listOf<String>("darkAge"),
        value = 15,
        rarity = "Common",
        variety = null
    ),
    "pilot" to Skills(
        displayName = "Pilot",
        era = listOf<String>("classic", "modern"),
        value = 1,
        rarity = "Common",
        variety = mutableMapOf("Aircraft" to 1, "Boat" to 1)
    ),
    "pilotGaslight" to Skills(
        displayName = "Pilot",
        era = listOf<String>("gaslight"),
        value = 1,
        rarity = "Common",
        variety = mutableMapOf("Balloon" to 1, "Boat" to 1)
    ),
    "pilotBoatDarkAge" to Skills(
        displayName = "Pilot Boat",
        era = listOf<String>("darkAge"),
        value = 1,
        rarity = "Common",
        variety = null
    ),
    "rangedWeapon" to Skills(
        displayName = "Ranged Weapon: Bow",
        era = listOf<String>("gaslight"),
        value = 15,
        rarity = "Uncommon",
        variety = null
    ),
    "rangedWeaponDarkAge" to Skills(
        displayName = "Ranged Weapon",
        era = listOf<String>("darkAge"),
        value = 10,
        rarity = "Common",
        variety = mutableMapOf("Bow" to 10, "Crossbow" to 10, "Sling" to 20, "War Engine" to 10)
    ),
    "readAndWrite" to Skills(
        displayName = "Read and Write",
        era = listOf<String>("darkAge"),
        value = 1,
        rarity = "Common",
        variety = mutableMapOf("Arabic" to 1, "Old English" to 1, "Old French" to 1, "Old German" to 1, "Own" to 1, "Hebrew" to 1, "Latin" to 1, "Old Norse" to 1, "Occitan" to 1, "Slavonic" to 1, "Syriac" to 1)
    ),
    "repairDevise" to Skills(
        displayName = "Repair/Devise",
        era = listOf<String>("darkAge"),
        value = 20,
        rarity = "Common",
        variety = null
    ),
    "religion" to Skills(
        displayName = "Religion",
        era = listOf<String>("darkAge"),
        value = 20,
        rarity = "Common",
        variety = null
    ),
    "psychoanalysis" to Skills(
        displayName = "Psychoanalysis",
        era = listOf<String>("classic", "modern"),
        value = 1,
        rarity = "Common",
        variety = null
    ),
    "psychology" to Skills(
        displayName = "Psychology",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 10,
        rarity = "Common",
        variety = null
    ),
    "readLips" to Skills(
        displayName = "Read Lips",
        era = listOf<String>("darkAge", "gaslight", "classic", "modern"),
        value = 1,
        rarity = "Uncommon",
        variety = null
    ),
    "ride" to Skills(
        displayName = "Ride",
        era = listOf<String>("darkAge", "gaslight", "classic", "modern"),
        value = 5,
        rarity = "Common",
        variety = null
    ),
    "sciences" to Skills(
        displayName = "Science",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 1,
        rarity = "Common",
        variety = mutableMapOf("Agriculture" to 1, "Astronomy" to 1, "Biology" to 1, "Chemistry" to 1, "Geology" to 1, "Mathematics" to 1, "Pharmacology" to 1, "Physics" to 1)
    ),
    "sciencesDarkAge" to Skills(
        displayName = "Science",
        era = listOf<String>("darkAge"),
        value = 1,
        rarity = "Common",
        variety = mutableMapOf("Astronomy" to 1, "Geometry" to 1, "Mathematics" to 1)
    ),
    "sleightOfHand" to Skills(
        displayName = "Sleight of Hand",
        era = listOf<String>("darkAge", "gaslight", "classic", "modern"),
        value = 10,
        rarity = "Common",
        variety = null
    ),
    "spotHidden" to Skills(
        displayName = "Spot Hidden",
        era = listOf<String>("darkAge", "gaslight", "classic", "modern"),
        value = 25,
        rarity = "Very Common",
        variety = null
    ),
    "status" to Skills(
        displayName = "Status",
        era = listOf<String>("darkAge"),
        value = 0,
        rarity = "Uncommon",
        variety = null
    ),
    "stealth" to Skills(
        displayName = "Stealth",
        era = listOf<String>("darkAge", "gaslight", "classic", "modern"),
        value = 20,
        rarity = "Common",
        variety = null
    ),
    "survival" to Skills(
       displayName = "Survival",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 10,
        rarity = "Common",
        variety = mutableMapOf("Desert" to 10, "Sea" to 10, "Arctic" to 10)
    ),
    "swim" to Skills(
        displayName = "Swim",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 20,
        rarity = "Common",
        variety = null
    ),
    "swimDarkAge" to Skills(
        displayName = "Swim",
        era = listOf<String>("darkAge"),
        value = 25,
        rarity = "Common",
        variety = null
    ),
    "throwSkill" to Skills(
        displayName = "Throw",
        era = listOf<String>("gaslight", "classic", "modern"),
        value = 20,
        rarity = "Common",
        variety = null
    ),
    "throwSkillDarkAge" to Skills(
        displayName = "Throw",
        era = listOf<String>("darkAge"),
        value = 25,
        rarity = "Common",
        variety = null
    ),
    "track" to Skills(
        displayName = "Track",
        era = listOf<String>("darkAge", "gaslight", "classic", "modern"),
        value = 10,
        rarity = "Common",
        variety = null)
    )}