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
