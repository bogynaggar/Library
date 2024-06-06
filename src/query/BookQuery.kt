package query

import model.Book
import model.Borrow
import model.Data
import java.time.LocalDate

class BookQuery {

    private var books = Data.bookList
    private var readers = Data.readerList
    private var borrowedBooks = Data.borrowedBooksList
    private var input = QueryTools().inputHandel()
    private var intInput = QueryTools().inputHandelInt()
    private val current: LocalDate = LocalDate.now()


     fun addBook() {
        add@ while (true) {
            println("Please enter the data of the new Book ")
            val index = books.size - 1
            val newBookId = books[index].id + 1
            println("Please enter the book's name ")
            val bookName = input
            println("Please enter the book's price ")
            val bookPrice = input
            println("Please enter the book's section ")
            val bookSection = input
            println("Please enter the book's author ")
            val bookAuthor = input
            println("Please enter the book's publisher ")
            val bookPublisher = input
            println("Please enter the book's publicationDate ")
            val publicationDate = input
            println("Please enter the book's language ")
            val language = input

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

     fun availableBooks() {
        println(
            "Available books in the Library\n" +
                    "-------------------------------- "
        )
        for (i in 0..<books.size) {
            println("${i + 1} - ${books[i].name}")
        }
        println("-------------------------------- ")
    }

     fun borrowBook() {
        // var  newBorrow  = Borrow()
        while (true) {
            println("please enter the Reader Id who borrow book !")
            val readerId = intInput
            if (QueryTools().userSearch(readerId, readers)) {
                book@ while (true) {
                    println("please enter the book Id to borrow !")
                    val bookId = intInput
                    if (books.find { it.id == bookId } != null) {
                        // val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                        val dueDate = LocalDate.from(current).plusMonths(1)
                        val borrow = Borrow(readerId, bookId, current, dueDate)
                        borrowedBooks.add(borrow)
                        println(borrow.toString())
                        println( "Mission Done Successfully " +
                                "-------------------------")

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

     fun dueBooks() {
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

}