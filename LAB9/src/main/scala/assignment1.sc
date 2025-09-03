trait M[T] {
  def flatMap[U](f: T => M[U]): M[U]
  def unit[T](x: T): M[T]
}
val f = (i:Int) => Option(i * i)
val g = (i:Int) => Option(i * i * i)
val m = Some(2)
var lhs = (m flatMap f) flatMap g
var rhs =  m flatMap (x => f(x) flatMap g)
lhs == rhs //true
val m = None
var lhs = (m flatMap f) flatMap g
var rhs =  m flatMap (x => f(x) flatMap g)
lhs == rhs //true
