def Humming_distance(x:Int, y:Int): Int = {
  Integer.bitCount(x ^ y)
}

Humming_distance(1729, math.pow(1729,2).toInt)