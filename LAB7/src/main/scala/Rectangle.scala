import Element.elem
object Rectangle {
  val space = elem(" ")
  val corner = elem("*")
  def rectangle(width: Int, height: Int): Element = {
    if (width < 2 || height < 2) {
      println("Provide integer numbers bigger or equal to 2!")
      elem("")
    } else {
      def verticalBar = elem('|', 1, height-2)
      def horizontalBar = elem('=', width-2, 1)
      def inside: Element = elem(' ',width-2,height-2)
      (corner beside horizontalBar beside corner) above (verticalBar above corner beside (inside above horizontalBar) beside (verticalBar above corner))
    }
  }
  def main(args: Array[String]) = {
    val width = args(0).toInt
    val height = args(1).toInt
    println(rectangle(width,height))
  }
}
