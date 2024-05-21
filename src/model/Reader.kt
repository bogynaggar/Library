package model

data class Reader(
    override var id: Int ,
    var userName :String,
    var password :String,
    override var name: String ,
    override var address: String ,
    override var telelphone: String ,
    var rank :String ,
    var gender : String
):Human(id, name, address, telelphone)
