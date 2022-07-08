class Names(region:String, male:List<String>, female:List<String>, surnames:List<String>, languages:List<String>) {

    val region = region
    val male = male
    val female = female
    val surnames = surnames
    val languages = languages

    fun randomName(gender:String):String{
        if (gender == "male"){
            return "${male.random()} ${surnames.random()}"
        } else if (gender == "female"){
            return "${female.random()} ${surnames.random()}"
        } else {
            return listOf("${male.random()} ${surnames.random()}", "${female.random()} ${surnames.random()}").random()
        }
    }
}