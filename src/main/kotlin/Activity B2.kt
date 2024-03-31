import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.logging.Logger

private val logger = Logger.getLogger("CartLogger")

fun main() {
    val listOfItems = mutableListOf<List<String>>()

    do {
        println("\nPlease select an option:")
        println("[1] Add to cart Record")
        println("[2] Display items bought")
        println("[3] Exit")

        val option = readLine()?.toIntOrNull() ?: 3

        when (option) {
            1 -> addNewItemBought(listOfItems)
            2 -> displayItemsBought(listOfItems)
            3 -> println("Exiting...")
            else -> println("Invalid option. Please try again.")
        }
    } while (option != 3)
}

fun addNewItemBought(listOfItemsBought: MutableList<List<String>>) {
    val availableItems = listOf("banana", "apple", "mango", "pineapple")
    var item: String? = null

    do {
        println("Please enter casher's name:")
        val casher = readLine() ?: ""

        println("\nAvailable Items: $availableItems")

        println("\nPlease enter the item to buy:")
        item = readLine()

        var isItemAvailable = false
        for (x in availableItems) {
            if (item.equals(x, true)) {
                println("Item is Found!")
                isItemAvailable = true
            }
        }

        println("\nPlease enter the number of items to buy:")
        val quantityToBuy = readLine()?.toIntOrNull() ?: 1

        if (isItemAvailable) {
            println("Please enter the cost of one item:")
            val itemCost = readLine()?.toDoubleOrNull() ?: 0.0

            println("Do you want to buy the item? [Y|N]")
            val confirm = readLine()
            if (confirm != null) {
                if (confirm[0].equals('Y', true) || confirm.equals("Yes", true)) {
                    println("Please wait! Saving Record..")

                    // Adding item record
                    listOfItemsBought.add(
                        listOf(
                            casher.toUpperCase(),
                            item!!.toUpperCase(),
                            LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                            quantityToBuy.toString(),
                            (quantityToBuy * itemCost).toString() // Adding the cost of items
                        )
                    )
                    println("Item added to the cart successfully!")
                    logger.info("Item added: [$casher, $item, ${LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))}, $quantityToBuy, ${(quantityToBuy * itemCost)}]")
                    return
                } else {
                    println("Thanks for coming! Come back soon!")
                    logger.info("User declined to buy the item.")
                    return
                }
            }
        } else {
            println("No record added - Item is not available")
            logger.warning("Attempted to buy unavailable item: $item")
            return
        }

    } while (true)
}

fun displayItemsBought(listOfItemsBought: List<List<String>>) {
    if (listOfItemsBought.isEmpty()) {
        println("No items bought yet.")
        return
    }

    println("List of Bought Items:")
    println("INDEX | CASHER | ITEM | DATE BOUGHT | QUANTITY | COST")
    println("------------------------------------------------------")

    var totalCost = 0.0
    listOfItemsBought.forEachIndexed { index, record ->
        val cost = record[4].toDouble()
        totalCost += cost
        println("${index + 1}\t${record.joinToString(" | ")}")
    }
    println("------------------------------------------------------")
    println("Total Cost of All Items Bought: $totalCost")
}
