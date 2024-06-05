package model

data class Publisher(
    override var id :Int,
    override var name :String,
    override var address :String,
    override var telelphone :String,
    var companyName :String
):Human(id , name , telelphone , address){

    override fun toString(): String {
        return (" \t      Id : $id \n " +
                " \t    Name : $name \n " +
                " \t Address : $address \n" +
                "  Telephone : $telelphone \n" +
                "Company name : $companyName \n"
                )
    }
}
