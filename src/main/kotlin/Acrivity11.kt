fun main() {
    //Activity11
    println("what is 0.75% of 0.20? ")
    println("enter a percentage: ")
    val inputpercentage = readln()?.toDoubleOrNull()?: 0.0
    println("enter a value to get a percentage: ")
    val inputvalue = readln()?.toDoubleOrNull()?: 0.0
    if (inputpercentage != null){
        val resul = if (inputpercentage % 1 == 0.0){
            inputpercentage.toInt() * 0.0001

        }else{
            inputpercentage * 0.01
        }
        val percentage = inputpercentage * 0.01
        val resut = resul * inputvalue
        println("Answer ${String.format("%.5f", resut * 0.1)}")
    }
}