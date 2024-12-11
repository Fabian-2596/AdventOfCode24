import java.io.File
import kotlin.math.abs

class Report() {
    var list = listOf<Int>()
    var asc = false
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

fun checkAsc2(list : List<Int>): Boolean {
    var check = false
    for(i in 0 until list.size - 1){
        if(list[i] < list[i+1] && abs(list[i] - list[i+1]) <= 3 && abs(list[i] - list[i+1]) >= 1){
            check = true
        } else{
            return false
        }
    }
    return check
}
fun checkDsc2(list: List<Int>): Boolean {
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

fun case3() {
    var sum = 0
    val reportList = ArrayList<Report>()
    val filePath="/Users/fabianschmidt/Library/Mobile Documents/com~apple~CloudDocs/Uni/Projects/AoC2024/AoCKotlin/AoC/src/main/kotlin/input2.txt"
    File(filePath).forEachLine { line ->
        val numbers = line.split(" ").map { it.toInt() }
        val r = Report()
        if(numbers[0] < numbers[1]){
            r.asc = true
        }
        r.list = numbers
        reportList.add(r)
    }
    for(x in reportList){
        if(x.asc){
            if(checkAsc2(x.list)){
                sum++
            }
        } else {
            if(checkDsc2(x.list)){
                sum++
            }
        }
    }
    println(sum)
}

fun main(args: Array<String>) {
    case3()
}