class CharacterApp(reader: Reader) {
    private val reader = reader

    fun run(){
        println("Character name:")
        val name = reader.getNextLine()
        println("Standard characteristics or roll:")
        val statsGeneration = reader.getNextLine()
        val highestValue: String
        if (statsGeneration == "standard") {
            println("Highest value (or leave blank for random):")
            val input = reader.getNextLine()
            if (input != ""){
                highestValue = input
            } else {
                highestValue = "none"}
        } else {
            highestValue = "none"
        }
        var character = ""
        for (characteristic in PlayableCharacter(statsGeneration, highestValue).characteristics.assignedCharacteristic){
            character += ", " + characteristic.key + ": " + characteristic.value
        }
        println("$name's stats are${character}")
    }
}