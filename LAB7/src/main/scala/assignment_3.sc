import scala.util.Random._
import scala.math._
import scala.annotation.tailrec

@tailrec
def stochastictailrec(n: Int, M: Array[Array[Int]]): Array[Array[Int]] = {
  val number = nextInt()
  val mod = number%256
  M(mod) :+ number
  stochastictailrec(n - 1, M)
}


var m = Array.ofDim[Int](256, 0)
val n: Int=pow(2,20).toInt
var M_20 = stochastictailrec(n, m)
