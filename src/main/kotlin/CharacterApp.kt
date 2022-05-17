

class CharacterApp(reader: Reader) {
    private val reader = reader

    fun run(){
        println("Character name:")
        val name = reader.getNextLine()
        println("Standard characteristics or roll:")
        val statsGeneration = reader.getNextLine()
        println("Highest value (or leave blank for random):")
        val input = reader.getNextLine()
        val highestValue = if (input != "") input else "none"
        var character = ""
        for (characteristic in PlayableCharacter(statsGeneration, highestValue).characteristics.assignedCharacteristic){
            character += ", " + characteristic.name + ": " + characteristic.value
        }
        println("$name's stats are${character}")
    }
}