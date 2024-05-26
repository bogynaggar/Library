package query

import model.Data
import model.Librarian
import model.Reader
import model.User

class SigningQuery {

    private var librarian = Data().librarianList
    private var reader = Data().readerList

    ////   Librarian Functions   ////
    fun librarianSignin() {
        if (signIn(librarian)) {
            println("Signed in Successfully ")
        }
    }

    fun librarianRegister() {
        add@ while (true) {
            println("Please enter the data of the new librarian ")
            val index = librarian.size - 1
            val newId = librarian[index].id + 1
            println("Please enter the librarian's UserName ")
            val userName = inputHandel()
            println("Please enter the librarian's Password ")
            val password = inputHandel()
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
            println(newLibrarian.toString())

            println(
                "Do you want to save this data to anew librarian ? \n " +
                        "1 - yes \n " +
                        "2 - No  and retry enter data again "
            )

            save@ while (true) {
                val select = readln().toInt()
                when (select) {
                    1 -> {
                        librarian.add(newLibrarian)
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


    ////   Reader Functions   ////
    fun readerSignin() {
        if (signIn(reader)) {
            println("Signed in Successfully ")
        }
    }

    fun readerRegister() {
        add@ while (true) {
            println("Please enter the data of the new Reader ")
            val index = reader.size - 1
            val newId = reader[index].id + 1
            println("Please enter the reader's UserName ")
            val userName = inputHandel()
            println("Please enter the reader's Password ")
            val password = inputHandel()
            println("Please enter the reader's Name ")
            val name = inputHandel()
            println("Please enter the reader's address ")
            val address = inputHandel()
            println("Please enter the reader's Telephone ")
            val telephone = inputHandel()
            println("Please enter the reader's Rank ")
            val rank = inputHandel()
            println("Please enter the reader's Gender ")
            val gender = inputHandel()

            val newReader = Reader(newId, userName, password, name, address, telephone, rank, gender)

            println("you have entered these data ")
            println(newReader.toString())

            println(
                "Do you want to save this data as anew Reader ? \n " +
                        "1 - yes \n " +
                        "2 - No  and retry enter data again "
            )

            save@ while (true) {
                val select = readln().toInt()
                when (select) {
                    1 -> {
                        reader.add(newReader)
                        println("${newReader.name} added as anew reader Successfully ")
                        break
                    }

                    2 -> {
                        continue@add
                    }

                    else -> {
                        println("Wrong Selection !")
                        continue@save
                    }
                }
            }
        }

    }


    ////   Support Functions   ////
    private fun inputHandel(): String {
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

    private fun userSearch(userName: String, list: List<User>): Boolean {
        return list.find { it.userName == userName } != null
    }

    private fun signIn(list: List<User>): Boolean {
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
                    }
                }

            } else {
                println("We Don't have this user in our database !! Retry ")
            }
        }
    }


}