package aula

object Tasks2b extends App:

  var p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  var p2: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y == z

  def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z

  def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y == z

  println("p1:")
  println(p1(1)(3)(3))
  println(p1(1)(3)(2))
  println("\n\np2:")
  println(p2(1, 3, 2))
  println(p2(1, 3, 3))
  println("\n\np3:")
  println(p3(1)(3)(3))
  println(p3(1)(3)(2))
  println("\n\np4:")
  println(p4(1, 3, 3))
  println(p4(1, 3, 2))

  println("\n\n\nCompose:")

  var compose: (Int => Int, Int => Int) => Int => Int = (f, g) => n => f(g(n))

  def funcCompose(f: Int => Int, g: Int => Int): Int => Int = n => f(g(n))

  println(compose(_ - 1, _ * 2)(5))
  println(funcCompose(_ - 1, _ * 2)(5))

  def genericCompose[A, B, C](f: B => A, g: C => B): C => A = n => f(g(n))

  println(genericCompose[String, Int, Int]("mult: " + _, _ * 2)(5))
