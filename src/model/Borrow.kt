package model

import java.time.LocalDate


   class Borrow(
        var idReader: Int,
        var idBook: Int,
       private var lendDate: LocalDate,
       var dueDate: LocalDate)
   {
    override fun toString(): String {
        val readerName  = Data.readerList.find { it.id == idReader }?.name.toString()
        val bookName = Data.bookList.find { it.id == idBook }?.name.toString()
        return  "\t   Reader ID : $idReader\n" +
                "\t Reader name : $readerName\n" +
                "\t   Book name : $bookName\n" +
                "\t   Lend date : $lendDate\n" +
                "\t    Due date : $dueDate\n" +
                "------------------------------------"
    }


 }


