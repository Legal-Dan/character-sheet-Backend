class Characteristics(statsGeneration: String, highestValue: String, private val age: Int) {
    private val charValues = mutableListOf(70, 60, 60, 50, 50, 50, 40, 40)
    private val toAssign = mutableListOf("strength", "dexterity", "intelligence", "constitution", "appearance", "power", "size", "education")
    private val baseCharacteristic:MutableMap<String, Characteristic> = assignCharacteristics(statsGeneration, highestValue)
    val updatedCharacteristic:MutableMap<String, Characteristic> = finaliseCharacteristics(statsGeneration)

    private fun assignCharacteristics(statsGeneration: String, highestValue: String): MutableMap<String, Characteristic> {
        return if (statsGeneration == "standard"){
            assignStandardCharacteristics(highestValue)
        } else{
            rollStatistics(highestValue)
        }
    }

    private fun rollStatistics(highestValue: String): MutableMap<String, Characteristic> {
        val assignedCharacteristicsWorking: MutableMap<String, Characteristic>
        val values3d6 = mutableListOf(roll3d6(), roll3d6(), roll3d6(), roll3d6(), roll3d6())
        values3d6.sortDescending()
        val stats3d6 = mutableListOf("strength", "dexterity", "constitution", "appearance", "power")
        val values2d6 = mutableListOf(roll2d6(), roll2d6(), roll2d6())
        values2d6.sortDescending()
        val stats2d6 = mutableListOf("intelligence", "size", "education")

        fun createRandomCharacteristic(name:String): Characteristic {
            return if (stats3d6.contains(name)){
                val randomValue = values3d6.random()
                stats3d6.remove(name)
                values3d6.remove(randomValue)
                createCharacteristic(name, randomValue)
            } else {
                val randomValue = values2d6.random()
                stats2d6.remove(name)
                values2d6.remove(randomValue)
                createCharacteristic(name, randomValue)
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

    private fun roll3d6():Int{
        return ((1..6).random() + (1..6).random() + (1..6).random())*5
    }

    private fun roll2d6():Int{
        return ((1..6).random() + (1..6).random() + 6)*5
    }

    private fun assignStandardCharacteristics(highestValue: String): MutableMap<String, Characteristic> {
        val assignedCharacteristicsWorking = if (highestValue != "") {
            mutableMapOf(highestValue to createCharacteristic(highestValue, 70))
        } else{
            mutableMapOf("strength" to createCharacteristic("strength", charValues.random()))
        }

        while ((toAssign).size != 0){
            assignedCharacteristicsWorking += toAssign[0] to createCharacteristic(toAssign[0], charValues.random())
        }
        assignedCharacteristicsWorking += "luck" to createCharacteristic("luck", roll3d6())
        return assignedCharacteristicsWorking
    }

    private fun createCharacteristic(name:String, value:Int): Characteristic {
        charValues.remove(value)
        toAssign.remove(name)
        return  Characteristic(name, value)
    }

    private fun updateCharacteristic(characteristic:Characteristic, newValue:Int):MutableMap<String, Characteristic>{
        baseCharacteristic.remove(characteristic.name)
        baseCharacteristic += characteristic.name to createCharacteristic(characteristic.name, newValue)
        return baseCharacteristic
    }

    private fun finaliseCharacteristics(statsGeneration: String): MutableMap<String, Characteristic> {
        ageEffects(statsGeneration)
        baseCharacteristic += "hp" to Characteristic("hp", assignHp())
        baseCharacteristic += "build" to Characteristic("build", assignBuild())
        baseCharacteristic += "move" to Characteristic("move", assignMove())
        baseCharacteristic += "magic" to Characteristic("magic", assignMagic())
        return baseCharacteristic
    }

    private fun assignMagic(): Int {
        return baseCharacteristic["power"]!!.value/5
    }

    private fun assignMove(): Int {
        return if (baseCharacteristic["strength"]!!.value < baseCharacteristic["size"]!!.value &&
            baseCharacteristic["dexterity"]!!.value < baseCharacteristic["size"]!!.value) moveAgeModifier(7)
        else if (baseCharacteristic["strength"]!!.value > baseCharacteristic["size"]!!.value &&
            baseCharacteristic["dexterity"]!!.value > baseCharacteristic["size"]!!.value) moveAgeModifier(9)
        else moveAgeModifier(8)
    }

    private fun moveAgeModifier(baseMove: Int): Int {
        return when (age) {
            in 40..49 -> baseMove - 1
            in 50..59 -> baseMove - 2
            in 60..69 -> baseMove - 3
            in 70..79 -> baseMove - 4
            in 80..89 -> baseMove - 5
            else -> baseMove
        }
    }

    private fun assignHp(): Int {
        return (baseCharacteristic["constitution"]!!.value + baseCharacteristic["size"]!!.value)/10
    }

    private fun assignBuild(): Int {
        return when(baseCharacteristic["strength"]!!.value + baseCharacteristic["size"]!!.value){
            in 2..64 -> -2
            in 65..84 -> -1
            in 85..124 -> 0
            in 125..164 -> 1
            else -> 2
        }
    }
    
    private fun ageEffects(statsGeneration: String):MutableMap<String, Characteristic>{
        if (statsGeneration != "standard"){
            when (age){
                in 15..19 -> {
                    lowerStats(1, "strength", "size")
                    lowerStats(1, "education")
                    extraLucky()
                }
                in 20..39 -> improveEdu(1)
                in 40..49 -> {
                    improveEdu(2)
                    lowerStats(1, "strength", "constitution", "dexterity")
                    lowerStats(1, "appearance")
                }
                in 50..59 -> {
                    improveEdu(3)
                    lowerStats(2, "strength", "constitution", "dexterity")
                    lowerStats(2, "appearance")
                }
                in 60..69 -> {
                    improveEdu(4)
                    lowerStats(4, "strength", "constitution", "dexterity")
                    lowerStats(3, "appearance")
                }
                in 70..79 -> {
                    improveEdu(4)
                    lowerStats(8, "strength", "constitution", "dexterity")
                    lowerStats(4, "appearance")
                }
                in 80..89 -> {
                    improveEdu(4)
                    lowerStats(16, "strength", "constitution", "dexterity")
                    lowerStats(5, "appearance")
                }
            }
        }
        return baseCharacteristic
    }

    private fun improveEdu(numberOfTimes: Int) {
        repeat(numberOfTimes){
            if ((1..100).random() <= baseCharacteristic["education"]!!.value){
                var updatedValue = baseCharacteristic["education"]!!.value + (1..10).random()
                if (updatedValue >= 100){
                    val excessToIntelligence = baseCharacteristic["intelligence"]!!.value + updatedValue - 99
                    updatedValue = 99
                    updateCharacteristic(baseCharacteristic["intelligence"]!!, excessToIntelligence)
                }
                updateCharacteristic(baseCharacteristic["education"]!!, updatedValue)
            }
        }
    }

    private fun extraLucky() {
        val newRoll = roll3d6()
        if (newRoll > baseCharacteristic["luck"]!!.value){
            updateCharacteristic(baseCharacteristic["luck"]!!, newRoll)
        }
    }

    private fun lowerStats(amount: Int, vararg stats: String) {
        var amountRemaining = amount
        val statsRemaining = stats.toMutableList()
        while(amountRemaining>0){
            val randomAmount = (1..amountRemaining).random()*5
            val randomStat = statsRemaining.random()
            if (baseCharacteristic[randomStat]!!.value - randomAmount > 0){
                amountRemaining -= randomAmount/5
                updateCharacteristic(baseCharacteristic[randomStat]!!, baseCharacteristic[randomStat]!!.value - randomAmount)
            }
            val toRemove = mutableListOf<String>()
            statsRemaining.forEach {
                if (baseCharacteristic[it]!!.value <=5) {
                    toRemove += it
                }
            }
            statsRemaining -= toRemove.toSet()
            if (statsRemaining.size >= 1) {
                statsRemaining.forEach {
                    if (baseCharacteristic[it]!!.value <=5) statsRemaining -= it
                }
            }
            else {
                break
            }
        }
    }
}

class Characteristic(val name: String, val value: Int)