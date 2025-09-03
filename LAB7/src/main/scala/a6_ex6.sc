import scala.util.Random._
import scala.math._
import scala.annotation.tailrec

@tailrec
def stochastictailrec(n: Int, M: Int): Int = {
  if (n == 0) {
    return M
  }
  var m = M
  val ones = Integer.numberOfLeadingZeros(nextInt())+1
  if (M < ones) m = ones
  stochastictailrec(n - 1, m)
}


var m = 0
val n: Int=pow(2,20).toInt
var M_20 = stochastictailrec(n, m)
val n2_20 = pow(2,M_20).toInt
Integer.compare(n,n2_20) // 1 -> n > n2_20 = 19

val n: Int=pow(2,24).toInt
var m = 0
val M_24 = stochastictailrec(n, m)
val n2_24 = pow(2,M_24).toInt
Integer.compare(n,n2_24)  // 0 -> n = n2_24 = 23

val n: Int=pow(2,28).toInt
var m = 0
val M_28 = stochastictailrec(n, m)
val n2_28 = pow(2,M_28).toInt
Integer.compare(n,n2_28) // -1 -> n < n2_28 = 29