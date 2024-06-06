package query

import model.Data
import model.Reader

class ReaderQuery {

    private var readers = Data.readerList
    private var input = QueryTools().inputHandel()


     fun readerSignin() {
        if (QueryTools().signIn(readers)) {
            println(
                "Signed in Successfully  \n" +
                        "--------------------------"
            )

        }
    }

     fun readerRegister() {
        add@ while (true) {
            println("Please enter the data of the new Reader ")
            val index = readers.size - 1
            val newId = readers[index].id + 1
            println("Please enter the reader's UserName ")
            val userName = input
            println("Please enter the reader's Password ")
            val password = input
            println("Please enter the reader's Name ")
            val name = input
            println("Please enter the reader's address ")
            val address = input
            println("Please enter the reader's Telephone ")
            val telephone = input
            println("Please enter the reader's Rank ")
            val rank = input
            println("Please enter the reader's Gender ")
            val gender = input

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

}