package com.knoldus.db

import org.scalatest.flatspec.AnyFlatSpec


class CompanyReadDtoTest extends AnyFlatSpec {

  val companyReadDto:CompanyReadDto=new CompanyReadDto()

  behavior of "getCompanyByName method"

  it should "return the company" in{

    val result= companyReadDto.getCompanyByName("Knoldus")
    assert(result.isDefined)
  }

  it should "not return the company as this company does not exist" in {

    val result= companyReadDto.getCompanyByName("Amazon")
    assert(result.isEmpty)
  }


}
