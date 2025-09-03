def Fib(x: BigInt=0, y: BigInt=1): LazyList[BigInt] = x #:: Fib(y,x+y)
def FibQ(x: BigInt=0, y: BigInt=1): LazyList[BigInt] = x #:: Fib(y,x+y)

def indexFib(d: Int): Int = {
  var i = 1
  while (true){
    var f = Fib().take(i).toList
    if(d <= String.valueOf(f.last).length()){
      return i-1
    }
    i += 1
  }
  return 0
}

def indexFibQ(d: Int): Int = {
  var fq = FibQ().takeWhile(String.valueOf(_).length() < d).toList
  fq.indexOf(fq.last)+1
}

indexFib(2)
indexFib(3)
indexFib(4)
val t0 = System.nanoTime()
indexFib(1000)
val t1 = System.nanoTime()
println("Elapsed time: "+ (t1 - t0)+"ns")
val t2 = System.nanoTime()
indexFibQ(1000)
val t3 = System.nanoTime()
println("Elapsed time: "+ (t3 - t2)+"ns")
println("indexFibQ is "+ (((t1 - t0).toDouble/(t3 - t2))*100).toInt +"% faster")
