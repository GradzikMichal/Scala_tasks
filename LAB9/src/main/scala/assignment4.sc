import scala.collection.mutable
import scala.io.Source
import scala.util.Random.nextInt
import scala.util.hashing.MurmurHash3
import Bloom._
import scala.io._


var bl = new Bloom(18,3)
bl.add("Foo")
bl.add("asd")
bl.add("ads")
bl.contains("Foo")
bl.contains("foo")
bl.exactFalsePositive()
/*
P(bit i is not set by some hash function)= 0.9444444444444444
P(bit i is not set by all hash functions)= 0.8424211248285322
P(bit i is not set by all hash functions after the insertion of n elements)= 0.6065306597126334
P(bit i is set after the insertion of n elements)= 0.3934693402873666
Actual positive rate = 0.06091618422799686
 */


val file = "/home/michal/IdeaProjects/project9/src/main/scala/alice29.txt"
val fileSource = Source.fromFile(file)
val alice=fileSource.mkString.toLowerCase().split("\\W+")
fileSource.close
val file = "/home/michal/IdeaProjects/project9/src/main/scala/bible.txt"
val fileSource = Source.fromFile(file)
val bible=fileSource.mkString.toLowerCase().split("\\W+")
fileSource.close
var numberHF = Bloom.optimalNumHF(0.01)
var numberBit = Bloom.optimalNumBits(bible.size,0.01)
var bloom = new Bloom(numberBit, numberHF)
bible.toSet.map(x => bloom.add(x))
var onlyAlice = alice.toSet.toArray.map(x => bloom.contains(x)).count(x => !x)
println(onlyAlice) //Only in Alice = 1046
bloom.exactFalsePositive()
for (i <- alice){

}
/*
P(bit i is not set by some hash function)= 0.9999996079598269
P(bit i is not set by all hash functions)= 0.9999972557220159
P(bit i is not set by all hash functions after the insertion of n elements)= 0.9663497796660206
P(bit i is set after the insertion of n elements)= 0.03365022033397935
Actual positive rate = 4.8855716358707547E-11
 */
