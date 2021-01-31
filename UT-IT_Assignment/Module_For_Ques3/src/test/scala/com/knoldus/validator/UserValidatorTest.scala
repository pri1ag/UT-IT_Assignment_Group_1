package com.knoldus.validator

import com.knoldus.models.User
import org.scalatest.flatspec.AnyFlatSpec

class UserValidatorTest extends AnyFlatSpec {

  val userValidator:UserValidator=new UserValidator()

  behavior of  "this user"

  it should "be valid as its company exist in database and the email id is also written in correct format" in{
    val user:User= User("Prince","Agrahari","princeag@gmail.com","Knoldus")
    assert(userValidator.userIsValid(user))
  }

  it should "not be valid as its company does not exist in database and the email id is also invalid" in{
    val user:User= User("Gulshan","Singh","gulshan@gm@ail.com","Infosys")
    assert(!userValidator.userIsValid(user))
  }

  it should "not be valid as its email id is invalid" in{
    val user:User= User("Shubham","Gupta","shubham235@gmail..com","Knoldus")
    assert(!userValidator.userIsValid(user))
  }

   it should "not be valid as its company does not exist in database" in{
     val user:User= User("Sachin","Singh","sachin877@gmail.com","Oppo")
     assert(!userValidator.userIsValid(user))
   }

}
