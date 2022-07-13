class Names(region:String, male:List<String>, female:List<String>, surnames:List<String>, languages:List<String>) {

    val region = region
    val male = male
    val female = female
    val surnames = surnames
    val languages = languages

    fun randomName(gender:String):String{
        return when(region) {
            "Kent", "East Anglia", "Essex", "Mercia", "Northumbria", "Sussex", "Wessex" -> angloSaxonName(gender)
            "Britons", "Burgundy", "Franks", "German Empire" -> forenameOnly(gender)
            else -> forenameFirst(gender)
        }
    }

    private fun forenameOnly(gender: String): String {
        return when (gender){
            "male" -> "${male.random()}"
            "female" -> "${female.random()}"
            else -> listOf("${male.random()}", "${female.random()}").random()
        }
    }

    private fun forenameFirst(gender: String): String {
        return when (gender){
            "male" -> "${male.random()} ${surnames.random()}"
            "female" -> "${female.random()} ${surnames.random()}"
            else -> listOf("${male.random()} ${surnames.random()}", "${female.random()} ${surnames.random()}").random()
        }
    }

    private fun angloSaxonName(gender: String): String {
        return when (gender){
            "male" -> "${surnames.random()}${male.random()}"
            "female" -> "${surnames.random()}${female.random()}"
            else -> listOf("${surnames.random()}${male.random()}", "${surnames.random()}${female.random()}").random()
        }
    }
}