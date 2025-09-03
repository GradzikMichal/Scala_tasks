/*val a = 1 :: 2 :: 3 :: Nil
val b1 = 0 :: a
val b2 = a.::(0) //it's an append method which
//val c = a :: 5 //adding to an existing array something
*/
/*
val a1 = List(1,2,3)
val a2 = List.apply(1,2,3)
a2.unapply(2)
a1.unapply(2)
*/
val a = List.range(1,10,2)
val b = List.fill(3)("foo")
val x = List.tabulate(10)(n => math.sin(math.Pi/2 * n).toInt)
//sin, equals, hashCode, toString, abs, etc.