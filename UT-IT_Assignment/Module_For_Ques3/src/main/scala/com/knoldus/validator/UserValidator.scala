package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.{Company, User}


class UserValidator {

  //this method will return true if company exists in database and the email id is valid, false otherwise.
  def userIsValid(user:User):Boolean= {

    val companyReadDTo:CompanyReadDto= new CompanyReadDto()
    val companyInfo:Option[Company]= companyReadDTo.getCompanyByName(user.companyName) //checking if company exists in database

    val emailValidator:EmailValidator=new EmailValidator()
    val isEmailValid= emailValidator.emailIdIsValid(user.emailId) //checking if email id is valid.

    if(companyInfo.isDefined && isEmailValid) true
    else false
  }
}
