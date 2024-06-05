package query

import model.*
import java.time.LocalDate

class QueryTools {

    private var librarians = Data.librarianList
    private var readers = Data.readerList
    private var books = Data.bookList
    private var borrowedBooks = Data.borrowedBooksList
    private var authors = Data.authorList
    private var publishers = Data.publisherList
    private val current: LocalDate = LocalDate.now()

///  1- librarian fun ///

    private fun librarianSignin() {
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
                { readerRegister() },
                { addBook() },
                { addAuthor() },
                { addPublisher() },
                { availableBooks() },
                { borrowBook() },
                { dueBooks() },
                { system() },
            )
        }
    }

    private fun librarianRegister() {
        add@ while (true) {
            println("Please enter the data of the new librarian ")
            val index = librarians.size - 1
            val newId = librarians[index].id + 1
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

///  2- Reader Functions ///

    private fun readerSignin() {
        if (QueryTools().signIn(readers)) {
            println(
                "Signed in Successfully  \n" +
                        "--------------------------"
            )

        }
    }

    private fun readerRegister() {
        add@ while (true) {
            println("Please enter the data of the new Reader ")
            val index = readers.size - 1
            val newId = readers[index].id + 1
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
                        readers.add(newReader)
                        println("${newReader.name} added as anew reader Successfully ")
                        break
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

///  3- Book Functions ///

    private fun addBook() {
        add@ while (true) {
            println("Please enter the data of the new Book ")
            val index = books.size - 1
            val newBookId = books[index].id + 1
            println("Please enter the book's name ")
            val bookName = inputHandel()
            println("Please enter the book's price ")
            val bookPrice = inputHandel()
            println("Please enter the book's section ")
            val bookSection = inputHandel()
            println("Please enter the book's author ")
            val bookAuthor = inputHandel()
            println("Please enter the book's publisher ")
            val bookPublisher = inputHandel()
            println("Please enter the book's publicationDate ")
            val publicationDate = inputHandel()
            println("Please enter the book's language ")
            val language = inputHandel()

            val newBook =
                Book(newBookId, bookName, bookPrice, bookSection, bookAuthor, bookPublisher, publicationDate, language)

            println("you have entered these data ")
            println(newBook.toString())

            println(
                "Do you want to save this data as anew Book ? \n " +
                        "1 - yes \n " +
                        "2 - No  and retry enter data again "
            )

            save@ while (true) {
                val select = readln().toInt()
                when (select) {
                    1 -> {
                        books.add(newBook)
                        println("${newBook.name} added as anew book Successfully ")
                        break
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

    private fun availableBooks() {
        println(
            "Available books in the Library\n" +
                    "-------------------------------- "
        )
        for (i in 0..<books.size) {
            println("${i + 1} - ${books[i].name}")
        }
        println("-------------------------------- ")
    }

    private fun borrowBook() {
        // var  newBorrow  = Borrow()
        while (true) {
            println("please enter the Reader Id who borrow book !")
            val readerId = inputHandelInt()
            if (QueryTools().userSearch(readerId, readers)) {
                book@ while (true) {
                    println("please enter the book Id to borrow !")
                    val bookId = inputHandelInt()
                    if (books.find { it.id == bookId } != null) {
                        // val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                        val dueDate = LocalDate.from(current).plusMonths(1)
                        val borrow = Borrow(readerId, bookId, current, dueDate)
                        borrowedBooks.add(borrow)
                        println(borrow.toString())
                        println(
                            "Mission Done Successfully " +
                                    "-------------------------"
                        )

                    } else {
                        println("Wrong Book Id Retry!")
                        continue@book
                    }
                }
            } else {
                println("Wrong Reader Id Retry!")
                continue
            }

        }
    }

    private fun dueBooks() {
        val newDueBooks = mutableListOf<Borrow>()
        for (i in borrowedBooks) {
            if (i.dueDate.isBefore(current)) {
                newDueBooks.add(i)
                println(i.toString())

            }
        }
        println("Total number of due books is ${newDueBooks.size}")
        println("Mission Done Successfully ")
        println("-------------------------")

    }

///  4- Author Functions ///
    private fun addAuthor() {
        add@ while (true) {
            println("Please enter the data of the new Author ")
            val index = authors.size - 1
            val newAuthorId = authors[index].id + 1
            println("Please enter the author's name ")
            val authorName = inputHandel()
            println("Please enter the author's address ")
            val authorAddress = inputHandel()
            println("Please enter the author's telephone ")
            val telephone = inputHandel()
            println("Please enter the author's workplace ")
            val workPlace = inputHandel()

            val newAuthor = Author(newAuthorId, authorName, authorAddress, telephone, workPlace)

            println("you have entered these data ")
            println(newAuthor.toString())

            println(
                "Do you want to save this data as anew author ? \n " +
                        "1 - yes \n " +
                        "2 - No  and retry enter data again "
            )

            save@ while (true) {
                val select = readln().toInt()
                when (select) {
                    1 -> {
                        authors.add(newAuthor)
                        println("${newAuthor.name} added as anew author Successfully ")
                        break
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

///  5- Publisher Functions ///
    private fun addPublisher() {
        add@ while (true) {
            println("Please enter the data of the new publisher ")
            val index = publishers.size - 1
            val newPublisherId = publishers[index].id + 1
            println("Please enter the publisher's name ")
            val publisherName = inputHandel()
            println("Please enter the publisher's address ")
            val publisherAddress = inputHandel()
            println("Please enter the publisher's telephone ")
            val telephone = inputHandel()
            println("Please enter the publisher's CompanyName ")
            val company = inputHandel()

            val newPublisher = Publisher(newPublisherId, publisherName, publisherAddress, telephone, company)

            println("you have entered these data ")
            println(newPublisher.toString())

            println(
                "Do you want to save this data as anew publisher ? \n " +
                        "1 - yes \n " +
                        "2 - No  and retry enter data again "
            )

            save@ while (true) {
                val select = readln().toInt()
                when (select) {
                    1 -> {
                        publishers.add(newPublisher)
                        println("${newPublisher.name} added as anew publisher Successfully ")
                        break
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
            { librarianSignin() },
            { readerSignin() }
        )
    }

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

    private fun inputHandelInt(): Int {
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

    private fun userSearch(userName: String, list: List<User>): Boolean {
        return list.find { it.userName == userName } != null
    }

    private fun userSearch(userId: Int, list: List<User>): Boolean {
        return list.find { it.id == userId } != null
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
                        continue@password
                    }
                }

            } else {
                println("We Don't have this user in our database !! Retry ")
            }
        }
    }


}