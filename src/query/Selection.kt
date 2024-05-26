package query

class Selection {


    fun select(
        message: String,
        fun1: () -> Unit,
        fun2: () -> Unit,
    ) {
        println(message)
        input@ while (true) {
            val input = readlnOrNull()
            when {
                input == null -> {
                    println("EOF or user pressed ctrl+D")
                    break
                }

                input.isEmpty() -> {
                    println("user didn't put anything")
                }

                else -> {
                    val number = input.toIntOrNull()
                    if (number == null) {
                        println("user put something that is not a number")
                    } else {
                        // number IS an Int, do something with it
                        when (number) {
                            1 -> {
                                fun1()
                                break
                            }

                            2 -> {
                                fun2()
                                break
                            }

                            else -> println("Wrong Selection !! Retry ")
                        }
                    }
                }
            }
        }
    }

    fun select(
        message: String,
        fun1: () -> Unit,
        fun2: () -> Unit,
        fun3: () -> Unit
    ) {
        println(message)
        input@ while (true) {
            val input = readlnOrNull()
            when {
                input == null -> {
                    println("EOF or user pressed ctrl+D")
                    break
                }

                input.isEmpty() -> {
                    println("user didn't put anything")
                }

                else -> {
                    val number = input.toIntOrNull()
                    if (number == null) {
                        println("user put something that is not a number")
                    } else {
                        // number IS an Int, do something with it
                        when (number) {
                            1 -> {
                                fun1()
                                break
                            }

                            2 -> {
                                fun2()
                                break
                            }

                            3 -> {
                                fun3()
                                break
                            }

                            else -> println("Wrong Selection !! Retry ")
                        }
                    }
                }
            }
        }
    }


}
