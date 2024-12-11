import java.io.File
import kotlin.math.abs

fun case1() {
    var sum = 0
    val firstList = ArrayList<Int>()
    val secondList = ArrayList<Int>()
    val filePath="/Users/fabianschmidt/Library/Mobile Documents/com~apple~CloudDocs/Uni/Projects/AoC2024/AoCKotlin/AoC/src/main/kotlin/input1.txt"
    File(filePath).forEachLine { line ->
        val numbers = line.split("\\s+".toRegex()).map { it.toInt() }
        firstList.add(numbers[0])
        secondList.add(numbers[1])
    }
    firstList.sort()
    secondList.sort()
    for((i, x) in firstList.withIndex()) {
        sum += abs(x - secondList[i])
    }
    println(sum)
}

fun case2() {
    var sum = 0
    var count = 0
    val firstList = ArrayList<Int>()
    val secondList = ArrayList<Int>()
    val filePath="/Users/fabianschmidt/Library/Mobile Documents/com~apple~CloudDocs/Uni/Projects/AoC2024/AoCKotlin/AoC/src/main/kotlin/input1.txt"
    File(filePath).forEachLine { line ->
        val numbers = line.split("\\s+".toRegex()).map { it.toInt() }
        firstList.add(numbers[0])
        secondList.add(numbers[1])
    }
    firstList.sort()
    secondList.sort()
    for(x in firstList) {
        for(y in secondList) {
            if (x == y) {
                count++
            }
        }
        sum += x * count
        count = 0
    }
    println(sum)
}

fun main(args: Array<String>) {
    case1()
    case2()
}