package model

data class Author(
    override var id :Int,
    override var name : String,
    override var address :String,
    override var telelphone : String ,
    var workPlace :String
):Human(id , name , address , telelphone){

    override fun toString(): String {
        return (" \t      Id : $id \n " +
                " \t    Name : $name \n " +
                " \t Address : $address \n" +
                "  Telephone : $telelphone \n" +
                " Work Place : $workPlace \n"
                )
    }
}
