package model

import java.time.LocalDate
import java.util.Date

data class Book(
    var id :Int ,
    var name :String ,
    var price : String  ,
    var Section : String ,
    var author :String ,
    var publisher :String ,
    var PublicationDate : String ,
    var language : String

){
    override fun toString(): String {
        return ("\t \t      Id : $id \n " +
                "\t \t    Name : $name \n " +
                "\t \t   Price : $price \n" +
                "\t \t Section : $Section \n" +
                "\t \t  Author : $author \n" +
                "\t   Publisher : $publisher \n " +
                " PublicationDate: $PublicationDate \n" +
                "\t \tlanguage : $language \n" +
                "---------------------------------------\n"

                )
    }
}