package query

import model.Author
import model.Data

class AuthorQuery {
    private var authors = Data.authorList
    private var input = QueryTools().inputHandel()

     fun addAuthor() {
        add@ while (true) {
            println("Please enter the data of the new Author ")
            val index = authors.size - 1
            val newAuthorId = authors[index].id + 1
            println("Please enter the author's name ")
            val authorName = input
            println("Please enter the author's address ")
            val authorAddress = input
            println("Please enter the author's telephone ")
            val telephone = input
            println("Please enter the author's workplace ")
            val workPlace = input

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
}