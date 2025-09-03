def properDivisors(n:Int): List[Int]={
  val range  = 1 to (n/2)
  range.filter(n % _ ==0).toList
}

def d(n: Int): Int = {
  val range = 4 to n
  var NumList = new Array[Int](0)
  for (i <- range if !NumList.contains(i)) {
    var numA = properDivisors(i)
    var numB = properDivisors(numA.sum)
    if (i == numB.sum & numA.sum != i & !NumList.contains(i) & !NumList.contains(numA.sum)) {
      NumList = NumList :+ numA.sum :+ numB.sum
    }
  }
  NumList.sum
}

d(10000) //exponential grow
/*
val t0 = System.nanoTime()
d(10)
val t1 = System.nanoTime()
val y1 = t1-t0
val t0 = System.nanoTime()
d(100)
val t1 = System.nanoTime()
val y2 = t1-t0
val t0 = System.nanoTime()
d(1000)
val t1 = System.nanoTime()
val y3 = t1-t0
val t0 = System.nanoTime()
d(10000)
val t1 = System.nanoTime()
val y4 = t1-t0
val t0 = System.nanoTime()
d(100000)
val t1 = System.nanoTime()
val y5 = t1-t0
println(y1,y2,y3,y4,y5)*/
