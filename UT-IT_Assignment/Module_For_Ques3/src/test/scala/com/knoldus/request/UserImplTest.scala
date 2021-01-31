package com.knoldus.request

import com.knoldus.models.User
import com.knoldus.validator.UserValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class UserImplTest extends AnyFlatSpec {

  // Unit Test Cases of UserImpl class:

    "the createUser method" should "create user" in{
      val newUser= User("Prince","Agrahari","princeagrahari847@gmail.com","Knoldus")
      val mockedUserValidator=mock[UserValidator]
      when(mockedUserValidator.userIsValid(newUser)) thenReturn(true)

      val userImpl=new UserImpl(mockedUserValidator)

      val res = userImpl.createUser(newUser)

      assert(res==Option(newUser.emailId))
    }

    it should "not create user as the email id is not valid" in{

      val newUser= User("Anurag", "Tripathi","anuragtripathi555@gm@ail.com","Philips")
      val mockedUserValidator=mock[UserValidator]
      when(mockedUserValidator.userIsValid(newUser)) thenReturn(false)

      val userImpl=new UserImpl(mockedUserValidator)

      val res = userImpl.createUser(newUser)

      assert(res==None)

    }


  // Integration Test Cases of UserImpl class:

  "the createUser method of UserImpl class" should "create user" in{

      val newUser= User("Prince","Agrahari","princeagrahari847@gmail.com","Knoldus")
      val userValidator= new UserValidator()
      val userImpl=new UserImpl(userValidator)

      val res = userImpl.createUser(newUser)

      assert(res==Option(newUser.emailId))
  }

  it should "not create user as the email id is not valid" in{

    val newUser= User("Anurag", "Tripathi","anuragtripathi555@gm@ail.com","Philips")
    val userValidator= new UserValidator()
    val userImpl=new UserImpl(userValidator)

    val res = userImpl.createUser(newUser)

    assert(res==None)

  }

}
