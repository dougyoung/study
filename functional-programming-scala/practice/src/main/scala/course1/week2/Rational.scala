package course1.week2

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be non-zero")

  def this(x: Int) = this(x, 1)

  def numer: Int = x / g
  def denom: Int = y / g

  def +(r: Rational): Rational = add(r)
  def add(r: Rational) = new Rational(
    numer * r.denom + denom * r.numer,
    denom * r.denom
  )

  def unary_- : Rational = neg
  def neg: Rational = new Rational(-numer, denom)

  def -(r:Rational): Rational = sub(r)
  def sub(r: Rational): Rational = add(r.neg)

  override def equals(r: Any): Boolean = r match {
    case ration: Rational => hashCode == ration.hashCode
    case _ => false
  }

  override def hashCode: Int =
    (numer.toDouble / denom).hashCode

  override def toString: String =
    if (denom == 1) numer + "" else numer + "/" + denom

  private val g = gcd(x, y)
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}
