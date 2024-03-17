fun main(){
    //Activity10
    println("input a number to know if it is even or odd")

    println("input a number: ")
    val input = readLine()!!.toInt()

    if (input % 2 == 0){
        println("$input is even")
    }else{
        println("$input is odd")

    }

    if (input % 2 == 0){
        for (z in input downTo 2 step 2){
            println(z)
        }
    }else{
        for (z in input downTo 1 step 2){
            println(z)
        }

    }
}