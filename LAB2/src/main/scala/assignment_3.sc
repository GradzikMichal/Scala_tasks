val initialState = ("b","a")
val fibs: List[String] = List.unfold(initialState){
  case(x, y) if x.length < 14 => {
    val result = x
    val newState = (y, y + x)
    Some((result, newState))
  }
  case _ => None
}