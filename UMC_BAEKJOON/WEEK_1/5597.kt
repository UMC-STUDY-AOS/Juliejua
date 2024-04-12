import java.util.*
import kotlin.collections.ArrayList


fun main() {
    val list = arrayListOf<Int>()
    val result = arrayListOf<Int>()

    repeat(28) {
        list.add(readln().toInt())
    }
    
    for (i in 1 .. 30) {
        if (i !in list) {
            result.add(i)
        }
    }
    
    println(result[0])
    println(result[1])
}