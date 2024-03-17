import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.logging.Logger


private val logger = Logger.getLogger("BorrowingLogger")
fun main() {
    val borrowedBooks = mutableListOf<List<String>>()

    do {
        println("\nPlease select an option:")
        println("[1] Add New Borrowing Record")
        println("[2] Display Borrowed Books")
        println("[3] Exit")

        val option = readLine()?.toIntOrNull() ?: 3

        when (option) {
            1 -> addNewBorrowingRecord(borrowedBooks)
            2 -> displayBorrowedBooks(borrowedBooks)
            3 -> println("Exiting...")
            else -> println("Invalid option. Please try again.")
        }
    } while (option != 3)
}


fun addNewBorrowingRecord(borrowedBooks: MutableList<List<String>>) {
    val list = arrayListOf("English", "Math", "Science", "Filipino")
    var book:String? = null

    do {
        println("Please enter borrower's name:")
        val borrower = readLine() ?: ""

        println("\nAvailable Books: $list")


        println("\nPlease enter the book to borrow:")
        book = readLine()

        var isbookavailable = false
        for(x in list){

            if(book.equals(x,true)) {
                println("Book is Found!")
                isbookavailable = true
            }
        }



        println("\nPlease enter the number of days to borrow:")
        val daysToBorrow = readLine()?.toLongOrNull() ?: 1

        val dateBorrowed = LocalDate.now()
        val dateReturn = dateBorrowed.plusDays(daysToBorrow)
        val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")

        if (isbookavailable) {
            println("Do you want to borrow the book? [Y|N]")
            val confirm = readLine()
            if (confirm != null) {
                if (confirm[0].equals('Y', true) || confirm.equals("Yes", true)) {
                    println("Please wait! Saving Record..")


                    borrowedBooks.add(
                        listOf(
                            borrower.toUpperCase(),
                            book!!.toUpperCase(),
                            dateBorrowed.format(dateFormat),
                            dateReturn.format(dateFormat),
                            daysToBorrow.toString()
                        )
                    )
                    println("Borrowing record added successfully!")
                    logger.info("Borrowing record added: [$borrower, $book, ${dateBorrowed.format(dateFormat)}, ${dateReturn.format(dateFormat)}, $daysToBorrow]")
                    return
                } else {
                    println("Thanks for coming! Comeback soon!")
                    logger.info("User declined to borrow the book.")
                    System.exit(0)
                }
            }
        }else{
            println("No record added - Book is not available")
            logger.warning("Attempted to borrow unavailable book: $book")
            return
        }

    } while (true)
}
fun displayBorrowedBooks(borrowedBooks: List<List<String>>) {
    if (borrowedBooks.isEmpty()) {
        println("No borrowing records found.")
        return
    }

    println("List of Borrowed Books:")
    println("INDEX | BORROWER | BOOK | DATE BORROWED | DATE RETURN | DURATION (DAYS)")
    println("-----------------------------------------------------------------------")

    borrowedBooks.forEachIndexed { index, record ->
        println("$index\t${record.joinToString(" | ")}")
    }
}