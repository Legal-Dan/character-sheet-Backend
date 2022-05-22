class PlayableCharacter(statsGeneration:String, highestValue: String) {
    val characteristics = Characteristics(statsGeneration, highestValue)
    val skills = Skills(characteristics.assignedCharacteristic["dexterity"]?.value ?: throw error("Dexterity not found"))
}
