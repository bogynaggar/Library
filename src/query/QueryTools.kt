package query

import model.*
import java.time.LocalDate

class QueryTools {

/*
  private var librarians = Data.librarianList
    private var readers = Data.readerList
    private var books = Data.bookList
    private var borrowedBooks = Data.borrowedBooksList
    private var authors = Data.authorList
    private var publishers = Data.publisherList
    private val current: LocalDate = LocalDate.now()
 */

///  1- librarian fun ///

///  2- Reader Functions ///

///  3- Book Functions ///

///  4- Author Functions ///

///  5- Publisher Functions ///

///  6- Support Functions ///

    fun system() {
        println(
                    "\t||===============================||\n" +
                    "\t||   Welcome to Library System   ||\n" +
                    "\t||===============================||"
        )
        val message = ("Please select your inquiry from the menu below , type the number of selection !\n" +
                "1 - Sign in as librarian \n" +
                "2 - Sign in as Reader")

        Selection().select(
            message,
            { LibrarianQuery().librarianSignin() },
            { ReaderQuery().readerSignin() }
        )
    }

     fun inputHandel(): String {
        while (true) {
            val input = readln()
            when {
                input.isEmpty() -> {
                    println("You didn't enter anything !! Retry ")
                    continue
                }
            }
            return input

        }
    }

     fun inputHandelInt(): Int {
        while (true) {
            try {
                val input = readln()
                when {
                    input.isEmpty() -> {
                        println("You didn't enter anything !! Retry ")
                        continue
                    }
                }
                return input.toInt()

            } catch (e: Exception) {
                println("Please enter a number !! Retry ")
                continue
            }

        }
    }

     fun userSearch(userName: String, list: List<User>): Boolean {
        return list.find { it.userName == userName } != null
    }

     fun userSearch(userId: Int, list: List<User>): Boolean {
        return list.find { it.id == userId } != null
    }

     fun signIn(list: List<User>): Boolean {
        username@ while (true) {
            println("Please enter your user name ")
            val userName = inputHandel()
            if (userSearch(userName, list)) {
                val signedUser = list.find { it.userName == userName }
                val name = signedUser?.name
                val password = signedUser?.password
                password@ while (true) {
                    println("Please enter your Password ")
                    val inputPassword = inputHandel()
                    if (inputPassword == password) {
                        println("Welcome $name")
                        return true
                    } else {
                        println("Wrong Password !! retry ")
                        continue@password
                    }
                }

            } else {
                println("We Don't have this user in our database !! Retry ")
            }
        }
    }


}