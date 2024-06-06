package query

import model.Data
import model.Publisher

class PublisherQuery {

    private var publishers = Data.publisherList
    private var input = QueryTools().inputHandel()

     fun addPublisher() {
        add@ while (true) {
            println("Please enter the data of the new publisher ")
            val index = publishers.size - 1
            val newPublisherId = publishers[index].id + 1
            println("Please enter the publisher's name ")
            val publisherName = input
            println("Please enter the publisher's address ")
            val publisherAddress = input
            println("Please enter the publisher's telephone ")
            val telephone = input
            println("Please enter the publisher's CompanyName ")
            val company = input

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
}