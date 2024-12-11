import java.io.File
import kotlin.math.abs


fun case2b() {
    var reportList = ArrayList<Report>()
    reportList = case2a()
    var count = 0
    for(x in reportList){
        if(!x.isSafe){
            for(i in 0 until x.list.size){
                val newList = ArrayList(x.list)
                newList.removeAt(i)
                if(newList[0] < newList[1]){
                    if(checkAsc(newList)){
                        x.isSafe = true
                        count++
                        break
                    }
                } else {
                    if(checkDsc(newList)){
                        x.isSafe = true
                        count++
                        break
                    }
                }
            }
        } else {
            count++
        }
    }
    println(count)
}
fun main(args: Array<String>) {
    case2b()
}