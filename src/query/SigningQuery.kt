package query

import model.Data
import model.Librarian

class SigningQuery {

    var librarian = Data().librarianList
    var reader = Data().readerList

    fun librarianSearch (userName :String): Boolean {
        return librarian.find { it.userName == userName}!= null
    }

    fun librarianSignin (){
        while (true){
        println("Please enter your user name ")
        val userName = readlnOrNull().toString()
        if (SigningQuery().librarianSearch(userName)) {
            val signedlibrarian = Data().librarianList.find { it.userName == userName }
            val name = signedlibrarian?.name
            println("Welcome $name")
            break
        } else {
            println("We Don't have this user in our database")

        }

        }

    }

    fun librarianSignUp (){
        add@while (true) {
            println("Please enter the data of new librarian ")
            val index = librarian.size - 1
            val newId = librarian[index].id + 1
            println("Please enter the librarian's UserName ")
            val userName =  inputHandel()
            println("Please enter the librarian's Password ")
            val password =  inputHandel()
            println("Please enter the librarian's Name ")
            val name = inputHandel()
            println("Please enter the librarian's address ")
            val address = inputHandel()
            println("Please enter the librarian's Telephone ")
            val telephone = inputHandel()
            println("Please enter the librarian's Position ")
            val position = inputHandel()

            val newLibrarian = Librarian(newId, userName, password, name, address, telephone, position)

            println("you have entered these data ")
            println(newLibrarian.toString() )

            println("Do you want to save this data to anew librarian ? \n " +
                    "1 - yes \n " +
                    "2 - No  and retry enter data again ")

            save@while (true){
                val select = readln().toInt()
                when (select){
                   1 -> {librarian.add(newLibrarian)
                   println("${newLibrarian.name} added as anew user Successfully ")
                    break
                   }
                   2 -> {
                   continue@add
                   }
                    else -> {
                    println("Wrong Choice !")
                    continue@save
                  }
            }
          }
        }

    }

    fun readerSearch(userName :String): Boolean{
        return reader.find { it.userName == userName}!= null
    }

    fun readerSignin (){
        while (true){
            println("Please enter your user name ")
            val userName = readlnOrNull().toString()
            if (SigningQuery().readerSearch(userName)) {
                val signedReader = Data().readerList.find { it.userName == userName }
                val name = signedReader?.name
                println("Welcome $name")

                break
            } else {
                println("We Don't have this user in our database")

            }

        }
    }


    fun inputHandel(): String {
        while (true){
            val input = readln()
            when {
                 input.isEmpty() -> {
                 println("You didn't put anything retry ")
                     continue
                 }
            }
        return input

      }
    }

}