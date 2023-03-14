package aula

object Task5 extends App:
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

