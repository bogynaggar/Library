package model

data class Book(
    var id :Int ,
    var name :String ,
    var price : Int = 0 ,
    var type : String ,
    var author :String ,
    var publisher :String
)