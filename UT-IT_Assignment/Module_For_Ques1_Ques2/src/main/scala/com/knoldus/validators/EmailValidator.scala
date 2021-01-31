package com.knoldus.validators

import com.knoldus.models.Email

import java.util.regex._

class EmailValidator {
  val emailRegex: String = """^([a-zA-Z\d\.-]+)@([a-zA-Z\d-]+)\.(com|net|org)$"""
  val pattern: Pattern =Pattern.compile(emailRegex)


  // this method will return true if given email is valid, otherwise false
  def isEmailValid(email: Email): Boolean = {
    val matcher:Matcher = pattern.matcher(email.emailAddress)
    matcher.matches
  }

}