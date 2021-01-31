package com.knoldus.validator

import java.util.regex.{Matcher, Pattern}

class EmailValidator {
  val emailRegex: String = """^([a-zA-Z\d\.-]+)@([a-zA-Z\d-]+)\.(com|net|org)$"""
  val pattern: Pattern =Pattern.compile(emailRegex)

  // this method will match the emailId format in the Regex pattern and will return true if it matches, false otherwise.
  def emailIdIsValid(emailId: String): Boolean = {
    val matcher:Matcher = pattern.matcher(emailId)
    matcher.matches
  }
}
