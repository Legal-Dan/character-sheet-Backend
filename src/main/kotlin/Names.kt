class Names(region:String, male:List<String>, female:List<String>, surnames:List<String>, languages:List<String>) {

    val region = region
    val male = male
    val female = female
    val surnames = surnames
    val languages = languages

    fun randomName(gender:String):String{
        return when(region) {
        "Kent" -> angloSaxonName(gender)
        "East Anglia" -> angloSaxonName(gender)
        "Essex" -> angloSaxonName(gender)
        "Mercia" -> angloSaxonName(gender)
        "Northumbria" -> angloSaxonName(gender)
        "Sussex" -> angloSaxonName(gender)
        "Wessex" -> angloSaxonName(gender)
        else -> forenameFirst(gender)
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