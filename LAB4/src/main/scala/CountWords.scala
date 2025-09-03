object CountWords {
  import scala.io._
  def main(args:Array[String]):Unit = {
    if (args.length>0)
    {
      val file = args(0)
      val fileSource = Source.fromFile(file)
      val words=fileSource.mkString.toLowerCase().split("\\W+")
      fileSource.close
      var Dict: Map[String, Int] = Map.empty[String, Int]
      var i = 0
      for(word <- words){
        if(Dict.contains(word)){
          i = Dict(word)
          //Dict.updated(word, i+1)
          Dict = Dict.updated(word, i+1)
        }else{
          i = 1
          Dict = Dict.updated(word, i)
        }
      }
      println(Dict.maxBy(_._2))
    }
    else println("no file")
  }
}