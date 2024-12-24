import java.io.File

fun case4a() {
    var x = 0
    var y = 0
    var sum = 0
    val filePath = "src/main/kotlin/input4.txt"
    //size of field
    var str = File(filePath).readText()
    File(filePath).forEachLine { line ->
        x = line.length + 1
        y++
    }
    for((i, c) in str.withIndex()){
        if(c == 'X'){
            //right field
            if(str[i+1] == 'M' && str[i+2] == 'A' && i+2 > 0 && str[i+3] == 'S' && i+3 > 0){
                sum++
            }
            //bottom right field
            if(i < x*y - 3*x - 3 && str[i + x + 1] == 'M' && str[i + 2*x + 2] == 'A' && str[i + 3*x + 3] == 'S'){
                sum++
            }
            //bottm field
            if(i < x*y - 3*x && str[i+x] == 'M' && str[i+2*x] == 'A' && str[i+3*x] == 'S'){
                sum++
            }
            //bottom left
            if(i < x*y - 3*x + 3 && str[i + x - 1] == 'M' && str[i + 2*x - 2] == 'A' && str[i + 3*x - 3] == 'S') {
                sum++
            }
            //left
            if(i > 3 && str[i-1] == 'M' && str[i-2] == 'A' && str[i-3] == 'S') {
                sum++
            }
            //top left
            if(i > 3*x + 3 && str[i - x - 1] == 'M' && str[i - 2*x - 2] == 'A' && str[i - 3*x - 3] == 'S'){
                sum++
            }
            //top
            if( i > 3*x && str[i-x] == 'M' && str[i-2*x] == 'A' && str[i-3*x] == 'S'){
                sum++
            }
            //top right
            if(i > 3*x + 3 && str[i - x + 1] == 'M' && str[i - 2*x + 2] == 'A' && str[i - 3*x + 3] == 'S'){
                sum++
            }
        }
    }
    println(sum)
}


fun case4b() {
    var x = 0
    var y = 0
    var sum = 0
    val filePath = "src/main/kotlin/input4.txt"
    //size of field
    var str = File(filePath).readText()
    File(filePath).forEachLine { line ->
        x = line.length + 1
        y++
    }
    for((i, c) in str.withIndex()){
        if(c == 'A'){
            //M is top left and right
            if(i > x + 1 && i < x*y -x+1 && str[i-x-1] == 'M' && str[i-x+1] == 'M' && str[i+x-1] == 'S' && str[i+x+1] == 'S'){
                sum++
            }
            //M is top left bottom left
            if(i > x+1 && i < x*y -x+1 && str[i-x-1] == 'M' && str[i+x-1] == 'M' && str[i-x+1] == 'S' && str[i+x+1] == 'S'){
                sum++
            }
            //M is top right bottom right
            if(i > x+1 && i < x*y -x+1 && str[i-x-1] == 'S' && str[i+x-1] == 'S' && str[i-x+1] == 'M' && str[i+x+1] == 'M'){
                sum++
            }
            //M is bottom left bottom right
            if(i > x+1 && i < x*y -x+1 && str[i-x-1] == 'S' && str[i-x+1] == 'S' && str[i+x-1] == 'M' && str[i+x+1] == 'M') {
                sum++
            }
        }
    }
    println(sum)
}
fun main(args: Array<String>) {
    case4a()
    case4b()
}