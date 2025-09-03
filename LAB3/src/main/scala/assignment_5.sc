def cmp[A,B,C](f: B => C, g: A => B): A => C ={
  (a:A)  =>f(g(a))

}

import math._
val f = cmp(math.exp _, math.log _)
f(5)
val x= List.range(0, 10).map(_.toDouble)
val xx = x.map(exp _ andThen log _) //log(exp(x))
val xxx = x.map(exp _ compose log _) //exp(log(x))
/*
So andThen method is firstly running second function and the result is used by the first function
So I think that xx and xxx are not exactly equal is because of this sequence of tasks.
Exp and log both return double but I think exp is more precise
 */

