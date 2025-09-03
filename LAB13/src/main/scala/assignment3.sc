//
var bitstream = "001"*400
var dgim = new DGIM(100)
var iter = 0

bitstream map {
  x=>
    iter += 1
    dgim.readStream((x.toInt%48))
    if (iter == 33){
      println(dgim.getApproxNumberOfOnesInLastKBits(12))//28
      println(dgim.getBucketList)
    }
}
