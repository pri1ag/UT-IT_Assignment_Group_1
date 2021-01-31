package com.knoldus.impl
import com.knoldus.traits.DivideAndFibonacci
class DivideAndFibonacciImpl extends DivideAndFibonacci {

  // Method to divide two numbers
  override def divide(numerator: Int, denominator: Int): Int = {

    // Through Exception if a number is divided by zero
    if(denominator == 0){
      throw new ArithmeticException("Not divisible by zero")
    }
    numerator/denominator
  }


  // Return Fibonacci Sequence Up to a Certain Number
  override def fibonacci(lastTerm: Int): String = {
    var (prevNum,nextNum,sum,i)=(0,1,0,2)
    var fibonacciSeries= prevNum+" "+nextNum

    if(lastTerm<0)
      return "Invalid Input"
    else if(lastTerm==1)
      return "0"
    else if(lastTerm==2)
      return fibonacciSeries

    while (i<lastTerm) {
      sum = prevNum + nextNum
      fibonacciSeries+=" "+sum
      prevNum = nextNum
      nextNum = sum
      i+=1
    }

  fibonacciSeries
  }
}

