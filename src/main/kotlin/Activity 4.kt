data class Student(val name: String, val Id: String, val course: String)
fun main() {

    val english = listOf("ENG1", "ENG2", "ENG3", "ENG4")
    val math = listOf("PE1", "PE2", "PE3", "PE4")
    val filipino = listOf("FIL1", "FIL2", "FIL3", "FIL4")


    println("Welcome to the School Library")
    println(" ")
    println("Enter student's name: ")
    var studName = readLine().toString().toUpperCase()

    println("Enter student ID")
    var studId = readLine()!!.toInt() ?: 0

    println("Enter student's Course")
    var studCourse = readLine().toString().toUpperCase()

    var student = Student("studName", "studId", "studCourse")

    println("---------------------------------------------")
    do{

        println("Choose a Subject:\n[1]. English\n[2]. Pe\n[3]. Filipino")
        println("---------------------------------------------")
        val opt: Int = readLine()!!.toInt() ?: 0

        var engName: String?
        var mathName: String?
        var filName: String?
        var quantity: Int?

        if (opt == 1) {

            outer@ do {

                println("Enter book name:\nENG1\nENG2\nENG3\nENG4")
                println("---------------------------------------------")
                engName = readLine().toString().toUpperCase()

                when (engName) {

                    english[0] -> {

                        println("Borrowable")
                        println("---------------------------------------------")

                        print("\nEnter quantity:")
                        quantity = readLine()!!.toInt() ?: 0

                        println("\nBook name: $engName")
                        println("Book quantity: $quantity");break
                    }

                    english[3] -> {

                        println("Borrowable")
                        println("---------------------------------------------")

                        print("\nEnter quantity:")
                        quantity = readLine()!!.toInt() ?: 0

                        println("\nBook name: $engName")
                        println("Book quantity: $quantity");break

                    }
                    english[2] -> println("Not Borrowable due to highly damaged")

                    english[1] -> println("Borrowable but slightly damaged")

                    else ->
                        println("\nOut of Stock")

                }

                println("---------------------------------------------")

            } while (!(engName!!.equals(english)))


        } else if (opt == 2) {
            outer@ do {

                println("Enter book name:\nPE1\nPE2\nPE3\nPE4")
                println("---------------------------------------------")
                mathName = readLine().toString().toUpperCase()

                when (mathName) {

                    math[1] -> {
                        println("Borrowable")
                        println("---------------------------------------------")

                        print("\nEnter quantity:")
                        quantity = readLine()!!.toInt() ?: 0

                        println("\nBook name: $mathName")
                        println("Book quantity: $quantity");break
                    }

                    math[2] -> {
                        println("Borrowable")
                        println("---------------------------------------------")

                        print("\nEnter quantity:")
                        quantity = readLine()!!.toInt() ?: 0

                        println("\nBook name: $mathName")
                        println("Book quantity: $quantity");break
                    }

                    math[2] -> {
                        println("Not Borrowable due to highly damaged")
                    }

                    math[1] -> {
                        println("Borrowable but slightly damaged")
                    }

                    else ->
                        println("\nOut of Stock")



                }

                println("---------------------------------------------")

            } while (!(mathName!!.equals(math)))


        } else if (opt == 3) {
            outer@ do {
                println("Enter book name:\nFIL1\nFIL2\nFIL3\nFIL4")
                println("---------------------------------------------")
                filName = readLine().toString().toUpperCase()

                when (filName) {

                    filipino[3] -> {

                        println("Borrowable")
                        println("---------------------------------------------")

                        print("\nEnter quality:")
                        quantity = readLine()!!.toInt() ?: 0

                        println("\nBook name: $filName")
                        println("Book quantity: $quantity");break
                    }

                    filipino[0] -> {

                        println("Borrowable")
                        println("---------------------------------------------")

                        print("\nEnter quantity:")
                        quantity = readLine()!!.toInt() ?: 0

                        println("\nBook name: $filName")
                        println("Book quantity: $quantity")
                    }

                    filipino[2] -> println("Not Borrowable due to highly damaged")

                    filipino[1] -> println("Borrowable but slightly damaged")

                    else -> println("Out of Stock")

                }


            } while (!(filName!!.equals(math)))
        }

        println("\nDo you want to add another book to borrow? {Y|N}")
        var response = readLine().toString()

    } while (when (response.toString().substring(0, 1).uppercase()) {
                "Y" -> true
                else -> false

            }
    )


}

