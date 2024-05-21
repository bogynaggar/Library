package model

data class Librarian(
    override var id :Int,
    var userName :String,
    var password :String,
    override var name :String,
    override var address :String,
    override var telelphone :String,
    var position :String
):Human(id , name , telelphone , address)
