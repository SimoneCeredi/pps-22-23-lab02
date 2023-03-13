package aula

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GenericNegTest:

  import Tasks.genericNeg;
  val intPositive: Int => Boolean = _ >= 0
  val stringEmpty: String => Boolean = _ == ""

  val intNegative = genericNeg(intPositive)
  val stringNotEmpty = genericNeg(stringEmpty)

  @Test def testInt() =
    assertTrue(intNegative(-1))
    assertFalse(intNegative(1))

  @Test def testString() =
    assertTrue(stringNotEmpty("test"))
    assertFalse(stringNotEmpty(""))

