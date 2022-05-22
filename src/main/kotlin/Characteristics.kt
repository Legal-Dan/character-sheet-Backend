class Characteristics(statsGeneration:String, highestValue:String) {
    val charValues = mutableListOf(70, 60, 60, 50, 50, 50, 40, 40)
    val toAssign = mutableListOf("strength", "dexterity", "intelligence", "constitution", "appearance", "power", "size", "education")
    val assignedCharacteristic:MutableMap<String, Characteristic> = assignCharacteristics(statsGeneration, highestValue)

    fun assignCharacteristics(statsGeneration: String, highestValue: String): MutableMap<String, Characteristic> {
        if (statsGeneration == "standard"){
            return assignStandardCharacteristics(highestValue)
        }
        else{
            return rollStatistics(highestValue)
        }
    }

    fun rollStatistics(highestValue: String): MutableMap<String, Characteristic> {
        val assignedCharacteristicsWorking: MutableMap<String, Characteristic>
        val values3d6 = mutableListOf(roll3d6(), roll3d6(), roll3d6(), roll3d6(), roll3d6())
        values3d6.sortDescending()
        val stats3d6 = mutableListOf("strength", "dexterity", "constitution", "appearance", "power")
        val values2d6 = mutableListOf(roll2d6(), roll2d6(), roll2d6())
        values2d6.sortDescending()
        val stats2d6 = mutableListOf("intelligence", "size", "education")

        fun createRandomCharacteristic(name:String): Characteristic {
            if (stats3d6.contains(name)){
                val randomValue = values3d6.random()
                stats3d6.remove(name)
                values3d6.remove(randomValue)
                return createCharacteristic(name, randomValue)
            }
            else {
                val randomValue = values2d6.random()
                stats2d6.remove(name)
                values2d6.remove(randomValue)
                return createCharacteristic(name, randomValue)
            }
        }

        if (stats3d6.contains(highestValue)) {
            assignedCharacteristicsWorking = mutableMapOf(highestValue to createCharacteristic(highestValue, values3d6[0]))
            values3d6.remove(values3d6[0])
            stats3d6.remove(highestValue)
        }
        else if (stats2d6.contains(highestValue)) {
            assignedCharacteristicsWorking = mutableMapOf(highestValue to createCharacteristic(highestValue, values2d6[0]))
            values2d6.remove(values2d6[0])
            stats2d6.remove(highestValue)
        }
        else{
            assignedCharacteristicsWorking = mutableMapOf("strength" to createRandomCharacteristic("strength"))
        }

        while ((toAssign).size != 0){
            assignedCharacteristicsWorking += toAssign[0] to createRandomCharacteristic(toAssign[0])
        }
        assignedCharacteristicsWorking += "luck" to createCharacteristic("luck", roll3d6())
        return assignedCharacteristicsWorking

    }

    fun roll3d6():Int{
        return ((1..6).random() + (1..6).random() + (1..6).random())*5
    }

    fun roll2d6():Int{
        return ((1..6).random() + (1..6).random() + 6)*5
    }

    fun assignStandardCharacteristics(highestValue: String): MutableMap<String, Characteristic> {
        val assignedCharacteristicsWorking: MutableMap<String, Characteristic>
        if (highestValue != "none") {
            assignedCharacteristicsWorking = mutableMapOf(highestValue to createCharacteristic(highestValue, 70))
        }
        else{
            assignedCharacteristicsWorking = mutableMapOf("strength" to createCharacteristic("strength", charValues.random()))
        }

        while ((toAssign).size != 0){
            assignedCharacteristicsWorking += toAssign[0] to createCharacteristic(toAssign[0], charValues.random())
        }
        assignedCharacteristicsWorking += "luck" to createCharacteristic("luck", roll3d6())
        return assignedCharacteristicsWorking
    }

    fun createCharacteristic(name:String, value:Int): Characteristic {
        charValues.remove(value)
        toAssign.remove(name)
        return  Characteristic(name, value)
    }

    fun updateCharacteristic(characteristic:Characteristic, newValue:Int):MutableMap<String, Characteristic>{
        assignedCharacteristic.remove(characteristic.name)
        assignedCharacteristic += characteristic.name to createCharacteristic(characteristic.name, newValue)
        return assignedCharacteristic
    }
}

class Characteristic(name:String, value:Int) {
    val name = name
    val value = value
}