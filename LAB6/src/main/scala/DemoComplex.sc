import Complex._
import scala.language.implicitConversions

implicit def doubleToComplex(x: Double) = new Complex(x, 0.0)
val zA = new Complex(-6.0, 1.0)
//zA: Complex = -6.0 + 1.0 i
val zB = Complex(5.0, 1.0)
//zB: Complex = 5.0 + 1.0 i
val zC = Complex(3.0)
//zC: Complex = 3.0
val a = zA * conj(zA)
//a: Complex = 37.0
val b = abs((5.0 * zA) + (7.0 * zB))
//b: Double = 13.0