import java.io.File

fun case5a() {
    val rules: HashMap<Int, ArrayList<Int>> = HashMap<Int, ArrayList<Int>>()
    val filePath = "src/main/kotlin/input5.txt"
    var sum = 0
    var sum2 = 0
    File(filePath).forEachLine { line ->
        if (line.isNotEmpty() && line[2] == '|') {
            val splitStr = line.split('|')
            val key = splitStr[0].toInt()
            val list = ArrayList<Int>()
            list.add(splitStr[1].toInt())
            if (!rules.containsKey(key)) {
                rules.put(key, list)
            } else {
                rules[key]!!.add(splitStr[1].toInt())
            }
        }
        if (line.isNotEmpty() && line[2] == ',') {
            var isCorrect = false
            val splitStr = line.split(',')
            for ((i, x) in splitStr.withIndex()) {
                if (i < splitStr.size-1) {
                    if(rules[x.toInt()]!!.contains(splitStr[i + 1].toInt())) {
                        isCorrect = true
                    } else {
                        isCorrect = false
                        break
                    }
                }
            }
            if (isCorrect) {
                sum += splitStr[splitStr.size / 2].toInt()
            }
        }
    }
    println(sum)
}

fun main(args: Array<String>) {
 case5a()
}