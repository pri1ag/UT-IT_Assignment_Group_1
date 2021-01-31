package com.knoldus.impl

import org.scalatest.flatspec.AnyFlatSpec

class DivideAndFibonacciImplTest extends AnyFlatSpec {

  val forValidatingDivideOpr =new DivideAndFibonacciImpl()
  val forValidatingFibonacciOpr =new DivideAndFibonacciImpl()

  // Test cases to validate divide method

  "A number 20" should "return 5 when divided by 4" in{

    assert(forValidatingDivideOpr.divide(20,4)==5)
  }

  it should "throw ArithmeticException when divided by 0" in{

    assertThrows[ArithmeticException] {
      forValidatingDivideOpr.divide(6,0)
    }
  }

  // Test cases to validate fibonacci method.

  "When user gives a positive number as the last term then it" should "generate the fibonacci series up to that term" in{
    val lastTerm=5
    assert(forValidatingFibonacciOpr.fibonacci(lastTerm).equals("0 1 1 2 3"))
  }

  "When user gives a negative number as last term then it" should "not accept that value and should print an error message" in {
    val lastElement = -5
    assert(forValidatingFibonacciOpr.fibonacci(lastElement).equals("Invalid Input"))
  }

}

