fun main(){
    //Activity8
    println("enter a number to know its prime numbers")
    println("enter first number: ")
    val input1 = readLine()!!.toInt()
    println("enter second number: ")
    val input2 = readLine()!!.toInt()

    println("$input1 -> ")
    for (num in 1..input1){
        var isprime = true
        for (i in 2 until num){
            if (num % i ==0){
                isprime = false
                break
            }
        }
        if (isprime) {
            println("$num")
        }
    }
    println("$input2 -> ")
    for (num in 1..input2){
        var sprim = true
        for (i in 2 until num){
            if (num % i == 0){
                sprim = false
                break
            }
        }
        if (sprim){
            println("$num")
        }
    }
}