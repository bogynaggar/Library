package model

data class Publisher(
    override var id :Int,
    override var name :String,
    override var address :String,
    override var telelphone :String,
    var companyName :String
):Human(id , name , telelphone , address)
