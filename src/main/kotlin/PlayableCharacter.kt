class PlayableCharacter(statsGeneration:String, highestValue: String) {
    val characteristics = Characteristics(statsGeneration, highestValue)
    val characterSkills = skills

    val occupations = Occupations(characterSkills)
}
