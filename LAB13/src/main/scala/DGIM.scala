class DGIM(nLastElements: Int){
  private val N = nLastElements
  private var t = 0
  private var lookupTable : List[List[Int]] = List() //tuple2: Timestamp, size
  private var memory : List[Int] = List()


  def readStream(bit: Int): Unit = {
    this.t = this.t + 1
    this.memory = this.memory ::: List(bit)
    checkMemory()
    checkEarliestBucket()
    if (bit == 1) {
      this.lookupTable = this.lookupTable ::: List(List(t, 1))


      val newLookUpTable: List[List[Int]] = checkNumberOfBuckets(this.lookupTable)
      regenerateLookUpTable(newLookUpTable)
    }
  }

  def getApproxNumberOfOnesInWholeWindow: Int = {
    val head::tail = this.lookupTable
    var sum = (1/2.0 * head(1)).toInt
    tail foreach {
      bucket =>
        sum += bucket(1)
    }
    sum
  }
  def getBucketList: List[List[Int]] ={
   return this.lookupTable
  }
  def getApproxNumberOfOnesInLastKBits(K: Int) : Int ={

    var first = true
    var sum = 0
    this.lookupTable foreach {
      bucket =>
        if (bucket.head >= this.t - K){
          if (first){
            sum = ((1/2.0) * bucket(1)).toInt
            first = false
          }else{
            sum += bucket(1)
          }

        }
    }
    sum
  }

  private def checkNumberOfBuckets(table : List[List[Int]]): List[List[Int]]={
    var currentBucket = 1
    var countBucket = 0
    var newLookUpTable: List[List[Int]] = List()

    table.reverse foreach {
      bucket =>
        if (bucket(1) != currentBucket) {
          (1 to countBucket).foreach(_ =>
            newLookUpTable = newLookUpTable ::: List(List(0, currentBucket))
          )

          currentBucket = bucket(1)
          countBucket = 1
        } else {
          countBucket += 1
          if (countBucket == 3) {
            newLookUpTable = newLookUpTable ::: List(List(0, currentBucket))
            val degree = math.log10(currentBucket) / math.log10(2)
            currentBucket = math.pow(2, degree + 1).toInt
            countBucket = 1
          }
        }
    }
    if (countBucket >0){
      (1 to countBucket).foreach(x =>
        newLookUpTable = newLookUpTable ::: List(List(x, currentBucket))
      )
    }

    newLookUpTable
  }

  private def regenerateLookUpTable(table : List[List[Int]]) : Unit = {
    var newLookUpTable = table
    var skippable = 0
    var dataTimestamp = this.t
    this.memory.reverse foreach {
      x =>
        if (x == 1 && skippable == 0) {
          val head :: tail = newLookUpTable

          skippable = head(1) - 1
          newLookUpTable = tail ::: List(List(dataTimestamp, head(1)))
        } else if (x == 1 && skippable > 0) {
          skippable = skippable - 1
        }
        dataTimestamp = dataTimestamp - 1
    }
    this.lookupTable = newLookUpTable.reverse
  }

  private def checkMemory(): Unit = {
    if (this.memory.length > N) {
      val _ :: t = this.memory
      this.memory = t
    }
  }

  private def checkEarliestBucket(): Unit = {
     if(this.lookupTable.nonEmpty){
      if (this.lookupTable.head.head < this.t - this.N) {
        val _ :: t = this.lookupTable
        this.lookupTable = t
      }
    }

  }
}

object DGIM{
  def apply(N:Int) = new DGIM(N)
}
