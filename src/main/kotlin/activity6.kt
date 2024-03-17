fun main(){
    //Activity6
    println("input string1: ")
    val string1 = readln()
    println("input string2: ")
    val string2 = readln()
    val bothstring = string1 + string2
    println("unique character in string1: ")
    var seenchar = ""
    for (char in string1){
        if(string1.indexOf(char) == string1.lastIndexOf(char)){
            seenchar += char
        }
    }
    println(seenchar)

    println("unique character in string2: ")
    var sencahr = ""
    for (char in string2){
        if(string2.indexOf(char) == string2.lastIndexOf(char)){
            sencahr += char
        }
    }
    println(sencahr)

    println("unique character in both string: ")
    var sechar = ""
    for (char in bothstring){
        if (bothstring.indexOf(char) == bothstring.lastIndexOf(char)){
            sechar += char
        }
    }
    println(sechar)
}