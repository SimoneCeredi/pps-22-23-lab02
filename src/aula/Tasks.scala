package aula

import scala.annotation.tailrec

object Tasks extends App:

  // Task 3a)
  println("\n\nTask 3a")

  val funcPositive: Int => String = _ match
    case i if i >= 0 => "positive"
    case _ => "negative"


  def positive(x: Int): String = x match
    case i if i >= 0 => "positive"
    case _ => "negative"

  println(funcPositive(-5))
  println(positive(5))


  // Task 3b)
  println("\n\nTask 3b")

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


  // Task 3c)
  println("\n\nTask 3c")

  def genericNeg[X](f: X => Boolean): (X => Boolean) = x => !f(x)

  val genericPositive: Int => Boolean = _ >= 0
  val genericNotPositive = genericNeg(genericPositive)
  println(genericNotPositive(1))
  println(genericNotPositive(-1))
  println(genericNotPositive(1) && !genericNotPositive(-1))


  // Task 4)
  println("\n\nTask 4")

  var p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  var p2: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y == z

  def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z

  def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y == z

  println("p1:")
  println(p1(1)(3)(3))
  println(p1(1)(3)(2))
  println("\np2:")
  println(p2(1, 3, 2))
  println(p2(1, 3, 3))
  println("\np3:")
  println(p3(1)(3)(3))
  println(p3(1)(3)(2))
  println("\np4:")
  println(p4(1, 3, 3))
  println(p4(1, 3, 2))


  // Task 5)
  println("\n\nTask 5")

  var compose: (Int => Int, Int => Int) => Int => Int = (f, g) => n => f(g(n))

  def funcCompose(f: Int => Int, g: Int => Int): Int => Int = n => f(g(n))

  println(compose(_ - 1, _ * 2)(5))
  println(funcCompose(_ - 1, _ * 2)(5))

  def genericCompose[A, B, C](f: B => A, g: C => B): C => A = n => f(g(n))

  println(genericCompose[String, Int, Int]("mult: " + _, _ * 2)(5))


  // Task 6)
  println("\n\nTask 6")

  @tailrec
  def gcd(a: Int, b: Int): Int = (a, b) match
    case (f, s) if s != 0 => gcd(s, f % s)
    case (f, _) => f

  println(gcd(36, 25))
  println(gcd(36, 24))


  // Task 7)
  println("\n\nTask 7")

  enum Shape:
    case Square(s: Double)
    case Rectangle(b: Double, h: Double)
    case Circle(r: Double)

  object Shape:
    def perimeter(shape: Shape): Double = shape match
      case Square(s) => s * 4
      case Rectangle(b, h) => 2 * (b + h)
      case Circle(r) => math.Pi * r

    def contains(shape: Shape, point: (Double, Double)): Boolean = (shape, point) match
      case (Square(s), (px, py)) => px <= s && py <= s
      case (Rectangle(b, h), (px, py)) => px <= b && py <= h
      case (Circle(r), (px, py)) => math.sqrt((BigDecimal(px).pow(2) + BigDecimal(py).pow(2)).doubleValue) <= r

  import Shape.*

  println(s"Square: ${perimeter(Square(2))}, Rectangle: ${perimeter(Rectangle(2, 1))}, Circle: ${perimeter(Circle(1))}");
  println(s"Square: ${contains(Square(1), (2, 0.7))}, Rectangle: ${contains(Rectangle(1.7, 2), (1.6, 1))}, " +
    s"Circle: ${contains(Circle(1), (3.14159265358, 3.14159265357))}")


  // Task 8)
  println("\n\nTask 8")

  enum Option[A]:
    case Some(a: A)
    case None() // here parens are needed because of genericity

  object Option:

    def isEmpty[A](opt: Option[A]): Boolean = opt match
      case None() => true
      case _ => false

    def orElse[A, B >: A](opt: Option[A], orElse: B): B = opt match
      case Some(a) => a
      case _ => orElse

    def flatMap[A, B](opt: Option[A])(f: A => Option[B]): Option[B] = opt match
      case Some(a) => f(a)
      case _ => None()

    def filter[A](opt: Option[A])(f: A => Boolean): Option[A] = opt match
      case Some(a) if f(a) => Some(a)
      case _ => None()

    def map[A, B](opt: Option[A])(f: A => B): Option[B] = opt match
      case Some(a) => Some(f(a))
      case _ => None()

    def fold[A](opt: Option[A])(default: A)(f: A => A): A = opt match
      case Some(a) => f(a)
      case _ => default

  import Option.*

  println(filter(Some(5))(_ > 2))
  println(filter(Some(5))(_ > 8))
  println(filter(None[Int]())(_ > 2))

  println(map(Some(5))(_ > 2))
  println(map(Some(5))(_ > 8))
  println(map(None[Int]())(_ > 2))

  println(fold(Some(5))(1)(_ + 1))
  println(fold(None[Int]())(1)(_ + 1))