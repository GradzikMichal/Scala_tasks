//Assignment 4
object SendMessage{
  def main(args:Array[String]):Unit = {
    if (args.length == 0){
      println("Hello you")
    }else{
      println("Hello "+args(0))
    }
    import java.util.Calendar
    println("Current time is: "+Calendar.getInstance().getTime())
  }
}
