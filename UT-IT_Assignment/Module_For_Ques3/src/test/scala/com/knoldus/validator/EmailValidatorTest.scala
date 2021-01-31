package com.knoldus.validator

import org.scalatest.flatspec.AnyFlatSpec

class EmailValidatorTest extends AnyFlatSpec {

  val emailValidator:EmailValidator=new EmailValidator()

  behavior of "This Email"
  it should "be valid as it is written in correct format" in{
    val email="princeagrahari@gmail.com"
    assert(emailValidator.emailIdIsValid(email))
  }

  it should "also be valid when with starting numbers" in{
    val email="12prince@gmail.com"
    assert(emailValidator.emailIdIsValid(email)) // valid when with starting numbers.
  }

  it should "not valid with starting with special symbols except dot and underscore" in{
    val email = "$%prince@gmail.com"     // special symbol at starting are not allowed.
    assert(!emailValidator.emailIdIsValid(email))
  }

  it should "not valid as it contains blank space" in{
    val email="prince 125@gmail.com.net" // blank space not allowed.
    assert(!emailValidator.emailIdIsValid(email))
  }

  it should "also not valid with missing top level domain" in {
    val email = "prince@gmail"   // missing top level domain are not allowed.
    assert(!emailValidator.emailIdIsValid(email))
  }

  it should "also not valid with missing main domain" in {
    val email = "prince@.com"   // missing main domain are not allowed.
    assert(!emailValidator.emailIdIsValid(email))
  }

  it should "also not valid when wrong top level domain except .com/.org/.net" in {
    val email = "prince@abc.live"   // wrong top level domain are not allowed.
    assert(!emailValidator.emailIdIsValid(email))
  }

  it should "also not valid with more than one top level domain" in {
    val email = "prince@gmail.com.net"   // more than one top level domain are not allowed.
    assert(!emailValidator.emailIdIsValid(email))
  }


  it should "also not valid as it contains two or more dot symbols" in{
    val email= "prince125@gmail..com"     // two dots are not allowed.
    assert(!emailValidator.emailIdIsValid(email))
  }

  it should "also not valid as it does not contain @ symbol" in{
    val email= "princeagrahari.com"      // here @ symbol is missing.
    assert(!emailValidator.emailIdIsValid(email))
  }
}
