package query

import model.Data
import model.Librarian

class LibrarianQuery {

    private var librarians = Data.librarianList
    private var input = QueryTools().inputHandel()


     fun librarianSignin() {
        if (QueryTools().signIn(librarians)) {
            println(
                "Signed in Successfully \n" +
                        "------------------------- "
            )

            val message = "Please select your inquiry from the menu below , type the number of selection ! \n" +
                    "1- Register new librarian\n" +
                    "2- Register new reader\n" +
                    "3- Add new book\n" +
                    "4- Add new Author\n" +
                    "5- Add new publisher\n" +
                    "6- check available books\n" +
                    "7- Borrow book to reader\n" +
                    "8- Check Books due for return\n" +
                    "9- Sign out \n"

            Selection().select(
                message,
                { librarianRegister() },
                { ReaderQuery().readerRegister() },
                { BookQuery().addBook() },
                { AuthorQuery().addAuthor() },
                { PublisherQuery().addPublisher() },
                { BookQuery().availableBooks() },
                { BookQuery().borrowBook() },
                { BookQuery().dueBooks() },
                { QueryTools().system() },
            )
        }
    }

     private fun librarianRegister() {
        add@ while (true) {
            println("Please enter the data of the new librarian ")
            val index = librarians.size - 1
            val newId = librarians[index].id + 1
            println("Please enter the librarian's UserName ")
            val userName = input
            println("Please enter the librarian's Password ")
            val password = input
            println("Please enter the librarian's Name ")
            val name = input
            println("Please enter the librarian's address ")
            val address = input
            println("Please enter the librarian's Telephone ")
            val telephone = input
            println("Please enter the librarian's Position ")
            val position = input

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
                        librarians.add(newLibrarian)
                        println("${newLibrarian.name} added as anew user Successfully ")
                        println("------------------------------------------------------")
                        break@add
                    }

                    2 -> {
                        continue@add
                    }

                    else -> {
                        println("Wrong Selection !! Retry")
                        continue@save
                    }
                }
            }
        }

    }

}