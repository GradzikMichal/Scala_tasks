val a = List.range(1,10)
val b = List.range(10,100,10)

a zip b

def myZip(as: List[Int],bs: List[Int]) = List.unfold((as, bs)){
  case (a :: tailA, b :: tailB) => Some((a, b), (tailA, tailB))
  case _ => None
}
myZip(a,b)
