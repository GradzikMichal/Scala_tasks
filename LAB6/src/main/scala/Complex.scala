import math._

class Complex(r:Double,i:Double){
  var real: Double = r
  var imaginary: Double = i



  def +(that: Complex): Complex = {
    new Complex(real + that.real, imaginary + that.imaginary)
  }
  def -(that: Complex): Complex = {
    new Complex(real - that.real,imaginary - that.imaginary)
  }
  def *(that: Complex): Complex = {
    new Complex(real*that.real - that.imaginary*imaginary, real*that.imaginary + that.real*imaginary)
  }

  def *(that: Int): Complex = {
    new Complex(real * that, that * imaginary)
  }
  def /(that: Complex): Complex = {
    new Complex((real*that.real + imaginary*that.imaginary)/(that.real*that.real + that.imaginary*that.imaginary),(imaginary*that.real + real*that.imaginary)/(that.real*that.real + that.imaginary*that.imaginary))
  }
  def abs(that: Complex): Double = {
    sqrt(pow(that.real,2)+pow(that.imaginary,2))
  }
  def conj(that: Complex): Complex = {
    new Complex(that.real, -that.imaginary)
  }
  override def toString: String = {
    imaginary match{
      case 0.0 => real.toString
      case _ => real.toString+" + "+imaginary.toString+" i"
    }

  }
}


object Complex{
  def apply(r: Double, i:Double):Complex = {
    new Complex(r,i)
  }
  def apply(r: Double):Complex = {
   new Complex(r,0.0)
 }

  def conj(that:Complex): Complex = {
    new Complex(that.real, -that.imaginary)
  }

  def abs(that: Complex): Double = {
    sqrt(pow(that.real, 2) + pow(that.imaginary, 2))
  }
}

/*
class Complex(val real: Double, val imaginary: Double = 0.0) {
  def +(that: Complex): Complex = new Complex(this.real + that.real, this.imaginary + that.imaginary)

  def -(that: Complex): Complex = new Complex(this.real - that.real, this.imaginary - that.imaginary)

  def *(that: Complex): Complex = new Complex(this.real * that.real - this.imaginary * that.imaginary, this.real * that.imaginary + this.imaginary * that.real)

  def /(that: Complex): Complex = {
    val denom = that.real * that.real + that.imaginary * that.imaginary
    new Complex((this.real * that.real + this.imaginary * that.imaginary) / denom, (this.imaginary * that.real - this.real * that.imaginary) / denom)
  }

  def conj(): Complex = new Complex(this.real, -this.imaginary)

  def abs(): Double = math.sqrt(this.real * this.real + this.imaginary * this.imaginary)

  def this(real: Double) = this(real, 0.0)

  override def toString: String = {
    if (imaginary < 0) {
      s"$real - ${math.abs(imaginary)}i"
    } else {
      s"$real + $imaginary i"
    }
  }
}

object Complex {
  def apply(real: Double, imaginary: Double): Complex = new Complex(real, imaginary)

  def apply(real: Double): Complex = new Complex(real, 0.0)
}
*/