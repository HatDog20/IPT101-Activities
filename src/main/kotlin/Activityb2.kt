import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.logging.Logger

val logger = Logger.getLogger("LibraryLogger")

fun main() {
    var borrower: String? = null
    var course: String? = null
    var year: Int? = null
    var id: String? = null
    var book: String? = null
    var formatdate: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-d")
    var dateBorrowed: LocalDate = LocalDate.now()
    var daystoborrow: Long? = null
    var dateReturn: LocalDate? = null
    var index: Int = 1

    val books = listOf("English", "Math", "Science", "Filipino", "Values")
    var borrowedBooks = ArrayList<ArrayList<Any?>>()

    do {
        var option: Int? = null
        println("Please select Menu \n [1]Add New [2]Display [3]Return Book [4]Exit")
        option = try {
            readLine()?.toInt() ?: 4
        } catch (e: Exception) {
            4
        }

        when (option) {
            1 -> {
                logger.info("Adding new borrowing record")
                println("Please enter Borrower name:")
                borrower = readLine()

                println("Please enter Borrower course:")
                course = readLine()

                println("Please enter Borrower year:")
                year = readLine()?.toIntOrNull()

                println("Please enter Borrower ID:")
                id = readLine()

                println("Please select a book:")
                books.forEachIndexed { index, book ->
                    println("${index + 1}. $book")
                }
                val bookIndex = readLine()?.toIntOrNull()

                if (bookIndex != null && bookIndex in 1..books.size) {
                    book = books[bookIndex - 1]
                } else {
                    println("Invalid book selection!")
                    continue
                }

                println("Please Enter a Number of days to borrow:")
                daystoborrow = try {
                    readLine()?.toLong() ?: 1
                } catch (e: Exception) {
                    1
                }
                dateReturn = dateBorrowed.plusDays(daystoborrow!!)

                println("Do you really want to borrow the book? [Y|N]")
                val confirmInput = readLine()
                if (confirmInput?.equals("Y", true) == true) {
                    println("Please wait! Saving Record..")
                    val data = arrayListOf<Any?>()
                    data.add(index++)
                    data.add(borrower?.toUpperCase())
                    data.add(course)
                    data.add(year)
                    data.add(id)
                    data.add(book?.toUpperCase())
                    data.add(dateBorrowed)
                    data.add(dateReturn)
                    data.add(daystoborrow)
                    borrowedBooks.add(data)
                    logger.info("Borrowing record added: $data")
                    println("Data has been successfully saved!")
                } else {
                    println("Thanks for Coming! Come back soon!")
                }
            }
            2 -> display(borrowedBooks)
            3 -> {
                println("Please enter the index of the book to return:")
                val returnIndex = readLine()?.toIntOrNull()
                if (returnIndex != null && returnIndex >= 1 && returnIndex <= borrowedBooks.size) {
                    val returnData = borrowedBooks[returnIndex - 1]
                    val returnDate = LocalDate.now()
                    returnData[7] = returnDate
                    logger.info("Book returned: ${returnData[5]} by ${returnData[1]} on $returnDate")
                    println("Book '${returnData[5]}' returned on $returnDate")
                } else {
                    println("Invalid index!")
                }
            }
            4 -> println("Exiting program.")
            else -> println("Invalid option.")
        }
    } while (option != 4)
}

fun display(list: ArrayList<ArrayList<Any?>>) {
    println("List of Borrowed")
    println("INDEX | NAME | COURSE | YEAR | ID | BOOK | DATE BORROWED | DATE RETURN | DURATION (DAYS)")
    println("--------------------------------------------------------------------------------------------")
    for (element in list) {
        println(element.joinToString(" | ") { if (it is LocalDate) it.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) else it.toString() })
    }
    if (list.isEmpty()) {
        println("There's no record yet added.")
    }
}
