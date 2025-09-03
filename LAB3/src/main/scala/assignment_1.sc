def lengthRight[A](as: List[A]) : Int = {
  val res = as.foldRight(0)((a, b) => b + 1)
  return res
}

