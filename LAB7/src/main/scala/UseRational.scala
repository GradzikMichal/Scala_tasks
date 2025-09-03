object UseRationals {
  import Rational._
  import scala.language.implicitConversions
  implicit def intToRational(x: Int) = new Rational(x)

  def main(args:Array[String]):Unit = {
    val x = new Rational(2, 3)
    val y = Rational(5, 7)
    val s = Rational(2)
    println(s)
    println(x)
    println(y)
    val z = -2 * x + y * 3
    println(z)
  }
}

