data class Student_details(val fullname: String, val stdId: String, val stdcourse: String)
fun main() {

    val mapeh = listOf("MAPEH-1", "MAPEH-2", "MAPEH-3", "MAPEH-4")
    val aralpan = listOf("ARALPAN-1", "ARALPAN-2", "ARALPAN-3", "ARALPAN-4")
    val science = listOf("SCIENCE-1", "SCIENCE-2", "SCIENCE-3", "SCIENCE-4")
    val course = listOf("BSIT","BSED","BSHM","BSBA")

    var mapeh1:Int=0
    var mapeh4:Int=0
    var aralpan2:Int=0
    var aralpan3:Int=0
    var science1:Int=0
    var science4:Int=0

    println("*****Aces School Library*****")
    println(" ")
    println("Enter Student's name: ")
    var studName = readLine().toString().toUpperCase()

    println("Enter Student's ID:")
    var studId = readLine()!!.toInt() ?: 0


    println("Enter Student's Course and Year:")
    var studCourse = readLine().toString().toUpperCase()


    var student = Student_details("studName", "studId", "studCourse")


    println("---------------------------------------------")
    do{

        println("Choose a Subject:\n[1]. Mapeh\n[2]. AralPan\n[3]. Science")
        println("---------------------------------------------")
        val choose: Int = readLine()!!.toInt() ?: 0

        var mapehBook: String?
        var aralpanBook: String?
        var scienceBook: String?
        var quantity: Int?

        if (choose == 1) {

            outer@ do {

                println("Enter a book name:\nMAPEH-1\nMAPEH-2\nMAPEH-3\nMAPEH-2")
                println("---------------------------------------------")
                mapehBook = readLine().toString().toUpperCase()

                when (mapehBook) {

                    mapeh[0] -> {
                        mapeh1++
                        println("Borrowable")
                        println("---------------------------------------------")

                        print("\nEnter quantity:")
                        quantity = readLine()!!.toInt() ?: 0

                        println("\nBook name: $mapehBook")
                        println("Book quantity: $quantity")
                        println("Borrowed book/s: $mapeh1");


                        break

                    }

                    mapeh[3] -> {
                        mapeh4++
                        println("Borrowable")
                        println("---------------------------------------------")

                        print("\nEnter quantity:")
                        quantity = readLine()!!.toInt() ?: 0

                        println("\nBook name: $mapehBook")
                        println("Book quantity: $quantity")
                        println("Borrowed book/s: $mapeh4");
                        break

                    }
                    mapeh[2] -> println("Not Borrowable due to highly damaged")

                    mapeh[1] -> println("Borrowable but slightly damaged")

                    else ->
                        println("\nOut of Stock")

                }

                println("---------------------------------------------")

            } while (!(mapehBook!!.equals(mapeh)))


        } else if (choose == 2) {
            outer@ do {

                println("Enter a book name:\nARALPAN-1\nARALPAN-2\nARALPAN-3\nARALPAN-4")
                println("---------------------------------------------")
                aralpanBook = readLine().toString().toUpperCase()

                when (aralpanBook) {

                    aralpan[1] -> {
                        aralpan2++
                        println("Borrowable")
                        println("---------------------------------------------")

                        print("\nEnter quantity:")
                        quantity = readLine()!!.toInt() ?: 0

                        println("\nBook name: $aralpanBook")
                        println("Book quantity: $quantity")
                        println("Borrowed book/s: $aralpan2");
                        break
                    }

                    aralpan[2] -> {
                        aralpan3++
                        println("Borrowable")
                        println("---------------------------------------------")

                        print("\nEnter quantity:")
                        quantity = readLine()!!.toInt() ?: 0

                        println("\nBook name: $aralpanBook")
                        println("Book quantity: $quantity")
                        println("Borrowed book/s: $aralpan3");
                        break
                    }

                    aralpan[2] -> {
                        println("Not Borrowable due to highly damaged")
                    }

                    aralpan[1] -> {
                        println("Borrowable but slightly damaged")
                    }

                    else ->
                        println("\nOut of Stock")



                }

                println("---------------------------------------------")

            } while (!(aralpanBook!!.equals(aralpan)))


        } else if (choose == 3) {
            outer@ do {
                println("Enter a book name:\nSCIENCE-1\nSCIENCE-2\nSCIENCE-3\nSCIENCE-4")
                println("---------------------------------------------")
                scienceBook = readLine().toString().toUpperCase()

                when (scienceBook) {

                    science[3] -> {
                        science4++
                        println("Borrowable")
                        println("---------------------------------------------")

                        print("\nEnter quality:")
                        quantity = readLine()!!.toInt() ?: 0

                        println("\nBook name: $scienceBook")
                        println("Book quantity: $quantity")
                        println("Borrowed book/s: $science4")  ;
                        break
                    }

                    science[0] -> {
                        science1++
                        println("Borrowable")
                        println("---------------------------------------------")

                        print("\nEnter quantity:")
                        quantity = readLine()!!.toInt() ?: 0

                        println("\nBook name: $scienceBook")
                        println("Book quantity: $quantity")
                        println("Borrowed book/s: $science1");break
                    }

                    science[2] -> println("Not Borrowable due to highly damaged")

                    science[1] -> println("Borrowable but slightly damaged")

                    else -> println("Out of Stock")

                }


            } while (!(scienceBook!!.equals(science)))
        }

        println("\nDo you want to add another book to borrow? {Y|N}")
        var response = readLine().toString()


    } while (when (response.toString().substring(0, 1).uppercase()) {
                "Y" ->
                    true

                else ->
                    false

            }
    )
}