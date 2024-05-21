package model

import java.time.LocalDate
import java.util.Date

data class Borrow(
    var idReader :Int ,
    var idBook :Int ,
    var lendDate : LocalDate ,
    var dueDate : LocalDate
)
