import scala.collection.mutable
import scala.io._
import scala.util.hashing.MurmurHash3
import scala.math._
import scala.annotation.tailrec
import scala.util.Random.nextInt

@tailrec
def calc(hash: List[Int], M: mutable.Map[Int, Int], buckets:Int): mutable.Map[Int, Int] = {
  if (hash.isEmpty) {
    return M
  }
  val str::t = hash
  val mod = str.abs % buckets
  var zeros = Integer.numberOfLeadingZeros(str)+1
  if (M.contains(mod)){
    if (M(mod) < zeros){
      M(mod) = zeros
    }
  }else{
    M += (mod -> zeros)
  }
  calc(t, M, buckets)
}
def CheckRandom(p:Int) : (Int, Int) ={
  var n = math.pow(2, p).toInt
  var num_buckets = math.pow(2, 10).toInt
  var alpha = 0.0
  num_buckets match{
    case 16 => alpha = 0.673
    case 32 => alpha = 0.697
    case 64 => alpha = 0.709
    case _ => alpha = (0.7213 / (1 + 1.079 / num_buckets))
  }
  var Z_j = mutable.Map[Int, Int]()
  var words = Array.fill(n)(nextInt())
  Z_j = calc(words.toList, Z_j, num_buckets)
  var d: Float = 0
  Z_j map { case (k, v) => d += math.pow(2, -v).toFloat }
  var Z_harm = (num_buckets / d)
  var harmonic = (Z_harm * num_buckets * alpha).toInt
  if (harmonic <= (5/2)*num_buckets){
    var V = Z_j.count({case (k, v) => v == 0})
    if( V != 0){
      harmonic = num_buckets * log((num_buckets/V)).toInt
    }
  }else if(harmonic > Integer.MAX_VALUE/30){
    harmonic = (Integer.MIN_VALUE * log(1 - harmonic/Integer.MAX_VALUE)).toInt
  }
  var estimated = num_buckets* math.pow(1-1/num_buckets,n).toInt
  print(Z_j.count({case (k, v) => v == 0}))
  (harmonic, estimated)
}

println(CheckRandom(24))