package model

data class Librarian(
    override var id :Int,
    var userName :String,
    var password :String,
    override var name :String,
    override var address :String,
    override var telelphone :String,
    var position :String
):Human(id , name , telelphone , address){

    override fun toString(): String {
        return (" \t      Id : $id \n " +
                " \tUserName : $userName \n " +
                " \tPassword : $password \n" +
                " \t    Name : $name \n" +
                " \t Address : $address \n" +
                "   Telephone : $telelphone \n " +
                " \tPosition : $position")

    }

}
