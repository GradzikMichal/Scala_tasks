def f[x,y](x: Double, y:Double) : Double = x + math.pow(y,2)
val f1 = (x: Double, y:Double) => x + math.pow(y,2)

def curry[A,B,C](f:(A,B) => C): A => B => C ={
  (a: A) => (b: B) => f(a, b)
}

println(f(1,2))
val t = (f _).curried
println(t(1)(2))

println(f1(1,2))
val t = (f1).curried
println(t(1)(2))

curry(f)(1)(2)
println(f(1,2) == curry(f)(1)(2))

curry(f1)(1)(2)
println(f(1,2) == curry(f1)(1)(2))

/*
The function f is not a lambda function thats why IntellJ is making underline but still compiling because its converting
it to lambda function i quess
In the other hand f1 is a lambda function and there is no problem, so curry function is working for lambda functions
 */