object CompareFiles{
  import scala.io._

  def main(args: Array[String]): Unit = {
    if (args.length > 1) {
      val file1 = computeFile(args(0))
      val file2 = computeFile(args(1))
      for ((key,value) <- file1){
        if (file2.contains(key)){
          println(key, value)
        }
      }
    }
    else None
  }

  private def computeFile(filename: String): Map[String, Int] = {
    val file = filename
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
    Dict
  }
}

