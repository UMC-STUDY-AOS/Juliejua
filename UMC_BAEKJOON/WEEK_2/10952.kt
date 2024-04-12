import java.util.*

fun main() = with(Scanner(System.`in`)){
    var a =0
    var b =0

    while(true){
        a = nextInt()
        b = nextInt()

        if (a == 0 && b == 0) {
            break
        }

        println("${a+b}")
    }

}