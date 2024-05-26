import query.SigningQuery
import model.Data
import query.Selection

fun main() {

    var data = Data()


    println("Welcome to our Library")
    val message = ("Please type number of your select what you want to do ! \n" +
            "1 - Sign in as librarian \n" +
            "2 - Sign in as Reader")



   Selection().select(
       message ,
       SigningQuery()::librarianSignin ,
       SigningQuery()::readerSignin
       )


}
