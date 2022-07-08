class Names(region:String, male:List<String>, female:List<String>, surnames:List<String>, languages:List<String>) {

    val region = region
    val male = male
    val female = female
    val surnames = surnames
    val languages = languages

    fun randomName(sex:String):String{
        return if (sex == "M"){
            "${male.random()} ${surnames.random()}"
        }
        else{
            "${female.random()} ${surnames.random()}"
        }
    }
}