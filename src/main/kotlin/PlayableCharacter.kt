class PlayableCharacter(name:String, occupation:String, age:Int, statsGeneration:String, highestValue: String) {
    val name = name
    val occupation = occupation
    val age = age
    val statsGeneration = statsGeneration
    val highestValue = highestValue

    val characteristics = Characteristics(statsGeneration, highestValue)

//    val characterSkills = skills
//
//    val occupations = Occupations(characterSkills)
}
