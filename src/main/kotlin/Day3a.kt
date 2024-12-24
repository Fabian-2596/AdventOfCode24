import java.io.File

fun useRegex(input: String): Boolean {
    val regex = Regex(pattern = "\\([0-9]+,[0-9]+\\)")
    return regex.matches(input)
}
fun test(i : Int, list : ArrayList<String>){
    if(list[i].length < 5) {
        list[i] = ""
        return
    } else if (list[i][list[i].length-1] != ')' || !list[i][list[i].length-2].isDigit()){
        list[i] = list[i].removeRange(list[i].length-1, list[i].length)
        test(i, list)
    } else {
        return
    }
}

fun case3a(str : String): Int {
    var sum = 0
    val list = ArrayList<String>()
    val splitstr = str.split("mul")
    for(x in splitstr) {
        if(x.isEmpty())
            continue
        else if(x[0] != '(') {
            continue
        } else if(x.length >= 9){
            val s = x.removeRange(9, x.length)
            list.add(s)
        } else {
            list.add(x)
        }
    }
    for((i,x) in list.withIndex()){
        test(i, list)
    }
    for(x in list){
        if(useRegex(x)){
            val splitstr = x.split(",")
            sum += splitstr[0].removePrefix("(").toInt() * splitstr[1].removeSuffix(")").toInt()
        }
    }
    return sum
}
fun case3b(str : String){
    var sum = 0
    val splitstr = str.split("do()")
    for(x in splitstr) {
        val str = x.split("don't()")
        sum += case3a(str[0])
    }
    println(sum)
}

fun main(args: Array<String>) {
    val filePath="src/main/kotlin/input3.txt"
    var str = File(filePath).readText()
    println(case3a(str))
    case3b(str)
}