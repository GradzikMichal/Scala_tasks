import scala.collection.mutable
import scala.util.Random.nextInt
import scala.util.hashing.MurmurHash3

class Bloom(m:Int, hash_families:Int){
  private val M = m.toDouble
  private val HF = hash_families
  private val F_a = new mutable.BitSet(m)
  private val family = Array.fill(hash_families)(nextInt())
  private var numOfElements = 0

  def add(str:String): Unit = {
    this.family.map( x =>{
      var hash = MurmurHash3.stringHash(str,x).abs
      F_a.add(hash % m)
    })
    this.numOfElements += 1
  }
  def contains(str:String): Boolean={
    this.family.foreach(x=> {
      var hash = MurmurHash3.stringHash(str, x).abs
      if(!F_a.contains(hash % m)){
        return false
      }
    })
    true
  }
  def exactFalsePositive():Unit={
    println("P(bit i is not set by some hash function)= "+(1-1/M).toString)
    println("P(bit i is not set by all hash functions)= "+math.pow((1-1/M),HF).toString)
    println("P(bit i is not set by all hash functions after the insertion of n elements)= "+math.exp(-(HF*numOfElements)/M).toString)
    println("P(bit i is set after the insertion of n elements)= "+(1-math.exp(-(HF*numOfElements)/M)).toString)
    var ex = math.pow(math.E,(-HF*numOfElements)/M.toDouble)
    var result = math.pow((1-ex),this.hash_families)
    println("Actual positive rate = "+result.toString)
  }

}
object Bloom {
  def apply(m:Int, hash_families:Int) = new Bloom(m, hash_families)

  def optimalNumHF(err: Double): Int = {
    return (-math.log10(err) / math.log10(2)).round.toInt
  }

  def optimalNumBits(numOfWords:Int, err: Double): Int = {
    return (-numOfWords* (math.log(err) / math.log(math.pow(2,2)))).round.toInt
  }
}