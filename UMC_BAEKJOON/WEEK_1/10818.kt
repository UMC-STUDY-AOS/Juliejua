import java.util.*
import kotlin.collections.ArrayList


fun main() = with(Scanner(System.`in`)){
    val n = nextInt()
    val numbers = ArrayList<Int>(n)
   
    
    for(i in 0 until n){
        var new = nextInt()
        numbers.add(new)
      
    }

    print("${numbers.min()} ${numbers.max()}")

}