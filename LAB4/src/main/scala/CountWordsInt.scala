import scala.collection.immutable.ListMap

object CountWordsInt {

  import scala.io._

  def main(args: Array[String]): Unit = {
    if (args.length > 1) {
      val file = args(0)
      val fileSource = Source.fromFile(file)
      val words = fileSource.mkString.toLowerCase().split("\\W+")
      fileSource.close
      var Dict: Map[String, Int] = Map.empty[String, Int]
      var i = 0
      for (word <- words) {
        if (Dict.contains(word)) {
          i = Dict(word)
          //Dict.updated(word, i+1)
          Dict = Dict.updated(word, i + 1)
        } else {
          i = 1
          Dict = Dict.updated(word, i)
        }
      }
      print(ListMap(Dict.toSeq.sortWith(_._2>_._2):_*).slice(0,args(1).toInt))
    }
    else println("no file or no number")
  }

}
