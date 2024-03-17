fun main(){
    print("Enter the number of students: ")
    val numberofStudents = readln()!!.toInt()

    var totalMarks: Int
    var averageGrade: Double

    for (i in 1..numberofStudents){
        print("\n Enter the name of student $i: ")
        val name = readln()!!

        print("Enter the Grade in English: ")
        val englishGrade = readln()!!.toInt()

        print("Enter the Grade in Math: ")
        val mathGrade = readln()!!.toInt()

        print("Enter the Grade in Filipino: ")
        val filipinoGrade = readln()!!.toInt()

        totalMarks = englishGrade + mathGrade + filipinoGrade
        averageGrade = totalMarks / 4.0

        print("The average grade for $name is $averageGrade ")
    }
}