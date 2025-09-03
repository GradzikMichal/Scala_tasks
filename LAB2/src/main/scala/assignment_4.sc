val fibs: LazyList[String] = LazyList.unfold(("b","a")){
  case (x, y) => Some((x,(y, y + x) ))
}

fibs.take(6).toList