def f[x,y](x: Double, y:Double) : Double = {
  val res = x + math.pow(y,2)
  res
}

def curry[A,B,C](f:(A,B) => C): A => B => C ={
  (a: A) => (b: B) => f(a, b)
}

def uncurry[A,B,C](f: A => B => C): (A, B) => C = {
  (a:A, b:B) => f(a)(b)
}


uncurry(curry(f))(3, 4) == f(3, 4)
