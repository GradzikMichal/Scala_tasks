lazy val myLazyInt: Int = {println("hi"); 2}
//val result = myLazyInt + 3

def fA(someInt: Int): Int = {
  println("begin")
  val result = someInt + 2
  println("end")
  result
}
fA(myLazyInt)

def fB(someInt: Int): Int = {
  println("begin")
  val result = someInt + 2
  println("end")
  result
}
fB(myLazyInt)