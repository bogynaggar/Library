package query

class Selection {


    fun select(
        message: String,
        fun1: () -> Unit,
        fun2: () -> Unit,
    ) {
        input@ while (true) {
            println(message)
            val input = readlnOrNull()
            when {
                input == null -> {
                    println("EOF or you pressed ctrl+D")
                    break
                }

                input.isEmpty() -> {
                    println("you didn't select anything")
                }

                else -> {
                    val number = input.toIntOrNull()
                    if (number == null) {
                        println("you enter something that is not a number")
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
        fun3: () -> Unit,
    ) {
        println(message)
        input@ while (true) {
            val input = readlnOrNull()
            when {
                input == null -> {
                    println("EOF or you pressed ctrl+D")
                    break
                }

                input.isEmpty() -> {
                    println("you didn't put anything")
                }

                else -> {
                    val number = input.toIntOrNull()
                    if (number == null) {
                        println("you enter something that is not a number")
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


    fun select(
        message: String,
        fun1: () -> Unit,
        fun2: () -> Unit,
        fun3: () -> Unit,
        fun4: () -> Unit,
        fun5: () -> Unit,
        fun6: () -> Unit,
        fun7: () -> Unit,
        fun8: () -> Unit,
        fun9: () -> Unit,

        ) {

        input@ while (true) {
            println(message)
            val input = readlnOrNull()
            when {
                input == null -> {
                    println("EOF or you pressed ctrl+D")
                    break
                }

                input.isEmpty() -> {
                    println("you didn't select anything")
                }

                else -> {
                    val number = input.toIntOrNull()
                    if (number == null) {
                        println("you enter something that is not a number")
                    } else
                    // number IS an Int, do something with it
                        when (number) {
                            1 -> {
                                fun1()

                            }

                            2 -> {
                                fun2()

                            }

                            3 -> {
                                fun3()

                            }

                            4 -> {
                                fun4()

                            }

                            5 -> {
                                fun5()

                            }

                            6 -> {
                                fun6()

                            }

                            7 -> {
                                fun7()

                            }

                            8 -> {
                                fun8()

                            }

                            9 -> {
                                fun9()

                            }

                            else -> println("Wrong Selection !! Retry ")
                        }
                }
            }
        }
    }


}
