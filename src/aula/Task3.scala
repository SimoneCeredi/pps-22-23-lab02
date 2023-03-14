package aula

import scala.annotation.tailrec

object Task3 extends App:

  @tailrec
  def gcd(a: Int, b: Int): Int = (a, b) match
    case (f, s) if f > s && s != 0 => gcd(s, f % s)
    case (f, _) => f

  println(gcd(36, 25))
  println(gcd(36, 24))

  enum Shape:
    case Square(s: Double)
    case Rectangle(b: Double, h: Double)
    case Circle(r: Double)

  object Shape:
    def perimeter(shape: Shape): Double = shape match
      case Square(s) => s * 4
      case Rectangle(b, h) => 2 * (b + h)
      case Circle(r) => math.Pi * r

    def contains(shape: Shape, point: (Double, Double)): Boolean = shape match
      case Square(s) => point._1 <= s && point._2 <= s
      case Rectangle(b, h) => point._1 <= b && point._2 <= h
      case Circle(r) => math.sqrt((BigDecimal(point._1).pow(2) + BigDecimal(point._2).pow(2)).doubleValue) <= r

  import Shape.*

  println(s"Square: ${perimeter(Square(2))}, Rectangle: ${perimeter(Rectangle(2, 1))}, Circle: ${perimeter(Circle(1))}");
  println(s"Square: ${contains(Square(1), (2, 0.7))}, Rectangle: ${contains(Rectangle(1.7, 2), (1.6, 1))}, " +
    s"Circle: ${contains(Circle(1), (3.14159265358, 3.14159265357))}")
