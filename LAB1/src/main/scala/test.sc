//Assignment 2 and 3
//import java.util.Calendar
//val tm : Long = Calendar.getInstance().getTimeInMillis()
//val time = Calendar.getInstance().getTime
//val (t1,t2) = (tm>>>32, tm&0xFFFFFFFFL)
//val a = Array(tm>>>32, tm&0xFFFFFFFFL).map(_.toInt.toBinaryString)


//Assignment 6
import scala.util.Random._
val n: Int = 1000000
val v = List.fill(n)(nextInt()%10)
val av = v.sum/v.length
val avL = v.sum.toDouble/v.length