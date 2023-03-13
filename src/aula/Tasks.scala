package aula

object Tasks extends App:
  val funcPositive: Int => String = _ match
    case i if i >= 0 => "positive"
    case _ => "negative"

  def positive(x: Int): String = x match
    case i if i >= 0 => "positive"
    case _ => "negative"

  println(positive(5))
  println(funcPositive(-5))
