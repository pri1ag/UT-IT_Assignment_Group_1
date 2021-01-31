package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company

class CompanyValidator {

  //this method will return true if company does not exist in database and the email id is valid, false otherwise.
  def companyIsValid(company: Company): Boolean = {

    val companyReadDTo:CompanyReadDto= new CompanyReadDto()
    val companyInfo:Option[Company]= companyReadDTo.getCompanyByName(company.name) //checking if company does not exist in database.

    val emailValidator:EmailValidator=new EmailValidator()
    val isEmailValid= emailValidator.emailIdIsValid(company.emailId) //checking if email id is valid.

    if(companyInfo.isEmpty && isEmailValid) true
    else false

  }


}