fun main(){
    //Activity9
    println("enter a number to know its factorial")
    println("input a number: ")
    val input = readln()!!

    val number = input.toInt()
    var factorial = 1
print("$number ->")
    for (i in number downTo 1){
        print("$i")
        if(i>1) print("x")
        factorial *= i
    }
    print("$factorial")
}
