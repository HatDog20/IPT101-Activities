class GroceryCart {
    //Joseph Ventures
    //Ken E Caupit
    //Amora CrisAljon
    //Anfred Albit

    public val cart = mutableMapOf<String, MutableMap<String, Any>>()

    fun addItem(itemName: String, quantity: Int, pricePerUnit: Double) {
        if (cart.containsKey(itemName)) {
            cart[itemName]?.let { item ->
                item["quantity"] = item["quantity"] as Int + quantity
            }
        } else {
            cart[itemName] = mutableMapOf("quantity" to quantity, "pricePerUnit" to pricePerUnit)
        }
    }

    fun calculateTotalCost(): Double {
        var totalCost = 0.0
        for ((_, item) in cart) {
            val quantity = item["quantity"] as Int
            val pricePerUnit = item["pricePerUnit"] as Double
            totalCost += quantity * pricePerUnit
        }
        return totalCost
    }

    fun listItemsBought(): List<Pair<String, Int>> {
        val itemsBought = mutableListOf<Pair<String, Int>>()
        for ((itemName, item) in cart) {
            val quantity = item["quantity"] as Int
            itemsBought.add(Pair(itemName, quantity))
        }
        return itemsBought
    }
}

fun main() {
    val cashier = GroceryCart()
    var itemCount = 1

    do {
        println("\nPlease select menu\n[1]Add Item\n[2]Display All Items bought\n[3]Exit")
        print("\nEnter your choice:")
        val select: Int = readLine()?.toIntOrNull() ?: 4

        when (select) {
            1 -> {
                var itemBought: String?
                print("\nItem: ")
                itemBought = readLine()

                var quantity: Int?
                print("Quantity: ")
                quantity = readLine()?.toIntOrNull() ?: 0

                var totalPrice: Double?
                print("Price: ")
                totalPrice = readLine()?.toDoubleOrNull() ?: 0.0

                // Adding items to the cart
                cashier.addItem(itemBought!!, quantity ?: 0, totalPrice ?: 0.0)
            }
            2 -> {
                println("\nList of all items bought:")
                println("")
                for (item in cashier.listItemsBought()) {
                    val itemName = item.first
                    val quantity = item.second
                    val pricePerUnit = cashier.cart[itemName]?.get("pricePerUnit") as Double
                    val totalItemCost = quantity * pricePerUnit
                    println("Item $itemCount: $itemName, Quantity: $quantity, Total Cost: $${"%.2f".format(totalItemCost)}")
                    itemCount++
                }
                // Reset item count for next display
                itemCount = 1

                // Calculating and printing total cost for all items
                val totalCost = cashier.calculateTotalCost()
                println("\nAll total cost: $${"%.2f".format(totalCost)}")
            }
            3 -> System.exit(0)
            else -> println("\nInvalid Option!")
        }
    } while (true)
}