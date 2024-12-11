import java.io.File
import kotlin.math.abs

class Report() {
    var list = ArrayList<Int>()
    var asc = false
    var isSafe = false
}
fun checkAsc(list : List<Int>): Boolean {
    var check = false
    for(i in 0 until list.size - 1){
        if(list[i] < list[i+1] && abs(list[i] - list[i+1]) <= 3 && abs(list[i] - list[i+1]) >= 1){
            check = true
        } else {
            return false
        }
    }
    return check
}

fun checkDsc(list: List<Int>): Boolean {
    var check = false
    for(i in 0 until list.size - 1){
        if(list[i] > list[i+1] && abs(list[i] - list[i+1]) <= 3 && abs(list[i] - list[i+1]) >= 1){
            check = true
        } else {
            return false
        }
    }
    return check
}

fun case2a(): ArrayList<Report> {
    var sum = 0
    val reportList = ArrayList<Report>()
    val filePath="src/main/kotlin/input2.txt"
    File(filePath).forEachLine { line ->
        val tmp = line.split("\\s+".toRegex()).map { it.toInt() }
        val numbers = ArrayList(tmp)
        val r = Report()
        if(numbers[0] < numbers[1]){
            r.asc = true
        }
        r.list = numbers
        reportList.add(r)
    }
    for(x in reportList){
        if(x.asc){
            if(checkAsc(x.list)){
                x.isSafe = true
                sum++
            }
        } else {
            if(checkDsc(x.list)){
                x.isSafe=true
                sum++
            }
        }
    }
    println(sum)
    return reportList
}

fun main(args: Array<String>) {
    case2a()
}