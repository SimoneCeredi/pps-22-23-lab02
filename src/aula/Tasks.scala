package aula

object Tasks extends App:
  val funcPositive: Int => String = _ match
    case i if i >= 0 => "positive"
    case _ => "negative"


  def positive(x: Int): String = x match
    case i if i >= 0 => "positive"
    case _ => "negative"

  println(funcPositive(-5))
  println(positive(5))


  val funcNeg: (String => Boolean) => String => Boolean = f => s => !f(s)

  def neg(f: String => Boolean): String => Boolean = s => !f(s)

  val empty: String => Boolean = _ == ""
  val funcNotEmpty = funcNeg(empty)
  println(funcNotEmpty("foo"))
  println(funcNotEmpty(""))
  println(funcNotEmpty("foo") && !funcNotEmpty(""))

  val notEmpty = neg(empty)
  println(notEmpty("foo"))
  println(notEmpty(""))
  println(notEmpty("foo") && !notEmpty(""))

  def genericNeg[X](f: X => Boolean): (X => Boolean) = x => !f(x)

  val genericPositive: Int => Boolean = _ >= 0
  val genericNotPositive = genericNeg(genericPositive)
  println(genericNotPositive(1))
  println(genericNotPositive(-1))
  println(genericNotPositive(1) && !genericNotPositive(-1))
