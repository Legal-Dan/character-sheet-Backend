class Characteristics(statsGeneration:String, highestValue:String) {
    val charValues = mutableListOf(70, 60, 60, 50, 50, 50, 40, 40)
    val toAssign = mutableListOf("strength", "dexterity", "intelligence", "constitution", "appearance", "power", "size", "education")
    val assignedCharacteristic:MutableList<Characteristic> = assignCharacteristics(statsGeneration, highestValue)

    fun assignCharacteristics(statsGeneration: String, highestValue: String): MutableList<Characteristic> {
        if (statsGeneration == "standard"){
            return assignStandardCharacteristics(highestValue)
        }
        else{
            return rollStatistics(highestValue)
        }
    }

    fun rollStatistics(highestValue: String): MutableList<Characteristic> {
        val assignedCharacteristicsWorking: MutableList<Characteristic>
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
            assignedCharacteristicsWorking = mutableListOf(createCharacteristic(highestValue, values3d6[0]))
            values3d6.remove(values3d6[0])
            stats3d6.remove(highestValue)
        }
        else if (stats2d6.contains(highestValue)) {
            assignedCharacteristicsWorking = mutableListOf(createCharacteristic(highestValue, values2d6[0]))
            values2d6.remove(values2d6[0])
            stats2d6.remove(highestValue)
        }
        else{
            assignedCharacteristicsWorking = mutableListOf(createRandomCharacteristic("strength"))
        }

        while ((toAssign).size != 0){
            assignedCharacteristicsWorking += createRandomCharacteristic(toAssign[0])
        }
        assignedCharacteristicsWorking += createCharacteristic("luck", roll3d6())
        return assignedCharacteristicsWorking

    }

    fun roll3d6():Int{
        return ((1..6).random() + (1..6).random() + (1..6).random())*5
    }

    fun roll2d6():Int{
        return ((1..6).random() + (1..6).random() + 6)*5
    }

    fun assignStandardCharacteristics(highestValue: String): MutableList<Characteristic> {
        val assignedCharacteristicsWorking: MutableList<Characteristic>
        if (highestValue != "none") {
            assignedCharacteristicsWorking = mutableListOf(createCharacteristic(highestValue, 70))
        }
        else{
            assignedCharacteristicsWorking = mutableListOf(createCharacteristic("strength", charValues.random()))
        }

        while ((toAssign).size != 0){
            assignedCharacteristicsWorking += createCharacteristic(toAssign[0], charValues.random())
        }
        assignedCharacteristicsWorking += createCharacteristic("luck", roll3d6())
        return assignedCharacteristicsWorking
    }

    fun createCharacteristic(name:String, value:Int): Characteristic {
        charValues.remove(value)
        toAssign.remove(name)
        return  Characteristic(name, value)
    }

    fun updateCharacteristic(characteristic:Characteristic, newValue:Int):MutableList<Characteristic>{
        assignedCharacteristic.remove(characteristic)
        assignedCharacteristic += createCharacteristic(characteristic.name, newValue)
        return assignedCharacteristic
    }
}

class Characteristic(name:String, value:Int) {
    val name = name
    val value = value
}