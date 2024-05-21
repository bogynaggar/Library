package model

import java.util.Date

data class Borrow(
    var idReader :Int ,
    var idBook :Int ,
    var lendDate : Date ,
    var dueDate : Date
)
