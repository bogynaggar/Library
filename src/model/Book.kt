package model

import java.time.LocalDate
import java.util.Date

data class Book(
    var id :Int ,
    var name :String ,
    var price : Int = 0 ,
    var Section : String ,
    var author :String ,
    var publisher :String ,
    var PublicationDate : LocalDate ,
    var language : String

)