import scala.annotation.tailrec


def mult(a: Int, b:Int):Int={
    @tailrec
    def multiplyHelper(a: Int, b: Int, result: Int): Int = {
        if (b == 0) result
        else {
            val newResult = if ((b & 1) == 1) result ^ a else result
            multiplyHelper(a << 1, b >> 1, newResult)
        }
    }

    multiplyHelper(a, b, 0)
}
def mult1(a: Int, b:Int):Int={
  if (a * b == 0) 0
  else if (a == 1) b
  else if (b == 1) a
  else (mult1(a>>>1, b)<<1)^(a%2 * b)
}
println(mult(15, 23), mult1(15,23))
// in both cases i got 129
