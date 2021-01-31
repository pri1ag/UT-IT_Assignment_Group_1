package com.knoldus.validator

import com.knoldus.models.Company
import org.scalatest.flatspec.AnyFlatSpec

class CompanyValidatorTest extends AnyFlatSpec {

  val companyValidator:CompanyValidator=new CompanyValidator()

  behavior of "this company"
  it should "be valid as it does not exist in database and the email id is also written in correct format" in{
    val company:Company = Company("Tesla","tesla@gmail.com","California")
    assert(companyValidator.companyIsValid(company))
  }

  it should "not be valid as it already exist in database and the email id is also invalid" in{
    val company:Company = Company("Philips","php@gma@il.com","Noida")
    assert(!companyValidator.companyIsValid(company))
  }

  it should "not be valid as it already exists in database" in{
    val company:Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
    assert(!companyValidator.companyIsValid(company))
  }

  it should "not be valid as it's email id is invalid" in{
    val company:Company = Company("tcs","tcs123@gm@ail.com","Mumbai")
    assert(!companyValidator.companyIsValid(company))
  }

}
