fun main(){
    //Activity7
    println("input a string or number to know if it is palindrome or not")
    println("input string or number:")
    val input = readln()?.replace(" ", "")?.toLowerCase()

    var boolean = true
  val lenght = input?.length?:0
    for (string in 0 until lenght / 2){
        if(input?.get(string) != input?.get(lenght -string -1)){
            boolean = false
            break;
        }
    }
    if(boolean){
        println("$input is palindrome")
    }else{
        println("$input is not a palindrome")
    }
}